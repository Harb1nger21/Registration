package ru.registration.dto

import ru.registration.model.Magician

data class MagicianRequest(
    val firstName: String,
    val secondName: String,
    val country: String,
    val city: String,
    val phoneNumber: String,
) {

    fun toMagician(): Magician {
        val magician = Magician(
            id = 0,
            firstName = firstName,
            secondName = secondName,
            country = country,
            city = city,
            phoneNumber = phoneNumber
        )
        return magician
    }
}