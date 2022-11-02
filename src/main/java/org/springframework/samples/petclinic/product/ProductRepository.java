package org.springframework.samples.petclinic.product;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;



public interface ProductRepository extends CrudRepository<Product, Integer> {
    @Query("SELECT p FROM Product p ")
    List<Product> findAll();

    @Query("SELECT pt FROM ProductType pt ")
    List<ProductType> findAllProductTypes();

    Optional<Product> findById(int id);

    @Query("SELECT pt FROM ProductType pt WHERE pt.name = :namep")
    ProductType findProductTypeByName(@Param("namep") String name);

    @Query("SELECT p FROM Product p WHERE p.price < :pr")
    List<Product> findByPriceLessThan (@Param("pr") Double price);

    Product findByName(String name);

    Product save(Product p);
}
