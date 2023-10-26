package com.example.starter.repository;


import com.example.starter.model.AuthenticationToken;
import com.example.starter.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthenticationRepository extends JpaRepository<AuthenticationToken,Integer> {
    AuthenticationToken findByEmployee(Employee employee);
}
