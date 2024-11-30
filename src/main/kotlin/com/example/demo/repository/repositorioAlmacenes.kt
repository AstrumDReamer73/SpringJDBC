package com.example.demo.repository

import com.example.demo.model.almacen
import com.example.demo.model.articulos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioAlmacenes @Autowired constructor(private val jdbcTemplate: JdbcTemplate){
    fun findAll(): List<almacen> {
        val sql = "SELECT * FROM almacenes"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(almacen::class.java))
    }

    fun findAllActive(): List<almacen> {
        val sql = "SELECT * FROM almacenes where eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(almacen::class.java))
    }

    fun findAllArticles(id: Int):List<articulos>{
        val sql="select * from articulos where idalmacen=? and eliminado=0"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(articulos::class.java))

    }

    fun save(almacen: almacen): Int {
        val sql = "INSERT INTO almacenes VALUES (?,?,?,?,?,?,?,?,?,?,?)"
        return jdbcTemplate.update(sql, almacen.IDAlmacen, almacen.nombre, almacen.direccion, almacen.territorio, almacen.estado,almacen.codPostal,almacen.telefono,almacen.capacidad,almacen.puertos,almacen.refrigeracion,almacen.eliminado)
    }

    fun update(almacen: almacen): Int {
        val sql = "UPDATE almacenes SET IDAlmacen=?, nombre=?, direccion=?, territorio=?, estado=?, codPostal=?, telefono=?, capacidad=?, puertos=?, refrigeracion=?, eliminado=?  WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql,  almacen.IDAlmacen, almacen.nombre, almacen.direccion, almacen.territorio, almacen.estado,almacen.codPostal,almacen.telefono,almacen.capacidad,almacen.puertos,almacen.refrigeracion,almacen.eliminado)
    }

    fun deleteByID(id: Int): Int {
        val sql = "UPDATE almacenes SET eliminado=1 WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql, id)
    }
}