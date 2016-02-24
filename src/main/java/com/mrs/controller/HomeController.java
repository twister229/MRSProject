package com.mrs.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.mrs.entity.User;
import com.mrs.obj.RoleEnum;
import com.mrs.service.UserService;

@Controller
public class HomeController {

	@Autowired
	UserService userService;

	@RequestMapping(value = " * ", method = RequestMethod.GET)
	public ModelAndView userPage(HttpSession session) {
		if (session.getAttribute("USER") != null) {
			return new ModelAndView("dashboard");
		}
		return new ModelAndView("login", "user", new User());
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
		// get user
		User result = userService.login(user);
		// return login page with error when username is not existed
		if (result == null) {
			model.addAttribute("error", "wronguser");
			return "login";
		}
		// check password
		if (!result.getPassword().equals(user.getPassword())) {
			model.addAttribute("error", "wrongpass");
			return "login";
		}

		session.setAttribute("USER", result);
		RoleEnum role = RoleEnum.fromInt(result.getRole());
		switch (role) {
		case TECHMGR:
			model.addAttribute("pageheader", "Technical Manager");
			model.addAttribute("activeTab", "Dashboard");
			break;
		case STAFF:
			model.addAttribute("pageheader", "STAFF");
			model.addAttribute("activeTab", "Dashboard");
			break;
		case CUSTOMER:
			model.addAttribute("pageheader", "CUSTOMER");
			model.addAttribute("activeTab", "Dashboard");
			return "dashboard_user";
		default:
			return "login";
		}
		return "dashboard";

	}

	@RequestMapping(value = "/signout")
	public String signout(HttpSession session) {
		session.removeAttribute("USER");
		return "redirect:/";
	}
}
