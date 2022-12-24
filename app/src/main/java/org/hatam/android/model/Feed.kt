package org.hatam.android.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
class Feed(
    @SerializedName("id")
    val id: Int = 0,

    @SerializedName("caption")
    val caption: String? = null,

    @SerializedName("photo")
    val photo: String? = null,

    @SerializedName("totalLikes")
    var totalLikes: String? = null,

    @SerializedName("createdAt")
    val createdAt: String? = null,

    @SerializedName("user")
    val user: User? = null,
) : Parcelable

