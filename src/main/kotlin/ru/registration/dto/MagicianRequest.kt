package ru.registration.dto

import ru.registration.domain.Magician


data class MagicianRequest(
    val firstName: String,
    val secondName: String,
    val country: String,
    val city: String,
    val phoneNumber: String,
    var competitionRequestList: List<CompetitionRequest> = emptyList()
) {
//    constructor(magician: Magician) : this(
//        firstName = magician.firstName,
//        secondName = magician.secondName,
//        country = magician.country,
//        city = magician.city,
//        phoneNumber = magician.phoneNumber,
////        competitions = magician.competitions
//        competitionRequestList = magician.competitions.map { CompetitionRequest(it) }
//    )

    fun toMagician(): Magician {
        val magician = Magician(
            firstName = firstName,
            secondName = secondName,
            country = country,
            city = city,
            phoneNumber = phoneNumber
//        competitions = competitions
//            competitions = competitions.map { it.toCompetition(this) }
        )
//        val competitions = competitionRequestList.map { it.toCompetition(magician) }
//        magician.competitions = competitions
        return magician
    }

    fun toMagician(id: Long): Magician {
        val magician = Magician(
            id = id,
            firstName = firstName,
            secondName = secondName,
            country = country,
            city = city,
            phoneNumber = phoneNumber,
//        competitions = competitions
//            competitions = competitions.map { it.toCompetition(this) }
        )
//        val competitions = competitionRequestList.map { it.toCompetition(id, magician) }
//        magician.competitions = competitions
        return magician
    }
}