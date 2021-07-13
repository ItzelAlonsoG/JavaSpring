package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

// la extension Crud solo necesita el nombre de la clase (tabla) y el tipo de dato de la llame primaria.
public interface ProductoCrudRepository extends CrudRepository <Producto,Integer> {
}
