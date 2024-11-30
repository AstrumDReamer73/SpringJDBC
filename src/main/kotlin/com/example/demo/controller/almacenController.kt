package com.example.demo.controller
import com.example.demo.model.almacen
import com.example.demo.repository.repositorioAlmacenes
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping

@Controller class almacenController {
    @Autowired lateinit var repositorioAlmacenes: repositorioAlmacenes

    @GetMapping("/almacenes") fun listarAlmacen(model: Model):String{
        val listaAlmacen:List<almacen> =repositorioAlmacenes.findAll()
        model.addAttribute("listaAlmacenes",listaAlmacen)
        return "almacenes"
    }

    @GetMapping("/almacenes/añadirAlmacenes")fun añadirAlmacenes(model: Model):String{
        model.addAttribute("almacenes", almacen())
        return "añadirAlmacenes"
    }

    @PostMapping("/almacenes/guardar") fun guardarAlmacen(almacen: almacen):String{
        repositorioAlmacenes.save(almacen)
        return "redirect:/almacenes"
    }
}