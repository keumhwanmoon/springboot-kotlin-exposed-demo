package com.demo.exposed.code.domain.entities

import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.javatime.datetime

object Codes : LongIdTable("CODE") {
    val codeId = varchar("CODE_ID", 32).uniqueIndex()
    val parCodeId = varchar("PAR_CODE_ID", 32).nullable()
    val codeName = varchar("CODE_NAME", 100).nullable()
    val codeValue = varchar("CODE_VALUE", 20).nullable()
    val codeExplanation = varchar("CODE_EXPLANATION", 4000).nullable()
    val useYn = char("USE_YN").default('Y')
    val sortNumber = integer("SORT_NUMBER").nullable()
    val createdAt = datetime("CREATED_AT")
    val lastUpdatedAt = datetime("LAST_UPDATED_AT")
}
