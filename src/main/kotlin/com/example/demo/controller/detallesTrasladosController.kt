package com.example.demo.controller

import com.example.demo.model.detallesTraslado
import com.example.demo.service.trasladosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/detallesTraslados")
class detallesTrasladosController {
    @Autowired private lateinit var trasladosService: trasladosService

    @GetMapping("/{IDTraslado}") fun findByTraslado(@PathVariable IDTraslado:Int,model: Model):String {
        model.addAttribute("detallesdeTraslado",trasladosService)
        return "detallesTraslado"
    }

    @PostMapping fun save(@ModelAttribute detallesTraslado: detallesTraslado,model: Model):String{
        model.addAttribute("detallesTraslado",trasladosService.save(detallesTraslado))
        return "redirect:/detallesTraslado"
    }

    @PutMapping("/{id}") fun update(@PathVariable id:Int,@RequestBody detallesTraslado: detallesTraslado):String {
        detallesTraslado.copy(IDDetallesTraslado = id).let { trasladosService.update(it) }
        return "redirect:/detallesTraslado"
    }

    @DeleteMapping("/{id}")fun deletebyID(@PathVariable id: Int):String {
        trasladosService.deleteById(id)
        return "redirect:/detallesTraslado"
    }
}