package web.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import web.model.User;
import web.service.UserService;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/")
public class UserController {

	@Autowired
	private UserService userService;



	@RequestMapping(value = "/hello", method = RequestMethod.GET)
	public String printWelcome(){
		return "redirect:/admin";
	}


	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String userList(Model model){
		List<User> allUsers = userService.getAllUsers();
		model.addAttribute("allUsers", allUsers);
		return "admin";
	}
	@DeleteMapping("/delete/{id}")
	public String delete(@PathVariable("id") Long id) {
		userService.deleteUser(id);
		return "redirect:/admin";
	}


	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user(ModelMap model){
		List<String> messages = new ArrayList<>();
		messages.add("Hello! User");
		messages.add("I'm Spring MVC-SECURITY application");
		messages.add("This is Root Page");
		model.addAttribute("messages", messages);
		return "user";
	}

    @RequestMapping(value = "login", method = RequestMethod.GET)
    public String loginPage() {
        return "login";
    }



}