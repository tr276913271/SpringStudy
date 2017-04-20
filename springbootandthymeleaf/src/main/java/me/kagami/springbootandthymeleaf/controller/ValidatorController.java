package me.kagami.springbootandthymeleaf.controller;

import javax.validation.Valid;

import me.kagami.springbootandthymeleaf.bean.Book;
import me.kagami.springbootandthymeleaf.validation.BookValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ValidatorController {
	@Autowired
	private BookValidator bookValidator;
	
	//这样做只能针对这个controller中的book验证,并且使用了自定义的validator后，原始的validator注解就没用了，比如notblank ，notnull
	@InitBinder
	public void initBinder(DataBinder binder) {
		binder.setValidator(bookValidator);
	}

	@RequestMapping("/getbook")
	public String getBook(@Valid Book book, BindingResult result) {
		if (result.hasErrors()) {
			System.out.println(result.getErrorCount());
		}
		return "validator/getbook";
	}
}
