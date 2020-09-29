package com.knittertest.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserEntity(
    @PrimaryKey
    val id: Int,

    var title: String,

    var body: String,

    var updated_at: String
)

