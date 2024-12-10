package com.example.demo.controller

import com.example.demo.model.articulo
import com.example.demo.service.articulosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/listaArticulos") class articulosController {
    @Autowired private lateinit var articulosService: articulosService
    @GetMapping fun findAll(model: Model): String {
        model.addAttribute("articulos", articulosService.findAll())
        return "listaArticulos"
    }

    @GetMapping("/activos") fun findAllActive(model: Model): String {
        model.addAttribute("articulos", articulosService.findAllActive())
        return "listaArticulos"
    }

    @GetMapping("/{UPC}/existencias") fun findAllExistences(@PathVariable UPC: Int, model: Model): String {
        model.addAttribute("articulos", articulosService.findAllExistences(UPC))
        return "listaArticulos"
    }

    @GetMapping("/{idcategoria}/articulos") fun findByCategoria(@PathVariable idcategoria:Int,model: Model):String{
        model.addAttribute("articulos",articulosService.findByCategoria(idcategoria))
        return "listaArticulos"
    }

    @PostMapping("/añadirArticulos") fun save(@RequestBody articulo: articulo): String {
        articulosService.save(articulo)
        return "redirect:/listaArticulos"
    }

    @PutMapping("/{UPC}") fun update(@PathVariable UPC: Int, @RequestBody articulos: articulo): String {
        articulosService.update(articulos.copy(UPC = UPC))
        return "redirect:/listaArticulos"
    }

    @DeleteMapping("/{UPC}") fun delete(@PathVariable UPC: Int):String {
        articulosService.deleteByUPC(UPC)
        return "redirect:/listaArticulos"
    }
}
