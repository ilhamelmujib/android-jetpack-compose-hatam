package org.hatam.android.utils

fun String?.notNull(): String {
    return this?.replace("\n", "") ?: ""
}

fun Int?.notNull(): Int {
    return this ?: 0
}