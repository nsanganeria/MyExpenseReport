package com.expense.report.services;

import com.expense.report.models.User;
import com.expense.report.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User addUser(User user){
        return userRepository.save(user);
    }

    public void deleteUser(String name) throws Exception {
        User u = userRepository.findByName(name);
        if(u!=null){
            userRepository.delete(u);
        }else{
            throw new Exception("user with name "+name+ "not found");
        }
    }

    public User updateUser(User newUser) throws Exception {
        User u = userRepository.findByName(newUser.getName());
        if(u!=null){
            u.setEmail(newUser.getEmail());
            u.setAddress(newUser.getAddress());
            u.setContact(newUser.getContact());
            u.setName(newUser.getName());
            u.setSalary(newUser.getSalary());
            return userRepository.save(u);
        }else{
            throw new Exception("User with name "+ newUser.getName()+" not found");
        }
    }

    public List findALl(){
        return userRepository.findAll();
    }

    public User findById(int id) throws Exception {
        User u = userRepository.findById(id);
        if(u!=null){
            return u;
        }else{
            throw new Exception("user with id "+id+"not found");
        }
    }

    public User findByName(String name) throws Exception {
        User u = userRepository.findByName(name);
        if(u!=null){
            return u;
        }else{
            throw new Exception("User with name "+name+ " not found");
        }
    }
}
