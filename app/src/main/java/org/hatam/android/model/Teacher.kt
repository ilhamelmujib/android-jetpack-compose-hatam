package org.hatam.android.model

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
class Teacher(
    @SerializedName("id")
    val id: Int? = null,

    @SerializedName("lastAcademic")
    val lastAcademic: String? = null,

    @SerializedName("institution")
    val institution: String? = null,

    @SerializedName("idCard")
    val idCard: String? = null,

    @SerializedName("certificate")
    val certificate: String? = null,

    @SerializedName("video")
    val video: String? = null,

    @SerializedName("status")
    val status: Int? = null,

    @SerializedName("notes")
    val notes: String? = null,

    @SerializedName("user")
    val user: User? = null,

    @SerializedName("createdAt")
    val createdAt: String? = null,

    @SerializedName("updatedAt")
    val updatedAt: String? = null,
) : Parcelable