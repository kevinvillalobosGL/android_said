package com.gl.kev.ui.home

import android.app.Activity
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.gl.kev.data.model.Photo
import com.gl.kev.navigation.Navigator

class HomeCoordinator {

    fun goToPhotoDetails(activity: Activity, photo: Photo, view: ImageView) {
        val options = ActivityOptionsCompat.makeSceneTransitionAnimation(
            activity,
            view,
            ViewCompat.getTransitionName(view)!!
        )
        Navigator.toPhotoDetailsActivity(activity, photo, options.toBundle())
    }
}