package com.demo.exposed.user.models

import com.demo.exposed.user.domain.entities.Users
import org.jetbrains.exposed.sql.ResultRow
import java.time.LocalDateTime

data class UserRes(
    val id: Long,
    val loginId: String,
    val userName: String,
    val email: String?,
    val phoneNumber: String?,
    val createdAt: LocalDateTime?
) {
    companion object {
        fun from(user: ResultRow): UserRes {
            return UserRes(
                id = user[Users.id],
                loginId = user[Users.loginId],
                userName = user[Users.userName],
                email = user[Users.email],
                phoneNumber = user[Users.phoneNumber],
                createdAt = user[Users.createdAt]
            )
            
        }
    }
}
