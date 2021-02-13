package in.stackroute.usercrudapp.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import in.stackroute.usercrudapp.dao.UserDAO;
import in.stackroute.usercrudapp.model.User;

@Controller
public class UserController {

	private UserDAO userDAO;

	@Autowired
	public UserController(UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	@GetMapping("/")
	public String indexPage(Model model) {
		model.addAttribute("userList", userDAO.listAllUsers());
		return "index";
	}

	@PostMapping("/addUser")
	public String addUser(@RequestParam("name") String name, @RequestParam("email") String email,
			@RequestParam("city") String city) {

		User existingUser = userDAO.getUserByEmail(email);

		if (existingUser != null) {
			existingUser.setName(name);
			existingUser.setCity(city);
			
			userDAO.updateUser(existingUser);
		} else {

			User user = new User(name, city, email);
			userDAO.addUser(user);
		}
		return "redirect:/";
	}

	@GetMapping("/deleteUser/{email}")
	public String deleteUser(@PathVariable String email) {

		userDAO.deleteUser(email);
		return "redirect:/";
	}

	@GetMapping("/updateUser/{email}")
	public String updateUser(@PathVariable String email, ModelMap model) {
		User userItem = userDAO.getUserByEmail(email);
		model.addAttribute("userItem", userItem);
		model.addAttribute("userList", userDAO.listAllUsers());

		return "index";
	}

}
