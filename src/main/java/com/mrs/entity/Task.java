package com.mrs.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "task")
public class Task implements Serializable {

	private static final long serialVersionUID = -7988799579036225137L;

	private int taskID;
	private int orderDetailID;
	private Date createTime;
	private Date deadline;
	private Date finishTime;
	private String technicalUsername;
	private String oldStaffUsername;
	private String currentStaffUsername;
	private String serviceName;
	private String equipmentName;
	private int status;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "TaskID")
	public int getTaskID() {
		return taskID;
	}
	
	public void setTaskID(int taskID) {
		this.taskID = taskID;
	}

	@Column(name = "OrderDetailID")
	public int getOrderDetailID() {
		return orderDetailID;
	}

	public void setOrderDetailID(int orderDetailID) {
		this.orderDetailID = orderDetailID;
	}

	@Column(name = "CreateTime")
	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	@Column(name = "Deadline")
	public Date getDeadline() {
		return deadline;
	}

	public void setDeadline(Date deadline) {
		this.deadline = deadline;
	}

	@Column(name = "FinishTime")
	public Date getFinishTime() {
		return finishTime;
	}

	public void setFinishTime(Date finishTime) {
		this.finishTime = finishTime;
	}

	@Column(name = "TechnicalUsername")
	public String getTechnicalUsername() {
		return technicalUsername;
	}

	public void setTechnicalUsername(String technicalUsername) {
		this.technicalUsername = technicalUsername;
	}

	@Column(name = "OldStaffUsername")
	public String getOldStaffUsername() {
		return oldStaffUsername;
	}

	public void setOldStaffUsername(String oldStaffUsername) {
		this.oldStaffUsername = oldStaffUsername;
	}

	@Column(name = "CurrentStaffUsername")
	public String getCurrentStaffUsername() {
		return currentStaffUsername;
	}

	public void setCurrentStaffUsername(String currentStaffUsername) {
		this.currentStaffUsername = currentStaffUsername;
	}

	@Column(name = "ServiceName")
	public String getServiceName() {
		return serviceName;
	}

	public void setServiceName(String serviceName) {
		this.serviceName = serviceName;
	}

	@Column(name = "EquipmentName")
	public String getEquipmentName() {
		return equipmentName;
	}

	public void setEquipmentName(String equipmentName) {
		this.equipmentName = equipmentName;
	}

	@Column(name = "Status")
	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}
}
