/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.app.demo;

import java.util.List;

/**
 *
 * @author nosov
 */
public interface PersonService {
    Person getPersonByName(String name);
    List<Person> getAllPersons();
}
