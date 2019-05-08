package com.gl.kev.data.api

import com.gl.kev.data.model.io.PhotoResponse
import com.gl.kev.data.model.io.TodoResponse
import com.rx2androidnetworking.Rx2AndroidNetworking
import io.reactivex.Observable
import javax.inject.Inject

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
class AppApiHelper @Inject constructor() : ApiHelper {

    override fun doGetPhotos(): Observable<PhotoResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.API_URL_PHOTOS)
            .doNotCacheResponse()
            .build()
            .getObjectObservable<PhotoResponse>(PhotoResponse::class.java)
    }

    override fun doGetTodos(): Observable<TodoResponse> {
        return Rx2AndroidNetworking.get(ApiEndPoint.API_URL_TODOS)
            .doNotCacheResponse()
            .build()
            .getObjectObservable<TodoResponse>(TodoResponse::class.java)
    }
}