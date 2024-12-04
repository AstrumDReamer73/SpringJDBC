package com.example.demo.repository

import com.example.demo.model.empleadosCliente
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository interface repositorioEmpleadosCliente:JpaRepository<empleadosCliente, String> {
    fun findByRfcEmpleador(rfcEmpleador: String): List<empleadosCliente>
    fun findByEliminadoFalse(): List<empleadosCliente>
}
