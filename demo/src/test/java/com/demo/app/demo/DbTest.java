package com.demo.app.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
//@SpringBootTest
@DataJpaTest
public class DbTest {

        
    @Autowired
    TestEntityManager entityManager;
    
    @Autowired
    PersonRepository personRepository;
    
	@Test
	public void whenFindByName_thenReturnPerson() {
            
            Person person = new Person();
            person.setName("Bob");
            entityManager.persist(person);
            entityManager.flush();
            
            Person found = personRepository.findByName(person.getName());
            
            assertThat(found.getName()).isEqualTo(person.getName());
	}

}
