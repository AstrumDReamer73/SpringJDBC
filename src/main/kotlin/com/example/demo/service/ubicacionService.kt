package com.example.demo.service

import com.example.demo.model.ubicacion
import com.example.demo.repository.repositorioUbicaciones
import org.springframework.stereotype.Service

@Service class ubicacionService(private val ubicacionRepository: repositorioUbicaciones) {

    fun findAll(): List<ubicacion> { return ubicacionRepository.findAll() }

    fun findAllActive(): List<ubicacion> { return ubicacionRepository.findAllActive() }

    fun findById(id: Int):ubicacion=ubicacionRepository.findbyIDUbicacion(id)

    fun save(ubicacion: ubicacion): ubicacion { return ubicacionRepository.save(ubicacion) }

    fun update(ubicacion: ubicacion): ubicacion { return ubicacionRepository.save(ubicacion) }

    fun deleteByID(Id: Int){
        val ubicacion=ubicacionRepository.findById(Id)
        if(ubicacion.isPresent){
            val ubicaciontoDelete=ubicacion.get().copy(eliminado = true)
            ubicacionRepository.save(ubicaciontoDelete)
        }else{
            throw  IllegalArgumentException("cliente no encontrado")
        }
    }
}
