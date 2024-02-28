package ru.registration

import org.hibernate.SessionFactory
import org.hibernate.cfg.Configuration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
//import ru.registration.domain.Competition
//import ru.registration.domain.Magician
//import ru.registration.domain.Nomination


@SpringBootApplication
class RegistrationApplication

fun main(args: Array<String>) {
//    val sessionFactory = Configuration().configure()
//        .addAnnotatedClass(Competition::class.java)
//        .addAnnotatedClass(Magician::class.java)
//        .addAnnotatedClass(Nomination::class.java)
//        .buildSessionFactory()
//
//    sessionFactory.use {
//        val dao = MagicianDao(sessionFactory)
//
//
//        val magician = Magician(
//            firstName = "Антон",
//            secondName = "Рогожин",
//            country = "Россия",
//            city = "Москва",
//            phoneNumber = "89153007541"
//        )
//
//        val competitions = listOf(
//            Competition(magician = magician, nomination = Nomination.STAGE),
//            Competition(magician = magician, nomination = Nomination.ONE_TRICK)
//        )
//
//        magician.competitions = competitions
//        val a = magician
//        dao.save(magician)
//
//    }
//    sessionFactory.close()
        runApplication<RegistrationApplication>(*args)
}

//class MagicianDao(private val sessionFactory: SessionFactory) {
//
//    fun save(magician: Magician) {
//        sessionFactory.openSession().use { session ->
//            session.beginTransaction()
//            magician.competitions.forEach { session.save(it) }
//            session.save(magician)
//            session.transaction.commit()
//        }
//    }
//}
