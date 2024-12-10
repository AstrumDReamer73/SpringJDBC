package com.example.demo.controller

import com.example.demo.model.detallesdeCompra
import com.example.demo.service.proveedoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/detallesdecompras") class detallesdeComprasController {
    @Autowired private lateinit var proveedoresService: proveedoresService

    @GetMapping("/{factura}") fun findByFactura(@PathVariable factura: String,model: Model):String {
        model.addAttribute("detallesdeCompras",proveedoresService.findDetallesDeCompraByFactura(factura))
        return "detallesdeCompras"
    }

    @PostMapping("/añadirDetallesdeCompra") fun save(@RequestBody detallesDeCompra: detallesdeCompra): String {
        proveedoresService.saveDetallesDeCompra(detallesDeCompra)
        return "redirect:/detallesdeCompra"
    }

    @PutMapping("/{id}") fun update(@PathVariable id: Int, @RequestBody detallesdeCompra: detallesdeCompra): String  {
        detallesdeCompra.copy(IDDetalledeCompra = id).let { proveedoresService.updateDetallesDeCompra(it) }
        return "redirect:/detallesdeCompra"
    }

    @DeleteMapping("/{id}") fun deleteById(@PathVariable id: Int):String{
        proveedoresService.deleteDetallesDeCompraById(id)
        return "redirect:/detallesdeCompra"
    }
}