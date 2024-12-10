package com.example.demo.service

import com.example.demo.model.cliente
import com.example.demo.model.detallesdeVenta
import com.example.demo.model.empleadosCliente
import com.example.demo.model.venta
import com.example.demo.repository.*
import org.springframework.stereotype.Service

@Service
class clientesService(
    private val clienteRepository: repositorioClientes,
    private val empleadosClienteRepository: repositorioEmpleadosCliente,
    private val ventaRepository: repositorioVentas,
    private val detallesdeVentasRepository: repositorioDetallesdeVentas
) {
    //cliente
    fun findAllCustomers(): List<cliente> = clienteRepository.findAll()

    fun findAllActiveCustomers(): List<cliente> = clienteRepository.findByEliminadoFalse()

    fun saveCustomer(cliente: cliente): cliente = clienteRepository.save(cliente)

    fun updateCustomer(cliente: cliente): cliente {
        return if (clienteRepository.existsById(cliente.RFC)) { clienteRepository.save(cliente)
        } else { throw IllegalArgumentException("Cliente no encontrado") }
    }

    fun deleteCustomerbyRFC(RFC: String){
        val cliente=clienteRepository.findById(RFC)
        if(cliente.isPresent){
            val clientetoDelete=cliente.get().copy(eliminado = true)
            clienteRepository.save(clientetoDelete)
        }else{
            throw  IllegalArgumentException("cliente no encontrado")
        }
    }

    //empleados
    fun findAllEmpleados():List<empleadosCliente> = empleadosClienteRepository.findAll()

    fun findAllActiveEmpleados():List<empleadosCliente> =empleadosClienteRepository.findByEliminadoFalse()

    fun findEmpleadosbyEmployer(rfc: String): List<empleadosCliente> = empleadosClienteRepository.findByRFCEmpleador(rfc)

    fun saveEmpleado(empleado: empleadosCliente):empleadosCliente=empleadosClienteRepository.save(empleado)

    fun updateEmpleado(empleado: empleadosCliente):empleadosCliente{
        return if(empleadosClienteRepository.existsById(empleado.RFC)){ empleadosClienteRepository.save(empleado) }
        else{ throw IllegalArgumentException("empleado no encontrado") }
    }

    fun deleteEmpleadobyRFC(RFC: String){
        val empleado=empleadosClienteRepository.findById(RFC)
        if(empleado.isPresent){
            val empleadotoDelete=empleado.get().copy(eliminado = true)
            empleadosClienteRepository.save(empleadotoDelete)
        }else{ throw IllegalArgumentException("empleado no encontrado") }
    }

    //ventas
    fun saveSell(venta: venta):venta=ventaRepository.save(venta)

    fun findAllSells(): List<venta>  = ventaRepository.findAll()

    fun findAllActiveSells(): List<venta> = ventaRepository.findByEliminadoFalse()

    fun findSellsByOrigen(almacenOrigen: String): List<venta> = ventaRepository.findByOrigen(almacenOrigen)

    fun findSellsByEmpleado(empleado: String): List<venta> = ventaRepository.findByEmployee(empleado)

    fun findSellsByCliente(cliente: String): List<venta> = ventaRepository.findByCustomer(cliente)

    fun updateSell(venta: venta):venta{
        return if(ventaRepository.existsById(venta.factura)){ ventaRepository.save(venta) }
        else { throw  IllegalArgumentException("venta no encontrada") }
    }

    fun deleteSellbyFactura(factura: String){
        val venta=ventaRepository.findById(factura)
        if(venta.isPresent){
            val ventatoDelete=venta.get().copy(estado = "eliminado")
            ventaRepository.save(ventatoDelete)
        }else{
            throw IllegalArgumentException("venta no encontrada")
        }
    }

    //detalles de venta
    fun findDetallesDeVentaByFactura(factura: String): List<detallesdeVenta> = detallesdeVentasRepository.findbyPurchase(factura)

    fun saveDetallesDeVenta(detallesDeVenta: detallesdeVenta): detallesdeVenta = detallesdeVentasRepository.save(detallesDeVenta)

    fun updateDetallesDeVenta(detallesDeVenta: detallesdeVenta): detallesdeVenta {
        return if (detallesDeVenta.IDDetalledeVenta != null && detallesdeVentasRepository.existsById(detallesDeVenta.IDDetalledeVenta!!)) { detallesdeVentasRepository.save(detallesDeVenta) }
        else { throw IllegalArgumentException("Detalle de venta no encontrado") }
    }

    fun deleteDetallesDeVentaById(id: Int) {
        if (detallesdeVentasRepository.existsById(id)) { detallesdeVentasRepository.deleteByID(id) }
        else { throw IllegalArgumentException("Detalle de venta no encontrado") }
    }
}
