package com.gl.kev.utils

import android.content.Context
import androidx.annotation.ColorInt
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat

/**
 * @author <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 03/12/2019
 */
class ViewUtils {

    companion object {
        @JvmStatic
        @ColorInt
        fun getColor(context: Context?, @ColorRes colorId: Int): Int {
            return if (context != null) ContextCompat.getColor(context, colorId) else 0
        }

        @JvmStatic
        @ColorInt
        fun getIntFromColor(red: Float, green: Float, blue: Float): Int {
            var r = Math.round(255 * red)
            var g = Math.round(255 * green)
            var b = Math.round(255 * blue)

            r = r shl 16 and 0x00FF0000
            g = g shl 8 and 0x0000FF00
            b = b and 0x000000FF

            return -0x1000000 or r or g or b
        }

    }
}