package com.example.demo.repository

import com.example.demo.model.categoria
import com.example.demo.model.ubicacion
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioUbicacion @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<ubicacion> {
        val sql = "SELECT * FROM ubicacion"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(ubicacion::class.java))
    }

    fun findAllActive(): List<ubicacion> {
        val sql = "SELECT * FROM ubicacion where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(ubicacion::class.java))
    }

    fun save(ubicacion: ubicacion): Int {
        val sql = "INSERT INTO ubicacion VALUES (?,?,?,?,?)"
        return jdbcTemplate.update(sql,ubicacion.IDUbicacion,ubicacion.IDAlmacen, ubicacion.pasillo, ubicacion.nivel, ubicacion.estante)
    }

    fun update(ubicacion: ubicacion): Int {
        val sql = "UPDATE ubicacion SET IDAlmacen=?, pasillo=?, nivel=?, estante=? WHERE IDUbicacion=?"
        return jdbcTemplate.update(sql, ubicacion.IDUbicacion,ubicacion.IDAlmacen, ubicacion.pasillo, ubicacion.nivel, ubicacion.estante)
    }

    fun deleteByID(id: Int): Int {
        val sql = "drop from ubicacion where IDUbicacion=?"
        return jdbcTemplate.update(sql, id)
    }
}