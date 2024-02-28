package ru.registration.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table

@Table(name = "competition")
data class Competition(
    @JsonIgnore
    @Column(value = "magician_id")
    val magicianId: Long,
    @Column(value = "nomination")
    val nomination: Nomination,
    @Column(value = "lot_number")
    val lotNumber: Long
) {
    override fun toString(): String {
        return "${nomination.value} + $lotNumber"
    }
}
