package com.app.student.client;

import java.util.Arrays;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class RestTemplateClient {
	
	   
	public static void performGet() {
		
		String url ="http://localhost:18083/student";
		
		RestTemplate restTemplate = new RestTemplate();
		//  Then U Create instance of Rest Template Object..
		
		HttpHeaders headers = new HttpHeaders();
		//Then u create instance of headers because what we get is JSON 
		//By default But Still if you want to specify u can do it..
		
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_ATOM_XML));
		
		HttpEntity<String>entity = new HttpEntity<String>("parameters", headers);
		//Then u create your entity Objects and You Pass That header as a Parameter.
	
		ResponseEntity<String>result = restTemplate.exchange(url,HttpMethod.GET,entity, String.class);
		
		//RestTemplate has a Exchange method that will help you to make a restful Api call...
		//You Store the Result in a ResponseEntity Object..
		
		System.out.println(result.getBody());
		//Then Using that result you call the getBody() which will intern get the data from server..
		
	}
	
public static void performPost() {
		
	//You have to write code the same way u post the data in your PostMan 
	
		String url ="http://localhost:18083/student";
	
		String json ="{\"firstName\":\"Vishnavi\",\"middleName\":Reddy\",\"lastName\":Bhavanam\",\"programs\":\"SWEN\"}";
		
		RestTemplate restTemplate = new RestTemplate();
		 
		
		HttpHeaders headers = new HttpHeaders();
		
		
		headers.setContentType(MediaType.APPLICATION_JSON);
		headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
		
		HttpEntity<String>entity = new HttpEntity<String>(json, headers);
		
	
		ResponseEntity<String>result = restTemplate.exchange(url,HttpMethod.POST,entity, String.class);
		
		
		System.out.println(result.getBody());
		
		
	}
		
	public static void main(String[] args) {
		
		//performGet();
		
		 performPost();
		
	}
	
}
