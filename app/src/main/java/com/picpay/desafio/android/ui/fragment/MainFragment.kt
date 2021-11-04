package com.picpay.desafio.android.ui.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.ui.adapter.UserListAdapter
import com.picpay.desafio.android.ui.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment() : Fragment(R.layout.activity_main) {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<MainViewModel>()
    private lateinit var adapter: UserListAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ActivityMainBinding.bind(view)
        setupLoading()
        initObserver()
        initRecyclerView()
//        initListeners()
    }

    private fun setupLoading() {
        binding.userListProgressBar.isVisible = true
    }

    private fun initObserver() {
        viewModel.userEvent.observe(viewLifecycleOwner) { userData ->
            adapter.users = userData
            binding.userListProgressBar.isVisible = false
        }

    }

    private fun initRecyclerView() {
        binding.recyclerView.adapter = adapter
        binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}