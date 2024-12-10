package com.example.demo.controller

import com.example.demo.model.compra
import com.example.demo.service.proveedoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/listaCompras") class compraController {
    @Autowired private lateinit var proveedoresService: proveedoresService

    @GetMapping fun findAllPurchases(model: Model):String  {
        model.addAttribute("compras", proveedoresService.findAllCompras())
        return "listaCompras"
    }

    @GetMapping("/activas") fun findAllActive(model: Model):String {
        model.addAttribute("compras", proveedoresService.findAllActiveCompras())
        return "listaCompras"
    }

    @GetMapping("/{rfc}") fun findComprasporProveedor(@PathVariable rfc: String,model: Model):String {
        model.addAttribute("compras", proveedoresService.findComprasporProveedor(rfc))
        return "listaCompras"
    }

    @GetMapping("/{almacenDestino}") fun findComprasporDestino(@PathVariable almacenDestino:String,model: Model):String {
        model.addAttribute("compras", proveedoresService.findComprasporDestino(almacenDestino))
        return "listaCompras"
    }

    @GetMapping("/{empleado}") fun findComprasporEmpleado(@PathVariable empleado:String,model: Model):String {
        model.addAttribute("compras", proveedoresService.findComprasporEmpleado(empleado))
        return "listaCompras"}

    @PostMapping("/añadirCompra")fun save(@RequestBody compra: compra):String{
        proveedoresService.save(compra)
        return "redirect:/listaCompras"
    }

    @PutMapping("/{factura}") fun update(@PathVariable factura:String,@RequestBody compra: compra):String {
        compra.copy(factura = factura).let { proveedoresService.update(it) }
        return "redirect:/listaCompras"
    }

    @DeleteMapping("/{factura}") fun delete(@PathVariable factura: String):String {
        proveedoresService.deletebyFactura(factura)
        return "redirect:/listaCompras"
    }
}

