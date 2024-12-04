package com.example.demo.controller

import com.example.demo.model.cliente
import com.example.demo.model.empleadosCliente
import com.example.demo.model.venta
import com.example.demo.service.clientesService
import org.springframework.web.bind.annotation.*

@RestController @RequestMapping("/clientes") class clientesController(private val clienteService: clientesService) {

    @GetMapping fun findAll(): List<cliente> = clienteService.findAll()

    @GetMapping("/activos") fun findAllActive(): List<cliente> = clienteService.findAllActive()

    @GetMapping("/{rfc}/empleados") fun findAllEmpleados(@PathVariable rfc: String): List<empleadosCliente> { return clienteService.findAllEmpleados(rfc) }

    @GetMapping("/{rfc}/ventas") fun findAllSells(@PathVariable rfc: String): List<venta> { return clienteService.findAllSells(rfc) }

    @PostMapping fun save(@RequestBody cliente: cliente): cliente = clienteService.save(cliente)

    @PutMapping("/{rfc}") fun update(@PathVariable rfc: String, @RequestBody cliente: cliente): cliente { return cliente.copy(RFC = rfc).let { clienteService.update(it) } }

    @DeleteMapping("/{rfc}") fun deleteById(@PathVariable rfc: String) = clienteService.deleteByRFC(rfc)
}