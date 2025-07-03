package com.example.demo.service

import com.example.demo.model.almacen
import com.example.demo.model.ubicacion
import com.example.demo.repository.repositorioUbicaciones
import org.springframework.stereotype.Service

@Service class ubicacionService(private val ubicacionRepository: repositorioUbicaciones) {
    fun findAll(): List<ubicacion> = ubicacionRepository.findAll()

    fun findById(id: Int):ubicacion = ubicacionRepository.findbyIDUbicacion(id)

    fun update(ubicacion: ubicacion): ubicacion = ubicacionRepository.save(ubicacion)

    fun deleteByID(id: Int){
        if (ubicacionRepository.existsById(id)) { ubicacionRepository.deleteByID(id) }
        else { throw IllegalArgumentException("ubicacion no encontrada") }
    }
    fun save(ubicacion: ubicacion):ubicacion = ubicacionRepository.save(ubicacion)
}
