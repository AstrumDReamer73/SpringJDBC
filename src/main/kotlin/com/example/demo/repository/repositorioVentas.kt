package com.example.demo.repository

import com.example.demo.model.venta
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface repositorioVentas : JpaRepository<venta, String> {
    fun findByDestino(destino: String): List<venta>
    fun findByEstadoNot(estado: String): List<venta>
}