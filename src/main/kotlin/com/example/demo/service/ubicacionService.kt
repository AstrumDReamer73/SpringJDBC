package com.example.demo.service

import com.example.demo.model.ubicacion
import com.example.demo.repository.repositorioUbicaciones
import org.springframework.beans.factory.annotation.Autowired

class ubicacionService @Autowired constructor(private val repositorioUbicaciones: repositorioUbicaciones){
    fun findAll(): List<ubicacion> {
        return try { repositorioUbicaciones.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<ubicacion> {
        return try { repositorioUbicaciones.findAllActive() }
        catch (e: Exception) { throw e }
    }

    fun insert(ubicacion: ubicacion):Int{
        return try { repositorioUbicaciones.save(ubicacion) }
        catch (e:Exception){ throw e }
    }

    fun update(ubicacion: ubicacion): Int {
        return try { repositorioUbicaciones.update(ubicacion) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(id:Int): Int {
        return try { repositorioUbicaciones.deleteByID(id)
        } catch (e: Exception) { throw e }
    }
}