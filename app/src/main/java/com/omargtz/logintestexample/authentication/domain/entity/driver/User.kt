package com.omargtz.logintestexample.authentication.domain.entity.driver

import android.util.Patterns

class User(
    var email: String,
    var password: String
) {

    fun emailIsValid() = Patterns.EMAIL_ADDRESS.matcher(email).matches()

    fun passwordIsValid() = password.length > 7

}