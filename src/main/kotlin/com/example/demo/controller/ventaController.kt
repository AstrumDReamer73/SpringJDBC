package com.example.demo.controller

import com.example.demo.model.*
import com.example.demo.service.almacenService
import com.example.demo.service.clientesService
import com.example.demo.service.proveedoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
@Controller
@RequestMapping("/listaVentas")
class ventaController{
    @Autowired private lateinit var clientesService: clientesService
    @Autowired private lateinit var almacenService: almacenService
    @Autowired private lateinit var proveedoresService: proveedoresService

    @GetMapping fun findAllVentas(model: Model ):String{
        model.addAttribute("ventas", clientesService.findAll())
        return "listaVentas"
    }

    @PostMapping("/detalle") fun addDetalle(@RequestParam factura: String, @RequestBody detalle: detallesdeVenta): String {
        val venta = clientesService.findByFactura(factura) ?: throw IllegalArgumentException("Factura no encontrada")
        detalle.factura = venta
        clientesService.saveDetallesDeVenta(detalle)
        return "redirect:/ventas"
    }

    @GetMapping("/añadirVenta") fun showAddForm(model: Model): String {
        model.addAttribute("listaCliente",clientesService.findAllActiveCustomers())
        model.addAttribute("listaAlmacenes",almacenService.findAllActive())
        model.addAttribute("listaEmpleadosCliente",clientesService.findAllEmpleados())
        model.addAttribute("venta", venta())
        return "añadirVenta"
    }

    @PostMapping("/guardar") fun save(@ModelAttribute venta: venta,
                                      @RequestParam cliente: String,
                                      @RequestParam empleado:String,
                                      @RequestParam almacenOrigen:Int):String {
        val cliente=clientesService.findbyRFC(cliente)
        val empleado=clientesService.findEmpleadobyRFC(empleado)
        val almacenOrigen=almacenService.findbyID(almacenOrigen)
        venta.almacenOrigen=almacenOrigen
        venta.empleado=empleado
        venta.cliente=cliente
        clientesService.saveSell(venta)
        return "redirect:/listaVentas"
    }

    @PutMapping("/{factura}")
    fun update(@PathVariable factura: String, @RequestBody venta: venta): String {
        venta.copy(factura = factura).let { clientesService.updateSell(it) }
        return "redirect:/ventas"
    }

    @DeleteMapping("/{factura}")
    fun delete(@PathVariable factura: String): String {
        clientesService.deleteSellbyFactura(factura)
        return "redirect:/ventas"
    }
}