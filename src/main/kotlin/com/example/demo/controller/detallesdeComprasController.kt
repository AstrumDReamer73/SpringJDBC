package com.example.demo.controller

import com.example.demo.model.compra
import com.example.demo.model.detallesdeCompra
import com.example.demo.repository.repositorioCompras
import com.example.demo.repository.repositorioDetallesdeCompras
import com.example.demo.repository.repositorioDetallesdeVentas
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class detallesdeComprasController {
    @Autowired
    lateinit var repositorioDetallesdeCompras: repositorioDetallesdeCompras

    @GetMapping("/detallesdeCompras") fun listardetallesdeCompras(model: Model):String{
        val listadetallesdeCompras:List<detallesdeCompra> =repositorioDetallesdeCompras.findAll()
        model.addAttribute("listaClientes",listadetallesdeCompras)
        return "detallesdeCompra"
    }

    @GetMapping("/detallesdeCompras/añadirdetallesdeCompras")fun agregardetallesdeCompras(model: Model):String{
        model.addAttribute("detallesdeCompra", detallesdeCompra())
        return "añadirCategoria"
    }

    @PostMapping("/detallesdeCompras/guardar") fun guardardetallesdeCompras(detallesdeCompra: detallesdeCompra):String{
        repositorioDetallesdeCompras.save(detallesdeCompra)
        return "redirect:/detallesdeCompra"
    }
}