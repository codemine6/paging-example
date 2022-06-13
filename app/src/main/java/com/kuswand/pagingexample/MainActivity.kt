package com.kuswand.pagingexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.map
import androidx.recyclerview.widget.LinearLayoutManager
import com.kuswand.pagingexample.databinding.ActivityMainBinding
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val userAdapter = UserAdapter()
        binding.rvResult.apply {
            layoutManager = LinearLayoutManager(this@MainActivity)
            adapter = userAdapter
        }
        lifecycleScope.launch {
            viewModel.result.collectLatest { result ->
                userAdapter.submitData(result)
                Log.d("aaa", "Result: ${result.map { it.login }}")
            }
        }
    }
}