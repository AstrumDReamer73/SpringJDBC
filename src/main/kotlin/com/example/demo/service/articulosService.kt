package com.example.demo.service

import com.example.demo.model.articulo
import com.example.demo.repository.repositorioArticulos
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service class articulosService (private val articulosRepository: repositorioArticulos){
    fun findAll(): List<articulo> { return articulosRepository.findAll() }

    fun findAllExistences(UPC: Int): List<articulo> { return articulosRepository.findByEliminadoAndUPC(false, UPC) }

    fun save(articulos: articulo): articulo { return articulosRepository.save(articulos) }

    fun update(articulos: articulo): articulo { return articulosRepository.save(articulos) }

    fun deleteByUPC(UPC: Int) {
        val articulo = articulosRepository.findById(UPC).orElseThrow { Exception("Artículo no encontrado") }
        val updatedArticulo = articulo.copy(eliminado = true)
        articulosRepository.save(updatedArticulo)
    }
}