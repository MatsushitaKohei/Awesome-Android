package com.trickring.app_flux.data.api

import com.trickring.app_flux.data.entity.UserEntity
import retrofit2.http.GET
import retrofit2.http.Path

/**
 * User's API for Retrofit
 */
interface UserApi {

    /**
     * Fetch all users
     *
     * @return List of users
     */
    @GET("users")
    suspend fun fetchUsers(): List<UserEntity>

    /**
     * Fetch user by id
     *
     * @param id ID of user
     * @return User
     */
    @GET("users/{id}")
    suspend fun fetchUser(@Path("id") id: Int): UserEntity
}
