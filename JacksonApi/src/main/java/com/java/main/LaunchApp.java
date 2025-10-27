package com.java.main;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.model.Allien;
//We can easily convert normal java class into Jackson object by using ObjectMapper class
public class LaunchApp {

	public static void main(String[] args) throws JsonProcessingException 
	{
		Allien al= new Allien(1,"Rajesh","Chandigarh");
		Allien al1= new Allien(2,"Raki","Mohali");
		Allien al2= new Allien(3,"Naresh","Chandigarh");
		List <Allien> ald= Arrays.asList(al,al1,al2);
		System.out.println(ald);
		//Create ObjectMapper
		 ObjectMapper ne =new ObjectMapper();
		 //String nss=ne.writeValueAsString(al);
		String str= ne.writerWithDefaultPrettyPrinter().writeValueAsString(ald);
		 System.out.println(str);
	}

}
