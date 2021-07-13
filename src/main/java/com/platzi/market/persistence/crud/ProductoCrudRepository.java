package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

// la extension Crud solo necesita el nombre de la clase (tabla) y el tipo de dato de la llame primaria.
public interface ProductoCrudRepository extends CrudRepository <Producto,Integer> {
    /* query de manera nativa
    @Query(value = "SELECT * FROM producos WHERE id_categoria =?", nativeQuery = true)
    List<Producto> getByCategoria(int idCategoria);
    */

    //querymethod
    List<Producto> findByIdCategoriaOrderByNombreAsc(int idCategoria);

    Optional<List<Producto>> findByCantidadStockLessThanAndEstado(int cantidadStock, boolean estado);

}
