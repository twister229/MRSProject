package com.mrs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.mrs.entity.User;
import com.mrs.obj.RoleEnum;
import com.mrs.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;

	@RequestMapping(value = "/ManageProduct")
	public String manageProduct(HttpSession session, Model model) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				model.addAttribute("pageheader", "Quản lý Sản phẩm");
				model.addAttribute("activeTab", "ManageProduct");
				returnPage = "manageProduct";
			}
		}
		return returnPage;
	}

	@RequestMapping(value = "/SearchProduct")
	public String searchProduct(HttpSession session, Model model, @RequestParam("txtUsername") String username) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				List result = productService.getProductsByUsername(username);
				if (result != null) {
					model.addAttribute("listProduct", result);
					model.addAttribute("pageheader", "Quản lý Sản phẩm");
					model.addAttribute("activeTab", "ManageProduct");
					returnPage = "manageProduct";
				}
			}
		}
		return returnPage;
	}
}
