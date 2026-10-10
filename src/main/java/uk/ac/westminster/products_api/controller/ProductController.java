package uk.ac.westminster.products_api.controller;


import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    private final List<Product> products = new ArrayList<>();

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        products.add(product);
        return product;
    }

    @GetMapping
    public List<Product> getAllProducts() {
        return products;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable Long id){
        for (Product product: products){
            if (product.getId().equals(id)){
                return product;
            }
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String deleteProduct(@PathVariable Long id){
        boolean removed = products.removeIf(
                product -> product.getId().equals(id)
        );
        if (removed){
            return "Product deleted successfully";
        }
        return "Product not found";
    }
}
