package com.omargtz.logintestexample.authentication.domain

import com.omargtz.logintestexample.authentication.data.model.DriverDTO
import com.omargtz.logintestexample.authentication.domain.entity.driver.Driver
import com.omargtz.logintestexample.base.IMapper

object DriverToDomain: IMapper<DriverDTO, Driver>() {
    override fun map(input: DriverDTO): Driver {
        return Driver(
            email = input.email ?: "",
            first_name = input.first_name ?: "",
            last_name = input.last_name ?: "",
            username = input.username ?: "",
            picture = input.picture ?: "",
            canceledTrips = input.driver?.cancelled_trips ?: 0
        )
    }
}
