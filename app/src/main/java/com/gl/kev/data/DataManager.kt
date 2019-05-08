package com.gl.kev.data

import androidx.lifecycle.LiveData
import com.gl.kev.data.api.ApiHelper
import com.gl.kev.data.local.db.DbHelper
import com.gl.kev.data.local.preferences.PreferencesHelper
import com.gl.kev.data.model.Photo
import com.gl.kev.data.model.Todo
import com.gl.kev.data.model.io.PhotoResponse
import com.gl.kev.data.model.io.TodoResponse
import io.reactivex.functions.Consumer

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
interface DataManager {

    fun getDbHelper(): DbHelper

    fun getApiHelper(): ApiHelper

    fun getPreferencesHelper(): PreferencesHelper

    fun getPhotos(response: Consumer<PhotoResponse>, failure: Consumer<Throwable>)

    fun getTodos(response: Consumer<TodoResponse>, failure: Consumer<Throwable>)

    fun getAndSavePhotos(failure: Consumer<Throwable>)

    fun getAndSaveTodos(failure: Consumer<Throwable>)

    //Using RX
    fun getPhotoById(id: Int, consumer: Consumer<Photo>, failure: Consumer<Throwable>)

    //Using Live Data
    fun getTodoById(id: Int) : LiveData<Todo>
}