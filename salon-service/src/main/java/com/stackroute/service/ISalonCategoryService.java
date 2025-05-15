package com.stackroute.service;
import com.stackroute.exceptions.CategoryAlreadyExistsException;
import com.stackroute.exceptions.CategoryNotFoundException;
import com.stackroute.exceptions.ServiceAlreadyExistsException;
import com.stackroute.model.Category;
import com.stackroute.model.Services;

import java.util.List;

public interface ISalonCategoryService {

    Category addCategory (Category category, Services services) throws CategoryAlreadyExistsException;
    Category updateCategory (Services service,String categoryName) throws CategoryNotFoundException, ServiceAlreadyExistsException;
    List getAllCategory();
    Category getCategoryByName(String categoryName);
    String deleteCategory (String categoryName) throws CategoryNotFoundException;
    Category deleteServiceByCategory(String categoryName,String serviceName);

    List getAllServices();

}
