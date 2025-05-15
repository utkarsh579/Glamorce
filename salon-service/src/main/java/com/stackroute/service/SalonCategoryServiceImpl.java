package com.stackroute.service;

import com.stackroute.exceptions.CategoryAlreadyExistsException;
import com.stackroute.exceptions.CategoryNotFoundException;
import com.stackroute.exceptions.ServiceAlreadyExistsException;
import com.stackroute.model.Category;
import com.stackroute.model.Services;
import com.stackroute.repository.SalonCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.stackroute.model.Services.SEQUENCE_NAME;

@Service
public class SalonCategoryServiceImpl implements ISalonCategoryService {

    @Autowired
    private SalonCategoryRepository categoryRepository;
    @Autowired
    private SequenceGeneratorService generatorService;


    @Override
    public Category addCategory(Category category, Services services) throws CategoryAlreadyExistsException {
        if (categoryRepository.findById(category.getCategoryName()).isPresent()){
            throw new CategoryAlreadyExistsException();
        }
        return categoryRepository.save(category);
    }

    @Override
    public Category updateCategory(Services service,String categoryName) throws CategoryNotFoundException, ServiceAlreadyExistsException {
        List<Services> list = new ArrayList<>();
        String c="FID";
        String id= String.valueOf(generatorService.getSequenceNumber(SEQUENCE_NAME));
        service.setServiceId(c+id);
        if (categoryRepository.findById(categoryName).isEmpty()){
            list.add(service);
            return categoryRepository.save(new Category(categoryName,list));
        }
        if (categoryRepository.findById(categoryName).isPresent()){
            list=categoryRepository.findById(categoryName).get().getServices();
            for (Services s : list){
                if (service.getServiceName().equals(s.getServiceName())){
                    throw new ServiceAlreadyExistsException();
                }
            }
            list.add(service);
            return categoryRepository.save(new Category(categoryName,list));
        }
       throw new CategoryNotFoundException();
    }

    @Override
    public List getAllCategory() {
        List categoryName= new ArrayList();
        categoryRepository.findAll().forEach(category -> {
            categoryName.add(category.getCategoryName());
        });
        return categoryName;
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

    @Override
    public Category deleteServiceByCategory(String categoryName, String serviceName){
        return categoryRepository.deleteServiceByCategory(categoryName,serviceName);
    }

    @Override
    public List getAllServices() {
        List<Category> list=categoryRepository.findAll();
        List serviceList=new ArrayList();
        for(int i=0;i<list.size();i++){
            for(int j=0;j<list.get(i).getServices().size();j++){
                serviceList.add(list.get(i).getServices().get(j));
            }
        }
        return serviceList;
    }

}
