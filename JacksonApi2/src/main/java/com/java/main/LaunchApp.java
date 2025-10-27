package com.java.main;

import java.io.*;
import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.model.Allien;
//We can easily convert normal java class into Jackson object by using ObjectMapper class
public class LaunchApp {

	public static void main(String[] args) throws IOException 
	{
		 ObjectMapper ne =new ObjectMapper();
		 Allien read=ne.readValue(new File("json/sample.json"),Allien.class);
		 System.out.println(read);
	}
}
