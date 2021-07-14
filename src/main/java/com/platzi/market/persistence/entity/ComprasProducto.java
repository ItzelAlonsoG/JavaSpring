package com.platzi.market.persistence.entity;

import javax.persistence.*;
/**
 * Clase  que es una entidad que tiene persiscencia con la tabla compras_productos de la base de datos market-place2
 * que tiene relacion con las columnas:
 * @params id
 * @params canitidad
 * @params total
 * @params estado
 *
 * @author  Itzel Alonso
 * @since 2021
 * @version 1.0
 * */

@Entity
@Table(name = "compras_productos")
public class ComprasProducto {

    @EmbeddedId  // se utiliza cuando la llave primaria es compuesta
    private ComprasPorductoPK id;

    private Integer cantidad;

    private Double total;

    private Boolean estado;


    @ManyToOne
    @MapsId("idCompra")
    @JoinColumn(name = "id_compra", insertable = false,updatable = false)
    private Compra compra;

    @ManyToOne
    @JoinColumn(name = "id_producto", insertable = false,updatable = false)
    private Producto producto;


    public ComprasPorductoPK getId() {
        return id;
    }

    public void setId(ComprasPorductoPK id) {
        this.id = id;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }

    public Compra getCompra() {
        return compra;
    }

    public void setCompra(Compra compra) {
        this.compra = compra;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
