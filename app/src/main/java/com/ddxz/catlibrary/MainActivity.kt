package com.ddxz.catlibrary

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.ddxz.catlibrary.base.BaseActivity
import com.ddxz.catlibrary.databinding.ActivityMainBinding
import com.ddxz.catlibrary.util.logD

class MainActivity : BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: MainViewModel = ViewModelProvider(this).get(MainViewModel::class.java)
        viewModel.cats.observe(this, {
            logD("riki", "size:${it.size}")
        })

        viewModel.fetchCatsList()
    }
}