package com.example.demo.repository

import com.example.demo.model.detallesTraslado
import jakarta.transaction.Transactional
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository interface repositorioDetallesTraslados:JpaRepository<detallesTraslado,String> {
    @Transactional @Modifying
    @Query("DELETE FROM detallesTraslado d WHERE d.IDDetallesTraslado =: id")
    fun deleteByID(@Param("id") id: Int): Int

    @Query("select d from detallesTraslado d where d.IDTraslado=:IDTraslado")
    fun findByTraslado(@Param("IDTraslado")IDTraslado: Int):List<detallesTraslado>
}