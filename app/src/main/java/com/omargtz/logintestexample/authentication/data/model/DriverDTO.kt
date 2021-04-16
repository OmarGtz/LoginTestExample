package com.omargtz.logintestexample.authentication.data.model

import com.google.gson.annotations.SerializedName

open class DriverDTO(
    @SerializedName("id")
    var id: String?,
    @SerializedName("email")
    var email: String?,
    @SerializedName("last_name")
    var last_name: String?,
    @SerializedName("username")
    var username: String?,
    @SerializedName("birthday")
    var birthday: String?,
    @SerializedName("gender")
    var gender: String?,
    @SerializedName("picture")
    var picture: String?,
    @SerializedName("first_name")
    var first_name: String?,
    @SerializedName("driver")
    var driver: DriverInfoDTO?,
    @SerializedName("token")
    var token: String?,
    @SerializedName("score")
    var score: String?,
    @SerializedName("trips")
    var trips: String?,
    @SerializedName("seniority")
    var seniority: String?
)

class DriverInfoDTO(
    @SerializedName("id")
    var id: Int?,
    @SerializedName("completed_trips")
    var completed_trips: Int?,
    @SerializedName("cancelled_trips")
    var cancelled_trips: Int ?
)
