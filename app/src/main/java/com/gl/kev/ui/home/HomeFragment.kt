package com.gl.kev.ui.home


import android.annotation.SuppressLint
import android.content.Intent
import android.widget.ImageView
import androidx.core.app.ActivityOptionsCompat
import androidx.core.view.ViewCompat
import com.gl.kev.R
import com.gl.kev.data.model.Photo
import com.gl.kev.databinding.FragmentHomeBinding
import com.gl.kev.ui.base.BaseFragment
import com.gl.kev.ui.photo.PhotoDetailsActivity
import com.gl.kev.ui.main.MainViewModel
import com.gl.kev.utils.BaseConstants
import com.google.android.flexbox.*


/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/25/2019
 */
class HomeFragment : BaseFragment<FragmentHomeBinding, MainViewModel>(), PhotoItemAdapter.OnPhotoClickListener {

    private val coordinator = HomeCoordinator()
    lateinit var mAdapter: PhotoItemAdapter

    @SuppressLint("WrongConstant")
    override fun initViews() {
        //Init Adapter
        mAdapter = PhotoItemAdapter(this)

        //Init Flexbox Layout Manager
        val flexboxLayoutManager = FlexboxLayoutManager(context).apply {
            flexWrap = FlexWrap.WRAP
            flexDirection = FlexDirection.ROW
            alignItems = AlignItems.STRETCH
            justifyContent = JustifyContent.SPACE_EVENLY
        }

        //Setup Recycler View
        mBinding.rvPhotoGrid.apply {
            layoutManager = flexboxLayoutManager
            adapter = mAdapter
        }

        //Observe Photos Live Data
        mViewModel.getPhotosLiveDate().observeForever {
            mAdapter.addItems(it)
        }
    }

    override fun getLayout(): Int {
        return R.layout.fragment_home
    }

    override fun getBindingVariable(): Int {
        return BaseConstants.DEFAULT_BINDING_VARIABLE
    }

    override fun onPhotoClick(photo: Photo, view: ImageView) {
        coordinator.goToPhotoDetails(activity!!, photo, view)
    }

}
