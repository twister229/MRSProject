package com.mrs.controller;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.mrs.entity.OrderDetail;
import com.mrs.entity.OrderSymptom;
import com.mrs.entity.Product;
import com.mrs.entity.Symptom;
import com.mrs.entity.Task;
import com.mrs.entity.User;
import com.mrs.obj.OrderStatusEnum;
import com.mrs.obj.RoleEnum;
import com.mrs.obj.TaskStatusEnum;
import com.mrs.service.EquipmentService;
import com.mrs.service.OrderService;
import com.mrs.service.ProductService;
import com.mrs.service.ServiceService;
import com.mrs.service.SymptomService;
import com.mrs.service.TaskService;
import com.mrs.service.UserService;

@Controller
public class TaskController {
	
	@Autowired
	private OrderService orderService;
	@Autowired
	private ProductService productService;
	@Autowired
	private ServiceService serviceService;
	@Autowired
	private EquipmentService equipmentService;
	@Autowired
	private SymptomService symptomService;
	@Autowired
	private TaskService taskService;
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/EditOrder/{orderID}", method = RequestMethod.GET)
	public String loadDetail(HttpSession session, Model model, @PathVariable("orderID") int orderID) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				model.addAttribute("orderID", orderID);
				
				List<OrderSymptom> listSymptomOrder = orderService.loadOrderSymptom(orderID);
				List listSymptom = new ArrayList<Symptom>();
				for (OrderSymptom obj : listSymptomOrder) {
					listSymptom.add(symptomService.getSymptomByID(obj.getSymptomID()));
				}
				model.addAttribute("listSymptom", listSymptom);
				
				Product pro = productService.getProduct(orderService.getProductIDByOrderID(orderID));
				model.addAttribute("pro", pro);
				
				List listService = serviceService.getAllService();
				model.addAttribute("listService", listService);
				
				List listEquipment = equipmentService.getAllEquipment();
				model.addAttribute("listEquipment", listEquipment);
				
				model.addAttribute("pageheader", "Chi tiết Đơn hàng");
				model.addAttribute("activeTab", "ManageOrder");
				returnPage = "createDetail";
			}
		}
		return returnPage;
	}
	
	@RequestMapping(value = "/ManageTask", method = RequestMethod.GET)
	public String loadTask(HttpSession session, Model model) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				List listTask = taskService.loadTask();
				model.addAttribute("listTask", listTask);
				
				model.addAttribute("pageheader", "Quản lý Task");
				model.addAttribute("activeTab", "ManageTask");
				returnPage = "manageTask";
			}
		}
		return returnPage;
	}
	
	@RequestMapping(value = "/EditOrder/{orderID}", method = RequestMethod.POST)
	public String saveDetail(HttpSession session, Model model, @PathVariable("orderID") int orderID,
			HttpServletRequest request, @RequestParam("txtNum")int num) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				List<OrderDetail> listDetail = new ArrayList<OrderDetail>();
				for (int i = 1; i <= num; i++) {
					Integer serviceID = Integer.parseInt(request.getParameter("ddlService" + i));
					Double servicePrice = serviceService.getService(serviceID).getPrice();
					Integer equipID = Integer.parseInt(request.getParameter("ddlEquipment" + i));
					Double equipPrice = null;
					if (equipID.equals(0)) {
						equipID = null;
						equipPrice = null;
					} else {
						equipPrice = equipmentService.getEquipment(equipID).getPrice();
					}
					listDetail.add(new OrderDetail(orderID, equipID, serviceID, equipPrice, servicePrice));
				}
				
				for (int i = 0; i < listDetail.size(); i++) {
					OrderDetail detail = listDetail.get(0);
					Serializable detailID = orderService.createDetail(detail);
					
					//create Task
					Date createTime = new Date();
					String techUsername = ((User) session.getAttribute("USER")).getUsername();
					int status = TaskStatusEnum.NOTASSIGN.getValue();
					String serviceName = serviceService.getService(detail.getServiceID()).getServiceName();
					String equipName = equipmentService.getEquipment(detail.getEquipmentID()).getEquipmentName();
					
					Task task = new Task((Integer) detailID, createTime, null, null, techUsername, null, null, serviceName, equipName, status);
					taskService.createTask(task);
				}
				
				orderService.updateStatus(OrderStatusEnum.WAITING, orderID);			
				
				returnPage = "redirect:/ManageTask";
			}
		}
		return returnPage;
	}
	
	@RequestMapping(value = "/EditTask/{taskID}", method = RequestMethod.GET)
	public String editTask(HttpSession session, Model model, @PathVariable("taskID") int taskID) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				Task task = taskService.getTaskByID(taskID);
				model.addAttribute("task", task);
				
				List listStaff = userService.loadUserByRole(RoleEnum.STAFF.getValue());
				model.addAttribute("listUser", listStaff);
				
				model.addAttribute("pageheader", "Giao Task");
				model.addAttribute("activeTab", "AssignTask");
				returnPage = "createTask";
			}
		}
		return returnPage;
	}
	
	
	@RequestMapping(value = "/EditTask/{taskID}", method = RequestMethod.POST)
	public String saveTask(HttpSession session, Model model, @PathVariable("taskID") int taskID,
			@RequestParam("txtStaffUsername") String username) {
		String returnPage = "redirect:/Login";
		User user = (User) session.getAttribute("USER");
		if (user != null) {
			RoleEnum role = RoleEnum.fromInt(user.getRole());
			if (role == RoleEnum.TECHMGR) {
				Task task = taskService.getTaskByID(taskID);
				task.setCurrentStaffUsername(username);
				task.setStatus(TaskStatusEnum.OPEN.getValue());
				taskService.updateTask(task);
				returnPage = "redirect:/ManageTask";
			}
		}
		return returnPage;
	}
	
	
}
