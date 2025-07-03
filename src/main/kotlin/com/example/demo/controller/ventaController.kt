package com.example.demo.controller

import com.example.demo.model.*
import com.example.demo.service.almacenService
import com.example.demo.service.articulosService
import com.example.demo.service.clientesService
import com.example.demo.service.proveedoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@Controller @RequestMapping("/listaVentas") class ventaController {
    @Autowired private lateinit var clientesService: clientesService
    @Autowired private lateinit var almacenService: almacenService
    @Autowired private lateinit var proveedoresService: proveedoresService
    @Autowired private lateinit var articulosService: articulosService

    @GetMapping fun findAllVentas(model: Model): String {
        model.addAttribute("ventas", clientesService.findAll())
        return "listaVentas"
    }

    @GetMapping("/{factura}") fun findByFactura(@PathVariable factura: String, model: Model): String {
        model.addAttribute("detallesVentas", clientesService.findDetallesDeVentaByFactura(factura))
        return "carritoVenta"
    }

    @GetMapping("/añadirVenta") fun showAddForm(model: Model): String {
        model.addAttribute("venta", venta())
        model.addAttribute("listaCliente", clientesService.findAllActiveCustomers())
        model.addAttribute("listaAlmacenes", almacenService.findAllActive())
        model.addAttribute("listaEmpleadosCliente", clientesService.findAllEmpleados())
        return "añadirVenta"
    }

    @PostMapping("/guardar") fun save(@ModelAttribute venta: venta,
                                                    @RequestParam cliente: String,
                                                    @RequestParam empleado: String,
                                                    @RequestParam almacenOrigen: Int): String {
        val cliente = clientesService.findbyRFC(cliente)
        val empleado = clientesService.findEmpleadobyRFC(empleado)
        val almacenOrigen = almacenService.findbyID(almacenOrigen)
        venta.cliente = cliente
        venta.empleado = empleado
        venta.almacenOrigen = almacenOrigen
        clientesService.saveSell(venta)
        return "redirect:/listaVentas"
    }

    @PostMapping("/detalle") fun addDetalle(@RequestParam factura: String, @RequestBody detalle: detallesVenta): String {
        val venta = clientesService.findByFactura(factura) ?: throw IllegalArgumentException("Factura no encontrada")
        detalle.factura = venta
        clientesService.saveDetallesDeVenta(detalle)
        return "redirect:/listaVentas"
    }

    @GetMapping("/agregarAlCarrito/{factura}")
    fun showAddArticuloForm(@PathVariable factura: String, model: Model): String {
        val detallesVenta = detallesVenta()
        model.addAttribute("detallesdeVenta", detallesVenta)
        model.addAttribute("factura", factura)
        model.addAttribute("articulos", articulosService.findAllActive()) // Lista de artículos
        return "agregarArticuloCarritoVenta"
    }

    @PostMapping("/agregarArticuloalCarrito/{factura}/{upc}")
    fun añadirCarrito(@PathVariable factura: String,
                            @PathVariable upc: Int,
                            @RequestParam cantidad: Int,
                            model: Model): String {
        val detalleCompra = detallesCompra()
        val articulo = articulosService.findbyUPC(upc)
        var sumaTotal = BigDecimal.ZERO
        detalleCompra.cantidad=cantidad
        detalleCompra.Subtotal=articulo.costoCompra?.multiply(BigDecimal(cantidad))
        detalleCompra.articulo=articulo
        val detalles=proveedoresService.findDetallesDeCompraByFactura(factura)
        detalleCompra.factura?.total=sumaTotal
        proveedoresService.saveDetallesDeCompra(detalleCompra)
        model.addAttribute("detalleCompra", detalleCompra)
        return "redirect:/carritoCompra/{factura}"
    }

    @PutMapping("/{factura}")
    fun update(@PathVariable factura: String, @RequestBody venta: venta): String {
        venta.copy(factura = factura).let { clientesService.updateSell(it) }
        return "redirect:/listaVentas"
    }

    @DeleteMapping("/{factura}")
    fun delete(@PathVariable factura: String): String {
        clientesService.deleteSellbyFactura(factura)
        return "redirect:/listaVentas"
    }
}
