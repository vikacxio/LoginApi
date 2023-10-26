package com.example.starter.model;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;


@Entity
@Table(name = "tokens")
public class AuthenticationToken {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    private String token;

    @Column(name = "created_date")
    private Date created_date;




    @OneToOne(targetEntity = Employee.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    private Employee employee;


    public Integer getId(){
        return id;
    }
    public void setId(Integer id){
        this.id=id;
    }
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Date getCreated_date() {
        return created_date;
    }

    public void setCreated_date(Date created_date) {
        this.created_date = created_date;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public AuthenticationToken(Employee employee) {
        this.employee = employee;
        this.created_date= new Date();
        this.token= UUID.randomUUID().toString();
    }
    public AuthenticationToken(){

    }
}
