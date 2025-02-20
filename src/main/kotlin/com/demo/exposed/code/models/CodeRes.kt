package com.demo.exposed.code.models

import java.time.LocalDateTime

data class CodeRes(
    val id: Long,
    val codeId: String,
    val parCodeId: String?,
    val codeName: String?,
    val codeValue: String?,
    val codeExplanation: String?,
    val useYn: String,
    val sortNumber: Int?,
    val createdAt: LocalDateTime?,
    val lastUpdatedAt: LocalDateTime?
) {
    var subCodes: MutableList<CodeRes>? = null
}
