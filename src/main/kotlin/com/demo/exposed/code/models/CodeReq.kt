package com.demo.exposed.code.models

import jakarta.validation.constraints.NotBlank
import jakarta.validation.constraints.Size

data class CodeReq(
    @field:NotBlank(message = "코드 ID는 필수입니다")
    @field:Size(max = 32, message = "코드 ID는 32자를 초과할 수 없습니다")
    val codeId: String,

    @field:Size(max = 32, message = "상위 코드 ID는 32자를 초과할 수 없습니다")
    val parCodeId: String? = null,

    @field:Size(max = 100, message = "코드명은 100자를 초과할 수 없습니다")
    val codeName: String? = null,

    @field:Size(max = 20, message = "코드값은 20자를 초과할 수 없습니다")
    val codeValue: String? = null,

    @field:Size(max = 4000, message = "코드 설명은 4000자를 초과할 수 없습니다")
    val codeExplanation: String? = null,

    @field:Size(max = 1, message = "사용 여부는 1자여야 합니다")
    val useYn: String = "Y",

    val sortNumber: Int? = null
)
