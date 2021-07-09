package com.ddxz.catlibrary

import android.os.Bundle
import android.widget.LinearLayout
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.SimpleItemAnimator
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ddxz.catlibrary.adapter.CatAdapter
import com.ddxz.catlibrary.base.BaseActivity
import com.ddxz.catlibrary.databinding.ActivityMainBinding
import com.ddxz.catlibrary.util.logD
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.cats.observe(this, {
            logD(TAG, "size:${it.size}")
        })

//        viewModel.fetchCatsList()

        val pagingAdapter = CatAdapter()
        val manager = StaggeredGridLayoutManager(2, LinearLayout.VERTICAL)
        manager.gapStrategy = StaggeredGridLayoutManager.GAP_HANDLING_NONE
        binding.recyclerView.layoutManager = manager
//        (binding.recyclerView.itemAnimator as DefaultItemAnimator).supportsChangeAnimations = false
//        (binding.recyclerView.itemAnimator as SimpleItemAnimator).supportsChangeAnimations = false
//        (binding.recyclerView.itemAnimator as DefaultItemAnimator).changeDuration = 0
        binding.recyclerView.adapter = pagingAdapter
//        binding.recyclerView.setHasFixedSize(true)
//        binding.recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
//
//            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
//                super.onScrolled(recyclerView, dx, dy)
//                //防止第一行到顶部有空白
//                manager.invalidateSpanAssignments()
//            }
//        })

        lifecycleScope.launch {
            viewModel.flow.collectLatest { pagingData ->
                logD(TAG, "pagingData:$pagingData")
                pagingAdapter.submitData(pagingData)
            }
        }
    }
}