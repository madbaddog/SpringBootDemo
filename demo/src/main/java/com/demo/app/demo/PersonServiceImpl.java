/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.app.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

/**
 *
 * @author nosov
 */
@Service
public class PersonServiceImpl implements PersonService{
    
    @Autowired
    PersonRepository personRepository;

    public Person getPersonByName(String name) {
        return personRepository.findByName(name);        
    }  
    
    
}
