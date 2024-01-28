package ru.registration.controller.dto

import ru.registration.entity.Contestant
import ru.registration.entity.Magician

data class MagicianRequest(
    val id: Long,
    val firstName: String,
    val secondName: String,
    val country: String,
    val city: String,
    val phoneNumber: String,
    val nominations: List<Contestant> = emptyList()
) {
    constructor(magician: Magician) : this(
        id = magician.id,
        firstName = magician.firstName,
        secondName = magician.secondName,
        country = magician.country,
        city = magician.city,
        phoneNumber = magician.phoneNumber,
    )

    fun toMagician(): Magician =
        Magician(
            id = id,
            firstName = firstName,
            secondName = secondName,
            country = country,
            city = city,
            phoneNumber = phoneNumber,
        )
}