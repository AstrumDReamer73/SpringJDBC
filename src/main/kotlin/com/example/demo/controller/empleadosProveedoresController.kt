package com.example.demo.controller

import com.example.demo.model.empleadosProveedor
import com.example.demo.service.proveedoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/listaEmpleadosProveedores") class empleadosProveedoresController {
    @Autowired private lateinit var proveedoresService: proveedoresService

    @GetMapping fun findAll(model: Model):String {
        model.addAttribute("empleadosProveedores",proveedoresService.findAllEmpleados())
        return "listaEmpleadosProveedores"
    }

    @GetMapping("/activos") fun findAllActive(model: Model):String {
        model.addAttribute("empleadosProveedores",proveedoresService.findAllActiveEmpleados())
        return "listaEmpleadosProveedores"
    }

    @GetMapping("/añadirEmpleadoProveedor")
    fun showAddForm(model: Model): String {
        model.addAttribute("empleadosProveedor", empleadosProveedor())
        model.addAttribute("listaProveedores",proveedoresService.findAllSuppliers())
        return "añadirEmpleadoProveedor"
    }

    @PostMapping("/guardar") fun save(@ModelAttribute empleadosProveedor: empleadosProveedor,model: Model):String{
        model.addAttribute("empleadosProveedor",proveedoresService.save(empleadosProveedor))
        return "listaEmpleadosProveedores"
    }

    @GetMapping("/editar/{RFC}")fun showEditForm(@PathVariable RFC:String,model: Model):String{
        val empleadosCliente =proveedoresService.findEmpleadobyRFC(RFC)
        model.addAttribute("empleadosProveedor", empleadosCliente)
        model.addAttribute("listaProveedores",proveedoresService.findAllActiveSuppliers())
        return "editarEmpleadoProveedor"
    }

    @PostMapping("/actualizar/{RFC}")fun update(empleadosProveedor: empleadosProveedor):String{
        proveedoresService.update(empleadosProveedor)
        return "redirect:/listaEmpleadosProveedores"
    }

    @GetMapping("eliminar/{RFC}")fun delete(@PathVariable RFC: String):String{
        proveedoresService.deletebyRFC(RFC)
        return "redirect:/listaEmpleadosProveedores"
    }
}