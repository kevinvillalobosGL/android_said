package com.gl.kev.data.local.preferences

interface PreferencesHelper {

    fun getSomeKey(): String?

    fun setSomeKey(value: String)

}