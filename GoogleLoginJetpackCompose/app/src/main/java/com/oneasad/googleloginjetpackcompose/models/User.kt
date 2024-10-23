package com.oneasad.googleloginjetpackcompose.models

data class User(
    var id: String = "",
    val name: String = "",
    val photoUrl: String = "",
    val email: String = "",
    val country: String = "",
    val subscription: String = ""
)
