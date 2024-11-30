package com.example.demo.repository

import com.example.demo.model.articulos
import com.example.demo.model.categoria
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class repositorioCategorias @Autowired constructor(private val jdbcTemplate: JdbcTemplate) {
    fun findAll(): List<categoria> {
        val sql = "SELECT * FROM categorias WHERE status=1"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(categoria::class.java))
    }

    fun findAllArticulos(id: Int):List<articulos>{
        val sql = "SELECT * FROM articulos WHERE IDCategoria=?"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(articulos::class.java))
    }

    fun save(categoria: categoria): Int {
        val sql = "INSERT INTO categorias VALUES (?,?,?,?,?)"
        return jdbcTemplate.update(sql,categoria.nombre,categoria.IVA,categoria.IEPS, categoria.eliminado)
    }

    fun update(categoria: categoria): Int {
        val sql = "UPDATE categorias SET IVA=?, IEPS=?, eliminado=? WHERE IDAlmacen=?"
        return jdbcTemplate.update(sql,categoria.nombre, categoria.IVA,categoria.IEPS, categoria.eliminado)
    }

    fun deleteByID(id: Int): Int {
        val sql = "UPDATE categorias SET eliminado=1 WHERE IDCategoria=?"
        return jdbcTemplate.update(sql, id)
    }
}