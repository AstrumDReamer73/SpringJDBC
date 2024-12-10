package com.example.demo.controller

import com.example.demo.model.detallesdeVenta
import com.example.demo.service.clientesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/detallesdeventas") class detallesdeVentaController {
    @Autowired private lateinit var clienteService: clientesService

    @GetMapping("/{factura}") fun findByFactura(@PathVariable factura: String,model: Model):String {
        model.addAttribute("detallesdeVentas", clienteService.findDetallesDeVentaByFactura(factura))
        return "detallesdeVentas"
    }

    @PostMapping fun save(@RequestBody detallesdeVenta: detallesdeVenta,model: Model): String {
        model.addAttribute("detallesdeVentas",clienteService.saveDetallesDeVenta(detallesdeVenta))
        return "redirect:/detallesdeVentas"
    }

    @PutMapping("/{id}") fun update(@PathVariable id: Int, @RequestBody detallesdeVenta: detallesdeVenta): String {
        detallesdeVenta.copy(IDDetalledeVenta = id).let { clienteService.updateDetallesDeVenta(it) }
        return "redirect:/detallesdeVentas"
    }

    @DeleteMapping("/{id}") fun deleteById(@PathVariable id: Int):String {
        clienteService.deleteDetallesDeVentaById(id)
        return "redirect:/detallesdeVentas"
    }
}

