package me.kagami.springbootandthymeleaf.config;

import me.kagami.springbootandthymeleaf.validation.BookValidator;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * 在使用了@ComponentScan后，会自动将标注了configuration的类当作配置文件加载
 * 取消某些配置文件@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
 */
@Configuration
public class OtherConfiguration {
	@Bean
	public BookValidator bookValidator() {
		return new BookValidator();
	}

}
