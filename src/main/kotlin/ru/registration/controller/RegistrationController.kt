package ru.registration.controller

import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.registration.dto.*
import ru.registration.model.Nomination
import ru.registration.service.CompetitionService
import ru.registration.service.MagicianService

@RestController
class RegistrationController(
    private val magicianService: MagicianService,
    private val competitionService: CompetitionService
) {

    @GetMapping("/list", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun showAllMagicians(): ResponseEntity<ListMagicianResponse> {
        val magicians = magicianService.getAllMagician()
        val response =
            magicians.map { MagicianResponse.toMagicianResponse(it, competitionService.allCompetitionsById(it.id)) }
        return ResponseEntity.ok(ListMagicianResponse(response))
    }

    @PostMapping("/add", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun addNewMagician(@RequestBody request: MagicianRequest): ResponseEntity<Any> {
        magicianService.addNewMagician(request.toMagician())
        return ResponseEntity.ok().build()
    }

    @GetMapping("/view/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun showMagicianById(@PathVariable id: Long): ResponseEntity<MagicianResponse> {
        return magicianService.getMagicianById(id)?.let {
            ResponseEntity.ok(MagicianResponse.toMagicianResponse(it, competitionService.allCompetitionsById(it.id)))
        } ?: ResponseEntity.notFound().build()
    }

    @PostMapping("/edit/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun editMagician(@PathVariable id: Long, @RequestBody request: MagicianRequest): ResponseEntity<Any> {
        magicianService.updateMagician(id, request.toMagician())
        return ResponseEntity.ok().build()
    }

    @PostMapping("/hardDelete/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun hardDelete(@PathVariable id: Long): ResponseEntity<Any> {
        magicianService.hardDelete(id)
        competitionService.deleteAllById(id)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/softDelete/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun softDelete(@PathVariable id: Long): ResponseEntity<Any> {
        magicianService.softDelete(id)
        return ResponseEntity.ok().build()
    }

    @PostMapping("/newCompetition/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun newCompetition(
        @PathVariable id: Long,
        @RequestBody request: CompetitionRequest
    ): ResponseEntity<Any> {
        competitionService.addCompetition(id, request.nomination, request.lotNumber)
        return ResponseEntity.ok().build()
    }

    @GetMapping("/competitions/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllCompetitionsById(@PathVariable id: Long): ResponseEntity<ListCompetitionResponse> =
        ResponseEntity.ok(ListCompetitionResponse(competitionService.allCompetitionsById(id)))

    @PostMapping("/updateCompetition/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun updateCompetition(@PathVariable id: Long, @RequestBody request: CompetitionRequest) {
        competitionService.updateLotNumber(id, request.nomination, request.lotNumber)
    }

    @PostMapping("/deleteCompetition/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun deleteCompetition(@PathVariable id: Long, @RequestBody request: CompetitionRequest) {
        competitionService.deleteNominationById(id, request.nomination)
    }
}