package com.example.demo.repository

import com.example.demo.model.compra
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioCompras @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<compra> {
        val sql = "SELECT * FROM compras"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(compra::class.java))
    }

    fun findAllActive(): List<compra> {
        val sql = "SELECT * FROM compras where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(compra::class.java))
    }

    fun save(compra: compra): Int {
        val sql = "INSERT INTO compras VALUES (?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, compra.factura,compra.motivo, compra.origen, compra.destino, compra.empleado, compra.fechayhora,compra.tipo,compra.estado)
    }

    fun update(compra: compra): Int {
        val sql = "UPDATE compras SET motivo=?, origen=?, destino=?, empleado=?, fechayhora=?, tipo=?, estado=? WHERE factura=?"
        return jdbcTemplate.update(sql,compra.factura,compra.motivo, compra.origen, compra.destino, compra.empleado, compra.fechayhora,compra.tipo,compra.estado)
    }

    fun deleteByFactura(factura:String): Int {
        val sql = "update compras set estado=? where factura=? "
        return jdbcTemplate.update(sql, factura)
    }
}