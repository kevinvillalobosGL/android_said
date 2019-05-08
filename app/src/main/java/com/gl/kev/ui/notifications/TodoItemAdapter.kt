package com.gl.kev.ui.notifications

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.gl.kev.BR
import com.gl.kev.data.model.Todo
import com.gl.kev.databinding.ItemTodoBinding
import java.util.*

class TodoItemAdapter(
    private val mListener: OnTodoClickListener,
    private val items: ArrayList<Todo> = ArrayList()
) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    fun addItems(items: List<Todo>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)

        //Inflate ItemPhotoBinding
        val itemBinding = ItemTodoBinding.inflate(layoutInflater, parent, false)

        //Return new Photo Item Holder
        return TodoItemHolder(itemBinding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        (holder as TodoItemHolder).bind(items[position], mListener)
    }

    interface OnTodoClickListener {
        fun onTodoClick(todo: Todo, view: View, text: View)
    }

    private class TodoItemHolder internal constructor(private val mBinding: ItemTodoBinding) :
        RecyclerView.ViewHolder(mBinding.root) {

        fun bind(todo: Todo, mListener: OnTodoClickListener) {
            mBinding.setVariable(BR.mTodo, todo)
            mBinding.executePendingBindings()
            mBinding.llItem.setOnClickListener {
                mListener.onTodoClick(todo, mBinding.llItem, mBinding.txTodo)
            }
        }
    }

}