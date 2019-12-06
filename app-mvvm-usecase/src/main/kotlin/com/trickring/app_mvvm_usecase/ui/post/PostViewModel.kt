package com.trickring.app_mvvm_usecase.ui.post

import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.trickring.app_mvvm_usecase.App
import com.trickring.app_mvvm_usecase.domain.usecase.PostUseCase
import kotlinx.coroutines.delay

/**
 * Post List Screen's ViewModel. [AndroidViewModel] subclass.
 *
 * @property post UseCase of post
 */
class PostViewModel(app: App, private val post: PostUseCase) : AndroidViewModel(app) {

    /**
     * Posts
     */
    val posts = liveData(viewModelScope.coroutineContext) {
        // FIXME: delay for debug
        delay(3000)
        emit(post.fetchPosts())
    }
}
