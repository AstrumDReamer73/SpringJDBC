package com.example.demo.controller

import com.example.demo.model.articulo
import com.example.demo.model.compra
import com.example.demo.model.detallesCompra
import com.example.demo.service.articulosService
import com.example.demo.service.proveedoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/carritoCompra") class detallesdeComprasController {
    @Autowired private lateinit var proveedoresService: proveedoresService
    @Autowired private lateinit var articulosService: articulosService

    @GetMapping("/{factura}") fun findByFactura(@PathVariable factura: String,model: Model):String {
        model.addAttribute("detallesCompras",proveedoresService.findDetallesDeCompraByFactura(factura))
        return "carritoCompra"
    }

    @GetMapping("/añadir/{factura}") fun showAddForm(@PathVariable factura: String, model: Model): String {
        model.addAttribute("listaArticulos", articulosService.findAll())
        model.addAttribute("articulo", articulo()) // Para identificar el carrito de compra
        return "agregarArticuloCarritoCompra" // Nombre de la vista para agregar artículos
    }


    @PostMapping("/añadirArticulo/{factura}") fun addCart(@PathVariable factura: compra, @ModelAttribute detallesDeCompra: detallesCompra): String {
        detallesDeCompra.factura = factura
        proveedoresService.saveDetallesDeCompra(detallesDeCompra)
        return "redirect:/carritoCompra/$factura" // Redirigir al carrito correspondiente
    }


    @DeleteMapping("/eliminarArticulo/{factura}/{id}")
    fun deleteById(@PathVariable factura: String, @PathVariable id: Int): String {
        proveedoresService.deleteDetallesDeCompraById(id)
        return "redirect:/carritoCompra/$factura" // Redirigir al carrito correspondiente
    }
}