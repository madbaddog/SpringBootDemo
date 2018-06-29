package com.demo.app.demo;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Assert;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
public class ServiceTest {
    
    @TestConfiguration
    static class PersonServiceImplTestContextConfiguration {  
        @Bean
        public PersonService personService() {
            return new PersonServiceImpl();
        }
    }        

    @Before
    public void init() {
        Person person = new Person();
        person.setName("Bob");

        Mockito.when(personRepository.findByName(person.getName()))
          .thenReturn(person);
    }    
    
    @Autowired
    PersonService personService;
    
    @MockBean
    PersonRepository personRepository;    
    
    @Test
    public void whenValidName_thenPersonShouldBeFound() {
        String name = "Bob";
        Person found = personService.getPersonByName(name);
        assertThat(found.getName())
         .isEqualTo(name);        
    }

}
