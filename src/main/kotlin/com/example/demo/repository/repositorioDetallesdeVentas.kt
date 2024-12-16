package com.example.demo.repository

import com.example.demo.model.*
import jakarta.transaction.Transactional
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
interface repositorioDetallesdeVentas : JpaRepository<detallesdeVenta, Int> {
    @Query("select d from detallesdeVenta d where d.factura=:factura")
    fun findbyPurchase(@Param("factura")factura: String): List<detallesdeVenta>

    @Transactional
    @Modifying
    @Query("DELETE FROM detallesdeVenta d WHERE d.IDDetalledeVenta = id")
    fun deleteByID(@Param("id") id: Int): Int

}
