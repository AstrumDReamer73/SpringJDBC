package com.example.demo.service

import com.example.demo.model.cliente
import com.example.demo.model.empleadosCliente
import com.example.demo.model.venta
import com.example.demo.repository.*
import org.springframework.stereotype.Service

@Service
class clientesService(
    private val clienteRepository: repositorioClientes,
    private val empleadosClienteRepository: repositorioEmpleadosCliente,
    private val ventaRepository: repositorioVentas
) {

    fun findAll(): List<cliente> = clienteRepository.findAll()

    fun findAllActive(): List<cliente> = clienteRepository.findByEliminadoFalse()

    fun findAllEmpleados(rfc: String): List<empleadosCliente> { return empleadosClienteRepository.findByRfcEmpleador(rfc) }

    fun findAllSells(rfc: String): List<venta> { return ventaRepository.findByDestino(rfc) }

    fun save(cliente: cliente): cliente = clienteRepository.save(cliente)

    fun update(cliente: cliente): cliente {
        return if (clienteRepository.existsById(cliente.RFC)) { clienteRepository.save(cliente)
        } else { throw IllegalArgumentException("Cliente no encontrado") }
    }

    fun deleteByRFC(RFC: String) {
        val cliente = clienteRepository.findById(RFC)
        if (cliente.isPresent) {
            val clienteToDelete = cliente.get().copy(eliminado = true)
            clienteRepository.save(clienteToDelete)
        } else { throw IllegalArgumentException("Cliente no encontrado") }
    }
}
