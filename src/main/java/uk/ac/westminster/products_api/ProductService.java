package uk.ac.westminster.products_api;

import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();

    public List<Product> getAllProducts() {
        return products;
    }

    public java.util.Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    private Long nextId = 1L;

    public Product addProduct(Product product) {
        product.setId(nextId);
        nextId += 1;
        products.add(product);
        return product;
    }

    public String deleteProduct(Long id) {
        boolean isDeleted = products.removeIf(
                p -> p.getId().equals(id)
        );

        if (isDeleted) {
            return "Deleted successfully";
        }else {
            return "ID not found";
        }
    }

    public List<Product> findProductByName(String name) {
        return products.stream()
                .filter(product ->
                        product.getName().toLowerCase()
                                .contains(name.toLowerCase()))
                .collect(Collectors.toList());
    }
}
