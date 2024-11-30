package com.example.demo.controller

import com.example.demo.model.articulos
import com.example.demo.repository.repositorioArticulos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class articulosController {
    @Autowired
    lateinit var repositorioArticulos: repositorioArticulos

    @GetMapping("/articulos") fun listarArticulos(model: Model):String{
        val listaArticulos:List<articulos> =repositorioArticulos.findAll()
        model.addAttribute("listaArticulos",listaArticulos)
        return "articulos"
    }

    @GetMapping("/articulos/añadirArticulos")fun añadirArticulo(model: Model):String{
        model.addAttribute("articulos", articulos())
        return "añadirArticulos"
    }

    @PostMapping("/articulos/guardar") fun guardarArticulo(articulos: articulos):String{
        repositorioArticulos.save(articulos)
        return "redirect:/articulos"
    }
}