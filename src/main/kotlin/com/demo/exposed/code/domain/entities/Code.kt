package com.demo.exposed.code.domain.entities

import com.demo.exposed.code.models.CodeRes
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID

class Code(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<Code>(Codes)

    var codeId by Codes.codeId
    var parCodeId by Codes.parCodeId
    var codeName by Codes.codeName
    var codeValue by Codes.codeValue
    var codeExplanation by Codes.codeExplanation
    var useYn by Codes.useYn
    var sortNumber by Codes.sortNumber
    var createdAt by Codes.createdAt
    var lastUpdatedAt by Codes.lastUpdatedAt

    fun toCodeRes() = CodeRes(
        id = id.value,
        codeId = codeId,
        parCodeId = parCodeId,
        codeName = codeName,
        codeValue = codeValue,
        codeExplanation = codeExplanation,
        useYn = useYn.toString(),
        sortNumber = sortNumber,
        createdAt = createdAt,
        lastUpdatedAt = lastUpdatedAt
    )
}
