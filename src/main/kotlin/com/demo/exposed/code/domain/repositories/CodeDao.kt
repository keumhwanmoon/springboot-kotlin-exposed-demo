package com.demo.exposed.code.domain.repositories

import com.demo.exposed.code.domain.entities.Code
import com.demo.exposed.code.domain.entities.Codes
import com.demo.exposed.code.models.CodeReq
import org.jetbrains.exposed.sql.transactions.transaction
import org.springframework.stereotype.Repository
import java.time.LocalDateTime

@Repository
class CodeDao {
    // 전체 코드 조회
    fun findAll() = transaction {
        Code.all().map { it.toCodeRes() }
    }

    // 코드 ID로 코드 조회
    fun findByCodeId(codeId: String) = transaction {
        Code.find { Codes.codeId eq codeId }.firstOrNull()?.toCodeRes()
    }

    // 상위 코드 ID로 코드 조회
    fun findByParentCodeId(parentCodeId: String) = transaction {
        Code.find { Codes.parCodeId eq parentCodeId }.map { it.toCodeRes() }
    }

    // 코드 생성
    fun create(codeReq: CodeReq) = transaction {
        Code.new {
            codeId = codeReq.codeId
            parCodeId = codeReq.parCodeId
            codeName = codeReq.codeName
            codeValue = codeReq.codeValue
            codeExplanation = codeReq.codeExplanation
            useYn = codeReq.useYn.single()
            sortNumber = codeReq.sortNumber
            createdAt = LocalDateTime.now()
            lastUpdatedAt = LocalDateTime.now()
        }.toCodeRes()
    }

    // 코드 수정
    fun update(codeId: String, codeReq: CodeReq) = transaction {
        val code = Code.find { Codes.codeId eq codeId }.firstOrNull()
        code?.apply {
            this.parCodeId = codeReq.parCodeId
            this.codeName = codeReq.codeName
            this.codeValue = codeReq.codeValue
            this.codeExplanation = codeReq.codeExplanation
            this.useYn = codeReq.useYn.single()
            this.sortNumber = codeReq.sortNumber
            this.lastUpdatedAt = LocalDateTime.now()
        }?.toCodeRes()
    }

    // 코드 삭제
    fun delete(codeId: String) = transaction {
        Code.find { Codes.codeId eq codeId }.forEach { it.delete() }
    }

    // 활성화된 코드만 조회
    fun getActiveCodesOnly() = transaction {
        Code.find { Codes.useYn eq 'Y' }.map { it.toCodeRes() }
    }
}
