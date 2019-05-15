package com.gl.kev.ui.sample

import android.os.Bundle
import com.gl.kev.BR
import com.gl.kev.R
import com.gl.kev.databinding.ActivitySampleBinding
import com.gl.kev.ui.base.BaseActivity

class SampleActivity : BaseActivity<ActivitySampleBinding, SampleViewModel>() {

    override fun initViews(savedInstanceState: Bundle?) {

    }

    override fun getLayout(): Int {
        return R.layout.activity_sample
    }

    override fun getBindingVariable(): Int {
        return BR.mHandler
    }
}
