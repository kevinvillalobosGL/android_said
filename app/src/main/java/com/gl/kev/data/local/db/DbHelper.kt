package com.gl.kev.data.local.db

import com.gl.kev.data.local.db.dao.PhotoDao
import com.gl.kev.data.local.db.dao.TodoDao

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
interface DbHelper {

    fun getPhotoDao(): PhotoDao

    fun getTodoDao(): TodoDao
}