package com.kuswand.pagingexample.ui.search_user

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.kuswand.pagingexample.SearchViewModel
import com.kuswand.pagingexample.UserAdapter
import com.kuswand.pagingexample.databinding.FragmentSearchUserBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class SearchUserFragment : Fragment() {

    private var _binding: FragmentSearchUserBinding? = null
    private val binding get() = _binding!!
    private val viewModel: SearchViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearchUserBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val userAdapter = UserAdapter()
        binding.rvResult.apply {
            layoutManager = LinearLayoutManager(activity)
            adapter = userAdapter
        }
        lifecycleScope.launch {
            viewModel.result.collectLatest { result ->
                userAdapter.submitData(result)
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}