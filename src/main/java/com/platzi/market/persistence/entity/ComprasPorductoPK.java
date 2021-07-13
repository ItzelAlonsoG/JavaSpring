package com.platzi.market.persistence.entity;


import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

/**
 * Clase con Embebida que será llamada por la clase
 * @link ComprasProducto
 *
 * @author  Itzel Alonso
 * @since 2021
 * @version 1.0
 * */

@Embeddable // la embebemos dentro de otra clase para obtener la llave compuesta
public class ComprasPorductoPK implements Serializable {

    @Column(name ="id_compra")
    private Integer idCompra;


    @Column(name = "id_producto")
    private Integer idProducto;

    public Integer getIdCompra() {
        return idCompra;
    }

    public void setIdCompra(Integer idCompra) {
        this.idCompra = idCompra;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }
}
