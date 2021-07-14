package com.platzi.market.persistence.entity;

import javax.persistence.*;

/**
 * Clase  que es una entidad que tiene persiscencia con la tabla productos de la base de datos market-place2
 * que tiene relacion con las columnas:
 * @params idProducto
 * @params nombre
 * @params idCategoria
 * @params codigoBarras
 * @params precioVenta
 * @params cantidadStock
 * @params estado
 *
 * @author  Itzel Alonso
 * @since 2021
 * @version 1.0
 * */

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // java genera el id automáticamente.
    @Column(name = "id_producto")
    private Integer idProducto;

    private String nombre; // no hacemos anotacion @column ya que la variable maneja el mismo nombre que la  columna de la tabla productos

    @Column(name = "id_categoria")
    private Integer idCategoria;

    @Column(name = "codigo_barras")
    private String codigoBarras;

    @Column(name = "precio_venta")
    private Double precioVenta;

    @Column(name = "cantidad_stock")
    private Integer cantidadStock;

    private Boolean estado;

    @ManyToOne
    // sirve para indicar la relacion de la clase producto con id_categoria de la tabla categoria y que no sea insertable ni editable
    @JoinColumn(name = "id_categoria", insertable = false,updatable = false)
    private Categoria categoria;

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Integer getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(Integer idProducto) {
        this.idProducto = idProducto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    public Double getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(Double precioVenta) {
        this.precioVenta = precioVenta;
    }

    public Integer getCantidadStock() {
        return cantidadStock;
    }

    public void setCantidadStock(Integer cantidadStock) {
        this.cantidadStock = cantidadStock;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
