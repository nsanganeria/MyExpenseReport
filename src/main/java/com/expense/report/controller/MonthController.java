package com.expense.report.controller;

import com.expense.report.models.Month;
import com.expense.report.models.User;
import com.expense.report.services.MonthService;
import com.expense.report.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping({"/month"})
public class MonthController {

    @Autowired
    MonthService monthService;

    @Autowired
    UserService userService;

    @PostMapping({"/add"})
    public Month create(@RequestParam("year") int year, @RequestParam("month") int month, @RequestParam("user_id") int user_id) throws Exception {

     /*   try {
            int y = Integer.parseInt(String.valueOf(year));
            int m = Integer.parseInt(String.valueOf(month));
            if(m>=1 && m<=12){
                User u = userService.findById(user_id);
                if(u!=null){
                    return monthService.addMonth(year,month,user_id);
                }else {
                    throw new Exception("User with id does't exist");
                }
            }else{
                throw new Exception("Invalid month");
            }
        }
        catch(NumberFormatException e){
            throw e;
        }*/

     return monthService.addMonth(year,month,user_id);
    }

    @GetMapping
    public List findAll(){
        return monthService.findAll();
    }

    @GetMapping(path = {"/{year}/{month}/{user_id}"})
    public Month findOne(@PathVariable("year") int year, @PathVariable("month") int month, @PathVariable("user_id") int user_id) throws Exception {
        return monthService.findByCompositeKey(year,month,user_id);
    }

    @DeleteMapping(path = {"/{year}/{month}/{user_id}"})
    public void deleteMonth(@PathVariable("year") int year,@PathVariable("month") int month,@PathVariable("user_id") int user_id) throws Exception {
        monthService.deleteMonth(year,month,user_id);
    }

    @PutMapping
    public Month updateMonth(@RequestParam("year") int year,@RequestParam("month") int month,@RequestParam("user_id") int user_id, @RequestParam("total") Double total) throws Exception {
        return monthService.updateMonth(year,month,user_id,total);
    }

}
