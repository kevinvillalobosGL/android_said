package com.gl.kev.utils

import android.content.ContextWrapper
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.BindingAdapter
import androidx.databinding.BindingConversion
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso


@Suppress("unused")
@BindingAdapter("font")
fun setFont(textView: TextView, fontName: String?) {
    textView.typeface = FontCache[fontName, textView.context]
}

@Suppress("unused")
@BindingAdapter("showIfNull")
fun showIfNull(view: View, o: Any?) {
    view.visibility = if (o == null) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun loadImage(view: ImageView, imageUrl: String?) {
    Picasso.get() // .with(view.getContext())
        .load(imageUrl)
        .into(view) //.placeholder(R.drawable.placeholder)
}

@BindingAdapter("imageUrlPostponed")
fun loadImagePostponed(view: ImageView, imageUrl: String?) {
    Picasso.get()
        .load(imageUrl)
        .into(view, object : Callback {
            override fun onSuccess() {
                if (view.context is AppCompatActivity) {
                    (view.context as AppCompatActivity).supportStartPostponedEnterTransition()
                } else if (view.context is ContextWrapper && (view.context as ContextWrapper).baseContext is AppCompatActivity) {
                    ((view.context as ContextWrapper).baseContext as AppCompatActivity).supportStartPostponedEnterTransition()
                }
            }

            override fun onError(e: Exception?) {
                if (view.context is AppCompatActivity) {
                    (view.context as AppCompatActivity).supportStartPostponedEnterTransition()
                } else if (view.context is ContextWrapper && (view.context as ContextWrapper).baseContext is AppCompatActivity) {
                    ((view.context as ContextWrapper).baseContext as AppCompatActivity).supportStartPostponedEnterTransition()
                }
            }
        })
}

@Suppress("unused")
@BindingConversion
fun convertColorToDrawable(color: String?): ColorDrawable? {
    color ?: return null
    val colorInt = Color.parseColor(color)
    return if (colorInt != 0) ColorDrawable(colorInt) else null
}

@Suppress("unused")
@BindingAdapter("setTextViewColor")
fun setTextViewColor(textView: TextView, color: String?) {
    color ?: return
    val colorInt = Color.parseColor(color)
    textView.setTextColor(colorInt)
}

