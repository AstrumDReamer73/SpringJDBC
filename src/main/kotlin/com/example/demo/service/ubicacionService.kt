package com.example.demo.service

import com.example.demo.model.proveedores
import com.example.demo.model.ubicacion
import com.example.demo.repository.repositorioProveedores
import com.example.demo.repository.repositorioUbicacion
import org.springframework.beans.factory.annotation.Autowired

class ubicacionService @Autowired constructor(private val repositorioUbicacion: repositorioUbicacion){
    fun findAll(): List<ubicacion> {
        return try { repositorioUbicacion.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllActive(): List<ubicacion> {
        return try { repositorioUbicacion.findAllActive() }
        catch (e: Exception) { throw e }
    }

    fun insert(ubicacion: ubicacion):Int{
        return try { repositorioUbicacion.save(ubicacion) }
        catch (e:Exception){ throw e }
    }

    fun update(ubicacion: ubicacion): Int {
        return try { repositorioUbicacion.update(ubicacion) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(id:Int): Int {
        return try { repositorioUbicacion.deleteByID(id)
        } catch (e: Exception) { throw e }
    }
}