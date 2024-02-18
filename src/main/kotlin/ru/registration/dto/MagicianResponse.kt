package ru.registration.dto

import ru.registration.domain.Magician
import ru.registration.dto.CompetitionResponse.Companion.fromCompetition

data class MagicianResponse(
    val id: Long,
    val firstName: String,
    val secondName: String,
    val country: String,
    val city: String,
    val phoneNumber: String,
    val competitions: List<CompetitionResponse>
) {
    companion object {
        fun fromMagician(magician: Magician): MagicianResponse =
            MagicianResponse(
                magician.id,
                magician.firstName,
                magician.secondName,
                magician.country,
                magician.city,
                magician.phoneNumber,
                magician.competitions.map { fromCompetition(it) }
            )
    }
}

