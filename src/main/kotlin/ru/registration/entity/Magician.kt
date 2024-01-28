package ru.registration.entity

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = "magician")
data class Magician(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long,
    @Column(name = "first_name")
    val firstName: String,
    @Column(name = "second_name")
    val secondName: String,
    @Column(name = "country")
    val country: String,
    @Column(name = "city")
    val city: String,
    @Column(name = "phone_number")
    val phoneNumber: String,
) {
    fun getFullName(): String = "$firstName $secondName"

    fun getBornPlace(): String = "$country, $city"


    override fun toString(): String {
        return "Magician(name = ${getFullName()}, country = $country, city = $city, " +
                "phoneNumber = $phoneNumber)"
    }
}
