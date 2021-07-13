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

    private Integer canitidad;

    private Double total;

    private Boolean estado;

    @ManyToOne
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

    public Integer getCanitidad() {
        return canitidad;
    }

    public void setCanitidad(Integer canitidad) {
        this.canitidad = canitidad;
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
}
