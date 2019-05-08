package com.gl.kev.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "todo")
data class Todo(
    @PrimaryKey val id: Int,
    val userId: Int,
    var title: String,
    var completed: Boolean
) {
}