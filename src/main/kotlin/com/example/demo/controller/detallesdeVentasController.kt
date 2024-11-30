package com.example.demo.controller

import com.example.demo.model.detallesdeCompra
import com.example.demo.model.detallesdeVenta
import com.example.demo.repository.repositorioDetallesdeCompras
import com.example.demo.repository.repositorioDetallesdeVentas
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class detallesdeVentasController {
    @Autowired
    lateinit var repositorioDetallesdeVentas: repositorioDetallesdeVentas

    @GetMapping("/detallesdeVentas") fun listardetallesdeCompras(model: Model):String{
        val listadetallesdeCompras:List<detallesdeVenta> =repositorioDetallesdeVentas.findAll()
        model.addAttribute("listadetallesdeCompras",listadetallesdeCompras)
        return "detallesdeVenta"
    }

    @GetMapping("/detallesdeVentas/añadirDetallesdeVentas")fun agregardetallesdeCompras(model: Model):String{
        model.addAttribute("detallesdeVenta", detallesdeVenta())
        return "añadirdetallesdeVenta"
    }

    @PostMapping("/detallesdeVentas/guardar") fun guardardetallesdeCompras(detallesdeVenta: detallesdeVenta):String{
        repositorioDetallesdeVentas.save(detallesdeVenta)
        return "redirect:/detallesdeVenta"
    }
}