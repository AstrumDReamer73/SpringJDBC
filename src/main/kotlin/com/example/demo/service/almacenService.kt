package com.example.demo.service

import com.example.demo.model.almacen
import com.example.demo.model.articulo
import com.example.demo.repository.repositorioAlmacenes
import com.example.demo.repository.repositorioArticulos
import org.springframework.stereotype.Service

@Service class almacenService(
    private val almacenRepository: repositorioAlmacenes,
    private val articuloRepository: repositorioArticulos
) {
    fun findAll(): List<almacen> = almacenRepository.findAll()

    fun findAllActive(): List<almacen> = almacenRepository.findAllActive()

    fun findByUPC(UPC: Int): articulo = articuloRepository.findbyUPC(UPC)

    fun findbyID(id:Int):almacen = almacenRepository.findbyIDAlmacen(id)

    fun save(almacen: almacen): almacen= almacenRepository.save(almacen)

    fun update(almacen: almacen): almacen {
        if (almacen.IDAlmacen != null && almacenRepository.existsById(almacen.IDAlmacen?:0)) { return almacenRepository.save(almacen) }
        else { throw IllegalArgumentException("Almacen no encontrado para actualizar") }
    }

    fun deleteById(idAlmacen: Int) {
        val almacen = almacenRepository.findById(idAlmacen)
        if (almacen.isPresent) {
            val almacenToUpdate = almacen.get().copy(eliminado = true)
            almacenRepository.save(almacenToUpdate)
        } else { throw IllegalArgumentException("Almacen no encontrado para eliminar") }
    }
}
