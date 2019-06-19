package com.gl.kev.ui.photo

import android.content.DialogInterface
import android.graphics.PorterDuff
import android.graphics.PorterDuffColorFilter
import android.os.Bundle
import android.widget.Toast
import com.gl.kev.BR
import com.gl.kev.R
import com.gl.kev.databinding.ActivityPhotoDetailsBinding
import com.gl.kev.ui.base.BaseActivity
import com.gl.kev.utils.BaseConstants
import com.gl.kev.utils.ViewUtils
import com.gl.kev.utils.logs.Logger
import com.google.android.material.appbar.AppBarLayout
import io.reactivex.functions.Consumer


class PhotoDetailsActivity : BaseActivity<ActivityPhotoDetailsBinding, PhotoDetailsViewModel>() {

    companion object {
        const val PHOTO_ID = "PHOTO_ID"
    }

    override fun initViews(savedInstanceState: Bundle?) {
        //Set up Toolbar
        setSupportActionBar(mBinding.toolbar)
        supportActionBar?.apply {
            title = ""
            setDisplayShowTitleEnabled(true)
            setDisplayHomeAsUpEnabled(true)

        }
        //On Back Pressed could be managed by a Coordinator as well but since this is simple I'm using the default
        mBinding.toolbar.setNavigationOnClickListener { onBackPressed() }

        //Change color of the arrow depending of the scroll offset
        mBinding.appBar.addOnOffsetChangedListener(AppBarLayout.OnOffsetChangedListener { appBarLayout: AppBarLayout, offset: Int ->
            val colorComponent = 1 - Math.max(0.1f, (offset.toFloat() + 0.5f) / -appBarLayout.totalScrollRange)
            mBinding.toolbar.navigationIcon?.colorFilter =
                PorterDuffColorFilter(
                    ViewUtils.getIntFromColor(colorComponent, colorComponent, colorComponent),
                    PorterDuff.Mode.SRC_ATOP
                )

            if (offset > 0.5) {
                Toast.makeText(this, "Collapsed", Toast.LENGTH_SHORT).show()
            }
        })

        //Postpone Enter Transition
        supportPostponeEnterTransition()

        //Get the Photo Id
        val photoId = intent.getIntExtra(PHOTO_ID, 0)

        //Rx Call to get the Photo Instance
        mViewModel.getPhotoById(photoId,
            Consumer {
                supportActionBar?.title = it.title
                mBinding.setVariable(BR.mPhotoDetails, it)
                mBinding.executePendingBindings()
            },
            Consumer {
                supportStartPostponedEnterTransition()
                Logger.e(it.message, it)
                showGeneralAlertDialog("We couldn't load your Photo!",
                    DialogInterface.OnClickListener { dialog, _ ->
                        dialog?.dismiss()
                        finish()
                    })
            }
        )

    }

    override fun getLayout(): Int {
        return R.layout.activity_photo_details
    }

    override fun getBindingVariable(): Int {
        return BaseConstants.DEFAULT_BINDING_VARIABLE
    }

}
