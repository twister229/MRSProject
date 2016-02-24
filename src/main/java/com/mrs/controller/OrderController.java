package com.mrs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.mrs.entity.User;
import com.mrs.obj.OrderStatusEnum;
import com.mrs.obj.RoleEnum;
import com.mrs.service.OrderService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	@RequestMapping(value = "/ManageOrder")
	public String manageProduct(HttpSession session, Model model) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				List result = orderService.getOrdersByStatus(OrderStatusEnum.PENDING);
				model.addAttribute("listOrder", result);
				model.addAttribute("pageheader", "Quản lý Đơn hàng");
				model.addAttribute("activeTab", "ManageOrder");
				returnPage = "manageOrder";
			}
		}
		return returnPage;
	}
	
	@RequestMapping(value = "/CreateOrder", method = RequestMethod.GET)
	public String createOrder(HttpSession session, Model model) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				model.addAttribute("pageheader", "Tạo mới Đơn hàng");
				model.addAttribute("activeTab", "ManageOrder");
				returnPage = "createOrder";
			}
		}
		return returnPage;
	}
}
