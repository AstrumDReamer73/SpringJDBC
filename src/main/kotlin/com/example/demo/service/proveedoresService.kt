package com.example.demo.service

import com.example.demo.model.*
import com.example.demo.repository.repositorioCompras
import com.example.demo.repository.repositorioDetallesdeCompras
import com.example.demo.repository.repositorioEmpleadosProveedores
import com.example.demo.repository.repositorioProveedores
import org.springframework.stereotype.Service

@Service class proveedoresService(
    private val proveedorRepository: repositorioProveedores,
    private val empleadosProveedorRepository: repositorioEmpleadosProveedores,
    private val compraRepository: repositorioCompras,
    private val detallesdeComprasRepository: repositorioDetallesdeCompras
) {
    //proveedores
    fun save(proveedor: proveedor): proveedor = proveedorRepository.save(proveedor)

    fun findSupplierbyRFC(rfc: String):proveedor=proveedorRepository.findbyRFC(rfc)

    fun findAllSuppliers(): List<proveedor> = proveedorRepository.findAll()

    fun findAllActiveSuppliers(): List<proveedor> = proveedorRepository.findAllActive()

    fun update(proveedor: proveedor): proveedor {
        return if (proveedorRepository.existsById(proveedor.RFC?:"")) { proveedorRepository.save(proveedor) }
        else { throw IllegalArgumentException("Proveedor no encontrado") }
    }

    fun deleteById(rfc: String) {
        val proveedor = proveedorRepository.findById(rfc)
        if (proveedor.isPresent) {
            val proveedorToDelete = proveedor.get().copy(eliminado = true)
            proveedorRepository.save(proveedorToDelete)
        } else { throw IllegalArgumentException("Proveedor no encontrado") }
    }

    //empleados
    fun findEmpleadobyRFC(rfc: String):empleadosProveedor=empleadosProveedorRepository.findbyID(rfc)

    fun findAllEmpleados():List<empleadosProveedor> =empleadosProveedorRepository.findAll()

    fun findAllActiveEmpleados():List<empleadosProveedor> =empleadosProveedorRepository.findAllActive()

    fun findEmpleadosbyEmployeer(rfc: String): List<empleadosProveedor> = empleadosProveedorRepository.findByRFCEmpleador(rfc)

    fun save(empleadosProveedor: empleadosProveedor):empleadosProveedor = empleadosProveedorRepository.save(empleadosProveedor)

    fun update(empleadosProveedor: empleadosProveedor):empleadosProveedor{
        return if(empleadosProveedorRepository.existsById(empleadosProveedor.RFC?:"")){ empleadosProveedorRepository.save(empleadosProveedor) }
        else{ throw IllegalArgumentException("empleado no encontrado") }
    }

    fun deletebyRFC(rfc: String){
        val empleado=proveedorRepository.findById(rfc)
        if(empleado.isPresent){
            val empleadotoDelete=empleado.get().copy(eliminado = true)
            proveedorRepository.save(empleadotoDelete)
        }else{ throw IllegalArgumentException("empleado no encontrado") }
    }

    //compras
    fun findAllCompras(): List<compra> = compraRepository.findAll()

    fun findAllActiveCompras():List<compra> = compraRepository.findbyEliminadoFalse()

    fun findByfechayhoraAsc(): List<compra> = compraRepository.findByfechayhoraAsc()

    fun findByfechayhoraDesc(): List<compra> =compraRepository.findByfechayhoraDesc()

    fun findByFactura(factura: String):compra =compraRepository.findByFactura(factura)

    fun findByDestino(almacenDestino:String): List<compra> = compraRepository.findByDestino(almacenDestino)

    fun findByEmpleado(empleado: String): List<compra> = compraRepository.findByEmployee(empleado)

    fun findByProveedor(proveedor: String): List<compra> = compraRepository.findBySupplier(proveedor)

    fun findByEstado(estado:String):List<compra> =compraRepository.findByestado(estado)

    fun save(compra: compra):compra = compraRepository.save(compra)

    fun update(compra: compra):compra{
       return if (proveedorRepository.existsById(compra.factura?:"")){ compraRepository.save(compra) }
       else{ throw  IllegalArgumentException("compra no encontrada") }
    }

    fun deletebyFactura(factura: String){
        val compra=compraRepository.findById(factura)
        if(compra.isPresent){
            val compraToDelete=compra.get().copy(estado="eliminada")
            compraRepository.save(compraToDelete)
        }else{
            throw IllegalArgumentException("compra no encontrada")
        }
    }
    //detalles de compra
    fun findDetallesDeCompraByFactura(factura: String): List<detallesdeCompra> {
        val compra=compraRepository.findByFactura(factura)
        return detallesdeComprasRepository.findbyPurchase(compra)
    }

    fun saveDetallesDeCompra(detallesDeCompra: detallesdeCompra): detallesdeCompra =
        detallesdeComprasRepository.save(detallesDeCompra)

    fun updateDetallesDeCompra(detallesDeCompra: detallesdeCompra): detallesdeCompra {
        return if (detallesDeCompra.IDDetalledeCompra != null && detallesdeComprasRepository.existsById(detallesDeCompra.IDDetalledeCompra!!)) { detallesdeComprasRepository.save(detallesDeCompra) }
        else { throw IllegalArgumentException("Detalle de compra no encontrado") }
    }

    fun deleteDetallesDeCompraById(id: Int) {
        if (detallesdeComprasRepository.existsById(id)) { detallesdeComprasRepository.deleteByID(id) }
        else { throw IllegalArgumentException("Detalle de compra no encontrado") }
    }
}
