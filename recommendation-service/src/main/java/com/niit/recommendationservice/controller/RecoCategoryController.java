package com.niit.recommendationservice.controller;
import com.niit.recommendationservice.exceptions.CategoryAlreadyExistsException;
import com.niit.recommendationservice.exceptions.CategoryNotFoundException;
import com.niit.recommendationservice.exceptions.ServiceAlreadyExistsException;
import com.niit.recommendationservice.model.Category;
import com.niit.recommendationservice.service.IRecoCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
//@CrossOrigin(origins = "http://localhost:4200")
public class RecoCategoryController {

    private IRecoCategoryService recoCategoryService;
    @Autowired
    public RecoCategoryController(IRecoCategoryService recoCategoryService){
        this.recoCategoryService = recoCategoryService;
    }

    @PostMapping("/category")
    public ResponseEntity<?> addCategory (@RequestBody Category category) throws CategoryAlreadyExistsException {
        try {
            return new ResponseEntity<>(recoCategoryService.addCategory(category), HttpStatus.CREATED);
        }
        catch (CategoryAlreadyExistsException e) {
            throw new CategoryAlreadyExistsException();
        }
    }

    @PutMapping("/category/{categoryName}")
    public ResponseEntity <?> updateCategory (@RequestBody Category category,@PathVariable String categoryName) throws ServiceAlreadyExistsException {
            return new ResponseEntity<>(recoCategoryService.updateCategory(category,categoryName),HttpStatus.OK);
    }

    @GetMapping("/categories")
    public ResponseEntity<?> getAllCategory(){
        return new ResponseEntity<>(recoCategoryService.getAllCategory(),HttpStatus.OK);
    }
    @GetMapping("/category/{categoryName}")
    public ResponseEntity<?> getCategoryByName(@PathVariable String categoryName){
        return new ResponseEntity<>(recoCategoryService.getCategoryByName(categoryName),HttpStatus.OK);
    }

    @DeleteMapping("/category/{categoryName}")
    public ResponseEntity<?> deleteCategory(@PathVariable String categoryName) throws CategoryNotFoundException {
        try {
            return new ResponseEntity<>(recoCategoryService.deleteCategory(categoryName),HttpStatus.GONE);
        } catch (CategoryNotFoundException e) {
            throw new CategoryNotFoundException();
        }
    }

}
