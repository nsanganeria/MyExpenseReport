package com.expense.report.models;

import javax.persistence.*;

@Entity
@Table
public class Month {

    @EmbeddedId
    private MonthIdentity monthIdentity;



    @Column
    private Double total;

    public Month(){}

    public Month(MonthIdentity monthIdentity,Double total) {
        this.monthIdentity = monthIdentity;
       // this.name = name;
        this.total = total;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public MonthIdentity getMonthIdentity() {
        return monthIdentity;
    }

    public void setMonthIdentity(MonthIdentity monthIdentity) {
        this.monthIdentity = monthIdentity;
    }
}
