package com.locotodevteam.androidbaseapp

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.locotodevteam.androidbaseapp.model.Post
import com.locotodevteam.androidbaseapp.services.PostService
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val postService: PostService): ViewModel() {

    val postList: LiveData<List<Post>> = liveData {
        val res = postService.getAllPosts()
        if(res.isSuccessful) {
            withContext(Dispatchers.Main) {
                emit(res.body()!!)
            }
        }else emit(emptyList())
    }

}