package com.boot.officeproject.controller.categorycontroller;

import java.util.List;
import java.util.Optional;

import com.boot.officeproject.model.categorymodel.CategoryBean;
import com.boot.officeproject.repository.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CategoryController {
    
    @Autowired
    private CategoryRepository categoryRepository;

    //continue, discontinue
    @PostMapping("/category/{id}/{action}")
    public CategoryBean continueEmployee(@PathVariable("action") String value,@PathVariable("id") String id){
        CategoryBean category = categoryRepository.findById(id).get();
        category.setDisContinue(Boolean.parseBoolean(value));
        return categoryRepository.save(category);
    }   

    //add Category no duplicate's allowed
    @PostMapping("/category")
    public ResponseEntity<List<CategoryBean>> addCategory(@RequestBody CategoryBean category){
        if(category==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        category.setCategoryCode(categoryRepository.findCategoryCode());

        String name = category.getName().trim();
        String value = category.getName().trim().replace(" ", "").toLowerCase();

        for(int i=0;i<value.length();i++){
            if(!(value.charAt(i)>='a' && value.charAt(i)<='z'))
            {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }

        boolean isExist= categoryRepository.exitsOrNot(name)>0? false : true;

        if(isExist){
            categoryRepository.save(category);
            return ResponseEntity.of(Optional.of(categoryRepository.findAll()));
        }
        else{
            
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        
        
    }

    //update Category
    @PutMapping("category/{categoryCode}")
    public ResponseEntity<CategoryBean> updateBean(@PathVariable("categoryCode") String code, @RequestBody CategoryBean category){
        if(category==null) return ResponseEntity.status(HttpStatus.NOT_FOUND).build();

        CategoryBean cate = categoryRepository.findById(code).get();


        String name = category.getName().trim();
        String value = category.getName().trim().replace(" ", "").toLowerCase();
        for(int i=0;i<value.length();i++){
            if(!(value.charAt(i)>='a' && value.charAt(i)<='z'))
            {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }
        boolean isExist= categoryRepository.exitsOrNot(name)>0? false : true;

        if(isExist){
            cate.setName(category.getName());
            cate.setDisContinue(category.isDisContinue());
            categoryRepository.save(cate);
            return ResponseEntity.ok(categoryRepository.save(cate));
        }
        else{
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        
    }

    // Retreiving all categories
    @GetMapping("/category")
    public List<CategoryBean> getAllCategories(){
        return categoryRepository.findAll();
    }

    //Retreiving category by Category Code
    @GetMapping("/category/{categoryCode}")
    public CategoryBean getCategoryById(@PathVariable("categoryCode") String code){
        return categoryRepository.findById(code).get();
    }

}
