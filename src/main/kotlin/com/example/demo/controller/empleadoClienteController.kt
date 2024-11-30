package com.example.demo.controller

import com.example.demo.model.empleadosCliente
import com.example.demo.repository.repositorioEmpleadosCliente
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller
class empleadosClienteController {
    @Autowired lateinit var repositorioEmpleadosCliente: repositorioEmpleadosCliente

    @GetMapping("/empleadosCliente") fun listarempleadosCliente(model: Model):String{
        val listadetallesdeCompras:List<empleadosCliente> =repositorioEmpleadosCliente.findAll()
        model.addAttribute("listadetallesdeCompras",listadetallesdeCompras)
        return "detallesdeVenta"
    }

    @GetMapping("/empleadosCliente/añadirempleadosCliente")fun agregarempleadosCliente(model: Model):String{
        model.addAttribute("empleadosCliente", empleadosCliente())
        return "añadirdetallesdeVenta"
    }

    @PostMapping("/empleadosCliente/guardar") fun guardarempleadosCliente(empleadosCliente: empleadosCliente):String{
        repositorioEmpleadosCliente.save(empleadosCliente)
        return "redirect:/detallesdeVenta"
    }
}