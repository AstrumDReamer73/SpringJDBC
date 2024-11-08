package com.example.demo.controller

import com.example.demo.model.ServiceResponse
import com.example.demo.model.Tarjeta
import com.example.demo.service.TarjetaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("api/v1/Tarjeta") @CrossOrigin("*") class TarjetaController @Autowired constructor(private val iTarjetaService: TarjetaService) {

    @GetMapping("/list")
    fun list(): ResponseEntity<List<Tarjeta>> {
        val result = iTarjetaService.findAll()
        return ResponseEntity(result, HttpStatus.OK)
    }

    @PostMapping("/save")
    fun save(@RequestBody tarjeta: Tarjeta): ResponseEntity<ServiceResponse> {
        val serviceResponse = ServiceResponse()
        val result = iTarjetaService.insert(tarjeta)
        if (result == 1) {
            serviceResponse.message = "Item saved with success"
        }
        return ResponseEntity(serviceResponse, HttpStatus.OK)
    }

    @PostMapping("/update")
    fun update(@RequestBody tarjeta: Tarjeta): ResponseEntity<ServiceResponse> {
        val serviceResponse = ServiceResponse()
        val result = iTarjetaService.update(tarjeta)
        if (result == 1) {
            serviceResponse.message = "Item updated with success"
        }
        return ResponseEntity(serviceResponse, HttpStatus.OK)
    }

    @GetMapping("/delete/{id}")
    fun delete(@PathVariable id: Int): ResponseEntity<ServiceResponse> {
        val serviceResponse = ServiceResponse()
        val result = iTarjetaService.deleteById(id)
        if (result == 1) {
            serviceResponse.message = "Item removed with success"
        }
        return ResponseEntity(serviceResponse, HttpStatus.OK)
    }
}
