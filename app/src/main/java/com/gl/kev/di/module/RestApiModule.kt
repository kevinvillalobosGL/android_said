package com.gl.kev.di.module

import com.gl.kev.data.api.ApiHelper
import com.gl.kev.data.api.AppApiHelper
import com.gl.kev.utils.rx.AppSchedulerProvider
import com.gl.kev.utils.rx.SchedulerProvider

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
@Module
open class RestApiModule {

    @Provides
    open fun provideSchedulerProvider(): SchedulerProvider {
        //Since AppSchedulerProvider is on Framework, we cannot add the Inject Constructor
        return AppSchedulerProvider()
    }

    @Provides
    @Singleton
    open fun provideApiHelper(appApiHelper: AppApiHelper): ApiHelper {
        return appApiHelper
    }
}