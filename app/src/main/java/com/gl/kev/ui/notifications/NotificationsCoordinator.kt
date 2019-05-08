package com.gl.kev.ui.notifications

import android.app.Activity
import android.view.View
import androidx.core.app.ActivityOptionsCompat
import androidx.core.util.Pair
import androidx.core.view.ViewCompat
import com.gl.kev.data.model.Todo
import com.gl.kev.navigation.Navigator

class NotificationsCoordinator {

    fun goToTodoDetails(activity: Activity, todo: Todo, view: View, text: View) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            activity,
            Pair(view, ViewCompat.getTransitionName(view)!!),
            Pair(text, ViewCompat.getTransitionName(text)!!)
        )
        Navigator.toTodoDetailsActivity(activity, todo, options.toBundle())
    }

}