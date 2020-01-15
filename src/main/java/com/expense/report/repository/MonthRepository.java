package com.expense.report.repository;

import com.expense.report.models.Category;
import com.expense.report.models.Month;
import com.expense.report.models.MonthIdentity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MonthRepository extends JpaRepository<Month, MonthIdentity> {

 Month save(Month month);
 void delete(Month month);
 List findAll();
 //Month findBymonthIdentity(new MonthIdentity(year,month,user));


    @Query("select m from Month m where m.monthIdentity.year = :#{#year} and m.monthIdentity.month = :#{#month} and m.monthIdentity.user.id = :#{#user_id}")
    Month findByMonthKey(@Param("year") int year, @Param("month") int month, @Param("user_id") int user_id);

}


