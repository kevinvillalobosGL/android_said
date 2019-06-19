package com.gl.kev.utils

import android.content.Context
import android.graphics.Bitmap
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Rect
import android.graphics.drawable.BitmapDrawable
import android.graphics.drawable.Drawable
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

        @JvmStatic
        fun getDrawableFromText(context: Context, text: String, fontName: String?, width: Int, height: Int): Drawable {
            val bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888)
            val canvas = Canvas(bitmap)
            val paint = Paint()
            if (fontName != null && !fontName.isEmpty()) {
                val typeface = FontCache[fontName, context]
                paint.typeface = typeface
            }
            paint.textAlign = Paint.Align.CENTER


            // Bounds
            val bounds: Rect = Rect()
            canvas.getClipBounds(bounds)

            // Centering for mixed case letters
            canvas.drawText(
                text, 0, text.length,
                bounds.centerX().toFloat(), bounds.centerY().toFloat() - ((paint.descent() + paint.ascent()) / 2), paint
            )

            // Centering for all uppercase letters
            canvas.drawText(
                text, 0, text.length,
                bounds.centerX().toFloat(), bounds.centerY().toFloat() - paint.ascent() / 2, paint
            )
            canvas.drawText(text, 0f, 0f, paint)
            return BitmapDrawable(context.resources, bitmap)
        }

    }
}