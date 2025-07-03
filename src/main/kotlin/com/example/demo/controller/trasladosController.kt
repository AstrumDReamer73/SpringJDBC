package com.example.demo.controller

import com.example.demo.model.traslado
import com.example.demo.service.almacenService
import com.example.demo.service.trasladosService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/listaTraslados") class trasladosController {
    @Autowired private lateinit var trasladosService: trasladosService
    @Autowired private lateinit var almacenService: almacenService
    @GetMapping fun findAll(model: Model):String {
        model.addAttribute("traslados",trasladosService.findALL())
        return "listaTraslados"
    }

    @GetMapping("/activos")fun findAllActive(model: Model):String{
        model.addAttribute("traslados",trasladosService.findAllActive())
        return "listaTraslados"
    }

    @GetMapping("/{almacenOrigen}") fun findByOrigen(@PathVariable almacenOrigen:String, model: Model):String {
        model.addAttribute("traslados",trasladosService.findByOrigen(almacenOrigen))
        model.addAttribute("listaAlmacenes",almacenService.findAll())
        return "añadirTraslado"
    }

    @GetMapping("/{almacenDestino}")fun findByDestino(@PathVariable almacenDestino:String, model: Model):String {
        model.addAttribute("traslados",trasladosService.findByDestino(almacenDestino))
        return "listaTraslados"
    }

    @GetMapping("/añadirTraslado") fun showAddForm(model: Model): String {
        model.addAttribute("traslado", traslado())
        model.addAttribute("listaAlmacenes", almacenService.findAll())
        return "añadirTraslado"
    }


    @PostMapping("/guardar") fun save(@ModelAttribute traslado: traslado,
                                                    @RequestParam almacenOrigen: Int,
                                                    @RequestParam almacenDestino: Int): String {
        val origen = almacenService.findbyID(almacenOrigen)
        val destino = almacenService.findbyID(almacenDestino)
        if (origen != null && destino != null) {
            traslado.almacenOrigen = origen
            traslado.almacenDestino = destino
            trasladosService.save(traslado)
        }
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
