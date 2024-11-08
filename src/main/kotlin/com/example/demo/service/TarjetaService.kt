package com.example.demo.service
import com.example.demo.model.Tarjeta
import com.example.demo.repository.RepositorioTarjeta
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service class TarjetaService @Autowired constructor(private val repositorioTarjeta: RepositorioTarjeta) {

    fun findAll(): List<Tarjeta> {
        return try { repositorioTarjeta.findAll() }
        catch (e: Exception) { throw e }
    }

    fun insert(tarjeta: Tarjeta):Int{
        return try { repositorioTarjeta.save(tarjeta) }
        catch (e:Exception){ throw e }
    }

    fun update(tarjeta: Tarjeta): Int {
        return try { repositorioTarjeta.update(tarjeta) }
        catch (e: Exception) { throw e }
    }

    fun deleteById(id: Int): Int {
        return try { repositorioTarjeta.deleteByID(id)
        } catch (e: Exception) { throw e }
    }
}