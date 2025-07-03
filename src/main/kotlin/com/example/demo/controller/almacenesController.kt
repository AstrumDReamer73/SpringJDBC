package com.example.demo.controller
import com.example.demo.model.almacen
import com.example.demo.service.almacenService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/listaAlmacenes") class almacenesController {
    @Autowired private lateinit var almacenService: almacenService
    @GetMapping fun findAll(model: Model): String {
        model.addAttribute("almacenes", almacenService.findAll())
        return "listaAlmacenes"
    }

    @GetMapping("/activos") fun findAllActive(model: Model): String {
        model.addAttribute("almacenes", almacenService.findAllActive())
        return "listaAlmacenes"
    }

    @GetMapping("/añadirAlmacen") fun showAddForm(model: Model): String {
        model.addAttribute("almacen", almacen())
        return "añadirAlmacen"
    }

    @PostMapping("/guardar") fun save( @ModelAttribute almacen: almacen): String {
        almacenService.crearAlmacenConUbicaciones(almacen)
        return "redirect:/listaAlmacenes"
    }

    @GetMapping("/editar/{idalmacen})") fun showEditForm(@PathVariable idalmacen: Int, model: Model): String {
        val almacen = almacenService.findbyID(idalmacen)
        model.addAttribute("almacen", almacen)
        return "añadirAlmacen"
    }

    @PostMapping("/actualizar/{idalmacen}") fun update(@ModelAttribute almacen: almacen,@RequestParam idalmacen:Int): String {
        almacenService.update(almacen)
        return "redirect:/listaAlmacenes"
    }

    @GetMapping("/eliminar/{idalmacen}") fun deleteById(@PathVariable idalmacen: Int): String {
        val almacen=almacenService.findbyID(idalmacen)
        almacenService.deleteById(almacen.IDAlmacen)
        return "redirect:/listaAlmacenes"
    }
}