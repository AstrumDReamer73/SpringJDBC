package com.example.demo.controller

import com.example.demo.model.ubicacion
import com.example.demo.service.ubicacionService
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/ubicaciones") class ubicacionesController(private val ubicacionService: ubicacionService) {

    @GetMapping fun getAll(): List<ubicacion> { return ubicacionService.findAll() }

    @GetMapping("/activas") fun getActive(): List<ubicacion> { return ubicacionService.findAllActive() }

    @PostMapping fun create(@RequestBody ubicacion: ubicacion): ubicacion { return ubicacionService.save(ubicacion) }

    @PutMapping("/{id}") fun update(@PathVariable id: Int, @RequestBody ubicacion: ubicacion): ubicacion { return ubicacionService.update(ubicacion.copy(IDUbicacion = id)) }

    @DeleteMapping("/{id}") fun delete(@PathVariable id: Int) { ubicacionService.deleteById(id) }
}
