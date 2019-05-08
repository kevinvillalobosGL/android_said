package com.gl.kev

import android.app.Application
import com.androidnetworking.AndroidNetworking
import com.androidnetworking.BuildConfig
import com.androidnetworking.interceptors.HttpLoggingInterceptor
import com.gl.kev.di.component.ApplicationComponent
import com.gl.kev.di.component.DaggerApplicationComponent
import com.gl.kev.di.module.ApplicationModule
import com.gl.kev.di.module.PreferencesModule
import com.gl.kev.di.module.RestApiModule
import com.gl.kev.utils.logs.Logger
import com.gl.kev.di.module.RoomDataBaseModule


class SaidApp : Application() {

    lateinit var mApplicationComponent: ApplicationComponent

    override fun onCreate() {
        super.onCreate()

        //Init Logger
        Logger.init()

        //Init Dagger
        mApplicationComponent = DaggerApplicationComponent
                .builder()
                .applicationModule(ApplicationModule(this))
                .preferencesModule(PreferencesModule())
                .roomDataBaseModule(RoomDataBaseModule(this))
                .restApiModule(RestApiModule())
                .build()

        mApplicationComponent.inject(this)

        //Init Android Networking
        AndroidNetworking.initialize(applicationContext)
        if (BuildConfig.DEBUG) {
            AndroidNetworking.enableLogging(HttpLoggingInterceptor.Level.BODY)
        }
    }

}