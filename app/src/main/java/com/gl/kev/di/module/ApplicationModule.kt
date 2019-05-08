package com.gl.kev.di.module

import android.app.Application
import android.content.Context
import com.gl.kev.di.qualifier.ApplicationContext
import dagger.Module
import dagger.Provides


/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
@Module
class ApplicationModule(private val mApplication: Application) {

    @Provides
    @ApplicationContext
    internal fun provideContext(): Context {
        return mApplication
    }

}