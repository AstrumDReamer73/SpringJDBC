package com.example.demo.controller

import com.example.demo.model.traslado
import com.example.demo.service.proveedoresService
import com.example.demo.service.trasladosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/listaTraslados") class trasladosController {
    @Autowired private lateinit var trasladosService: trasladosService

    @GetMapping fun findAll(model: Model):String {
        model.addAttribute("traslados",trasladosService.findALL())
        return "listaTraslados"
    }

    @GetMapping("/activos")fun findAllActive(model: Model):String{
        model.addAttribute("traslados",trasladosService.findAllActive())
        return "listaTraslados"
    }

    @GetMapping("/{almacenOrigen}") fun findByOrigen(@PathVariable almacenOrigen:String,model: Model):String {
        model.addAttribute("traslados",trasladosService.findByOrigen(almacenOrigen))
        return "listaTraslados"
    }

    @GetMapping("/{almacenDestino}")fun findByDestino(@PathVariable almacenDestino:String,model: Model):String {
        model.addAttribute("traslados",trasladosService.findByDestino(almacenDestino))
        return "listaTraslados"
    }

    @PostMapping fun save(@RequestBody traslado: traslado,model: Model):String {
        model.addAttribute("traslados",trasladosService.save(traslado))
        return "redirect:/listaTraslados"
    }

    @PutMapping("/{id}") fun update(@PathVariable id: Int, @RequestBody traslado: traslado):String {
        traslado.copy(IDTraslado = id).let { trasladosService.update(it) }
        return "redirect:/listaTraslados"
    }

    @DeleteMapping("/{id}") fun delete(@PathVariable id: Int):String {
        trasladosService.deleteById(id)
        return "redirect:/listaTraslados"
    }
}
