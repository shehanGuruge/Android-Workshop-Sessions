package com.example.androidsession3.features.posts.presentation.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.androidsession3.databinding.ItemPostBinding
import com.example.androidsession3.features.posts.domain.entities.PostEntity

class PostAdapter(
    private var postList: List<PostEntity>):
    RecyclerView.Adapter<PostListViewHolder>() {

    private lateinit var binding: ItemPostBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostListViewHolder {
        binding = ItemPostBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PostListViewHolder(binding)
    }

    override fun getItemCount(): Int = postList.size

    override fun onBindViewHolder(holder: PostListViewHolder, position: Int) {
        val post = postList[position]
        holder.bind(post)
    }

    fun updateList(posts: List<PostEntity>) {
        postList = posts
        notifyDataSetChanged()
    }
}


class PostListViewHolder(private val binding: ItemPostBinding): RecyclerView.ViewHolder(binding.root) {
    fun bind(post: PostEntity) {
        binding.post = post
    }
}