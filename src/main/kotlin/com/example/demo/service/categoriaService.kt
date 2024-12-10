package com.example.demo.service

import com.example.demo.model.categoria
import com.example.demo.repository.repositorioCategorias
import org.springframework.stereotype.Service

@Service class categoriaService(private val categoriaRepository: repositorioCategorias) {
    fun findAll(): List<categoria> = categoriaRepository.findAll()

    fun findAllActive(): List<categoria> = categoriaRepository.findByEliminadoFalse()

    fun save(categoria: categoria): categoria = categoriaRepository.save(categoria)

    fun update(categoria: categoria): categoria {
        if (categoriaRepository.existsById(categoria.IDCategoria)) { return categoriaRepository.save(categoria) }
        else { throw IllegalArgumentException("Categoria no encontrada para actualizar") }
    }

    fun deleteById(id: Int) {
        val categoria = categoriaRepository.findById(id)
        if (categoria.isPresent) {
            val categoriaToUpdate = categoria.get().copy(eliminado = true)
            categoriaRepository.save(categoriaToUpdate)
        } else { throw IllegalArgumentException("Categoria no encontrada para eliminar") }
    }
}