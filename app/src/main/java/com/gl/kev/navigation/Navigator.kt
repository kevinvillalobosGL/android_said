package com.gl.kev.navigation

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import com.gl.kev.data.model.Photo
import com.gl.kev.data.model.Todo
import com.gl.kev.ui.photo.PhotoDetailsActivity
import com.gl.kev.ui.todo.TodoDetailsActivity


class Navigator {

    //Using a companion object to make all of this methods statics since we don't want to create an instance of the Navigator every time
    companion object {

        fun toPhotoDetailsActivity(context: Context, photo: Photo, options: Bundle?) {
            val intent = Intent(context, PhotoDetailsActivity::class.java)
            intent.putExtra(PhotoDetailsActivity.PHOTO_ID, photo.id)
            context.startActivity(intent, options)
        }

        fun toTodoDetailsActivity(context: Context, todo: Todo, options: Bundle?) {
            val intent = Intent(context, TodoDetailsActivity::class.java)
            intent.putExtra(TodoDetailsActivity.TODO_ID, todo.id)
            context.startActivity(intent, options)
        }

        fun goToFragment(
            supportFragmentManager: FragmentManager,
            fragment: Fragment,
            viewId: Int,
            tag: String,
            addToBackStack: Boolean
        ) {
            var transaction = supportFragmentManager.beginTransaction()
                .replace(viewId, fragment, tag)
            if (addToBackStack) {
                transaction = transaction.addToBackStack(tag)
            }
            transaction.commit()
        }
    }
}