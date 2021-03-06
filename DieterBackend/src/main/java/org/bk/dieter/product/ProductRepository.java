package org.bk.dieter.product;

import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * Created by redi on 03.04.2016.
 */
public interface ProductRepository extends CrudRepository<Product, Long> {

    List<Product> findByNameIgnoreCase(String name);

    Optional<Product> findByProductId(Long productId);

    List<Product> findAll();

}
