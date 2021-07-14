package com.platzi.market.persistence;

import com.platzi.market.domain.Product;
import com.platzi.market.domain.repository.ProductRepository;
import com.platzi.market.persistence.crud.ProductoCrudRepository;
import com.platzi.market.persistence.entity.Producto;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
// con implemets ProductoRepository
// nuestro repositorio estará enfocado al dominio productRepository
//  los mapeos sirven ya que si importamos el proyecto a otro tipo de base de datos
// por ejemplo mongoDB manejan colecciones y eso haría que nuestra api cambie
// con mapper struct evitamos esto. creamos un nuevo mapper que simplemente cambie a product
// en lo que sea que la coleccion tenga como nombre para que siga funcionando el proyecto.

@Repository
public class ProductoRepository implements ProductRepository {

    @Autowired // Spring con esta anotacion creará las instancias  para la inyeccion de dependencias.
    // si no hacemos esto no estamos inicializando la expresion y se estaría tomando como un null
    //debe de ser un tipo de componente spring
    private ProductoCrudRepository productoCrudRepository;


    @Autowired
    private ProductMapper mapper;

    @Override
    public List<Product> getAll(){
        List<Producto> productos = (List<Producto>) productoCrudRepository.findAll();
        return mapper.toProducts(productos);
    }

    @Override
    public Optional<List<Product>> getByCategory(int categoryId) {
        List<Producto> productos = productoCrudRepository.findByIdCategoriaOrderByNombreAsc(categoryId);
        // el mapper se encarga de convertir la lista de productos a product con el toProductos
        // y el Optional.of se encarga de que la Lista se convierta en un tipo Optioanl para retornar
        // una lista Optional de Product  Optional<List<Product>>
        return Optional.of(mapper.toProducts(productos));
    }

    @Override
    public Optional<List<Product>> getScarseProducts(int quantity) {
       Optional<List<Producto>> productos =  productoCrudRepository.findByCantidadStockLessThanAndEstado(quantity,true);
       // con la lambda por cada producto de la lista opcional llamamos a la funciona de mapper toProducts,
        // lo enviamos como una lista para la funcion ya que toPorducts espera una List<Producto> y los retrona
        return productos.map(prods -> mapper.toProducts(prods));
    }

    @Override
    public Optional<Product> getProduct(int productId) {
        //Como no es una lista si no un objeto podemos hacer que el objeto Producto
        // se convierta en un objeto Product con la funcion de mapper.toProduct que recibe un objeto producto
        // como parámetro
        return productoCrudRepository.findById(productId).map(producto -> mapper.toProduct(producto));
    }


    @Override
    public Product save(Product product) {
        //  como estamos recibiendo en el parámetro un objeto product
        // y la funcion save espera recibir un objeto de tipo producto
        // ahora debemos convertir de product a producto para poder guarder un objeto producto.
        Producto producto = mapper.toProducto(product);
        return mapper.toProduct(productoCrudRepository.save(producto));
    }

    @Override
    public void delete (int productId){
        productoCrudRepository.deleteById(productId);
    }

}
