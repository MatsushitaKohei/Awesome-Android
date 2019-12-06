package com.trickring.app_mvvm_usecase.data.api

import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.request.post

/**
 * RestAPI Client for Ktor.
 *
 * @property httpClient HttpClient fot Ktor
 */
class APIClient(val httpClient: HttpClient) {

    /**
     * RestAPI GET Method.
     *
     * @param T Response Entity Class
     * @param url Request URL
     * @return Response Entity Instance
     */
    suspend inline fun <reified T> get(url: String): T = httpClient.get(url)

    /**
     * RestAPI POST Method.
     *
     * @param T Response Entity Class
     * @param url Request URL
     * @return Response Entity Instance
     */
    suspend inline fun <reified T> post(url: String): T = httpClient.post(url)
}
