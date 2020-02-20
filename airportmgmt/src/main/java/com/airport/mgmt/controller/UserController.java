package com.airport.mgmt.controller;

import java.util.Map;
import java.util.Random;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.airport.mgmt.form.User;
import com.airport.mgmt.service.UserService;


@Controller
@RequestMapping("/api/user")
public class UserController {

	private static Logger log=Logger.getLogger(UserController.class);
	private UserService userService;
	
	@Autowired(required=true)
	@Qualifier(value="userService")
	public void setUserService(UserService userService) {
		this.userService = userService;
	}

	@RequestMapping(value="/")
	public String listUser(Map<String,Object> map)
	{
		map.put("user", new User());
		map.put("userList", userService.listUser());
		log.info("Inside list user");
		return "user";
	}
	
	@RequestMapping(value="/register")
	public String userRegister(Map<String,Object> map)
	{
		map.put("user", new User());
		//map.put("userList", userService.listUser());
		log.info("Inside list user");
		return "userregister";
	}
	
	@RequestMapping(value="/add",method=RequestMethod.POST)
	public String addUser(@ModelAttribute("user")@Validated User user,BindingResult bindingResult,Model model)
	{
		log.info("Inside add user");
		if(bindingResult.hasErrors())
		{
			log.info("Validation error");
			model.addAttribute("userList", userService.listUser());
			return "userregister";
		}
		else
		{
			if(userService.getUserByName(user.getUserName()) != null) {
				model.addAttribute("errorMessage", "Username already exists !!!");
				return "redirect:/api/user/"; 
			}
			log.info("going to add user");
			if(null==user.getId())
			{
				Random rand=new Random();
				int num=rand.nextInt(900000)+1000000;
				user.setId(num);
				log.info("Before add user");
				userService.addUser(user);
			}
			else
			{
				log.info("Before update user");
				userService.updateUser(user);
			}
			return "redirect:/api/user/";
		}
	}
	
	@RequestMapping("/edit/{userId}")
	public String editUser(@PathVariable("userId")Integer userId,Map<String,Object>map)
	{
		map.put("user", userService.getUserById(userId));
		log.info("Getting details for palne ID"+userId);
		
		map.put("userList", userService.listUser());
		log.info("Retrieving user information");
		
		return "user";
	}
	
	@RequestMapping("/delete/{userId}")
	public String deleteUser(@PathVariable("userId")Integer userId, Map<String,Object>map, RedirectAttributes redirectAttrs)
	{
		log.info("Deleting user information"+userId);
		userService.deleteUser(userId);
		//return "redirect:/api/user/";
		map.put("message", "User details deleted successfully");
		redirectAttrs.addFlashAttribute("message", "User details deleted successfully");
		return "redirect:/result";
	}
}
