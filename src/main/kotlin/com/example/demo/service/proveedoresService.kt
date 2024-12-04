package com.example.demo.service

import com.example.demo.model.compra
import com.example.demo.model.empleadosProveedor
import com.example.demo.model.proveedor
import com.example.demo.repository.repositorioCompras
import com.example.demo.repository.repositorioEmpleadosProveedores
import com.example.demo.repository.repositorioProveedores
import org.springframework.stereotype.Service

@Service class proveedoresService(
    private val proveedorRepository: repositorioProveedores,
    private val empleadosProveedorRepository: repositorioEmpleadosProveedores,
    private val compraRepository: repositorioCompras
) {
    fun findAll(): List<proveedor> = proveedorRepository.findAll()

    fun findAllActive(): List<proveedor> = proveedorRepository.findByEliminadoFalse()

    fun findAllEmpleados(rfc: String): List<empleadosProveedor> { return empleadosProveedorRepository.findByRfcEmpleador(rfc) }

    fun findAllPurchases(rfc: String): List<compra> { return compraRepository.findByDestino(rfc) }

    fun save(proveedor: proveedor): proveedor = proveedorRepository.save(proveedor)

    fun update(proveedor: proveedor): proveedor {
        return if (proveedorRepository.existsById(proveedor.RFC)) { proveedorRepository.save(proveedor) }
        else { throw IllegalArgumentException("Proveedor no encontrado") }
    }

    fun deleteById(rfc: String) {
        val proveedor = proveedorRepository.findById(rfc)
        if (proveedor.isPresent) {
            val proveedorToDelete = proveedor.get().copy(eliminado = true)
            proveedorRepository.save(proveedorToDelete)
        } else { throw IllegalArgumentException("Proveedor no encontrado") }
    }
}
