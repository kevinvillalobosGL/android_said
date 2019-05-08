package com.gl.kev.data.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.gl.kev.data.local.db.dao.PhotoDao
import com.gl.kev.data.local.db.dao.TodoDao
import com.gl.kev.data.model.Photo
import com.gl.kev.data.model.Todo

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
@Database(entities = [Photo::class, Todo::class], version = 1, exportSchema = false)
abstract class AppDataBase : RoomDatabase() {

    abstract fun photoDao(): PhotoDao

    abstract fun todoDao(): TodoDao

}