package com.example.demo.controller

import com.example.demo.model.cliente
import com.example.demo.service.clientesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.*

@Controller @RequestMapping("/listaClientes") class clientesController{
    @Autowired private lateinit var clientesService: clientesService

    @GetMapping fun findAll(model: Model):String {
        model.addAttribute("clientes",clientesService.findAllCustomers())
        return "listaClientes"
    }

    @GetMapping("/activos") fun findAllActive(model: Model):String{
        model.addAttribute("clientes",clientesService.findAllActiveCustomers())
        return "redirect:/listaClientes"
    }

    @GetMapping("/empleados/{RFC}") fun findAllEmpleados(@PathVariable RFC: String,model: Model):String {
        model.addAttribute("empleadosCliente",clientesService.findEmpleadosbyEmployer(RFC))
        return "listaEmpleadosCliente"
    }

    @GetMapping("/ventas/{RFC}") fun findAllSells(@PathVariable RFC: String,model: Model):String{
        val ventas = clientesService.findByCliente(RFC) // Revisión aquí
        model.addAttribute("ventas", ventas)
        return "listaVentas"
    }

    @GetMapping("/añadirCliente")
    fun showAddForm(model: Model): String {
        model.addAttribute("cliente", cliente())
        return "añadirCliente"
    }

    @PostMapping("/guardar") fun save(@ModelAttribute cliente: cliente): String {
        clientesService.saveCustomer(cliente)
        return "redirect:/listaClientes"
    }

    @GetMapping("/editar/{RFC}")fun showEditForm(@PathVariable RFC:String,model: Model):String{
        val cliente =clientesService.findbyRFC(RFC)
        model.addAttribute("cliente",cliente)
        return "editarCliente"
    }

    @PostMapping("/actualizar/{RFC}")fun update(cliente: cliente):String{
        clientesService.updateCustomer(cliente)
        return "redirect:/listaCategorias"
    }

    @GetMapping("eliminar/{RFC}")fun delete(@PathVariable RFC: String):String{
        clientesService.deleteCustomerbyRFC(RFC)
        return "redirect:/listaCategorias"
    }
}