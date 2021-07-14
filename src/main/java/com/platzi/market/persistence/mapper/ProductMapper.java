package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.Product;
import com.platzi.market.persistence.entity.Producto;
import org.mapstruct.*;

import java.util.List;

//Sirve para indicar que será una classe de tipo Mapper
// y que internamente usará  o tiene relacion con otra clase que es Category el cual maneja su propio Mapper también.
@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    // Source es de la clase Producto y tarjet de la clase Product
    //Esto con el fin de relacionarlo y convertirlo
    @Mappings({
            @Mapping(source = "idProducto",target = "productoId"),
            @Mapping(source = "nombre",target = "name"),
            @Mapping(source = "idCategoria",target = "categoryId"),
            @Mapping(source = "precioVenta",target = "price"),
            @Mapping(source = "cantidadStock",target = "stock"),
            @Mapping(source = "estado",target = "active"),
            @Mapping(source = "categoria",target = "category"),
    })
    Product toProduct (Producto producto);
    List<Product> toProducts(List<Producto> productos);

    // Esta notación sirve para para aplicar de manera inversa
    // convertir de Product a Producto, como ya tenemos la configuración de mappings arriba
    // no es necesario escribirlo de nuevo y  como no estan mapeados todos los campos
    // podemos aplicar  target e ignore como true para que  ignore el campo al querer  convertir
    // de product a producto.
    @InheritInverseConfiguration
    @Mapping(target = "codigoBarras", ignore = true)
    Producto toProducto (Product product);
}
