package com.omargtz.logintestexample.authentication.domain.entity.driver

class Driver(
    var email: String = "",
    var first_name: String = "",
    var last_name: String = "",
    var username: String = "",
    var picture: String = "",
    var canceledTrips: Int = 0
) {

    fun isActive() = canceledTrips < 10

}