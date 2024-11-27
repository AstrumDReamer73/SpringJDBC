package com.example.demo.repository

import com.example.demo.model.articulos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioArticulos @Autowired constructor(private val jdbcTemplate: JdbcTemplate) {
    fun findAll(): List<articulos> {
        val sql = "SELECT * FROM articulos"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(articulos::class.java))
    }

    fun findAllExistences(UPC:Int): List<articulos> {
        val sql = "SELECT * FROM articulos where eliminado=0 and UPC=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(articulos::class.java))
    }

    fun save(articulos: articulos): Int {
        val sql = "INSERT INTO articulos VALUES (?,?,?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, articulos.UPC, articulos.posicion, articulos.descripcion, articulos.cantidad, articulos.categoria,articulos.costoCompra,articulos.ultimoCostoCompra,articulos.precioVenta,articulos.ultimoPrecioVenta,articulos.ultimaFechaModificacion,articulos.eliminado)
    }

    fun update(articulos: articulos): Int {
        val sql = "UPDATE articulos SET IDAlmacen=?, nombre=?, direccion=?, territorio=?, estado=?, codPostal=?, telefono=?, capacidad=?, puertos=?, refrigeracion=?, eliminado=?  WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql,  articulos.UPC, articulos.posicion, articulos.descripcion, articulos.cantidad, articulos.categoria,articulos.costoCompra,articulos.ultimoCostoCompra,articulos.precioVenta,articulos.ultimoPrecioVenta,articulos.ultimaFechaModificacion,articulos.eliminado)
    }

    fun deleteByUPC(UPC: Int): Int {
        val sql = "UPDATE articulos SET eliminado=1 WHERE UPC=?"
        return jdbcTemplate.update(sql, UPC)
    }
}