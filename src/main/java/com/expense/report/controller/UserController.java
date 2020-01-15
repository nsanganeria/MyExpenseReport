package com.expense.report.controller;

import com.expense.report.models.User;
import com.expense.report.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/user"})
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping({"/add"})
    public User addUser(@RequestBody User user){
        return userService.addUser(user);
    }

    @GetMapping
    public List findAll(){
        return userService.findALl();
    }

    @DeleteMapping(path={"/{name}"})
    public void deleteUser(@PathVariable("name") String name) throws Exception {
        userService.deleteUser(name);
    }

    @PutMapping
    public User updateUser(@RequestBody User user) throws Exception {
        return userService.updateUser(user);
    }

    @GetMapping(path={"/{name}"})
    public User getByName(@PathVariable("name") String name) throws Exception {
        return userService.findByName(name);
    }

    @GetMapping(path={"/{id}"})
    public User getById(@PathVariable("id") int id) throws Exception {
        return userService.findById(id);
    }



}
