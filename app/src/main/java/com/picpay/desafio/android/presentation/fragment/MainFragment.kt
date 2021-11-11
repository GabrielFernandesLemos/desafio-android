package com.picpay.desafio.android.presentation.fragment

import android.os.Bundle
import android.view.View
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.picpay.desafio.android.R
import com.picpay.desafio.android.databinding.ActivityMainBinding
import com.picpay.desafio.android.presentation.adapter.UserListAdapter
import com.picpay.desafio.android.presentation.viewmodel.MainViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : Fragment(R.layout.activity_main) {

    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding!!
    private val viewModel by viewModel<MainViewModel>()
    private var adapter = UserListAdapter()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = ActivityMainBinding.bind(view)
        setupLoading()
        initRecyclerView()
        initObserver()
    }

    private fun setupLoading() {
        binding.userListProgressBar.isVisible = true
    }

    private fun initObserver() {
        viewModel.state.observe(viewLifecycleOwner) { state ->
            if (state.isLoading) showErrorLoading()
            if (state.isEmptyState) showErrorEmptyList()
            if (state.userList.isNotEmpty()) {
                hideErrorLayout()
                adapter.submitList(state.userList)
                binding.userListProgressBar.isVisible = false
            }

        }
    }

    private fun hideErrorLayout() {
        binding.apply {
            frameError.visibility = View.GONE
            userListProgressBar.isVisible = false
        }
    }

    private fun showErrorLoading() {
        binding.apply {
            frameError.visibility = View.VISIBLE
            textError.text = getString(R.string.loading)
            userListProgressBar.isVisible = true
        }
    }

    private fun showErrorEmptyList() {
        binding.apply {
            frameError.visibility = View.VISIBLE
            textError.text = getString(R.string.empty_list)
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