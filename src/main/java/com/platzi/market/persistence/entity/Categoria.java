package com.platzi.market.persistence.entity;

import javax.persistence.*;
import java.util.List;

/**
 * Clase  que es una entidad que tiene persiscencia con la tabla categorias de la base de datos market-place2
 * que tiene relacion con las columnas:
 * @params idCategoria
 * @params descripcion
 * @params estado
 *
 * @author  Itzel Alonso
 * @since 2021
 * @version 1.0
 * */


@Entity
@Table(name ="categorias")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categoria")
    private Integer idCategoria;

    private String descripcion;

    private Boolean estado;

    // crear un uno a muchos ya que una categoría puede tener muchos productos y dentro de la clase Productos existe le relacion
    // Many to One con esta clase categoria y como el atributo dentro de Producto se llama categoría ese es el mappedBy que debemos escribir

    @OneToMany(mappedBy = "categoria")
    private List<Producto> productos;

    public Integer getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Integer idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Boolean getEstado() {
        return estado;
    }

    public void setEstado(Boolean estado) {
        this.estado = estado;
    }
}
