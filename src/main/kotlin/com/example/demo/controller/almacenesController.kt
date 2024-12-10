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

@Controller @RequestMapping("/listaAlmacenes") class almacenesController() {
    @Autowired private lateinit var almacenService: almacenService

    @GetMapping fun findAll(model: Model):String {
        model.addAttribute("almacenes",almacenService.findAll())
        return "listaAlmacenes"
    }

    @GetMapping("/activos") fun findAllActive(model: Model):String {
        model.addAttribute("almacenes",almacenService.findAllActive())
        return "listaAlmacenes"
    }

    @GetMapping("/{id}/articulos") fun findAllArticles(@PathVariable id: Int,model: Model):String {
        model.addAttribute("articulos",almacenService.findAllArticles(id))
        return "listaAlmacenes"
    }

    @PostMapping fun save(@RequestBody almacen: almacen): String {
        almacenService.save(almacen)
        return "redirect:/añadirAlmacenes"
    }

    @PutMapping("/{id}/update") fun update(@PathVariable id: Int, @RequestBody almacen: almacen): String {
        almacen.copy(IDAlmacen = id).let { almacenService.update(it) }
        return "redirect:/listaAlmacenes"
    }

    @DeleteMapping("/{id}/delete") fun deleteById(@PathVariable id: Int):String {
        almacenService.deleteById(id)
        return "redirect:/listaAlmacenes"
    }
}
