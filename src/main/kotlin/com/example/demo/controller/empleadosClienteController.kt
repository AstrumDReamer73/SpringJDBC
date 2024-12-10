package com.example.demo.controller

import com.example.demo.model.empleadosCliente
import com.example.demo.service.clientesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/listaEmpleadosCliente") class empleadosClienteController {
    @Autowired private lateinit var clientesService: clientesService

    @GetMapping fun findAll(model: Model):String {
        model.addAttribute("empleadosCliente",clientesService.findAllEmpleados())
        return "listaEmpleadosCliente"
    }

    @GetMapping("/activos") fun findAllActive(model: Model):String {
        model.addAttribute("empleadosCliente",clientesService.findAllActiveEmpleados())
        return "listaEmpleadosCliente"
    }

    @PostMapping fun save(@RequestBody empleadosCliente: empleadosCliente,model: Model):String {
        model.addAttribute("empleadosCliente",clientesService.saveEmpleado(empleadosCliente))
        return "listaEmpleadosCliente"
    }

    @PutMapping("/{rfc}") fun update(@PathVariable rfc:String,@RequestBody empleadosCliente: empleadosCliente):String {
        empleadosCliente.copy(RFC = rfc).let { clientesService.updateEmpleado(it) }
        return "redirect:/listaEmpleadosCliente"
    }

    @DeleteMapping("/{rfc}") fun delete(@PathVariable rfc: String):String {
        clientesService.deleteEmpleadobyRFC(rfc)
        return "redirect:/listaEmpleadosCliente"
    }
}