package com.gl.kev.ui.main

import androidx.test.runner.AndroidJUnit4
import com.gl.kev.SaidApp
import io.reactivex.functions.Consumer
import org.junit.Assert
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.Mockito

@RunWith(AndroidJUnit4::class)
@Config(application = SaidApp::class)
class MainViewModelTest {

    @Test
    @Throws(Exception::class)
    fun test() {
        val applicationMock = Mockito.mock(SaidApp::class.java)
        val viewModel = MainViewModel(applicationMock)
        viewModel.getPhotos(Consumer {
            Assert.assertNotNull(it)
        }, Consumer {
            Assert.fail()
        })

    }
}