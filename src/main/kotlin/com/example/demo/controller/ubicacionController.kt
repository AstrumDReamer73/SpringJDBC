package com.example.demo.controller

import com.example.demo.model.ubicacion
import com.example.demo.model.venta
import com.example.demo.repository.repositorioUbicaciones
import com.example.demo.repository.repositorioVentas
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class ubicacionController {
    @Autowired
    lateinit var repositorioUbicaciones: repositorioUbicaciones

    @GetMapping("/ubicacion") fun listarUbicacion(model: Model):String{
        val listaUbicaciones:List<ubicacion> =repositorioUbicaciones.findAll()
        model.addAttribute("listaUbicaciones",listaUbicaciones)
        return "ubicacion"
    }

    @GetMapping("/ubicacion/añadirUbicacion")fun agregarUbicacion(model: Model):String{
        model.addAttribute("ubicacion", ubicacion())
        return "añadirUbicacion"
    }

    @PostMapping("/ubicacion/guardar") fun guardarUbicacion(ubicacion: ubicacion):String{
        repositorioUbicaciones.save(ubicacion)
        return "redirect:/ventas"
    }
}