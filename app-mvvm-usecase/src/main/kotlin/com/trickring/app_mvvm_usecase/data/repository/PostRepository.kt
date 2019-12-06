package com.trickring.app_mvvm_usecase.data.repository

import com.trickring.app_mvvm_usecase.BuildConfig
import com.trickring.app_mvvm_usecase.data.api.APIClient
import com.trickring.app_mvvm_usecase.domain.model.Post

/**
 * Repository of Post
 *
 * @property api APIClient
 */
class PostRepository(private val api: APIClient) {

    /**
     * Fetch all posts
     *
     * @return List of post
     */
    suspend fun fetchPosts(): List<Post> {
        val url = "${BuildConfig.API_BASE_URL}posts"
        return api.get(url)
    }

    /**
     * Fetch post by id
     *
     * @param id ID of post
     * @return Post
     */
    suspend fun fetchPost(id: Int): Post {
        val url = "${BuildConfig.API_BASE_URL}posts/$id"
        return api.get(url)
    }
}
