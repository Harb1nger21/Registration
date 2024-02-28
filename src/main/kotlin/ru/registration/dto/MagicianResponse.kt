package ru.registration.dto

import ru.registration.model.Competition
import ru.registration.model.Magician

data class MagicianResponse(
    val id: Long?,
    val firstName: String,
    val secondName: String,
    val country: String,
    val city: String,
    val phoneNumber: String,
    val competitions: List<Competition>
) {
    companion object {
        fun toMagicianResponse(magician: Magician, competitions: List<Competition> = emptyList()): MagicianResponse =
            MagicianResponse(
                magician.id,
                magician.firstName,
                magician.secondName,
                magician.country,
                magician.city,
                magician.phoneNumber,
                competitions
            )
    }
}