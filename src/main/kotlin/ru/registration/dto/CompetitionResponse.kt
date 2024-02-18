package ru.registration.dto

import ru.registration.domain.Competition
import ru.registration.domain.Nomination

data class CompetitionResponse(
    val nomination: Nomination,
    val lotNumber: Long
) {
    companion object {
        fun fromCompetition(competition: Competition): CompetitionResponse =
            CompetitionResponse(competition.nomination, competition.lotNumber)
    }
}