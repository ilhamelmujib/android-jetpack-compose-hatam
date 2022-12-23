package org.hatam.android.model

import com.google.gson.annotations.SerializedName

class Feed(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("caption")
    val caption: String? = null,

    @SerializedName("photo")
    val photo: String? = null,

    @SerializedName("status")
    val status: Int? = null,

    @SerializedName("isLike")
    var isLike: Int? = null,

    @SerializedName("isReported")
    var isReported: Int? = null,

    @SerializedName("totalLikes")
    var totalLikes: Int? = null,

    @SerializedName("createdAt")
    val createdAt: String? = null,

    @SerializedName("teacher")
    val teacher: Teacher? = null,
)

