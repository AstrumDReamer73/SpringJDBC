package com.example.demo.repository

import com.example.demo.model.detallesdeCompra
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioDetallesdeCompras  @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<detallesdeCompra> {
        val sql = "SELECT * FROM detallesdeCompra"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(detallesdeCompra::class.java))
    }

    fun findAllbyFactura(factura:String):List<detallesdeCompra>{
        val sql = "SELECT * FROM detallesdeCompra where factura=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(detallesdeCompra::class.java))
    }

    fun save(detallesdeCompra: detallesdeCompra): Int {
        val sql = "INSERT INTO detallesdeCompra VALUES (?,?,?)"
        return jdbcTemplate.update(sql, detallesdeCompra.IDDetallesdeCompra, detallesdeCompra.factura, detallesdeCompra.UPC, detallesdeCompra.cantidad, detallesdeCompra.IVA, detallesdeCompra.IEPS, detallesdeCompra.Subtotal, detallesdeCompra.total)
    }

    fun update(detallesdeCompra: detallesdeCompra): Int {
        val sql = "UPDATE detallesdeCompra SET factura=?, UPC=?, cantidad=?, IVA=?, IEPS=?, subtotal=?, total=? WHERE IDDetallesdeCompra=?"
        return jdbcTemplate.update(sql, detallesdeCompra.IDDetallesdeCompra, detallesdeCompra.factura, detallesdeCompra.UPC, detallesdeCompra.cantidad, detallesdeCompra.IVA, detallesdeCompra.IEPS, detallesdeCompra.Subtotal, detallesdeCompra.total)
    }

    fun deleteByID(id:Int): Int {
        val sql="DROP detallesdeCompra where IDDetallesdeCompra=?"
        return jdbcTemplate.update(sql, id)
    }
}