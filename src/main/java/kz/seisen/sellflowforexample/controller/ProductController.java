package kz.seisen.sellflowforexample.controller;


import kz.seisen.sellflowforexample.model.Category;
import kz.seisen.sellflowforexample.model.Product;
import kz.seisen.sellflowforexample.service.CategoryService;
import kz.seisen.sellflowforexample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/products")
public class ProductController {

    @Autowired
    private ProductService productService;
    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public String getProducts(
            @RequestParam(required = false) String search,
            @RequestParam(required = false) Long categoryId,
            Model model) {

        try {
            List<Product> products = productService.getProducts();

            // Apply filters safely
            if (search != null && !search.isEmpty()) {
                products = products.stream()
                        .filter(p -> p.getTitle() != null && p.getTitle().toLowerCase().contains(search.toLowerCase()))
                        .collect(Collectors.toList());
            }

            if (categoryId != null) {
                products = products.stream()
                        .filter(p -> p.getCategoryId() != null && p.getCategoryId().equals(categoryId))
                        .collect(Collectors.toList());
            }

            model.addAttribute("products", products);
            model.addAttribute("categories", categoryService.getCategories());
            model.addAttribute("selectedCategory", categoryId);
            model.addAttribute("searchTerm", search);

            // Get category name safely
            String categoryName = "this category";
            if (categoryId != null) {
                Category category = categoryService.getCategoryById(categoryId);
                categoryName = category != null ? category.getName() : "this category";
            }
            model.addAttribute("selectedCategoryName", categoryName);

            return "products";

        } catch (Exception e) {
            model.addAttribute("error", "An error occurred while filtering products");
            return "products"; // Return to same page with error message
        }
    }


    @GetMapping("/{id}")
    public String getProduct(@PathVariable Long id, Model model) {
        Product product = productService.getProduct(id);
        if (product == null) {
            return "error";
        }

        Category category = categoryService.getCategoryById(product.getCategoryId());
        model.addAttribute("product", product);
        model.addAttribute("category", category);
        return "product-info";
    }


    @GetMapping("/add")
    public String addProduct(Model model) {
        model.addAttribute("categories", categoryService.getCategories());
        return "product-add";
    }

    @PostMapping("/add")
    public String addProduct(Product product) {
        productService.saveProduct(product);
        return "redirect:/products/all";
    }
}
