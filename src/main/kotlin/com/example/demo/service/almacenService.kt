package com.example.demo.service

import com.example.demo.model.almacen
import com.example.demo.model.articulo
import com.example.demo.model.ubicacion
import com.example.demo.repository.repositorioAlmacenes
import com.example.demo.repository.repositorioArticulos
import com.example.demo.repository.repositorioUbicaciones
import org.springframework.stereotype.Repository
import org.springframework.stereotype.Service

@Service class almacenService(
    private val almacenRepository: repositorioAlmacenes,
    private val articuloRepository: repositorioArticulos,
    private val ubicacionRepository: repositorioUbicaciones
) {
    fun findAll(): List<almacen> = almacenRepository.findAll()

    fun findAllActive(): List<almacen> = almacenRepository.findAllActive()

    fun findByUPC(UPC: Int): articulo = articuloRepository.findbyUPC(UPC)

    fun findbyID(id:Int):almacen = almacenRepository.findbyIDAlmacen(id)

    fun crearAlmacenConUbicaciones(almacen: almacen, nivelesPorPasillo: Int = 5, estantesPorNivel: Int = 40): almacen {
        val almacenGuardado = almacenRepository.save(almacen)
        for (pasillo in 1..almacen.numPasillos) {
            for (nivel in 1..nivelesPorPasillo) {
                for (estante in 1..estantesPorNivel) {
                    val ubicacion = ubicacion(IDAlmacen = almacenGuardado,
                                              pasillo = pasillo,
                                              nivel = nivel,
                                              estante = estante)
                    ubicacionRepository.save(ubicacion)
                }
            }
        }
        return almacenGuardado
    }

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
