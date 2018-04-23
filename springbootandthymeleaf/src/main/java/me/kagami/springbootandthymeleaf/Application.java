package me.kagami.springbootandthymeleaf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 根据约定，Application类要放在根目录下，这样它就会搜索这个目录下的所有注册类
 * 
 * 修改template后不用重启：在application.properties中加入spring.thymeleaf.cache=false，记得上线的时候改回来
 */
@SpringBootApplication
public class Application {
	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
}