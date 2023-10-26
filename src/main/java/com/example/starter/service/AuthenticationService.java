package com.example.starter.service;


import com.example.starter.model.AuthenticationToken;
import com.example.starter.model.Employee;
import com.example.starter.repository.AuthenticationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class  AuthenticationService {
    @Autowired
    AuthenticationRepository authenticationRepository;
   public void saveConfirmationToken(AuthenticationToken authenticationToken){
       authenticationRepository.save(authenticationToken);

    }

    public AuthenticationToken getToken(Employee employee) {
       return authenticationRepository.findByEmployee(employee);
    }
}
