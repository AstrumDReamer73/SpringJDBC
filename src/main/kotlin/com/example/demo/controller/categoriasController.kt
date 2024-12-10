package com.example.demo.controller

import com.example.demo.model.categoria
import com.example.demo.service.categoriaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/listaCategorias") class categoriasController {
    @Autowired private lateinit var categoriaService: categoriaService
    @GetMapping fun findAll(model: Model): String {
        model.addAttribute("categorias",categoriaService.findAll())
        return "listaCategorias"
    }

    @GetMapping("/activos") fun findAllActive(model: Model):String{
        model.addAttribute("categorias",categoriaService.findAllActive())
        return "redirect:/listaCategorias"
    }

    @PostMapping fun save(@RequestBody categoria: categoria): String {
        categoriaService.save(categoria)
        return "redirect:/añadirCategoria"
    }

    @PutMapping("/{id}") fun update(@PathVariable id: Int, @RequestBody categoria: categoria): String {
         categoria.copy(IDCategoria = id).let { categoriaService.update(it) }
         return "redirect:/listaCategorias"
    }

    @DeleteMapping("/{id}") fun deleteById(@PathVariable id: Int):String {
        categoriaService.deleteById(id)
        return "redirect:/listaCategorias"
    }
}