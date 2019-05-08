package com.gl.kev.ui.home

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.gl.kev.BR
import com.gl.kev.data.model.Photo
import com.gl.kev.databinding.ItemPhotoBinding
import java.util.*

class PhotoItemAdapter(
    private val mListener: OnPhotoClickListener,
    private val items: ArrayList<Photo> = ArrayList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun addItems(items: List<Photo>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        //Inflate ItemPhotoBinding
        val itemBinding = ItemPhotoBinding.inflate(layoutInflater, parent, false)

        //Return new Photo Item Holder
        return PhotoItemHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as PhotoItemHolder).bind(items[position], mListener)
    }

    interface OnPhotoClickListener {
        fun onPhotoClick(photo: Photo, view: ImageView)
    }

    private class PhotoItemHolder internal constructor(private val mBinding: ItemPhotoBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun bind(photo: Photo, mListener: OnPhotoClickListener) {
            mBinding.setVariable(BR.mPhoto, photo)
            mBinding.executePendingBindings()
            mBinding.cvPhoto.setOnClickListener {
                mListener.onPhotoClick(photo, mBinding.imgPhoto)
            }
        }
    }

}