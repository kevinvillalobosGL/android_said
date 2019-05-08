package com.gl.kev.di.module

import android.app.Application
import androidx.room.Room
import com.gl.kev.data.AppDataManager
import com.gl.kev.data.DataManager
import com.gl.kev.data.local.db.AppDataBase
import com.gl.kev.data.local.db.AppDbHelper
import com.gl.kev.data.local.db.DbHelper
import com.gl.kev.utils.AppConstants
import com.gl.kev.di.qualifier.DatabaseInfo
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
@Module
class RoomDataBaseModule(private val mApplication: Application) {

    @Provides
    @DatabaseInfo
    internal fun provideDatabaseName(): String {
        return AppConstants.DB_NAME
    }

    @Provides
    @Singleton
    internal fun provideDataManager(appDataManager: AppDataManager): DataManager {
        return appDataManager
    }

    @Provides
    @Singleton
    internal fun provideAppDatabase(@DatabaseInfo dbName: String): AppDataBase {
        return Room.databaseBuilder(mApplication, AppDataBase::class.java, dbName)
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    internal fun provideDBHelper(appDbHelper: AppDbHelper): DbHelper {
        return appDbHelper
    }
}