package com.example.demo.controller

import com.example.demo.model.categoria
import com.example.demo.model.cliente
import com.example.demo.model.proveedor
import com.example.demo.repository.repositorioClientes
import com.example.demo.repository.repositorioProveedores
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class proveedoresController {
    @Autowired
    lateinit var repositorioProveedores: repositorioProveedores

    @GetMapping("/proveedor") fun listarClientes(model: Model):String{
        val listaProveedor:List<proveedor> =repositorioProveedores.findAll()
        model.addAttribute("listaProveedor",listaProveedor)
        return "proveedor"
    }

    @GetMapping("/proveedor/añadirCliente")fun añadirCategoria(model: Model):String{
        model.addAttribute("proveedor", categoria())
        return "añadirCategoria"
    }

    @PostMapping("/proveedores/guardar") fun guardarCliente(proveedor: proveedor):String{
        repositorioProveedores.save(proveedor)
        return "redirect:/proveedor"
    }
}