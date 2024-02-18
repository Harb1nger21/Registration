package ru.registration.domain

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnore
import jakarta.persistence.*

@Table(name = "competition")
data class Competition(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    @JsonIgnore
    val id: Long = 1,
    val magicianId: Long = 0,
    @Column(name = "nomination")
    val nomination: Nomination = Nomination.STAGE,
    @Column(name = "lot_number")
    val lotNumber: Long = 0
) {
    override fun toString(): String {
        return "Competition(nomination=$nomination, lotNumber=$lotNumber)"
    }
}