package ru.registration.domain.service

import ru.registration.domain.Competition
import ru.registration.domain.Magician

interface MagicianService {
    fun createMagician(magician: Magician, competitions: List<Competition>)
    fun modifyMagician(magician: Magician, competitions: List<Competition>)
    fun getMagicianById(id: Long): Magician?
//    fun getRecordById(id: Long, username: String): Magician?
//    fun getAllRecord(username: String): List<Magician>
    fun getAllMagician(): List<Magician>
    fun deleteMagicianById(id: Long)
//    fun search(query: String): List<Magician>
//    fun search(query: String, username: String): List<Magician>
}