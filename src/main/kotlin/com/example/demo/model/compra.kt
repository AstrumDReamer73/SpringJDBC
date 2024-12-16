package com.example.demo.model

import jakarta.persistence.*
import java.math.BigDecimal
import java.time.LocalDateTime

@Entity
@Table(name = "compras")
data class compra(
    @Id var factura: String? = "",
    @ManyToOne @JoinColumn(name = "RFCProveedor") var proveedor: proveedor? = null,
    @ManyToOne @JoinColumn(name="RFCEmpleado")var empleado: empleadosProveedor? = null,
    @OneToOne @JoinColumn(name="almacenDestino")var almacenDestino: almacen? = null,
    var motivo: String? = "",
    var tipo: String? = "",
    var estado: String? = "",
    var total:BigDecimal?=BigDecimal.ZERO,
    var fechayhora: LocalDateTime? = LocalDateTime.now(),
)