package com.example.demo.controller

import com.example.demo.model.cliente
import com.example.demo.model.empleadosCliente
import com.example.demo.service.clientesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/listaEmpleadosCliente") class empleadosClienteController {
    @Autowired private lateinit var clientesService: clientesService

    @GetMapping fun findAll(model: Model):String {
        model.addAttribute("empleadosCliente",clientesService.findAllEmpleados())
        return "listaEmpleadosCliente"
    }

    @GetMapping("/activos") fun findAllActive(model: Model):String {
        model.addAttribute("empleadosCliente",clientesService.findAllActiveEmpleados())
        return "listaEmpleadosCliente"
    }

    @GetMapping("/añadirEmpleadoCliente")
    fun showAddForm(model: Model): String {
        model.addAttribute("empleadoCliente", empleadosCliente())
        model.addAttribute("listaClientes",clientesService.findAllActiveCustomers())
        return "añadirEmpleadoCliente"
    }

    @PostMapping("/guardar") fun save(@ModelAttribute empleadosCliente: empleadosCliente,model: Model):String {
        model.addAttribute("empleadosCliente",clientesService.saveEmpleado(empleadosCliente))
        return "listaEmpleadosCliente"
    }

    @GetMapping("/editar/{RFC}")fun showEditForm(@PathVariable RFC:String,model: Model):String{
        val empleadosCliente =clientesService.findEmpleadobyRFC(RFC)
        model.addAttribute("empleadosCliente", empleadosCliente)
        model.addAttribute("listaClientes",clientesService.findAllActiveCustomers())
        return "editarEmpleadoCliente"
    }

    @PostMapping("/actualizar/{RFC}")fun update(cliente: cliente):String{
        clientesService.updateCustomer(cliente)
        return "redirect:/listaEmpleadosCliente"
    }

    @GetMapping("eliminar/{RFC}")fun delete(@PathVariable RFC: String):String{
        clientesService.deleteCustomerbyRFC(RFC)
        return "redirect:/listaEmpleadosCliente"
    }
}