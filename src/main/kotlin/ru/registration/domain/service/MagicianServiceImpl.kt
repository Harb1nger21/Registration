package ru.registration.domain.service

import org.springframework.stereotype.Service
import ru.registration.domain.Competition
import ru.registration.domain.repository.CompetitionRepository
import ru.registration.domain.Magician
import ru.registration.domain.repository.MagicianRepository

@Service
class MagicianServiceImpl(private val repository: MagicianRepository, private val rep: CompetitionRepository) :
    MagicianService {

    override fun createMagician(magician: Magician, competitions: List<Competition>) {
        repository.save(magician)
        rep.saveAll(competitions)
    }

    override fun modifyMagician(magician: Magician, competitions: List<Competition>) {
        deleteMagicianById(magician.id)
        for (competition in competitions) {
            rep.save(competition)
        }
        repository.save(magician)
    }

    override fun getMagicianById(id: Long): Magician? = repository.findById(id).orElse(null)

    override fun getAllMagician(): List<Magician> = repository.findAll().toList()

    override fun deleteMagicianById(id: Long) {
//        repository.deleteQwe(id)
        repository.deleteById(id)
//        println(repository.findById(id))
    }
}