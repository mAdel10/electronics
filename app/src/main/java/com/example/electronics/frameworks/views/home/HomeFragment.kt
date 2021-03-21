package com.example.electronics.frameworks.views.home

import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.electronics.R
import com.example.electronics.R.string.home
import com.example.electronics.databinding.FragmentHomeBinding
import com.example.electronics.frameworks.utils.ToolbarType.TEXT
import com.example.electronics.frameworks.views.base.BaseFragment


class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val homeViewModel by viewModels<HomeViewModel>()
    private var layoutManager: RecyclerView.LayoutManager? = null
    private lateinit var adapter: HomeAdapter

    override fun bindViews() {
        viewModel.UpdateToolbarType(TEXT)
        viewModel.UpdateToolbarName(getString(home))
        binding.textView.setOnClickListener { findNavController().navigate(HomeFragmentDirections.toProducts()) }
        subscribeOnObservers()
        initRecyclerView()
    }


    private fun subscribeOnObservers() {
        homeViewModel.getProductResponse().observe(this, {
            Toast.makeText(requireContext(), it.data.products.size.toString(), Toast.LENGTH_LONG)
                .show()

            adapter.setProducts(it.data.products)


        })
    }


    private fun initRecyclerView() {
        adapter = HomeAdapter(mutableListOf())
        binding.recyclerView.adapter = adapter
        layoutManager = LinearLayoutManager(context)
        binding.recyclerView.layoutManager = layoutManager
    }

    override fun getLayoutResId() = R.layout.fragment_home

}