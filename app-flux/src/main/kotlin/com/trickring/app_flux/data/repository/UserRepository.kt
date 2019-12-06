package com.trickring.app_flux.data.repository

import com.trickring.app_flux.data.api.UserApi
import com.trickring.app_flux.data.entity.UserEntity

/**
 * Repository of User
 *
 * @property user UserApi
 */
class UserRepository(private val user: UserApi) {

    /**
     * Cache of user
     */
    private val cache = mutableMapOf<Int, UserEntity>()

    /**
     * Fetch all users
     *
     * @return List of user
     */
    suspend fun fetchUsers(): List<UserEntity> {
        return user.fetchUsers().onEach {
            cache[it.id] = it
        }
    }

    /**
     * Fetch user by id
     *
     * @param id ID of user
     * @return User
     */
    suspend fun fetchUser(id: Int): UserEntity {
        return cache.getOrElse(id) {
            val user = user.fetchUser(id)
            cache[id] = user
            return user
        }
    }
}
