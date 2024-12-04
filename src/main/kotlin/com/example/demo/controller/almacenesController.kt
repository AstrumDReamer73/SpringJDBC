package com.example.demo.controller
import com.example.demo.model.almacen
import com.example.demo.model.articulo
import com.example.demo.repository.repositorioAlmacenes
import com.example.demo.service.almacenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/almacenes") class almacenesController(private val almacenService: almacenService) {
    @GetMapping fun findAll(): List<almacen> = almacenService.findAll()

    @GetMapping("/activos") fun findAllActive(): List<almacen> = almacenService.findAllActive()

    @GetMapping("/{id}/articulos") fun findAllArticles(@PathVariable id: Int): List<articulo> = almacenService.findAllArticles(id)

    @PostMapping fun save(@RequestBody almacen: almacen): almacen = almacenService.save(almacen)

    @PutMapping("/{id}") fun update(@PathVariable id: Int, @RequestBody almacen: almacen): almacen { return almacen.copy(IDAlmacen = id).let { almacenService.update(it) } }

    @DeleteMapping("/{id}") fun deleteById(@PathVariable id: Int) = almacenService.deleteById(id)
}
