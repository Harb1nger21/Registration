package ru.registration.service

import org.springframework.stereotype.Service
import ru.registration.model.Competition
import ru.registration.model.Nomination
import ru.registration.repository.CompetitionRepository

@Service
class CompetitionService(private val competitionRepository: CompetitionRepository) {
    fun addCompetition(id: Long, nomination: Nomination, lotNumber: Long) {
        competitionRepository.save(id, nomination, lotNumber)
    }

    fun allCompetitionsById(id: Long): List<Competition> = competitionRepository.getCompetitionsByMagicianId(id)

    fun updateLotNumber(id: Long, nomination: Nomination, lotNumber: Long) {
        competitionRepository.updateLotNumber(id, nomination, lotNumber)
    }

    fun deleteNominationById(id: Long, nomination: Nomination) {
        competitionRepository.deleteNomination(id, nomination)
    }

    fun deleteAllById(id: Long) {
        competitionRepository.deleteAllById(id)
    }
}