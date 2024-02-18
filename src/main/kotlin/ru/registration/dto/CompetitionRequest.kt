package ru.registration.dto

import ru.registration.domain.Competition
import ru.registration.domain.Magician
import ru.registration.domain.Nomination


data class CompetitionRequest(
    val magician: Magician?,
    val nomination: Nomination,
    val lotNumber: Long
) {
    fun toCompetition(magician: Magician): Competition = Competition(
        magicianId = magician.id,
        nomination = nomination,
        lotNumber = lotNumber
    )
}