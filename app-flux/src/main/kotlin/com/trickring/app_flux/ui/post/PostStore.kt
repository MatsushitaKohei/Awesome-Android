package com.trickring.app_flux.ui.post

import androidx.lifecycle.LiveData
import androidx.lifecycle.asLiveData
import com.trickring.app_flux.App
import com.trickring.app_flux.action.post.PostAction
import com.trickring.app_flux.flux.Dispatcher
import com.trickring.app_flux.flux.Result
import com.trickring.app_flux.flux.Store
import com.trickring.app_flux.model.Post
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.mapNotNull

/**
 * Post List Screen's Store. [Store] subclass.
 *
 * @param app Application
 * @param dispatcher Dispatcher
 */
class PostStore(app: App, private val dispatcher: Dispatcher) : Store(app) {

    /**
     * Posts
     */
    val posts: LiveData<Result<List<Post>>> = dispatcher.event
        .asFlow()
        .mapNotNull { it as? PostAction.FetchedPosts }
        .mapNotNull { it.result }
        .asLiveData(scope.coroutineContext)
}
