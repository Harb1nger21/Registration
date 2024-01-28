package ru.registration.controller.dto

import ru.registration.entity.Contestant
import ru.registration.entity.Magician

data class MagicianResponse(
    val id: Long,
    val firstName: String,
    val secondName: String,
    val country: String,
    val city: String,
    val phoneNumber: String,
    val nominations: List<Contestant> = emptyList()
) {
    companion object {
        fun fromMagician(magician: Magician): MagicianResponse =
            MagicianResponse(
                id = magician.id,
                firstName = magician.firstName,
                secondName = magician.secondName,
                country = magician.country,
                city = magician.city,
                phoneNumber = magician.phoneNumber,
            )
    }
}