package com.gl.kev.ui.main


import android.content.DialogInterface
import android.os.Bundle
import com.gl.kev.R
import com.gl.kev.data.api.local.LocalApiHelper
import com.gl.kev.data.model.ThemeWrapper
import com.gl.kev.databinding.ActivityMainBinding
import com.gl.kev.ui.base.BaseActivity
import com.gl.kev.utils.BaseConstants
import com.gl.kev.utils.logs.Logger
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.gson.Gson
import io.reactivex.functions.Consumer


class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {

    private val coordinator = MainCoordinator(supportFragmentManager)
    private lateinit var retryClickListener: DialogInterface.OnClickListener
    private lateinit var mOnNavigationItemSelectedListener: BottomNavigationView.OnNavigationItemSelectedListener

    override fun initViews(savedInstanceState: Bundle?) {
        //Setup the Coordinator, in this case handles the Fragments on its own and Navigation between them
        mOnNavigationItemSelectedListener = coordinator.getNavigationListener()
        mBinding.bottomNavigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        coordinator.showFirstFragment(savedInstanceState)

        val failureConsumer = Consumer<Throwable> {
            showDataErrorDialog(it)
        }
        retryClickListener = DialogInterface.OnClickListener { _, _ ->
            mViewModel.initData(failureConsumer)
            mDialog?.dismiss()
            mDialog = null
        }

        //Photos and Todos are retrieved once in the Main activity...
        mViewModel.initData(failureConsumer)

        //Try to get Local Json File
        val json = LocalApiHelper.inputStreamToString(resources.openRawResource(R.raw.theme))
        mViewModel.themeData.value = Gson().fromJson(json, ThemeWrapper::class.java)
        //If MainActivity requires something from the theme here we should set the Binding Variable

    }

    private fun showDataErrorDialog(throwable: Throwable) {
        //Here we could count the number of retries and do something else... In the meantime infinite loop until possible
        showGeneralAlertDialog("Something went wrong", "Retry", retryClickListener)
        Logger.e(throwable.message, throwable)
    }

    override fun getLayout(): Int {
        return R.layout.activity_main
    }

    override fun getBindingVariable(): Int {
        return BaseConstants.DEFAULT_BINDING_VARIABLE
    }


}
