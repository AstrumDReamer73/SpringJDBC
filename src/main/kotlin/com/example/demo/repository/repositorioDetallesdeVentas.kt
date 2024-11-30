package com.example.demo.repository

import com.example.demo.model.detallesdeVenta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioDetallesdeVentas @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<detallesdeVenta> {
        val sql = "SELECT * FROM detallesdeVentas WHERE status=1"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(detallesdeVenta::class.java))
    }

    fun findAllByFactura(factura:String):List<detallesdeVenta>{
        val sql="select * from detallesdeVentas where factura=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(detallesdeVenta::class.java))
    }

    fun save(detallesdeVenta: detallesdeVenta): Int {
        val sql = "INSERT INTO detallesdeVentas VALUES (?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, detallesdeVenta.IDDetallesdeCompra, detallesdeVenta.factura, detallesdeVenta.UPC, detallesdeVenta.cantidad, detallesdeVenta.IVA, detallesdeVenta.IEPS, detallesdeVenta.Subtotal, detallesdeVenta.total)
    }

    fun update(detallesdeVenta: detallesdeVenta): Int {
        val sql = "UPDATE detallesdeVentas SET factura=?, UPC=?, cantidad=?, IVA=?, IEPS=?, subtotal=?, total=? WHERE IDDetallesdeCompra=?"
        return jdbcTemplate.update(sql, detallesdeVenta.IDDetallesdeCompra, detallesdeVenta.factura, detallesdeVenta.UPC, detallesdeVenta.cantidad, detallesdeVenta.IVA, detallesdeVenta.IEPS, detallesdeVenta.Subtotal, detallesdeVenta.total)
    }

    fun deleteByID(id:Int): Int {
        val sql="delete from detallesdeVentas where detallesdeVentas=?"
        return jdbcTemplate.update(sql, id)
    }
}