package ru.registration.controller

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.registration.dto.ListMagicianResponse
import ru.registration.dto.MagicianRequest
import ru.registration.dto.MagicianResponse
import ru.registration.domain.service.MagicianService

@RestController
class RestfullController(val service: MagicianService) {

    @GetMapping(path = ["/list"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getList(): ResponseEntity<ListMagicianResponse> =
        ResponseEntity.ok(ListMagicianResponse(service.getAllMagician()))

//    @GetMapping(path = ["/search"], produces = [MediaType.APPLICATION_JSON_VALUE])
//    fun getSearchList(@RequestParam query: String, ): ResponseEntity<ListMagicianResponse> =
//        ResponseEntity.ok(
//            ListMagicianResponse(
//                if (user.authorities.contains(SimpleGrantedAuthority("ROLE_ADMIN")))
//                    service.search(query)
//                else
//                    service.search(query, user.username)
//            )
//        )

    @PostMapping(path = ["/add"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun addMagician(@RequestBody requestMagician: MagicianRequest): ResponseEntity<Any> {
        val magician = requestMagician.toMagician()
        val competitions = requestMagician.competitionRequestList.map { it.toCompetition(magician) }
        service.createMagician(magician, competitions)
        return ResponseEntity.ok().build()
    }

    @GetMapping(path = ["{id}/view"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun viewMagician(@PathVariable id: Long): ResponseEntity<MagicianResponse> {
        return service.getMagicianById(id)?.let {
            ResponseEntity.ok(MagicianResponse.fromMagician(it))
        } ?: ResponseEntity.notFound().build()
    }

    @PostMapping(path = ["/{id}/edit"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun editMagician(@RequestBody requestMagician: MagicianRequest, @PathVariable id: Long): ResponseEntity<Any> {
        val magician = requestMagician.toMagician(id)
        val competitions = requestMagician.competitionRequestList.map { it.toCompetition(magician) }
        service.createMagician(magician, competitions)
        return ResponseEntity.ok().build()
    }

    @PostMapping(path = ["/{id}/delete"])
    fun deleteMagician(@PathVariable id: Long): ResponseEntity<Any> {
        service.deleteMagicianById(id)
        return ResponseEntity.ok().build()
    }
}