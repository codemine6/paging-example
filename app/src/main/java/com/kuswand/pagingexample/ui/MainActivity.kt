package com.kuswand.pagingexample.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.kuswand.pagingexample.R
import com.kuswand.pagingexample.databinding.ActivityMainBinding
import com.kuswand.pagingexample.ui.search_user.SearchUserFragment

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportFragmentManager.beginTransaction().apply {
            add(R.id.flContainer, SearchUserFragment())
            commit()
        }
    }
}