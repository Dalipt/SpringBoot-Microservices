package com.java.SpringRestApp.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.assertj.MockMvcTester.MockMvcRequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.java.SpringRestApp.RestApi.GreetingController;
import com.java.SpringRestApp.Service.IGreeting;
@WebMvcTest(GreetingController.class)
public class GreetingControllerTest
{
	
	@MockBean
	private IGreeting service;
	
	@Autowired
	private MockMvc mocmvc;
	
	@Test
	void testGetWishes() throws Exception
	{
		//Mocking 
		Mockito.when(service.generateWish("Nandu")).thenReturn("Good Morning");
		
		//RequestObject
		MockHttpServletRequestBuilder request = MockMvcRequestBuilders.get("/greet");
		ResultActions result = mocmvc.perform(request);
		MvcResult mvc=result.andReturn();
		MockHttpServletResponse response = mvc.getResponse();
		int re=response.getStatus();
		
		//Assertion
		assertEquals(200,re);
	}
}
