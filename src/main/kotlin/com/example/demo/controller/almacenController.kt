package com.example.demo.controller
import com.example.demo.model.almacen
import com.example.demo.repository.repositorioAlmacen
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping

@Controller @RequestMapping("/almacenes") class almacenController {
    private lateinit var rAlmacen: repositorioAlmacen

    @GetMapping("", "/")
    fun getAlmacenes(almacen: almacen): String {
        val almacenes = rAlmacen.findAll()
        return "almacenes/index"
    }
}