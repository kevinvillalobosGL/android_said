package com.gl.kev.ui.profile


import com.gl.kev.R
import com.gl.kev.databinding.FragmentProfileBinding
import com.gl.kev.databinding.FragmentSettingsBinding
import com.gl.kev.ui.base.BaseFragment
import com.gl.kev.ui.main.MainViewModel
import com.gl.kev.utils.BaseConstants

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/25/2019
 */
class ProfileFragment : BaseFragment<FragmentProfileBinding, MainViewModel>() {

    override fun initViews() {

    }

    override fun getLayout(): Int {
        return R.layout.fragment_profile
    }

    override fun getBindingVariable(): Int {
        return BaseConstants.DEFAULT_BINDING_VARIABLE
    }
}
