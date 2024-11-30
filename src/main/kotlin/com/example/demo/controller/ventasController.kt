package com.example.demo.controller

import com.example.demo.model.compra
import com.example.demo.model.venta
import com.example.demo.repository.repositorioCompras
import com.example.demo.repository.repositorioVentas
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class ventasController {
    @Autowired
    lateinit var repositorioVentas: repositorioVentas

    @GetMapping("/ventas") fun listarVentas(model: Model):String{
        val listaVentas:List<venta> =repositorioVentas.findAll()
        model.addAttribute("listaClientes",listaVentas)
        return "categorias"
    }

    @GetMapping("/ventas/añadirVentas")fun agregarVentas(model: Model):String{
        model.addAttribute("compra", venta())
        return "añadirCategoria"
    }

    @PostMapping("/ventas/guardar") fun guardarVentas(venta: venta):String{
        repositorioVentas.save(venta)
        return "redirect:/ventas"
    }
}