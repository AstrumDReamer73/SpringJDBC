package com.example.demo.controller

import com.example.demo.model.detallesVenta
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

    @PostMapping fun save(@ModelAttribute detallesVenta: detallesVenta, model: Model): String {
        model.addAttribute("detallesdeVentas",clienteService.saveDetallesDeVenta(detallesVenta))
        return "redirect:/detallesdeVentas"
    }

    @PutMapping("/{id}") fun update(@PathVariable id: Int, @RequestBody detallesVenta: detallesVenta): String {
        detallesVenta.copy(IDDetalledeVenta = id).let { clienteService.updateDetallesDeVenta(it) }
        return "redirect:/detallesdeVentas"
    }

    @DeleteMapping("/{id}") fun deleteById(@PathVariable id: Int):String {
        clienteService.deleteDetallesDeVentaById(id)
        return "redirect:/detallesdeVentas"
    }
}

