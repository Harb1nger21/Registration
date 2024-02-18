package ru.registration.domain.repository

import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.repository.CrudRepository
import ru.registration.domain.Competition

interface CompetitionRepository : CrudRepository<Competition, Long>