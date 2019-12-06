package com.trickring.app_mvvm_usecase.domain.usecase

import com.trickring.app_mvvm_usecase.data.repository.PostRepository
import com.trickring.app_mvvm_usecase.domain.result

class PostUseCase(private val post: PostRepository) {

    suspend fun fetchPosts() = result {
        post.fetchPosts()
    }

    suspend fun fetchPost(id: Int) = result {
        post.fetchPost(id)
    }
}
