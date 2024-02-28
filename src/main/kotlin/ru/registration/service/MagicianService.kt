package ru.registration.service

import org.springframework.stereotype.Service
import ru.registration.model.Magician
import ru.registration.model.Nomination
import ru.registration.repository.CompetitionRepository
import ru.registration.repository.MagicianRepository

@Service
class MagicianService(
    private val magicianRepository: MagicianRepository
) {
    fun getAllMagician(): List<Magician> {
        return magicianRepository.findAll().toList()
    }

    fun addNewMagician(magician: Magician) {
        val id = magicianRepository.getLastId()
        if (id == null) magician.id = 1 else magician.id = id + 1
        magicianRepository.save(magician)
    }

    fun getMagicianById(id: Long): Magician? = magicianRepository.findById(id).orElse(null)

    fun updateMagician(id: Long, magician: Magician) {
        magicianRepository.update(
            id,
            magician.firstName,
            magician.secondName,
            magician.country,
            magician.city,
            magician.phoneNumber
        )
    }

    fun hardDelete(id: Long) {
        magicianRepository.deleteById(id)
    }

    fun softDelete(id: Long) {
        magicianRepository.softDelete(id)
    }
}