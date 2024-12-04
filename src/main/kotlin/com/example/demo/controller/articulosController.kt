package com.example.demo.controller

import com.example.demo.model.*
import com.example.demo.repository.*
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller class articulosController {
    @Autowired lateinit var repositorioArticulo: repositorioArticulos
    @Autowired lateinit var repositorioCategoria: repositorioCategorias
    @Autowired lateinit var repositorioUbicaciones: repositorioUbicaciones

    @GetMapping("articulos/agregar") fun agregarArticulo(model: Model):String{
        val listaCategorias:List<categoria> =repositorioCategoria.findAll()
        val listaUbicaciones:List<ubicacion> =repositorioUbicaciones.findAll()
        model.addAttribute("articulo",articulo())
        model.addAttribute("listaCategorias",listaCategorias)
        model.addAttribute("listaUbicaciones",listaUbicaciones)
        return "añadirArticulos"
    }

    @PostMapping("/articulos/guardar") fun guardarArticulo(articulo: articulo):String{
        repositorioArticulo.save(articulo)
        return "redirect:/articulos"
    }

    @GetMapping("/articulos") fun listarArticulos(model: Model):String{
        val listaArticulos:List<articulo> =repositorioArticulo.findAll()
        model.addAttribute("listaArticulos",listaArticulos)
        return "articulos"
    }
}