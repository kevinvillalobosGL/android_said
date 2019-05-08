package com.gl.kev.ui.main

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.gl.kev.SaidApp
import com.gl.kev.data.DataManager
import com.gl.kev.data.model.Photo
import com.gl.kev.data.model.ThemeWrapper
import com.gl.kev.data.model.Todo
import com.gl.kev.data.model.io.PhotoResponse
import com.gl.kev.data.model.io.TodoResponse
import io.reactivex.functions.Consumer
import javax.inject.Inject

class MainViewModel(application: Application) : AndroidViewModel(application) {

    @Inject
    lateinit var mDataManager: DataManager

    val themeData = MutableLiveData<ThemeWrapper>()

    init {
        getApplication<SaidApp>().mApplicationComponent.inject(this)
    }

    fun initData(failure: Consumer<Throwable>) {
        mDataManager.getAndSavePhotos(failure)
        mDataManager.getAndSaveTodos(failure)
    }

    fun getPhotos(consumer: Consumer<PhotoResponse>, failure: Consumer<Throwable>) {
        mDataManager.getPhotos(consumer, failure)
    }

    fun getTodos(consumer: Consumer<TodoResponse>, failure: Consumer<Throwable>) {
        mDataManager.getTodos(consumer, failure)
    }

    fun getPhotosLiveDate(): LiveData<List<Photo>> {
        return mDataManager.getDbHelper().getPhotoDao().getAll()
    }

    fun getTodosLiveDate(): LiveData<List<Todo>> {
        return mDataManager.getDbHelper().getTodoDao().getAll()
    }


}