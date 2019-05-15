package com.gl.kev.ui.sample

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.gl.kev.SaidApp
import com.gl.kev.data.DataManager
import javax.inject.Inject

class SampleViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var mDataManager: DataManager

    init {
        getApplication<SaidApp>().mApplicationComponent.inject(this)
    }

    fun getSampleText(): String {
        return "Hola Sample!"
    }
}