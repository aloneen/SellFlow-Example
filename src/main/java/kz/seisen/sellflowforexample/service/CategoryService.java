package kz.seisen.sellflowforexample.service;

import kz.seisen.sellflowforexample.model.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    private List<Category> categories = new ArrayList<>();
    private static Long ID = 1L;

    public CategoryService() {
        categories.add(new Category(1L, "Cars"));
        categories.add(new Category(2L, "Kitchen"));
        categories.add(new Category(3L, "Toys"));
        categories.add(new Category(4L, "Food"));
        categories.add(new Category(5L, "Clothes"));
        categories.add(new Category(6L, "Job"));
    }

    public List<Category> getCategories() {
        return categories;
    }

    public Category getCategoryById(Long id) {
        for (Category category : categories) {
            if (category.getId().equals(id)) {
                return category;
            }
        }
        return null;
    }

    public void addCategory(Category category) {
        category.setId(ID++);
        categories.add(category);
    }

}
