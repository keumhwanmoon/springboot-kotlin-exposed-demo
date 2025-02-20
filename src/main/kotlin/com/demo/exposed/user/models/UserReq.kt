package com.demo.exposed.user.models

import jakarta.validation.constraints.*
import jakarta.validation.constraints.Pattern

data class UserReq(
    @field:NotBlank(message = "로그인 ID는 필수입니다")
    @field:Size(min = 4, max = 50, message = "로그인 ID는 4-50자 사이여야 합니다")
    val loginId: String,

    @field:NotBlank(message = "사용자 이름은 필수입니다")
    @field:Size(max = 100, message = "사용자 이름은 100자를 초과할 수 없습니다")
    val userName: String,

    @field:Email(message = "올바른 이메일 형식이 아닙니다")
    @field:Size(max = 100, message = "이메일은 100자를 초과할 수 없습니다")
    val email: String? = null,

    @field:Pattern(
        regexp = "^\\d{2,3}-\\d{3,4}-\\d{4}$",
        message = "올바른 전화번호 형식이 아닙니다"
    )
    @field:Size(max = 20, message = "전화번호는 20자를 초과할 수 없습니다")
    val phoneNumber: String? = null,

    @field:Size(max = 20, message = "휴대폰 번호는 20자를 초과할 수 없습니다")
    val mobilePhoneNumber: String? = null,

    @field:Size(max = 255, message = "프로필 이미지 URL은 255자를 초과할 수 없습니다")
    val picture: String? = null,
)
