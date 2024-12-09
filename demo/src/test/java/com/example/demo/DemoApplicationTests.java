package com.example.demo;

import com.example.demo.models.Product;
import com.example.demo.models.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


@SpringBootTest
class DemoApplicationTests  {

	@Test
	void test() {
		Flux<Product> productFlux =  WebClient.create("http://localhost:8080")
				.get().
				uri("/product/getAllProducts").
				retrieve()
				.bodyToFlux(Product.class).doOnNext(System.out::println).delayElements(Duration.ofSeconds(1));
		productFlux.blockLast();
		Assertions.assertNotNull(productFlux);
	}
@Autowired
UserService userService;
	@Test
	void test2() {
		List<User> list1= userService.getAll();

		Set<User> set1 = new HashSet<>(list1);
		ArrayList<User> arrayList1 = new ArrayList<>(set1);


		List<User> list2= new ArrayList<>();
		list2.addAll(arrayList1);
		set1.stream().forEach(System.out::println);
		System.out.println(arrayList1);

		Assertions.assertEquals(set1.stream().toList(),list2);

	}
}
