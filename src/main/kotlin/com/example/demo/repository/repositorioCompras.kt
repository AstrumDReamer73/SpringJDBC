package com.example.demo.repository

import com.example.demo.model.compras
import com.example.demo.model.ubicacion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioCompras @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<compras> {
        val sql = "SELECT * FROM compras"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(compras::class.java))
    }

    fun findAllActive(): List<compras> {
        val sql = "SELECT * FROM compras where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(compras::class.java))
    }

    fun save(compras: compras): Int {
        val sql = "INSERT INTO compras VALUES (?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, compras.factura,compras.motivo, compras.origen, compras.destino, compras.empleado, compras.fechayhora,compras.tipo,compras.estado)
    }

    fun update(compras: compras): Int {
        val sql = "UPDATE compras SET motivo=?, origen=?, destino=?, empleado=?, fechayhora=?, tipo=?, estado=? WHERE factura=?"
        return jdbcTemplate.update(sql,compras.factura,compras.motivo, compras.origen, compras.destino, compras.empleado, compras.fechayhora,compras.tipo,compras.estado)
    }

    fun deleteByFactura(factura:String): Int {
        val sql = "update compras set estado=? where factura=? "
        return jdbcTemplate.update(sql, factura)
    }
}