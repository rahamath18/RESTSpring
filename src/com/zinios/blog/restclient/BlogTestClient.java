package com.zinios.blog.restclient;

import java.util.List;

import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.zinios.blog.bean.Blog;

public class BlogTestClient {

	public static final String REST_SERVICE_URI = "http://localhost:8080/RESTSpring/api";

	/* GET */
	private static void listAllBlogs() {
		System.out.println("Testing listAllBlogs API-----------");

		RestTemplate restTemplate = new RestTemplate();
		List<Blog> blogsMap = restTemplate.getForObject(REST_SERVICE_URI + "/blog/", List.class);
		System.out.println("blogsMap----------" + blogsMap);

		if (blogsMap != null) {
			// for(LinkedHashMap<String, Object> map : blogsMap){
			// System.out.println("Blog : id="+map.get("id")+",
			// Name="+map.get("name")+", Age="+map.get("age")+",
			// Salary="+map.get("salary"));;
			// }
		} else {
			System.out.println("No blog exist----------");
		}
	}

	/* GET */
	private static void getBlog() {
		System.out.println("Testing getBlog API----------");
		RestTemplate restTemplate = new RestTemplate();
		Blog blog = restTemplate.getForObject(REST_SERVICE_URI + "/blog/1", Blog.class);
		System.out.println(blog);
	}

	/* POST */
	private static void createBlog() {
		System.out.println("Testing create Blog API----------");
		RestTemplate restTemplate = new RestTemplate();

		// ClientHttpRequestFactory requestFactory = new
		// HttpComponentsClientHttpRequestFactory(HttpClients.createDefault());
		// RestTemplate restTemplate = new RestTemplate(requestFactory);

		Blog blog = new Blog(0, "dummy-content", null, 0, 1, "USER 1", new java.sql.Date(System.currentTimeMillis()),
				null, null);
		// URI uri = restTemplate.postForLocation(REST_SERVICE_URI+"/blog/",
		// blog, Blog.class);
		// System.out.println("Location : "+uri.toASCIIString());

		restTemplate.postForObject(REST_SERVICE_URI + "/blog/", blog, Blog.class);
	}

	/* PUT */
	private static void updateBlog() {
		System.out.println("Testing update Blog API----------");
		RestTemplate restTemplate = new RestTemplate();
		Blog blog = null;//
		restTemplate.put(REST_SERVICE_URI + "/blog/1", blog);
		System.out.println(blog);
	}

	/* DELETE */
	private static void deleteBlog() {
		System.out.println("Testing delete Blog API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/blog/3");
	}

	/* DELETE */
	private static void deleteAllBlogs() {
		System.out.println("Testing all delete Blogs API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/blog/");
	}

	public static void main(String args[]) {
		listAllBlogs();
		// getBlog();
		createBlog();
		// listAllBlogs();
		// updateBlog();
		// listAllBlogs();
		// deleteBlog();
		// listAllBlogs();
		// deleteAllBlogs();
		// listAllBlogs();
	}
}
