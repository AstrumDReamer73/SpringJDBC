package com.example.demo.repository

import com.example.demo.model.*
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface repositorioDetallesdeVentas : JpaRepository<detallesVenta, Int> {
    @Query("select d from detallesVenta d where d.factura=:factura")
    fun findbyPurchase(@Param("factura")factura: String): List<detallesVenta>

    @Transactional @Modifying
    @Query("DELETE FROM detallesVenta d WHERE d.IDDetalledeVenta = id")
    fun deleteByID(@Param("id") id: Int): Int
}
