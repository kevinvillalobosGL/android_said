package com.gl.kev.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gl.kev.data.model.Todo

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
@Dao
interface TodoDao {

    @Query("SELECT * FROM todo")
    fun getAll(): LiveData<List<Todo>>

    @Query("SELECT * FROM todo WHERE id = :id")
    fun getTodoById(id: Int?): LiveData<Todo>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(dataList: List<Todo>)

    @Update
    fun update(dataList: List<Todo>)

    @Query("DELETE FROM todo")
    fun deleteAll()

}