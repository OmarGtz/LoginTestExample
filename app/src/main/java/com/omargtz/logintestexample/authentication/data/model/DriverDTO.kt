package com.omargtz.logintestexample.authentication.data.model

import com.google.gson.annotations.SerializedName

open class DriverDTO(
    @SerializedName("id")
    var id: String? = null,
    @SerializedName("email")
    var email: String? = null,
    @SerializedName("last_name")
    var last_name: String? = null,
    @SerializedName("username")
    var username: String? = null,
    @SerializedName("birthday")
    var birthday: String? = null,
    @SerializedName("gender")
    var gender: String? = null,
    @SerializedName("picture")
    var picture: String? = null,
    @SerializedName("first_name")
    var first_name: String? = null,
    @SerializedName("driver")
    var driver: DriverInfoDTO? = null,
    @SerializedName("token")
    var token: String? = null,
    @SerializedName("score")
    var score: String? = null,
    @SerializedName("trips")
    var trips: String? = null,
    @SerializedName("seniority")
    var seniority: String? = null
)

class DriverInfoDTO(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("completed_trips")
    var completed_trips: Int?,
    @SerializedName("cancelled_trips")
    var cancelled_trips: Int ?
)
