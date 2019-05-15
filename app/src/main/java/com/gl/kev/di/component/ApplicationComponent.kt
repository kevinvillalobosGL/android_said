package com.gl.kev.di.component

import com.gl.kev.SaidApp
import com.gl.kev.di.module.ApplicationModule
import com.gl.kev.di.module.PreferencesModule
import com.gl.kev.di.module.RestApiModule
import com.gl.kev.di.module.RoomDataBaseModule
import com.gl.kev.ui.photo.PhotoDetailsViewModel
import com.gl.kev.ui.main.MainViewModel
import com.gl.kev.ui.sample.SampleViewModel
import com.gl.kev.ui.todo.TodoDetailsViewModel
import dagger.Component
import javax.inject.Singleton

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/15/2019
 */
@Singleton
@Component(
    modules = [ApplicationModule::class, PreferencesModule::class,
        RoomDataBaseModule::class, RestApiModule::class]
)
interface ApplicationComponent {

    fun inject(app: SaidApp)

    fun inject(viewModel: MainViewModel)

    fun inject(viewModel: PhotoDetailsViewModel)

    fun inject(viewModel: TodoDetailsViewModel)

    fun inject(viewModel: SampleViewModel)

}