package com.expense.report.services;

import com.expense.report.models.Category;
import com.expense.report.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;


    public Category addCategory(Category category){
        return categoryRepository.save(category);
    }

    public void deleteCategory(String categoryName) throws Exception {

         Category c = categoryRepository.findByName(categoryName);
         if(c!=null){
             categoryRepository.delete(c);
         }else{
             throw new Exception("No category found with category name " + categoryName);
         }

    }

    public Category update(String oldName,String newName) throws Exception {
        Category c = categoryRepository.findByName(oldName);
        if(c!=null){
            c.setName(newName);
            return categoryRepository.save(c);
        }else{
            throw new Exception("No category found by name" +oldName);
        }

    }

    public Category findById(int id) throws Exception {
        Category c = categoryRepository.findById(id);
        if(c!=null){
            return c;
        }else{
                throw new Exception("no category found with id " + id);
        }
    }

    public List findAll(){
        return categoryRepository.findAll();
    }
}
