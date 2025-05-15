package com.niit.recommendationservice.service;
import com.niit.recommendationservice.exceptions.CategoryAlreadyExistsException;
import com.niit.recommendationservice.exceptions.CategoryNotFoundException;
import com.niit.recommendationservice.model.Category;
import com.niit.recommendationservice.repository.RecoCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class RecoCategoryServiceImpl implements IRecoCategoryService{

    @Autowired
    private RecoCategoryRepository categoryRepository;


    @Override
    public Category addCategory(Category category) throws CategoryAlreadyExistsException {
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Category category,String categoryName) {
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> getAllCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Category getCategoryByName(String categoryName) {
        return categoryRepository.findById(categoryName).get();
    }

    @Override
    public String deleteCategory(String categoryName) throws CategoryNotFoundException {
        if (categoryRepository.findById(categoryName).isEmpty()){
            throw new CategoryNotFoundException();
        }
        categoryRepository.deleteById(categoryName);
        return "Category_Deleted";
    }

}
