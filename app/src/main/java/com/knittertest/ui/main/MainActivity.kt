package com.knittertest.ui.main

import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.knittertest.databinding.ActivityMainBinding
import com.knittertest.ui.base.BaseActivity
import com.knittertest.utils.viewModelOf

class MainActivity : BaseActivity<MainViewModel, ActivityMainBinding>() {

    private val userAdapter by lazy {
        UserPagedListAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(mViewBinding.root)

        mViewBinding.apply {
            userRecyclerView.apply {
                layoutManager = LinearLayoutManager(this@MainActivity)
                adapter = userAdapter
            }
        }

        initObservers()

    }

    override fun getViewModel(): MainViewModel = viewModelOf<MainViewModel>(mViewModelProvider)

    override fun getViewBinding(): ActivityMainBinding = ActivityMainBinding.inflate(layoutInflater)

    private fun initObservers() {
        mViewModel.userList.observe(this, Observer {
            mViewBinding.progressBar.visibility = GONE
            mViewBinding.userRecyclerView.visibility = VISIBLE
            val list = it
            userAdapter.submitList(list)
        })
    }

}