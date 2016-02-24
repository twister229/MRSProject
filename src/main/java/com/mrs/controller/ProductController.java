package com.mrs.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mrs.entity.Product;
import com.mrs.entity.User;
import com.mrs.obj.RoleEnum;
import com.mrs.service.ProductModelService;
import com.mrs.service.ProductService;

@Controller
public class ProductController {

	@Autowired
	private ProductService productService;
	@Autowired
	private ProductModelService modelService;

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

	@RequestMapping(value = "/CreateProduct", method = RequestMethod.GET)
	public String createProduct(HttpSession session, Model model) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				model.addAttribute("pageheader", "Tạo mới Sản phẩm");
				model.addAttribute("activeTab", "ManageProduct");

				List<String> listBrand = modelService.getListBrand();

				if (listBrand != null) {
					model.addAttribute("listBrand", listBrand);
				}

				returnPage = "createProduct";
			}
		}
		return returnPage;
	}

	@RequestMapping(value = "/CreateProduct", method = RequestMethod.POST)
	public String saveProduct(HttpSession session, Model model, @RequestParam("txtUsername") String username,
			@RequestParam("ddlModelName") int modelID,
			@RequestParam(value = "txtDescription", required = false) String description,
			@RequestParam(value = "chkOrder", required = false) String orderValue,
			@RequestParam(value = "txtModelName") String modelName) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				int type = 1;
				Product pro = new Product(modelName, username, modelID, type, description);
				
				productService.saveProduct(pro);
				
				if (orderValue != null) {
					model.addAttribute("pageheader", "Tạo mới Đơn hàng");
					model.addAttribute("activeTab", "ManageOrder");
					returnPage = "redirect:/CreateOrder/";
				} else {
					model.addAttribute("pageheader", "Quản lý sản phẩm");
					model.addAttribute("activeTab", "ManageProduct");
					returnPage = "manageProduct";
				}
			}
		}
		return returnPage;
	}

	@RequestMapping(value = "/GetModel", method = RequestMethod.GET)
	@ResponseBody
	public List getModelName(@RequestParam("brand") String brandName) {
		return modelService.getListModelName(brandName);
	}
}
