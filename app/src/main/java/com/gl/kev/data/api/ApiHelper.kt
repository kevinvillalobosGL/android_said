package com.gl.kev.data.api

import com.gl.kev.data.model.io.PhotoResponse
import com.gl.kev.data.model.io.TodoResponse
import io.reactivex.Observable

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
interface ApiHelper {

    fun doGetPhotos(): Observable<PhotoResponse>

    fun doGetTodos(): Observable<TodoResponse>

}