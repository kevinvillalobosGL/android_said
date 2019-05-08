package com.gl.kev.data.local.db.dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.gl.kev.data.model.Photo

/**
 *
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
@Dao
interface PhotoDao {

    @Query("SELECT * FROM photo")
    fun getAll(): LiveData<List<Photo>>

    @Query("SELECT * FROM photo WHERE id = :id")
    fun getPhotoById(id: Int?): LiveData<Photo>

    @Query("SELECT * FROM photo WHERE id = :id")
    fun getPhotoByIdRx(id: Int?): Photo

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(dataList: List<Photo>)

    @Update
    fun update(dataList: List<Photo>)

    @Query("DELETE FROM photo")
    fun deleteAll()

}