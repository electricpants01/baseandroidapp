package com.locotodevteam.androidbaseapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.locotodevteam.androidbaseapp.databinding.PostItemBinding
import com.locotodevteam.androidbaseapp.model.Post

class PostAdapter(private var postList: List<Post>): RecyclerView.Adapter<PostAdapter.PostHolder>() {


    lateinit var listener: OnItemClickListener

    interface OnItemClickListener {
        fun onPostClick(post: Post)
    }

    fun updateList(newList: List<Post>){
        postList = newList
        notifyDataSetChanged()
    }

    class PostHolder(val view: View): RecyclerView.ViewHolder(view) {
        val binding = PostItemBinding.bind(view)

        fun render(post: Post, listener: OnItemClickListener) {
            binding.postTitle.text = post.title
            binding.postDescription.text = post.body
            binding.myCardView.setOnClickListener { listener.onPostClick(post) }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PostAdapter.PostHolder {
        val view = PostItemBinding.inflate( LayoutInflater.from(parent.context),parent, false)
        return PostHolder(view.root)
    }

    override fun onBindViewHolder(holder: PostAdapter.PostHolder, position: Int) {
        val item = postList[position]
        holder.render(item, listener)
    }

    override fun getItemCount(): Int = postList.size


}