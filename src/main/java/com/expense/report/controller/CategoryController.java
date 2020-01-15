package com.expense.report.controller;

import com.expense.report.models.Category;
import com.expense.report.models.User;
import com.expense.report.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/category"})
public class CategoryController {

    @Autowired
    CategoryService categoryService;

    @PostMapping({"/add"})
    public Category addCategory(@RequestBody Category category) {
       // Category c = categoryService.findById(category.getId());
       // if(c.getName() == null){
            return categoryService.addCategory(category);
        //}else{
          //  throw new Exception("category with id already exists");
        //}

    }

    @GetMapping(path = {"/{id}"})
    public Category findOne(@PathVariable("id") int id) throws Exception {
        return categoryService.findById(id);
    }

    @DeleteMapping(path ={"/{name}"})
    public void deleteCategory(@PathVariable("name") String name) throws Exception {
        categoryService.deleteCategory(name);
    }

    @GetMapping
    public List findAll(){
        return categoryService.findAll();
    }

    @PutMapping
    public void update(@RequestParam("oldName") String oldName, @RequestParam("newName") String newName) throws Exception {
        categoryService.update(oldName,newName);
    }
}
