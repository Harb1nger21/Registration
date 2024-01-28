package ru.registration

import org.hibernate.cfg.Configuration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import ru.registration.entity.Contestant
import ru.registration.entity.Magician
import ru.registration.entity.Nomination

@SpringBootApplication
class RegistrationApplication

fun main(args: Array<String>) {
    val sessionFactory = Configuration().configure()
        .addAnnotatedClass(Magician::class.java)
        .addAnnotatedClass(Contestant::class.java)
        .addAnnotatedClass(Nomination::class.java)
        .buildSessionFactory()
    runApplication<RegistrationApplication>(*args)
}
