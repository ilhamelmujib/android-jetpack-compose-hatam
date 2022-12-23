package org.hatam.android.model

import com.google.gson.annotations.SerializedName

class Video(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("title")
    val title: String? = null,

    @SerializedName("description")
    val description: String? = null,

    @SerializedName("code")
    val code: String? = null,

    @SerializedName("createdAt")
    val createdAt: String? = null,
)