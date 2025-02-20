package com.demo.exposed.user.domain.entities

import org.jetbrains.exposed.sql.Table
import org.jetbrains.exposed.sql.javatime.datetime

object Users : Table() {
    val id = long("id").autoIncrement()
    val loginId = varchar("login_id", 50)
    val userName = varchar("user_name", 100)
    val picture = varchar("picture", 255).nullable()
    val phoneNumber = varchar("phone_number", 20).nullable()
    val mobilePhoneNumber = varchar("mobile_phone_number", 20).nullable()
    val email = varchar("email", 100).nullable()
    val createdAt = datetime("created_at")
    val lastUpdatedAt = datetime("last_updated_at").nullable()

    override val primaryKey = PrimaryKey(id)

}
