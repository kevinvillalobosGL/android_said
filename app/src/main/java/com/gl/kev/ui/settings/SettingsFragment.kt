package com.gl.kev.ui.settings


import com.gl.kev.BR
import com.gl.kev.R
import com.gl.kev.databinding.FragmentSettingsBinding
import com.gl.kev.ui.base.BaseFragment
import com.gl.kev.ui.main.MainViewModel

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/25/2019
 */
class SettingsFragment : BaseFragment<FragmentSettingsBinding, MainViewModel>() {

    override fun initViews() {
    }

    override fun getLayout(): Int {
        return R.layout.fragment_settings
    }

    override fun getBindingVariable(): Int {
        return BR.mHandler
    }
}
