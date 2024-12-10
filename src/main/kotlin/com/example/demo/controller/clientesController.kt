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

    @GetMapping("/{rfc}/empleados") fun findAllEmpleados(@PathVariable rfc: String,model: Model):String {
        model.addAttribute("clientes",clientesService.findEmpleadosbyEmployer(rfc))
        return "listaEmpleadosProveedores"
    }

    @GetMapping("/{rfc}/ventas") fun findAllSells(@PathVariable rfc: String,model: Model):String{
        model.addAttribute("clientes",clientesService.findSellsByCliente(rfc))
        return "listaVentas"
    }

    @PostMapping("/añadirCliente") fun save(@RequestBody cliente: cliente): String {
        clientesService.saveCustomer(cliente)
        return "redirect:/añadirCliente"
    }

    @PutMapping("/{rfc}") fun update(@PathVariable rfc: String, @RequestBody cliente: cliente): String {
        cliente.copy(RFC=rfc).let{clientesService.updateCustomer(it)}
        return "redirect:/listaClientes"
    }

    @DeleteMapping("/{rfc}") fun delete(@PathVariable rfc: String):String {
        clientesService.deleteCustomerbyRFC(rfc)
        return "redirect:/listaClientes"
    }
}