package ru.registration.repository

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import ru.registration.model.Competition
import ru.registration.model.Nomination

interface CompetitionRepository : CrudRepository<Competition, Long> {
    @Modifying
    @Query("""INSERT INTO competition VALUES (:magicianId, :nomination, :lotNumber)""")
    fun save(magicianId: Long, nomination: Nomination, lotNumber: Long)

    @Query("""SELECT * FROM competition WHERE magician_id = :id""")
    fun getCompetitionsByMagicianId(id: Long): List<Competition>

    @Modifying
    @Query("""UPDATE competition SET lot_number = :lotNumber WHERE magician_id = :id AND nomination = :nomination""")
    fun updateLotNumber(id: Long, nomination: Nomination, lotNumber: Long)

    @Modifying
    @Query("""DELETE FROM competition WHERE magician_id = :id AND nomination = :nomination""")
    fun deleteNomination(id: Long, nomination: Nomination)

    @Modifying
    @Query("""DELETE FROM competition WHERE magician_id = :id""")
    fun deleteAllById(id: Long)

}