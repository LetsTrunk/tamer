package com.tamerofficial.common.utils

inline fun <reified T : Enum<T>> safeValueOf(type: String?): T? {
    return java.lang.Enum.valueOf(T::class.java, type)
}