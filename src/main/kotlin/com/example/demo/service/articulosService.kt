package com.example.demo.service

import com.example.demo.model.articulo
import com.example.demo.repository.repositorioArticulos
import org.springframework.stereotype.Service

@Service class articulosService (private val articulosRepository: repositorioArticulos){
    fun findAll(): List<articulo> = articulosRepository.findAll()

    fun findAllExistences(UPC: Int): List<articulo> = articulosRepository.findbyUPC(UPC)

    fun findAllActive(): List<articulo> = articulosRepository.findByEliminadoFalse()

    fun findByCategoria(idcategoria:Int):List<articulo> = articulosRepository.findByCategoria(idcategoria)

    fun save(articulos: articulo): articulo = articulosRepository.save(articulos)

    fun update(articulos: articulo): articulo = articulosRepository.save(articulos)

    fun deleteByUPC(UPC: Int) {
        val articulo = articulosRepository.findById(UPC).orElseThrow { Exception("Artículo no encontrado") }
        val updatedArticulo = articulo.copy(eliminado = true)
        articulosRepository.save(updatedArticulo)
    }
}