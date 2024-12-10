package com.example.demo.model

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "compras")
data class compra(
    @Id var factura: String = "",
    @ManyToOne @JoinColumn(name = "RFCProveedor") var proveedor: proveedor? = null, // Relación Many-to-One con `Cliente`
    var motivo: String? = "",
    @OneToOne @JoinColumn(name="almacenDestino")var almacenDestino: almacen? = null,
    var destino: String? = "",
    var empleado: String? = "",
    var fechayhora: LocalDateTime? = null,
    var tipo: String = "",
    var estado: String = "",
    //@OneToMany (mappedBy = "factura", cascade = [CascadeType.ALL], orphanRemoval = true) var detalles: MutableList<detallesdeCompra> = mutableListOf(),
)