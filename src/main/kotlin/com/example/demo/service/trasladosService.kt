package com.example.demo.service

import com.example.demo.model.detallesTraslado
import com.example.demo.model.traslado
import com.example.demo.repository.repositorioDetallesTraslados
import com.example.demo.repository.repositorioTraslados
import org.springframework.stereotype.Service

@Service class trasladosService (private val repositorioTraslados: repositorioTraslados, private val repositorioDetallesTraslados: repositorioDetallesTraslados) {
    fun findALL():List<traslado> = repositorioTraslados.findAll()

    fun findAllActive():List<traslado> = repositorioTraslados.findByEliminadoFalse()

    fun findByID(id:Int):traslado = repositorioTraslados.findbyID(id)

    fun findByOrigen(almacenOrigen:String):List<traslado> = repositorioTraslados.findByOrigen(almacenOrigen)

    fun findByDestino(almacenDestino:String):List<traslado> = repositorioTraslados.findByDestino(almacenDestino)

    fun save(traslado: traslado):traslado = repositorioTraslados.save(traslado)

    fun update(traslado: traslado):traslado {
        return  if(repositorioTraslados.existsById(traslado.IDTraslado?:0)){ repositorioTraslados.save(traslado) }
        else { throw IllegalArgumentException("traslado no encontrado") }
    }

    fun deleteById(IDTraslado:Int){
        val traslado=repositorioTraslados.findById(IDTraslado)
        if(traslado.isPresent){
            val trasladoToDelete=traslado.get().copy(estado = "cancelado")
            repositorioTraslados.save(trasladoToDelete)
        }else{ throw IllegalArgumentException("traslado no encontrado") }
    }

    //detalles
    fun findByIDTraslado(IDTraslado: Int):List<detallesTraslado> = repositorioDetallesTraslados.findByTraslado(IDTraslado)

    fun save(detallesTraslado: detallesTraslado):detallesTraslado = repositorioDetallesTraslados.save(detallesTraslado)

    fun update(detallesTraslado: detallesTraslado) = repositorioDetallesTraslados.save(detallesTraslado)
}