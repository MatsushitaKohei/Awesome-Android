package com.trickring.app_flux.di

import com.trickring.app_flux.App
import com.trickring.app_flux.action.post.PostActionCreator
import com.trickring.app_flux.data.api.PostApi
import com.trickring.app_flux.data.api.UserApi
import com.trickring.app_flux.data.repository.PostRepository
import com.trickring.app_flux.data.repository.UserRepository
import com.trickring.app_flux.flux.Dispatcher
import com.trickring.app_flux.ui.post.PostStore
import kotlinx.serialization.UnstableDefault
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

/**
 * Dependency Module for Koin.
 */
object AppModule {

    /**
     * Module Instance.
     */
    val instance = module {
        // ViewModel Module
        // This class must be subclass of AndroidX ViewModel.
        viewModel {
            PostStore(
                androidApplication() as App,
                get()
            )
        }

        // Dispatcher Module
        // This class must managed by a singleton.
        single { Dispatcher() }

        // ActionCreator Module
        // This class must managed by a factory. Factory is always recreated.
        factory { PostActionCreator(get(), get(), get()) }

        // Repository Module
        // This class must managed by a singleton.
        single { PostRepository(get()) }
        single { UserRepository(get()) }

        // Network Module
        // This class must managed by a singleton.
        single { NetworkModule.provideOkHttpClient(androidApplication()) }
        single<PostApi> { NetworkModule.provideRetrofitApi(get()) }
        single<UserApi> { NetworkModule.provideRetrofitApi(get()) }
    }
}
