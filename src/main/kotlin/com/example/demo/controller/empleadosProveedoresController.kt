package com.example.demo.controller

import com.example.demo.model.empleadosCliente
import com.example.demo.model.empleadosProveedor
import com.example.demo.repository.repositorioEmpleadosCliente
import com.example.demo.repository.repositorioEmpleadosProveedores
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class empleadosProveedoresController {
    @Autowired
    lateinit var repositorioEmpleadosProveedores:repositorioEmpleadosProveedores

    @GetMapping("/empleadosProveedores") fun listarempleadosCliente(model: Model):String{
        val listaEmpleadosProveedores:List<empleadosProveedor> =repositorioEmpleadosProveedores.findAll()
        model.addAttribute("listaEmpleadosProveedores",listaEmpleadosProveedores)
        return "empleadosProveedores"
    }

    @GetMapping("/empleadosProveedores/añadirempleadosProveedores")fun agregarempleadosCliente(model: Model):String{
        model.addAttribute("empleadosProveedor", empleadosProveedor())
        return "añadirempleadosProveedores"
    }

    @PostMapping("/empleadosProveedores/guardar") fun guardarempleadosCliente(empleadosProveedores: empleadosProveedor):String{
        repositorioEmpleadosProveedores.save(empleadosProveedores)
        return "redirect:/empleadosProveedores"
    }
}