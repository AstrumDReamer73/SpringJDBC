package com.example.demo.repository

import com.example.demo.model.detallesdeVentas
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioDetallesdeVentas @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<detallesdeVentas> {
        val sql = "SELECT * FROM detallesdeVentas WHERE status=1"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(detallesdeVentas::class.java))
    }

    fun findAllByFactura(factura:String):List<detallesdeVentas>{
        val sql="select * from detallesdeVentas where factura=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(detallesdeVentas::class.java))
    }

    fun save(detallesdeVentas: detallesdeVentas): Int {
        val sql = "INSERT INTO detallesdeVentas VALUES (?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, detallesdeVentas.IDDetallesdeCompra, detallesdeVentas.factura, detallesdeVentas.UPC, detallesdeVentas.cantidad, detallesdeVentas.IVA, detallesdeVentas.IEPS, detallesdeVentas.Subtotal, detallesdeVentas.total)
    }

    fun update(detallesdeVentas: detallesdeVentas): Int {
        val sql = "UPDATE detallesdeVentas SET factura=?, UPC=?, cantidad=?, IVA=?, IEPS=?, subtotal=?, total=? WHERE IDDetallesdeCompra=?"
        return jdbcTemplate.update(sql, detallesdeVentas.IDDetallesdeCompra, detallesdeVentas.factura, detallesdeVentas.UPC, detallesdeVentas.cantidad, detallesdeVentas.IVA, detallesdeVentas.IEPS, detallesdeVentas.Subtotal, detallesdeVentas.total)
    }

    fun deleteByID(id:Int): Int {
        val sql="delete from detallesdeVentas where detallesdeVentas=?"
        return jdbcTemplate.update(sql, id)
    }
}