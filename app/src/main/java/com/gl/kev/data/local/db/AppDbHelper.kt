package com.gl.kev.data.local.db

import com.gl.kev.data.local.db.dao.PhotoDao
import com.gl.kev.data.local.db.dao.TodoDao
import javax.inject.Inject

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
class AppDbHelper @Inject constructor(private val mAppDatabase: AppDataBase) : DbHelper {

    override fun getPhotoDao(): PhotoDao {
        return mAppDatabase.photoDao()
    }

    override fun getTodoDao(): TodoDao {
        return mAppDatabase.todoDao()
    }
}