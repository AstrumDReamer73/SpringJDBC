package com.example.demo.repository
import com.example.demo.model.Tarjeta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.jdbc.core.BeanPropertyRowMapper
import org.springframework.jdbc.core.JdbcTemplate
import org.springframework.stereotype.Repository

@Repository class RepositorioTarjeta @Autowired constructor(private val jdbcTemplate: JdbcTemplate) {

    fun findAll(): List<Tarjeta> {
        val sql = "SELECT * FROM tarjeta WHERE status=1"
        return jdbcTemplate.query(sql, BeanPropertyRowMapper(Tarjeta::class.java))
    }

    fun save(tarjeta: Tarjeta): Int {
        val sql = "INSERT INTO tarjetas VALUES (?, ?, ?, ?, ?)"
        return jdbcTemplate.update(sql, tarjeta.nombre, tarjeta.numero, tarjeta.tipo, tarjeta.cvv, tarjeta.status)
    }

    fun update(tarjeta: Tarjeta): Int {
        val sql = "UPDATE tarjetas SET name=?, number=?, CVV=? WHERE IDTarjeta=?"
        return jdbcTemplate.update(sql, tarjeta.nombre, tarjeta.numero, tarjeta.tipo, tarjeta.cvv, tarjeta.status)
    }

    fun deleteByID(id: Int): Int {
        val sql = "UPDATE cards SET status=1 WHERE IDTarjeta=?"
        return jdbcTemplate.update(sql, id)
    }
}
