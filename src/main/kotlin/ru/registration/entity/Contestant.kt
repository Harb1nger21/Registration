package ru.registration.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
import javax.persistence.Table

@Entity
@Table(name = "CONTESTANTS")
data class Contestant(
    @Column(name = "MAGICIAN_ID")
    val magicianId: Long,
    @Enumerated(EnumType.STRING)
    @Column(name = "NOMINATION")
    val nomination: Nomination,
    @Column(name = "LOT_NUMBER")
    val lotNumber: Long = 0
)