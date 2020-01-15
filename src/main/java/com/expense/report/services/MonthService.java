package com.expense.report.services;

import com.expense.report.models.Month;
import com.expense.report.models.MonthIdentity;
import com.expense.report.models.User;
import com.expense.report.repository.MonthRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MonthService {

    @Autowired
    private MonthRepository monthRepository;

    @Autowired
    private UserService userService;

    public Month addMonth(int year,int month,int user_id) throws Exception {
        User u = userService.findById(user_id);
        MonthIdentity mi = new MonthIdentity(year,month,u);
        Month mo = new Month(mi,0.0);
        return monthRepository.save(mo);
    }

    public List findAll(){
        return monthRepository.findAll();
    }


    public Month findByCompositeKey(int year,int month,int user_id) throws Exception {
        User u = userService.findById(user_id);
        MonthIdentity mi = new MonthIdentity(year,month,u);
        Month m = monthRepository.findByMonthKey(year,month,user_id);
        if(m!=null){
            return m;
        }
        else{
            throw new Exception("Month with id "+ year+month+user_id+ " doesn't exist");
        }
    }

    public void deleteMonth(int year,int month,int user_id) throws Exception {
        Month m = monthRepository.findByMonthKey(year, month, user_id);
        if(m!=null){
            monthRepository.delete(m);
        }else{
            throw new Exception( year+month+user_id +" doesn't exist");
        }
    }

    public Month updateMonth(int year,int month,int user_id,Double total) throws Exception {
        Month m = monthRepository.findByMonthKey(year, month, user_id);
        if(m!=null){
         //   m.setName(newName);
            m.setTotal(total);
            monthRepository.save(m);
            return m;
        }else{
            throw new Exception(year+month+user_id +" doesn't exist");
        }
    }
}
