package com.gl.kev.data.api

import com.gl.kev.BuildConfig

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
class ApiEndPoint {

    companion object {
        const val API_URL_TODOS = "${BuildConfig.BASE_ENDPOINT_URL}/todos"
        const val API_URL_PHOTOS = "${BuildConfig.BASE_ENDPOINT_URL}/photos"
    }

}