package com.trickring.app_mvvm_usecase.domain.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import kotlinx.serialization.Serializable

/**
 * Post data class
 *
 * @property id ID
 * @property title Title
 * @property body Content
 */
@Parcelize
@Serializable
data class Post(
    val id: Int,
    val title: String,
    val body: String
) : Parcelable
