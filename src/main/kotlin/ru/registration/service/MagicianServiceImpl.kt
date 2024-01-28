package ru.registration.service

import org.springframework.stereotype.Service
import ru.registration.entity.Magician
import ru.registration.entity.Nomination
import ru.registration.repository.ContestantRepository
import ru.registration.repository.MagicianRepository

@Service
class MagicianServiceImpl(
    private val magicianRepository: MagicianRepository,
    private val contestantRepository: ContestantRepository
) : MagicianService {
    override fun addMagician(magician: Magician) {
        magicianRepository.save(magician)
    }

    override fun all(): List<Magician> {
        return magicianRepository.findAll().toList()
    }

    override fun magicianById(id: Long): Magician {
        return magicianRepository.findById(id).get()
    }

    override fun allByNomination(nomination: Nomination): List<Magician> {
        val contestantRecords = contestantRepository.findIdsByNomination(nomination)
        return all().filter { contestantRecords.contains(it.id) }
    }

    override fun updateMagician(magician: Magician) {
        magicianRepository.update(magician)
    }

    override fun deleteMagician(magician: Magician) {
        magicianRepository.delete(magician)
    }
}