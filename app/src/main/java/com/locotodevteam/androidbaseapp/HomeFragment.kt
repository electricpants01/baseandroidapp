package com.locotodevteam.androidbaseapp

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.locotodevteam.androidbaseapp.adapter.PostAdapter
import com.locotodevteam.androidbaseapp.databinding.FragmentHomeBinding
import com.locotodevteam.androidbaseapp.model.Post
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    lateinit var homeBinding: FragmentHomeBinding
    lateinit var postAdapter: PostAdapter
    val homeViewModel by viewModels<MainViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        homeBinding = FragmentHomeBinding.bind(view)
        return homeBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initAdapter()
        initSubscribers()

    }

    private fun initAdapter() {
        postAdapter = PostAdapter(emptyList())
        homeBinding.myRecyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.VERTICAL, false)
        homeBinding.myRecyclerView.adapter = postAdapter

        postAdapter.apply {
            listener = object: PostAdapter.OnItemClickListener {
                override fun onPostClick(post: Post) {
                    Log.d("chris", "tocaste ${post.id}")
                    Toast.makeText(requireContext(),"tocaste ${post.title}", Toast.LENGTH_SHORT).show()
                }


            }
        }
    }

    private fun initSubscribers() {
        homeViewModel.postList.observe(viewLifecycleOwner) {
            postAdapter.updateList(it)
        }
    }

}