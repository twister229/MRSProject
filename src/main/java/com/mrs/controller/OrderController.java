package com.mrs.controller;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mrs.entity.Order;
import com.mrs.entity.OrderSymptom;
import com.mrs.entity.Product;
import com.mrs.entity.Symptom;
import com.mrs.entity.User;
import com.mrs.obj.OrderStatusEnum;
import com.mrs.obj.RoleEnum;
import com.mrs.service.OrderService;
import com.mrs.service.ProductService;
import com.mrs.service.SymptomService;

@Controller
public class OrderController {

	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@Autowired
	private SymptomService symptomService;

	@RequestMapping(value = "/ManageOrder")
	public String manageProduct(HttpSession session, Model model) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				List result = orderService.loadOrder();
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
				List<Symptom> listSymptom = symptomService.getListSymptomName();
				model.addAttribute("listSymptom", listSymptom);

				model.addAttribute("pageheader", "Tạo mới Đơn hàng");
				model.addAttribute("activeTab", "ManageOrder");
				returnPage = "createOrder";
			}
		}
		return returnPage;
	}

	@RequestMapping(value = "/CreateOrder/{proID}", method = RequestMethod.GET)
	public String createOrderWithProduct(HttpSession session, Model model, @PathVariable("proID") int proID) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {

				Product pro = productService.getProduct(proID);
				model.addAttribute("pro", pro);

				List<Symptom> listSymptom = symptomService.getListSymptomName();
				model.addAttribute("listSymptom", listSymptom);

				model.addAttribute("pageheader", "Tạo mới Đơn hàng");
				model.addAttribute("activeTab", "ManageOrder");
				returnPage = "createOrder";
			}
		}
		return returnPage;
	}

	@RequestMapping(value = "/CreateOrder", method = RequestMethod.POST)
	public String createOrder(HttpSession session, Model model, @RequestParam("txtProductID") int proID,
			@RequestParam("txtProductName") String proName, @RequestParam("txtUsername") String username,
			@RequestParam("txtSymptomID") String sympIDList) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				Date createTime = new Date();
				String[] listID = sympIDList.split(",");
				String listName = "";
				for (int i = 0; i < listID.length; i++) {
					String name = symptomService.getSymptomNameByID(Integer.parseInt(listID[i]));
					if (i > 0) {
						listName += ";";
					}
					listName += name;
				}

				Order order = new Order(createTime, proID, listName, proName, null, 0, username);
				Serializable orderID = orderService.createOrder(order);

				for (int i = 0; i < listID.length; i++) {
					OrderSymptom orderSymp = new OrderSymptom(Integer.parseInt(orderID.toString()), 
																Integer.parseInt(listID[i]));
					orderService.createOrderSymptom(orderSymp);
				}
				System.out.println("Create Order Successfully: " + orderID);
				returnPage = "redirect:/ManageOrder";
			}
		}
		return returnPage;
	}
}
