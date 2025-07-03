package com.example.demo.repository

import com.example.demo.model.compra
import com.example.demo.model.detallesCompra
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface repositorioDetallesdeCompras : JpaRepository<detallesCompra, Int> {
    @Query("select d from detallesCompra d where d.factura=:factura")
    fun findbyPurchase(@Param("factura")factura: compra): List<detallesCompra>

    @Transactional @Modifying
    @Query("DELETE FROM detallesCompra d WHERE d.IDDetalledeCompra =: id")
    fun deleteByID(@Param("id") id: Int): Int
}
