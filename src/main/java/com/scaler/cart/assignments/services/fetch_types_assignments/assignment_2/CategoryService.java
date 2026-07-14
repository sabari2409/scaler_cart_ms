package com.scaler.cart.assignments.services.fetch_types_assignments.assignment_2;

import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_2.Category;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_2.Image;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_2.Product;
import com.scaler.cart.assignments.models.fetch_types_assignments.assignment_2.SubCategory;
import com.scaler.cart.assignments.repo.fetch_types_assignments.assignment_2.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    /**
     * We want to capture titles of all categories,
     * names of products associated with those categories
     * descriptiveNames of all images associated with a product
     *
     * @return return these as List<String>. Order doesn't matter.
     */
    public List<String> getNamesOfAllCategoriesAndLinkedProductsAndTheirImages() {
        List<Category> categoryLists = this.categoryRepo.findAll();
        List<String> out = new ArrayList<>();
        for (Category category : categoryLists) {
            out.add(category.getTitle());
            List<Product> productList = category.getProductList();
            for (Product product : productList) {
                out.add(product.getName());
                List<Image> imageList = product.getImages();
                for (Image image : imageList) {
                    out.add(image.getDescriptiveName());
                }
            }
        }
        return out;
    }

    /**
     * We want to capture titles of all categories
     * names of all subCategories associated with these categories
     *
     * @return return these as List<String>.
     */
    public List<String> getNamesOfAllCategoriesAndTheirSubCategories() {
        List<Category> categoryLists = this.categoryRepo.findAll();
        List<String> out = new ArrayList<>();
        for (Category category : categoryLists) {
            out.add(category.getTitle());
            List<SubCategory> subCategoryList = category.getSubCategories();
            for (SubCategory subCategory : subCategoryList) {
                out.add(subCategory.getName());
            }
        }
        return out;
    }
}