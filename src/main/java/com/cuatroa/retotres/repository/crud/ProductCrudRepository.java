package com.cuatroa.retotres.repository.crud;

import com.cuatroa.retotres.model.Product;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 *
 * @author tatianadiaz
 */
public interface ProductCrudRepository extends MongoRepository<Product, String> {
    
}
