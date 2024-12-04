package com.example.demo.service

import com.example.demo.model.categoria
import com.example.demo.repository.repositorioCategorias
import org.springframework.stereotype.Service

@Service
class categoriaService(private val categoriaRepository: repositorioCategorias) {

    fun findAll(): List<categoria> { return categoriaRepository.findAll() }

    fun findAllActive(): List<categoria> { return categoriaRepository.findByEliminado(false) }

    fun save(categoria: categoria): categoria { return categoriaRepository.save(categoria) }

    fun update(categoria: categoria): categoria { return categoriaRepository.save(categoria) }

    fun deleteById(id: Int) {
        val categoria = categoriaRepository.findById(id).orElseThrow { Exception("Categoría no encontrada") }
        val updatedCategoria = categoria.copy(eliminado = true)
        categoriaRepository.save(updatedCategoria)
    }
}
