package com.demo.exposed.user.domain.repositories

import com.demo.exposed.common.exception.DuplicateLoginIdException
import com.demo.exposed.user.domain.entities.Users
import com.demo.exposed.user.models.UserReq
import com.demo.exposed.user.models.UserRes
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.SqlExpressionBuilder.eq
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import org.springframework.transaction.annotation.Transactional

@Repository
class UserDao {
    fun getAllUsers(
        page: Int = 0,
        size: Int = 20,
        sortBy: String = "id",
        isAsc: Boolean = true
    ) = transaction {
        // 정렬 컬럼 검증 및 매핑
        val sortColumn = when (sortBy.lowercase()) {
            "id" -> Users.id
            "loginid" -> Users.loginId
            "username" -> Users.userName
            "email" -> Users.email
            "createdAt" -> Users.createdAt
            else -> Users.id // 기본값
        }

        val order = if (isAsc) SortOrder.ASC else SortOrder.DESC

        Users
            .selectAll()
            .orderBy(sortColumn to order)
            .limit(size, offset = (page * size).toLong())
            .map { row ->
                UserRes(
                    id = row[Users.id],
                    loginId = row[Users.loginId],
                    userName = row[Users.userName],
                    email = row[Users.email],
                    phoneNumber = row[Users.phoneNumber],
                    createdAt = row[Users.createdAt]
                )
            }
    }

    fun findById(id: Long): ResultRow? = transaction {
        Users.select { Users.id eq id }
            .firstOrNull()
    }

    fun create(userReq: UserReq): ResultRow = transaction {
        Users.select { Users.loginId eq userReq.loginId }
            .firstOrNull()
            ?.let {
                throw DuplicateLoginIdException("이미 사용 중인 로그인 아이디입니다: ${userReq.loginId}")
            }

        val insertStatement = Users.insert { row ->
            row[loginId] = userReq.loginId
            row[userName] = userReq.userName
            row[email] = userReq.email
            row[phoneNumber] = userReq.phoneNumber
            row[createdAt] = java.time.LocalDateTime.now()
        }

        Users.select { Users.id eq insertStatement[Users.id] }
            .first()
    }

    fun update(id: Long, userReq: UserReq): ResultRow? = transaction {
        Users.update({ Users.id eq id }) { row ->
            row[loginId] = userReq.loginId
            row[userName] = userReq.userName
            row[email] = userReq.email
            row[phoneNumber] = userReq.phoneNumber
            row[lastUpdatedAt] = java.time.LocalDateTime.now()
        }

        Users.select { Users.id eq id }
            .firstOrNull()
    }

    @Transactional
    fun delete(id: Long) {
        transaction {
            Users.deleteWhere { Users.id eq id }
        }
    }
}
