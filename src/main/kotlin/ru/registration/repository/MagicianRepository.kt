package ru.registration.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import ru.registration.entity.Magician

@Repository
interface MagicianRepository : CrudRepository<Magician, Long> {
    @Query(
        "UPDATE magician SET first_name = :magician.firstName, " +
                "secondName = :magician.secondName, country = :magician.country, " +
                "city = :magician.city, phoneNumber = :magician.phoneNumber," +
                "nominations = :magician.nominations WHERE id = :magician.id"
    )
    fun update(@Param("magician") magician: Magician)
}