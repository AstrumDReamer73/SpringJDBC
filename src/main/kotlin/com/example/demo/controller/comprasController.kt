package com.example.demo.controller

import com.example.demo.model.categoria
import com.example.demo.model.cliente
import com.example.demo.model.compra
import com.example.demo.repository.repositorioClientes
import com.example.demo.repository.repositorioCompras
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class comprasController {
    @Autowired
    lateinit var repositorioCompras: repositorioCompras

    @GetMapping("/compras") fun listarCompras(model: Model):String{
        val listaCompras:List<compra> =repositorioCompras.findAll()
        model.addAttribute("listaClientes",listaCompras)
        return "categorias"
    }

    @GetMapping("/compras/añadirCompra")fun agregarCompra(model: Model):String{
        model.addAttribute("compra", compra())
        return "añadirCompra"
    }

    @PostMapping("/compras/guardar") fun guardarCompra(compra: compra):String{
        repositorioCompras.save(compra)
        return "redirect:/compras"
    }
}