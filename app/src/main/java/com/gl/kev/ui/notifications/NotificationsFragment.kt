package com.gl.kev.ui.notifications


import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.gl.kev.R
import com.gl.kev.data.model.Todo
import com.gl.kev.databinding.FragmentNotificationsBinding
import com.gl.kev.ui.base.BaseFragment
import com.gl.kev.ui.main.MainViewModel
import com.gl.kev.utils.BaseConstants

/**
 * @author Gorilla Logic - <a href="mailto:kevin.villalobos@gorillalogic.com">Kevin Villalobos</a>
 * @since 04/25/2019
 */
class NotificationsFragment : BaseFragment<FragmentNotificationsBinding, MainViewModel>(),
    TodoItemAdapter.OnTodoClickListener {

    private val coordinator = NotificationsCoordinator()
    private lateinit var mAdapter: TodoItemAdapter

    override fun initViews() {
        //Init Adapter
        mAdapter = TodoItemAdapter(this)

        //Setup Recycler View
        mBinding.rvTodoList.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = mAdapter
        }

        //Observe Photos Live Data
        mViewModel.getTodosLiveDate().observeForever {
            mAdapter.addItems(it)
        }

    }

    override fun onTodoClick(todo: Todo, view: View, text: View) {
        coordinator.goToTodoDetails(activity!!, todo, view, text)
    }

    override fun getLayout(): Int {
        return R.layout.fragment_notifications
    }

    override fun getBindingVariable(): Int {
        return BaseConstants.DEFAULT_BINDING_VARIABLE
    }
}
