package com.example.demo.controller

import com.example.demo.model.ubicacion
import com.example.demo.service.ubicacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/listaUbicaciones") class ubicacionesController {
    @Autowired private lateinit var ubicacionService: ubicacionService

    @GetMapping fun findAll(model: Model): String {
        model.addAttribute("ubicaciones",ubicacionService.findAll())
        return "listaUbicaciones"
    }

    @GetMapping("/activas") fun findAllActive(model: Model):String{
        model.addAttribute("ubicaciones",ubicacionService.findAllActive())
        return "listaUbicaciones"
    }

    @PostMapping fun save(@RequestBody ubicacion: ubicacion,model: Model):String {
        model.addAttribute("ubicaciones",ubicacionService.save(ubicacion))
        return "redirect:/listaUbicaciones"
    }

    @PutMapping("/{id}") fun update(@PathVariable id: Int, @RequestBody ubicacion: ubicacion): String {
        ubicacion.copy(IDUbicacion = id).let { ubicacionService.update(it) }
        return "redirect:/listaUbicaciones"
    }

    @DeleteMapping("/{id}") fun delete(@PathVariable id: Int):String {
        ubicacionService.deleteById(id)
        return "redirect:/listaUbicaciones"
    }
}
