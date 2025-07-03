package com.example.demo.controller

import com.example.demo.model.*
import com.example.demo.service.almacenService
import com.example.demo.service.articulosService
import org.springframework.ui.Model
import com.example.demo.service.proveedoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.*
import java.math.BigDecimal

@Controller @RequestMapping("/listaCompras") class compraController {
    @Autowired private lateinit var proveedoresService: proveedoresService
    @Autowired private lateinit var almacenService: almacenService
    @Autowired private lateinit var articulosService: articulosService

    @GetMapping fun findAllVentas(model: Model):String{
        model.addAttribute("compras",proveedoresService.findAllCompras())
        return "listaCompras"
    }

    @GetMapping("/añadirCompra") fun showAddForm(model: Model): String {
        model.addAttribute("compra", compra())
        model.addAttribute("listaProveedores",proveedoresService.findAllSuppliers())
        model.addAttribute("listaAlmacenes",almacenService.findAll())
        model.addAttribute("listaEmpleadosProveedores",proveedoresService.findAllEmpleados())
        return "añadirCompra"
    }

    @PostMapping("/guardar") fun save(@ModelAttribute compra: compra,
                                                    @RequestParam proveedor:String,
                                                    @RequestParam empleado: String,
                                                    @RequestParam almacenDestino: Int): String {
        val proveedor=proveedoresService.findSupplierbyRFC(proveedor)
        val empleado=proveedoresService.findEmpleadobyRFC(empleado)
        val almacenDestino=almacenService.findbyID(almacenDestino)
        compra.proveedor=proveedor
        compra.empleado=empleado
        compra.almacenDestino=almacenDestino
        proveedoresService.save(compra)
        return "redirect:/carritoCompra"
    }

    @GetMapping("/{factura}") fun findByFactura(@PathVariable factura: String,model: Model):String {
        model.addAttribute("detallesCompras",proveedoresService.findDetallesDeCompraByFactura(factura))
        return "carritoCompra"
    }

    @GetMapping("/carritoCompra/{factura}") fun verCarrito(@PathVariable factura: String,model: Model):String {
        val compra=proveedoresService.findByFactura(factura)
        if(compra==null){ throw RuntimeException("compra no encontrada para la factura:$factura") }
        model.addAttribute("compra",compra)
        model.addAttribute("detallesCompras",proveedoresService.findDetallesDeCompraByFactura(factura))
        return "carritoCompra"
    }

    // Agregar artículo al carrito
    @GetMapping("/agregarAlCarrito/{factura}")
    fun showAddArticuloForm(@PathVariable factura: String, model: Model): String {
        val articulos = articulosService.findAll() // Recuperar artículos desde la base de datos.
        if (articulos.isEmpty()) { throw RuntimeException("No hay artículos disponibles para agregar.") }
        model.addAttribute("factura", factura)
        model.addAttribute("articulos", articulos) // Asegúrate de que este atributo se añade al modelo.
        return "agregarArticuloCarritoCompra"
    }

    // Agregar el artículo seleccionado al carrito
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

    @DeleteMapping("/eliminar/{factura}") fun delete(@PathVariable factura: String): String {
        proveedoresService.deletebyFactura(factura)
        return "redirect:/listaCompras"
    }
}
