package kz.seisen.sellflowforexample.service;


import kz.seisen.sellflowforexample.model.Category;
import kz.seisen.sellflowforexample.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private static Long ID = 7L;

    public ProductService() {
        products.add(new Product(1L, "iphone", "good condition", "Taraz", 10000, "dias", 1L));
        products.add(new Product(2L, "Laptop", "middle condition", "Almaty", 23000, "max", 2L));
        products.add(new Product(3L, "PC", "bad condition", "Almaty", 103000, "aza", 3L));
        products.add(new Product(4L, "XBOX", "old condition", "Shymkent", 23200, "kaira", 4L));
        products.add(new Product(5L, "T-shirt", "good condition", "Taraz", 43000, "eliot", 5L));
        products.add(new Product(6L, "PC", "bad condition", "Almaty", 103000, "aza", 6L));
    }


    public List<Product> getProducts() {
        return products;
    }

    public Product getProduct(Long id) {
        for (Product product : products) {
            if (product.getId().equals(id)) {
                return product;
            }
        }
        return null;
    }


    public void saveProduct(Product product) {
        product.setId(ID++);
        products.add(product);
    }

}
