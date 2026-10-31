package uk.ac.westminster.products_api;

import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextId = 1L;

    public ProductService() {
        products.add(new DigitalProduct(
                nextId++, "Clean Code (E-book)", 29.99,
                "/downloads/clean-code.pdf", 4.2
        ));

        products.add(new PhysicalProduct(
                nextId++, "27-inch Monitor", 249.99,
                5.4, "61cm x 41cm x 18cm"
        ));
    }

    public List<Product> getAllProducts() {
        return products;
    }

    public java.util.Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }


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

    public List<String> getAllSummaries() {
        return products.stream()
                .map(p -> p.getSummary())
                .toList();
    }
}
