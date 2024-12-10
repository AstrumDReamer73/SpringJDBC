package com.example.demo.controller

import com.example.demo.model.empleadosProveedor
import com.example.demo.service.proveedoresService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/listaEmpleadosProveedor") class empleadosProveedoresController {
    @Autowired private lateinit var proveedoresService: proveedoresService

    @GetMapping fun findAll(model: Model):String {
        model.addAttribute("empleadosProveedores",proveedoresService.findAll())
        return "listaEmpleadosProveedor"
    }

    @GetMapping("/activos") fun findAllActive(model: Model):String {
        model.addAttribute("empleadosProveedores",proveedoresService.findAllActiveEmpleados())
        return "listaEmpleadosProveedor"
    }

    @PostMapping fun save(@RequestBody empleadosProveedor: empleadosProveedor,model: Model):String {
        model.addAttribute("empladosProveedores",proveedoresService.save(empleadosProveedor))
        return "listaEmpleadosProveedor"
    }

    @PutMapping("7{rfc}") fun update(@PathVariable rfc:String,@RequestBody empleadosProveedor: empleadosProveedor):String {
        empleadosProveedor.copy(RFC = rfc).let { proveedoresService.update(it) }
        return "redirect:/listaEmpleadosProveedor"
    }
    @DeleteMapping("/{rfc}")fun delete(@PathVariable rfc:String):String {
        proveedoresService.deleteById(rfc)
        return "redirect:/listaEmpleadosProveedor"
    }
}