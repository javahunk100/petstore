package com.petstore.web.controller;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@Scope("singleton")
public class LoginController {

	
	@RequestMapping(value="validateUser.do",method=RequestMethod.POST)
	//request.getParameter("username")
	/**
	 * @RequestParam - this is used to take input from html form to the controller and it
	 * is equivalent to request.getParameter("email")
	 * @param email
	 * @param password
	 * @param model -- this is used to carry data from controller to the JSP same as request attributes
	 * @return
	 */
	public String validateUser(@RequestParam("email") String email,@RequestParam("pwd") String password,Model model){
		
		if("ram@gmail.com".equalsIgnoreCase(email) && "cool".equals(password)){
			return "home";  // /home.jsp
		}else{
			model.addAttribute("message", "Sorry ,your username and passwod are not correct..................");
			return "happyNumber";  // /home.jsp
		}
	}
	
}
