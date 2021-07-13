package com.platzi.market.persistence.entity;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;

/**
 * Clase  que es una entidad que tiene persiscencia con la tabla clientes de la base de datos market-place2
 * que tiene relacion con las columnas:
 * @params id
 * @params nombre
 * @params apellidos
 * @params celular
 * @params direccion
 * @params correoElectronico
 *
 * @author  Itzel Alonso
 * @since 2021
 * @version 1.0
 * */

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    private Integer id;

    private String nombre;

    private String apellidos;

    private Integer celular;

    private String direccion;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    // crear un uno a muchos ya que un cliente puede tener muchas compras y dentro de la clase Compras existe le relacion
    // Many to One con esta clase Compra y como el atributo dentro de sus atributos el cliente ese es el mappedBy que debemos escribir
    @OneToMany(mappedBy = "cliente")
    private List<Compra> compras;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Integer getCelular() {
        return celular;
    }

    public void setCelular(Integer celular) {
        this.celular = celular;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }
}
