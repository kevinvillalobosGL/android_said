package com.gl.kev.ui.todo

import android.os.Bundle
import com.gl.kev.BR
import com.gl.kev.R
import com.gl.kev.databinding.ActivityTodoDetailsBinding
import com.gl.kev.ui.base.BaseActivity
import com.gl.kev.utils.BaseConstants


class TodoDetailsActivity : BaseActivity<ActivityTodoDetailsBinding, TodoDetailsViewModel>() {

    companion object {
        const val TODO_ID = "TODO_ID"
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
        mBinding.toolbar.setNavigationOnClickListener {
            onBackPressed()
        }

        //Postpone Enter Transition
        supportPostponeEnterTransition()
        //Get the TodoId
        val todoId = intent.getIntExtra(TODO_ID, 0)
        mViewModel.mDataManager.getTodoById(todoId).observeForever {
            mBinding.setVariable(BR.mTodoDetails, it)
            mBinding.executePendingBindings()
            supportStartPostponedEnterTransition()
        }
    }

    override fun getLayout(): Int {
        return R.layout.activity_todo_details
    }

    override fun getBindingVariable(): Int {
        return BaseConstants.DEFAULT_BINDING_VARIABLE
    }

    override fun onBackPressed() {
        supportActionBar?.setDisplayHomeAsUpEnabled(false)
        super.onBackPressed()
    }


}
