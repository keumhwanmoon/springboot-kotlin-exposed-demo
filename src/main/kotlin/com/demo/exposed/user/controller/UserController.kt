package com.demo.exposed.user.controller

import com.demo.exposed.common.exception.DuplicateLoginIdException
import com.demo.exposed.common.models.ErrorResponse
import com.demo.exposed.user.models.UserReq
import com.demo.exposed.user.models.UserRes
import com.demo.exposed.user.service.UserService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/users")
class UserController(
    private val userService: UserService
) {
    @GetMapping
    fun getAllUsers(): List<UserRes> {
        return userService.getAllUsers()
    }

    @GetMapping("/{id}")
    fun getUserById(@PathVariable id: Long): UserRes {
        return userService.getUserById(id)
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun registerUser(@RequestBody userReq: UserReq): ResponseEntity<Any> {
        return try {
            ResponseEntity.status(HttpStatus.CREATED).body(userService.registerUser(userReq))
        } catch (e: DuplicateLoginIdException) {
            ResponseEntity
                .status(HttpStatus.CONFLICT)
                .body(
                    ErrorResponse(
                        code = "DUPLICATE_LOGIN_ID",
                        message = e.message ?: "Login ID already exists"
                    )
                )
        }
    }

    @PutMapping("/{id}")
    fun updateUser(@PathVariable id: Long, @RequestBody userReq: UserReq): UserRes? {
        return userService.updateUser(id, userReq)
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    fun deleteUser(@PathVariable id: Long) {
        userService.deleteUser(id)
    }
}