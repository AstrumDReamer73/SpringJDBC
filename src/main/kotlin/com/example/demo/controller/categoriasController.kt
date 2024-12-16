package com.example.demo.controller

import com.example.demo.model.categoria
import com.example.demo.service.categoriaService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/listaCategorias") class categoriasController {
    @Autowired private lateinit var categoriaService: categoriaService
    @GetMapping
    fun findAll(@RequestParam(required = false) activos: Boolean?, model: Model): String {
        if (activos == true) { model.addAttribute("categorias", categoriaService.findAllActive()) }
        else { model.addAttribute("categorias", categoriaService.findAll()) }
        return "listaCategorias"
    }
    @GetMapping("/activos") fun findAllActive(model: Model):String{
        model.addAttribute("categorias",categoriaService.findAllActive())
        return "redirect:/listaCategorias"
    }

    @GetMapping("/añadirCategoria")fun showAddForm(model: Model):String{
        model.addAttribute("categoria",categoria())
        return "añadirCategoria"
    }

    @PostMapping("/guardar")fun save(@ModelAttribute categoria: categoria):String{
        categoriaService.save(categoria)
        return "redirect:/listaCategorias"
    }

    @GetMapping("/editar/{IDCategoria}")fun showEditForm(@PathVariable IDCategoria:Int,model: Model):String{
        val categoria:categoria=categoriaService.findbyID(IDCategoria)
        model.addAttribute("categoria",categoria)
        return "editarCategoria"
    }

    @PostMapping("/actualizar/{IDCategoria}")fun update(categoria: categoria):String{
        categoriaService.update(categoria)
        return "redirect:/listaCategorias"
    }

    @GetMapping("eliminar/{IDCategoria}")fun delete(@PathVariable IDCategoria: Int):String{
        categoriaService.deleteById(IDCategoria)
        return "redirect:/listaCategorias"
    }
}