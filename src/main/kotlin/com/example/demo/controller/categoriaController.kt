package com.example.demo.controller

import com.example.demo.model.categoria
import com.example.demo.repository.repositorioCategoria
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller class categoriaController {
    @Autowired lateinit var repositorioCategoria: repositorioCategoria

    @GetMapping("/categorias") fun listarCategorias(model: Model):String{
        val listaCategorias:List<categoria> =repositorioCategoria.findAll()
        model.addAttribute("listaCategorias",listaCategorias)
        return "categorias"
    }

    @GetMapping("/categorias/añadirCategoria")fun agregarCategoria(model: Model):String{
        model.addAttribute("categoria",categoria())
        return "añadirCategoria"
    }
    @PostMapping("/categorias/guardar") fun guardarCategoria(categoria: categoria):String{
        repositorioCategoria.save(categoria)
        return "redirect:/categorias"
    }
}