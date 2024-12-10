package com.example.demo.service

import com.example.demo.model.ubicacion
import com.example.demo.repository.repositorioUbicaciones
import org.springframework.stereotype.Service

@Service class ubicacionService(private val ubicacionRepository: repositorioUbicaciones) {

    fun findAll(): List<ubicacion> { return ubicacionRepository.findAll() }

    fun findAllActive(): List<ubicacion> { return ubicacionRepository.findByEliminadoFalse() }

    fun save(ubicacion: ubicacion): ubicacion { return ubicacionRepository.save(ubicacion) }

    fun update(ubicacion: ubicacion): ubicacion { return ubicacionRepository.save(ubicacion) }

    fun deleteById(id: Int) {
        val ubicacion = ubicacionRepository.findById(id).orElseThrow { Exception("Ubicación no encontrada") }
        ubicacionRepository.delete(ubicacion)
    }
}
