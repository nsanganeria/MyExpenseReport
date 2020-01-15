package com.expense.report.repository;

import com.expense.report.models.Month;
import com.expense.report.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User,Integer> {
    User save(User user);
    void delete(User user);
    User findById(int id);
    List findAll();

    @Query("select u from User u where u.name = :#{#name}")
    User findByName(@Param("name") String name);
}
