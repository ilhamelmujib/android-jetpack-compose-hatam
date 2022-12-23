package org.hatam.android.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class User(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("email")
    val email: String? = null,

    @SerializedName("password")
    val password: String? = null,

    @SerializedName("name")
    val name: String? = null,

    @SerializedName("username")
    val username: String? = null,

    @SerializedName("phoneNumber")
    val phoneNumber: String? = null,

    @SerializedName("isVerification")
    val isVerification: String? = null,

    @SerializedName("gender")
    val gender: String? = null,

    @SerializedName("photo")
    val photo: String? = null,

    @SerializedName("signWith")
    val signWith: String? = null,

    @SerializedName("birthDate")
    val birthDate: String? = null,

    @SerializedName("token")
    val token: String? = null,

    @SerializedName("status")
    val status: String? = null,

    @SerializedName("teacher")
    val teacher: Teacher? = null,

    @SerializedName("is_admin")
    val isAdmin: Boolean = false,

    @SerializedName("createdAt")
    val createdAt: String? = null,

    @SerializedName("updatedAt")
    val updatedAt: String? = null,

) : Parcelable