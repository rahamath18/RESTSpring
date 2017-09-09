package com.zinios.blog.restclient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.client.RestTemplate;

import com.zinios.blog.bean.Employee;

/*
HTTP method	RestTemplate methods

DELETE	delete(java.lang.String, java.lang.Object...)

GET		getForObject(java.lang.String, java.lang.Class<T>, java.lang.Object...)
		getForEntity(java.lang.String, java.lang.Class<T>, java.lang.Object...)

HEAD	headForHeaders(java.lang.String, java.lang.Object...)

OPTIONS	optionsForAllow(java.lang.String, java.lang.Object...)

POST	postForLocation(java.lang.String, java.lang.Object, java.lang.Object...)
		postForObject(java.lang.String, java.lang.Object, java.lang.Class<T>, java.lang.Object...)

PUT	put(java.lang.String, java.lang.Object, java.lang.Object...)

any	exchange(java.lang.String, org.springframework.http.HttpMethod, org.springframework.http.HttpEntity<?>, java.lang.Class<T>, java.lang.Object...)
	execute(java.lang.String, org.springframework.http.HttpMethod, org.springframework.web.client.RequestCallback, org.springframework.web.client.ResponseExtractor<T>, java.lang.Object...)
 */

public class EmployeeRESTTestClient {
	
	public static final String REST_SERVICE_URI = "http://localhost:8080/RESTSpring/employees";

	private static void getEmployees()
	{
	    RestTemplate restTemplate = new RestTemplate();
	     
	    List<Employee> result = restTemplate.getForObject(REST_SERVICE_URI, List.class);
	     
	    System.out.println(result);
	}
	
	private static void getEmployeeById()
	{
	     
	    Map<String, String> params = new HashMap<String, String>();
	    params.put("id", "1");
	     
	    RestTemplate restTemplate = new RestTemplate();
	    Employee result = restTemplate.getForObject(REST_SERVICE_URI + "/{id}", Employee.class, params);
	     
	    System.out.println(result);
	}
	
public static void main(String args[]) {
	System.out.println(">>>>>>>>>>>>>>>>>>");

	getEmployees();
	getEmployeeById();
}
}
