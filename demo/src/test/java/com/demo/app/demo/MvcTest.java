package com.demo.app.demo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;
import org.hamcrest.Matcher;

import org.junit.*;
import org.junit.runner.*;
import static org.mockito.BDDMockito.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.*;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import org.springframework.beans.factory.annotation.*;
import org.springframework.boot.test.autoconfigure.web.servlet.*;
import org.springframework.boot.test.mock.mockito.*;
import org.springframework.test.web.servlet.ResultMatcher;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonRestController.class)
public class MvcTest {
    
	@MockBean
	private PersonService personService;

	@Autowired
	private MockMvc mvc;      
       
        
	@Test
	public void exampleTest() throws Exception {
                List<Person> persons = new ArrayList<>();
                Person bob = new Person();
                bob.setName("Bob");
                bob.setAge(20);
                persons.add(bob);
		given(personService.getAllPersons()).willReturn(persons);
                
                this.mvc.perform(get("/api/persons").accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isOk()).andExpect(content().json("[{'name':'Bob','age':20}]"));

	}
    
}
