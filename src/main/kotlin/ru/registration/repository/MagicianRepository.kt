package ru.registration.repository

import org.springframework.data.jdbc.repository.query.Modifying
import org.springframework.data.jdbc.repository.query.Query
//import org.springframework.data.jpa.repository.JpaRepository
//import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.registration.model.Magician
import java.util.*

@Repository
interface MagicianRepository : CrudRepository<Magician, Long> {

    @Query("""SELECT MAX(id) FROM magician""")
    fun getLastId(): Long?

    @Query("""SELECT * FROM magician WHERE deleted = false""")
    override fun findAll(): List<Magician>

    @Query("""SELECT * FROM magician WHERE id = :id AND deleted = false""")
    override fun findById(id: Long): Optional<Magician>

    @Modifying
    @Query(
        """UPDATE magician
                SET first_name   = :firstName,
                    second_name  = :secondName,
                    city         = :city,
                    country      = :country,
                    phone_number = :phoneNumber
                WHERE id = :id;
            """
    )
    fun update(id: Long, firstName: String, secondName: String, city: String, country: String, phoneNumber: String)

    @Modifying
    @Query("""UPDATE magician SET deleted = true WHERE id = :id""")
    fun softDelete(id: Long)
}