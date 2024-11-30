package com.example.demo.service

import com.example.demo.model.almacen
import com.example.demo.model.articulos
import com.example.demo.repository.repositorioAlmacenes
import org.springframework.beans.factory.annotation.Autowired

class almacenService @Autowired constructor(private val repositorioAlmacenes: repositorioAlmacenes){
    fun findAll(): List<almacen> {
        return try { repositorioAlmacenes.findAll() }
        catch (e: Exception) { throw e }
    }
    fun findAllActive(): List<almacen> {
        return try { repositorioAlmacenes.findAllActive() }
        catch (e: Exception) { throw e }
    }
    fun findAllArticles(id: Int): List<articulos> {
        return try { repositorioAlmacenes.findAllArticles(id) }
        catch (e: Exception) { throw e }
    }

    fun insert(almacen: almacen):Int{
        return try { repositorioAlmacenes.save(almacen) }
        catch (e:Exception){ throw e }
    }

    fun update(almacen: almacen): Int {
        return try { repositorioAlmacenes.update(almacen) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(id: Int): Int {
        return try { repositorioAlmacenes.deleteByID(id)
        } catch (e: Exception) { throw e }
    }
}