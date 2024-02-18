package ru.registration.domain.repository

import org.springframework.data.jdbc.repository.query.Query
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import ru.registration.domain.Magician

@Repository
interface MagicianRepository : CrudRepository<Magician, Long>