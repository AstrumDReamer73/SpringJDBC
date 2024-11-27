package com.example.demo.service

import com.example.demo.model.almacen
import com.example.demo.model.articulos
import com.example.demo.repository.repositorioAlmacen
import org.springframework.beans.factory.annotation.Autowired

class almacenService @Autowired constructor(private val repositorioAlmacen: repositorioAlmacen){
    fun findAll(): List<almacen> {
        return try { repositorioAlmacen.findAll() }
        catch (e: Exception) { throw e }
    }
    fun findAllActive(): List<almacen> {
        return try { repositorioAlmacen.findAllActive() }
        catch (e: Exception) { throw e }
    }
    fun findAllArticles(id: Int): List<articulos> {
        return try { repositorioAlmacen.findAllArticles(id) }
        catch (e: Exception) { throw e }
    }

    fun insert(almacen: almacen):Int{
        return try { repositorioAlmacen.save(almacen) }
        catch (e:Exception){ throw e }
    }

    fun update(almacen: almacen): Int {
        return try { repositorioAlmacen.update(almacen) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(id: Int): Int {
        return try { repositorioAlmacen.deleteByID(id)
        } catch (e: Exception) { throw e }
    }
}