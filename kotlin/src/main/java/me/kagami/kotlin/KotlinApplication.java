package me.kagami.kotlin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import kotlinss.Person;

@SpringBootApplication
public class KotlinApplication {

	public static void main(String[] args) {
		System.out.println(new Person("1", 1));
		SpringApplication.run(KotlinApplication.class, args);
	}
}
