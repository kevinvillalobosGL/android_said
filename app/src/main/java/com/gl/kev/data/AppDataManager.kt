package com.gl.kev.data

import androidx.lifecycle.LiveData
import com.gl.kev.data.api.ApiHelper
import com.gl.kev.data.local.db.DbHelper
import com.gl.kev.data.local.preferences.PreferencesHelper
import com.gl.kev.data.model.Photo
import com.gl.kev.data.model.Todo
import com.gl.kev.data.model.io.PhotoResponse
import com.gl.kev.data.model.io.TodoResponse
import com.gl.kev.utils.logs.Logger
import com.gl.kev.utils.rx.SchedulerProvider
import io.reactivex.functions.Consumer
import java.util.concurrent.Callable
import javax.inject.Inject

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
class AppDataManager @Inject constructor(
    private val mDbHelper: DbHelper,
    private val mApiHelper: ApiHelper,
    private val mPreferencesHelper: PreferencesHelper,
    mSchedulerProvider: SchedulerProvider
) : DataManager, BaseDataManager(mSchedulerProvider) {

    override fun getPhotoById(id: Int, consumer: Consumer<Photo>, failure: Consumer<Throwable>) {
        genericCallable(Callable { mDbHelper.getPhotoDao().getPhotoByIdRx(id) }, consumer, failure)
    }

    override fun getTodoById(id: Int) : LiveData<Todo> {
        return mDbHelper.getTodoDao().getTodoById(id)
    }

    override fun getTodos(response: Consumer<TodoResponse>, failure: Consumer<Throwable>) {
        getCompositeDisposable().add(
            mApiHelper.doGetTodos()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(response, failure)
        )
    }

    override fun getPhotos(response: Consumer<PhotoResponse>, failure: Consumer<Throwable>) {
        getCompositeDisposable().add(
            mApiHelper.doGetPhotos()
                .subscribeOn(mSchedulerProvider.io())
                .observeOn(mSchedulerProvider.ui())
                .subscribe(response, failure)
        )
    }

    override fun getAndSavePhotos(failure: Consumer<Throwable>) {
        getCompositeDisposable().add(
            mApiHelper.doGetPhotos()
                .subscribeOn(mSchedulerProvider.io()) //Note both of these are happening in the in the IO
                .map {
                    mDbHelper.getPhotoDao().insertAll(it)
                    it
                }
                .observeOn(mSchedulerProvider.ui())
                .subscribe(Consumer {
                    Logger.i("I retrieved ${it.size} photos")
                }, failure)
        )
    }

    override fun getAndSaveTodos(failure: Consumer<Throwable>) {
        getCompositeDisposable().add(
            mApiHelper.doGetTodos()
                .subscribeOn(mSchedulerProvider.io()) //Note both of these are happening in the in the IO
                .map {
                    mDbHelper.getTodoDao().insertAll(it)
                    it
                }
                .observeOn(mSchedulerProvider.ui())
                .subscribe(Consumer {
                    Logger.i("I retrieved ${it.size} todos'")
                }, failure)
        )
    }

    override fun getDbHelper(): DbHelper {
        return mDbHelper
    }

    override fun getApiHelper(): ApiHelper {
        return mApiHelper
    }

    override fun getPreferencesHelper(): PreferencesHelper {
        return mPreferencesHelper
    }

}