package org.hatam.android.utils

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import org.hatam.android.model.Feed

class AssetParamType : NavType<Feed>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): Feed? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Feed {
        return Gson().fromJson(value, Feed::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: Feed) {
        bundle.putParcelable(key, value)
    }
}