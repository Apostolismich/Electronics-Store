package gr.aueb.cf.beststore.controller;

import gr.aueb.cf.beststore.models.Product;
import gr.aueb.cf.beststore.services.ProductsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductsApiController {

    @Autowired
    private ProductsRepository repo;

    @GetMapping
    public List<Product> getAllProducts() {
        return repo.findAll();
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable int id) {
        return repo.findById(id).orElse(null);
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {
        return repo.save(product);
    }

    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable int id, @RequestBody Product updatedProduct) {
        return repo.findById(id).map(product -> {
            product.setName(updatedProduct.getName());
            product.setBrand(updatedProduct.getBrand());
            product.setCategory(updatedProduct.getCategory());
            product.setPrice(updatedProduct.getPrice());
            product.setDescription(updatedProduct.getDescription());
            return repo.save(product);
        }).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable int id) {
        repo.deleteById(id);
    }
}
