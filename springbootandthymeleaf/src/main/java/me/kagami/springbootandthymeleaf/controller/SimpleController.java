package me.kagami.springbootandthymeleaf.controller;

import java.util.Date;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import me.kagami.springbootandthymeleaf.bean.User;
@Controller
// 表示在 Model中需要session化的数据
@SessionAttributes({ "message", "loginTime" })
public class SimpleController {
	
	private static final Log logger = LogFactory.getLog(SimpleController.class);
	
	@RequestMapping("/helloworld")
	public String helloworld() {
		logger.info("Helloworld");
		return "helloworld";
	}

	@RequestMapping("/requesttransmission")
	public String requestTransmission(Model model) {
		model.addAttribute("user", new User());
		return "requesttransmission";
	}
	
	//在session中设置数据
	@RequestMapping("/sessionTransmission")
	public String sessionTransmission(Model model) {
		model.addAttribute("loginTime", new Date());
		model.addAttribute("message", "没有异常");
		return "sessiontransmission";
	}
	//从session中去数据，与上面的方法配套
	@RequestMapping("/getfromsession")
	public String getFromSession() {
		return "getfromsession";
	}
}
