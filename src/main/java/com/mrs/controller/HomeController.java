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
	public String defaultPage() {
		return "redirect:/Login";		
	}
	
	@RequestMapping(value = "/Login", method = RequestMethod.GET)
	public ModelAndView home(HttpSession session, Model model) {
		String returnPage = "login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			returnPage = getPageByRole(role, model);
			return new ModelAndView(returnPage);
		}
		return new ModelAndView("login", "user", new User());
	}

	@RequestMapping(value = "/Login", method = RequestMethod.POST)
	public String login(@ModelAttribute("user") User user, Model model, HttpSession session) {
		String returnPage = "Login";
		// get user
		User result = userService.login(user);
		// check username and password
		if (result == null) {
			model.addAttribute("error", "wronguser");
		} else if (!result.getPassword().equals(user.getPassword())) {
			model.addAttribute("error", "wrongpass");
		} else {
			session.setAttribute("USER", result);
			RoleEnum role = RoleEnum.fromInt(result.getRole());
			returnPage = getPageByRole(role, model);
		}
		return returnPage;
	}

	@RequestMapping(value = "/Admin")
	public String loadAdmin(HttpSession session, Model model) {
		String returnPage = "Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			returnPage = getPageByRole(role, model);
		}
		return "redirect:/" + returnPage;
	}

	@RequestMapping(value = "/Signout")
	public String signout(HttpSession session) {
		session.removeAttribute("USER");
		return "redirect:/";
	}

	private String getPageByRole(RoleEnum role, Model model) {
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
			return "Login";
		}
		return "dashboard";
	}
}
