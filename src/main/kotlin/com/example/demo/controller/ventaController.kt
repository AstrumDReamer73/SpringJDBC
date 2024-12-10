package com.example.demo.controller

import com.example.demo.model.venta
import com.example.demo.service.clientesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/listaVentas") class ventaController{
    @Autowired private lateinit var clientesService: clientesService

    @GetMapping fun findAllSells(model: Model):String {
        model.addAttribute("ventas", clientesService.findAllSells())
        return "listaVentas"
    }

    @GetMapping("/activas") fun findAllActiveSells(model: Model):String {
        model.addAttribute("ventas",clientesService.findAllActiveSells())
        return "listaVentas"
    }

    @GetMapping("/{almacenOrigen}") fun findSellsbyOrigen(@PathVariable almacenOrigen:String,model: Model):String {
        model.addAttribute("ventas", clientesService.findSellsByOrigen(almacenOrigen))
        return "listaVentas"
    }

    @GetMapping("/{rfc}") fun findSellsbyEmpleado(@PathVariable rfc:String,model: Model):String {
        model.addAttribute("ventas",clientesService.findSellsByEmpleado(rfc))
        return "listaVentas"
    }

    @PutMapping("/{factura}") fun update(@PathVariable factura: String,@RequestBody venta: venta):String {
        venta.copy(factura = factura).let { clientesService.updateSell(venta) }
        return "redirect:/listaVentas"
    }

    @PostMapping fun save(@RequestBody venta: venta):String {
        clientesService.saveSell(venta)
        return "redirect:/listaVentas"
    }

    @DeleteMapping("/{factura}")fun deleteSellbyFactura(@PathVariable factura:String):String {
        clientesService.deleteSellbyFactura(factura)
        return "redirect:/listaVentas"
    }
}
