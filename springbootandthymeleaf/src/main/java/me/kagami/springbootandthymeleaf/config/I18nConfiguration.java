package me.kagami.springbootandthymeleaf.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;
//spring boot 1.3.5 在国际化这块有点问题，需要手动添加资源文件
@Configuration
public class I18nConfiguration {
	@Bean
	public ResourceBundleMessageSource messageSource() {
		ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
		//  设置“useCodeAsDefaultMessage”，默认为false，这样当Spring在ResourceBundle中找不到messageKey的话，就抛出NoSuchMessageException，   把它设置为True，则找不到不会抛出异常，而是使用messageKey作为返回值。
		messageSource.setUseCodeAsDefaultMessage(true);
		messageSource.setFallbackToSystemLocale(false);
		//用于控制资源文件的前缀,没有后缀的则认为是默认文件
		messageSource.setBasenames("messages");
		messageSource.setDefaultEncoding("UTF-8");
		messageSource.setCacheSeconds(2);
		return messageSource;

	}
}
