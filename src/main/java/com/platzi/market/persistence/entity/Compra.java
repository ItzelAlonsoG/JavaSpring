package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

/**
 * Clase  que es una entidad que tiene persiscencia con la tabla compras de la base de datos market-place2
 * que tiene relacion con las columnas:
 * @params idCompra
 * @params idCliente
 * @params fecha
 * @params medioPago
 * @params comentario
 * @params estado
 *
 * @author  Itzel Alonso
 * @since 2021
 * @version 1.0
 * */
@Entity
@Table(name = "compras")
public class Compra {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_compra")
    private Integer idCompra;

    @Column(name = "id_cliente")
    private String idCliente;

    private LocalDateTime fecha;

    @Column(name = "medio_pago")
    private String medioPago;

    private String comentario;

    private String estado;

    public Cliente getCliente() {
        return cliente;
    }

    @ManyToOne
    // sirve para indicar la relacion de la clase producto con id_categoria de la tabla categoria y que no sea insertable ni editable
  // si desea modificar un cliente que entre en la Entity Cliente
    @JoinColumn(name = "id_cliente", insertable = false,updatable = false)
    private Cliente cliente;

    //cascade le indicamos que se guardara en forma de castada
    //todos los procesos que se hagan en procesos en la BD se atenderan en cascada
    //los productos

    @OneToMany(mappedBy = "compra", cascade = {CascadeType.ALL})
    private List<ComprasProducto> productos;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(String idCliente) {
        this.idCliente = idCliente;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public String getMedioPago() {
        return medioPago;
    }

    public void setMedioPago(String medioPago) {
        this.medioPago = medioPago;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ComprasProducto> getProductos() {
        return productos;
    }

    public void setProductos(List<ComprasProducto> productos) {
        this.productos = productos;
    }
}
