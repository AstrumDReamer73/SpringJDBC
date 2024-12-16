package com.example.demo.repository

import com.example.demo.model.articulo
import com.example.demo.model.compra
import com.example.demo.model.detallesdeCompra
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
public interface repositorioDetallesdeCompras : JpaRepository<detallesdeCompra, Int> {
    @Query("select d from detallesdeCompra d where d.factura=:factura")
    fun findbyPurchase(@Param("factura")factura: compra): List<detallesdeCompra>

    @Transactional
    @Modifying
    @Query("DELETE FROM detallesdeCompra d WHERE d.IDDetalledeCompra =: id")
    fun deleteByID(@Param("id") id: Int): Int

}
