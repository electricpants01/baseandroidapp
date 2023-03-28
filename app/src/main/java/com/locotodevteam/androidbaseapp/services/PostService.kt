package com.locotodevteam.androidbaseapp.services

import com.locotodevteam.androidbaseapp.model.Post
import retrofit2.Response
import retrofit2.http.GET

interface PostService {

    @GET("posts")
    suspend fun getAllPosts(): Response<List<Post>>
}