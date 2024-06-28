package gr.aueb.cf.beststore.services;

import gr.aueb.cf.beststore.models.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductsRepository extends JpaRepository<Product, Integer> {

}
