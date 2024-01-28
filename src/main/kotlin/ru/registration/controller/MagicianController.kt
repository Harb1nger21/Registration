package ru.registration.controller

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import ru.registration.controller.dto.ListMagicianResponse
import ru.registration.controller.dto.MagicianRequest
import ru.registration.controller.dto.MagicianResponse
import ru.registration.entity.Magician
import ru.registration.entity.Nomination
import ru.registration.service.MagicianService

@RestController
class MagicianController(val service: MagicianService) {

    @PostMapping(path = ["/add"])
    fun add(@RequestBody req: MagicianRequest): ResponseEntity<Any> {
        service.addMagician(req.toMagician())
        return ResponseEntity.ok().build()
    }

    @GetMapping(path = ["/all"])
    fun getMagicianList(): ResponseEntity<ListMagicianResponse> {
        return ResponseEntity.ok(ListMagicianResponse(service.all()))
    }

    @GetMapping(path = ["/byId/{id}"])
    fun getMagicianById(@PathVariable id: Long): ResponseEntity<MagicianResponse> {
        val magician = service.magicianById(id)
        return magician?.let {
            ResponseEntity.ok(MagicianResponse.fromMagician(it))
        } ?: ResponseEntity.notFound().build()
    }

    @GetMapping(path = ["/byNomination/{nomination}"])
    fun getByNomination(@PathVariable nomination: Nomination): ResponseEntity<ListMagicianResponse> {
        return ResponseEntity.ok(ListMagicianResponse(service.allByNomination(nomination)))
    }

    @PostMapping(path = ["/update"])
    fun updateMagicianInfo(magician: Magician) {
        service.updateMagician(magician)
    }

    @PostMapping(path = ["/delete"])
    fun deleteMagicianInfo(magician: Magician) {
        service.deleteMagician(magician)
    }
}