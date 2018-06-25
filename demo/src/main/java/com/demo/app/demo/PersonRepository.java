/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.demo.app.demo;

import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author nosov
 */
public interface PersonRepository extends CrudRepository<Person, Long> {
    public Person findByName(String name);
}
