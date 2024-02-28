package ru.registration.dto

import ru.registration.model.Nomination

data class CompetitionRequest(
    val nomination: Nomination,
    val lotNumber: Long = 0
)