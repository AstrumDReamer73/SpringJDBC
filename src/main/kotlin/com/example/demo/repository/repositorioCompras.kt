package com.example.demo.repository

import com.example.demo.model.compra
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository
interface repositorioCompras : JpaRepository<compra, String> {
    fun findByDestino(destino: String): List<compra>
    fun findByEstadoNot(estado: String): List<compra>
}
