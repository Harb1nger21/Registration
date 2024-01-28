package ru.registration.service

import ru.registration.entity.Magician
import ru.registration.entity.Nomination

interface MagicianService {
    fun addMagician(magician: Magician)
    fun all(): List<Magician>
    fun magicianById(id: Long): Magician?
    fun allByNomination(nomination: Nomination): List<Magician>
    fun updateMagician(magician: Magician)
    fun deleteMagician(magician: Magician)
}