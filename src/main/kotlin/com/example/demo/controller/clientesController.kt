package com.example.demo.controller

import com.example.demo.model.categoria
import com.example.demo.model.cliente
import com.example.demo.repository.repositorioClientes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping


@Controller
class clientesController {
    @Autowired
    lateinit var repositorioClientes: repositorioClientes

    @GetMapping("/clientes") fun listarClientes(model: Model):String{
        val listaClientes:List<cliente> =repositorioClientes.findAll()
        model.addAttribute("listaClientes",listaClientes)
        return "categorias"
    }

    @GetMapping("/clientes/añadirCliente")fun añadirCategoria(model: Model):String{
        model.addAttribute("cliente", cliente())
        return "añadirCategoria"
    }

    @PostMapping("/clientes/guardar") fun guardarCliente(cliente: cliente):String{
        repositorioClientes.save(cliente)
        return "redirect:/clientes"
    }
}