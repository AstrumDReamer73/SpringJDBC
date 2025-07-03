package com.example.demo.controller

import com.example.demo.model.ubicacion
import com.example.demo.service.almacenService
import com.example.demo.service.ubicacionService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/listaUbicaciones") class ubicacionesController {
    @Autowired private lateinit var ubicacionService: ubicacionService
    @Autowired private lateinit var almacenService: almacenService
    @GetMapping fun findAll(model: Model): String {
        model.addAttribute("ubicaciones",ubicacionService.findAll())
        return "listaUbicaciones"
    }

    @GetMapping("/activas") fun findAllActive(model: Model):String{
        model.addAttribute("ubicaciones",ubicacionService.findAll())
        return "listaUbicaciones"
    }

    @GetMapping("/añadirUbicacion")
    fun showAddForm(model: Model): String {
        model.addAttribute("ubicacion", ubicacion())
        model.addAttribute("listaAlmacenes",almacenService.findAllActive())
        return "añadirUbicacion"
    }

    @PostMapping("/guardar") fun save(@ModelAttribute ubicacion: ubicacion,model: Model):String {
        model.addAttribute("ubicaciones",ubicacionService.save(ubicacion))
        return "redirect:/listaUbicaciones"
    }

    @GetMapping("eliminar/{IDUbicacion}")fun delete(@PathVariable IDUbicacion: Int):String{
        ubicacionService.deleteByID(IDUbicacion)
        return "redirect:/listaCategorias"
    }
}
