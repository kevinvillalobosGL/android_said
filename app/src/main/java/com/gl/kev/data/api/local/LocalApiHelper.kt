package com.gl.kev.data.api.local

import java.io.IOException
import java.io.InputStream

class LocalApiHelper {

    companion object {
        @JvmStatic
        fun inputStreamToString(inputStream: InputStream): String? {
            return try {
                val bytes = ByteArray(inputStream.available())
                inputStream.read(bytes, 0, bytes.size)
                String(bytes)
            } catch (e: IOException) {
                null
            }

        }
    }

}