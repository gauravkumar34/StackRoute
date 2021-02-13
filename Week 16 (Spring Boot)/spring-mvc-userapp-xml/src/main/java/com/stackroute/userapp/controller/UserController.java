package com.stackroute.userapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.stackroute.userapp.dao.UserDAO;
import com.stackroute.userapp.model.User;

@Controller
public class UserController {
	
	private UserDAO userDAO;
	
	
	@Autowired
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("userList",userDAO.listAllUsers());
		return "index";
	}
	
	@PostMapping("/addUser")
	public String addUser(@RequestParam("name") String name,
						@RequestParam("city") String city,
						@RequestParam("email") String email) {
		
		
		User existingUser = userDAO.getUserByEmail(email);
		
		if(existingUser!=null) {
			existingUser.setName(name);
			existingUser.setCity(city);
			userDAO.updateUser(existingUser);
		} else {
		
			User user = new User(name,city,email);
			userDAO.addUser(user);
		}

		return "redirect:/";
		
	}
	
	@GetMapping("/deleteUser/{email}")
	public String deleteUser(@PathVariable("email") String email) {
		
		userDAO.deleteUser(email);
		return "redirect:/";
		
	}
	
	@GetMapping("/updateUser/{email}")
	public String updateUser(@PathVariable("email") String email, ModelMap model) {
		
		User userItem = userDAO.getUserByEmail(email);
		model.addAttribute("userItem", userItem);
		model.addAttribute("userList",userDAO.listAllUsers());
		
		return "index";
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	@RequestMapping("/")
//	public String indexPage(ModelMap model) {
//		model.addAttribute("userList",userDAO.listAllUsers());
//		return "index";
//	}
	
//	@RequestMapping("/")
//	public ModelAndView indexPage() {
//		
//		return new ModelAndView("index","userList",userDAO.listAllUsers());
//	}
	

}
