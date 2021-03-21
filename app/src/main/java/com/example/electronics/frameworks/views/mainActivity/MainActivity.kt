package com.example.electronics.frameworks.views.mainActivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.*
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.example.electronics.R
import com.example.electronics.databinding.ActivityMainBinding
import com.example.electronics.frameworks.utils.ToolbarType
import com.example.electronics.frameworks.utils.ToolbarType.*

class MainActivity : AppCompatActivity() {

    private var _binding: ActivityMainBinding? = null
    private val binding: ActivityMainBinding get() = _binding!!

    private val viewModel by viewModels<MainViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.viewModel = viewModel
        subscribeOnObservers()
    }

    private fun subscribeOnObservers() {
        viewModel.toolbarName.observe(this, {
            binding.toolbar.setToolbarName(it)
        })
        viewModel.toolbarType.observe(this, {
            when (it) {
                DEFAULT -> {
                    binding.toolbar.toolbar.visibility = VISIBLE
                    binding.toolbar.toolbarName.visibility = GONE
                    binding.toolbar.toolbarBack.visibility = VISIBLE
                }
                TEXT -> {
                    binding.toolbar.toolbar.visibility = VISIBLE
                    binding.toolbar.toolbarName.visibility = VISIBLE
                    binding.toolbar.toolbarBack.visibility = GONE
                }
                BOTH -> {
                    binding.toolbar.toolbar.visibility = VISIBLE
                    binding.toolbar.toolbarName.visibility = VISIBLE
                    binding.toolbar.toolbarBack.visibility = VISIBLE
                }
                NONE -> {
                    binding.toolbar.toolbar.visibility = GONE
                }
            }
        })
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}