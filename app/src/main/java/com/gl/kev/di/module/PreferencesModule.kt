package com.gl.kev.di.module

import com.gl.kev.data.local.preferences.AppPreferencesHelper
import com.gl.kev.data.local.preferences.PreferencesHelper
import com.gl.kev.utils.AppConstants
import com.gl.kev.di.qualifier.PreferenceInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
@Module
class PreferencesModule {

    @Provides
    @PreferenceInfo
    internal fun providePreferenceName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @Singleton
    internal fun providePreferencesHelper(appPreferencesHelper: AppPreferencesHelper): PreferencesHelper {
        return appPreferencesHelper
    }

}