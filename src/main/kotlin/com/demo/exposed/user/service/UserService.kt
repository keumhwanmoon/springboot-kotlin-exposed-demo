package com.demo.exposed.user.service

import com.demo.exposed.user.domain.repositories.UserDao
import com.demo.exposed.user.models.UserReq
import com.demo.exposed.user.models.UserRes
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userDao: UserDao
) {
    fun getAllUsers(
        page: Int = 0,
        size: Int = 20,
        sortBy: String = "id",
        isAsc: Boolean = true
    ): List<UserRes> {
        return userDao.getAllUsers(page, size, sortBy, isAsc)
    }

    fun getUserById(id: Long): UserRes {
        val user = userDao.findById(id) ?: throw IllegalArgumentException("User with ID $id not found")
        return UserRes.from(user)
    }

    fun registerUser(userReq: UserReq): UserRes {
        val newUser = userDao.create(userReq)
        return UserRes.from(newUser)
    }

    fun updateUser(id: Long, userReq: UserReq): UserRes? {
        userDao.findById(id) ?: throw IllegalArgumentException("User with ID $id not found")
        val updatedUser = userDao.update(id, userReq)
        return updatedUser?.let { UserRes.from(it) }
    }

    fun deleteUser(id: Long) {
        userDao.findById(id) ?: throw IllegalArgumentException("User with ID $id not found")
        userDao.delete(id)
    }
}
