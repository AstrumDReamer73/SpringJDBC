package com.example.demo.service

import com.example.demo.model.articulos
import com.example.demo.repository.repositorioArticulos
import org.springframework.beans.factory.annotation.Autowired

class articulosService @Autowired constructor(private val repositorioArticulos: repositorioArticulos){
    fun findAll(): List<articulos> {
        return try { repositorioArticulos.findAll() }
        catch (e: Exception) { throw e }
    }

    fun findAllExistences(UPC:Int): List<articulos> {
        return try { repositorioArticulos.findAllExistences(UPC) }
        catch (e: Exception) { throw e }
    }

    fun insert(articulos: articulos):Int{
        return try { repositorioArticulos.save(articulos) }
        catch (e:Exception){ throw e }
    }

    fun update(articulos: articulos): Int {
        return try { repositorioArticulos.update(articulos) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(id: Int): Int {
        return try { repositorioArticulos.deleteByUPC(id)
        } catch (e: Exception) { throw e }
    }
}