package com.gl.kev.ui.photo

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gl.kev.SaidApp
import com.gl.kev.data.DataManager
import com.gl.kev.data.model.Photo
import io.reactivex.functions.Consumer
import javax.inject.Inject

class PhotoDetailsViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var mDataManager: DataManager

    init {
        getApplication<SaidApp>().mApplicationComponent.inject(this)
    }

    fun getPhotoById(id: Int, consumer: Consumer<Photo>, failure: Consumer<Throwable>) {
        mDataManager.getPhotoById(id, consumer, failure)
    }


}