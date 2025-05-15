package com.niit.recommendationservice.service;
import com.niit.recommendationservice.exceptions.CategoryAlreadyExistsException;
import com.niit.recommendationservice.exceptions.CategoryNotFoundException;
import com.niit.recommendationservice.exceptions.ServiceAlreadyExistsException;
import com.niit.recommendationservice.model.Category;
import java.util.List;

public interface IRecoCategoryService {

    Category addCategory (Category category) throws CategoryAlreadyExistsException;
    Category updateCategory (Category category,String categoryName) throws ServiceAlreadyExistsException;
    List<Category> getAllCategory();
    Category getCategoryByName(String categoryName);
    String deleteCategory (String categoryName) throws CategoryNotFoundException;

}
