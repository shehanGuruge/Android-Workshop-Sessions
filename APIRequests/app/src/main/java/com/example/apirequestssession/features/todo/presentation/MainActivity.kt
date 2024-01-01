package com.example.apirequestssession.features.todo.presentation

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.apirequestssession.core.base.BaseActivity
import com.example.apirequestssession.core.base.BaseViewModel
import com.example.apirequestssession.databinding.ActivityMainBinding
import com.example.apirequestssession.features.todo.domain.entities.PostEntity
import com.example.apirequestssession.features.todo.presentation.adapter.PostAdapter
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity: BaseActivity() {

    private lateinit var binding: ActivityMainBinding
    private val vm: MainViewModel by viewModel()

    override val baseViewModel: BaseViewModel
        get() = vm

    private lateinit var postAdapter: PostAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpBindings()
        setUpListeners()
    }


    private fun setUpBindings() {
        postAdapter = PostAdapter(vm.postsList.value ?: listOf())
        binding.lifecycleOwner = this
        binding.viewModel = vm
        binding.rcvPostList.adapter = postAdapter
        binding.rcvPostList.layoutManager = LinearLayoutManager(this)

        binding.btnGetTodos.setOnClickListener {
            vm.getPostList()
        }
    }


    private fun setUpListeners() {
        super.initObservers()
        lifecycleScope.launch {
            vm.postsList.collectLatest {
                if(!it.isNullOrEmpty()) {
                    postAdapter.updateList(it)
                }
            }
        }
    }
}