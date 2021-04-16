package com.omargtz.logintestexample.base

import androidx.lifecycle.MutableLiveData

sealed class LoginResult<out R> {

    data class Success<out T>(val data: T) : LoginResult<T>()
    data class Error(val exception: Throwable) : LoginResult<Nothing>()
    object Loading : LoginResult<Nothing>()

    override fun toString(): String {
        return when (this) {
            is Success<*> -> "Success[data=$data]"
            is Error -> "Error[exception=$exception]"
            Loading -> "Loading"
        }
    }
}

/**
 * [Success.data] if [LoginResult] is of type [Success]
 */
fun <T> LoginResult<T>.successOr(fallback: T): T {
    return (this as? LoginResult.Success<T>)?.data ?: fallback
}

val <T> LoginResult<T>.data: T?
    get() = (this as? LoginResult.Success)?.data

/**
 * Updates value of [liveData] if [LoginResult] is of type [Success]
 */
inline fun <reified T> LoginResult<T>.updateOnSuccess(liveData: MutableLiveData<T>) {
    if (this is LoginResult.Success) {
        liveData.value = data
    }
}