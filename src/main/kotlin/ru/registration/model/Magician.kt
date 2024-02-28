package ru.registration.model

import com.fasterxml.jackson.annotation.JsonIgnore
import org.springframework.data.annotation.Id
import org.springframework.data.domain.Persistable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.OneToMany

@Table(name = "magician")
data class Magician(
    @Id
    var id: Long = 0,
    @Column(value = "first_name")
    val firstName: String,
    @Column(value = "second_name")
    val secondName: String,
    @Column(value = "country")
    val country: String,
    @Column(value = "city")
    val city: String,
    @Column(value = "phone_number")
    val phoneNumber: String,
    @JsonIgnore
    @Column(value = "deleted")
    val deleted: Boolean = false
) : Persistable<Long> {

    override fun toString(): String {
        return "Magician(firstName=$firstName, secondName=$secondName, country=$country, " +
                "city=$city phoneNumber=$phoneNumber})"
    }

    override fun getId(): Long = id

    @JsonIgnore
    override fun isNew(): Boolean = true

}
