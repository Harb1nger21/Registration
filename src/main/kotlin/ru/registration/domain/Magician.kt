package ru.registration.domain

import jakarta.persistence.*
import org.hibernate.annotations.OnDelete
import org.hibernate.annotations.OnDeleteAction

@Table(name = "magician")
data class Magician(
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    var id: Long = 0,
    @Column(name = "first_name", length = 127)
    var firstName: String = "",
    @Column(name = "second_name")
    var secondName: String = "",
    @Column(name = "country", length = 127)
    var country: String = "",
    @Column(name = "city", length = 127)
    var city: String = "",
    @Column(name = "phone_number")
    var phoneNumber: String = "",
    @Column(name = "competitions", length = 127)
    var competitions: List<Competition> = emptyList()
) {

    override fun toString(): String {
        return "Magician(firstName=$firstName, secondName=$secondName, country=$country, " +
                "city=$city phoneNumber=$phoneNumber\ncompetitions=$competitions)"
    }
}