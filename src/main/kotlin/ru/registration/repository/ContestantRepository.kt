package ru.registration.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import ru.registration.entity.Contestant
import ru.registration.entity.Nomination

@Repository
interface ContestantRepository : CrudRepository<Contestant, Long> {

    @Query("SELECT cont.magician_id FROM contestant as cont WHERE cont.nomination = :nomination")
    fun findIdsByNomination(@Param("nomination") nomination: Nomination): List<Long>
}