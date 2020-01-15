package com.expense.report.models;

import com.sun.istack.NotNull;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;

@Embeddable
public class MonthIdentity implements Serializable {

    @NotNull
    @Column
    private int year;

    @NotNull
    @Column
    private int month;

    @NotNull
    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    public MonthIdentity(){}

    public MonthIdentity(int year,int month,User user){
        this.year = year;
        this.month = month;
        this.user = user;
    }


    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }


    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
