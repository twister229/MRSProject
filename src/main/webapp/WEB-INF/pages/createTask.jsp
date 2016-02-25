<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Assign Task</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="widget">
				<div class="widget-head">
					<div class="pull-left">Giao Task</div>
					<div class="widget-icons pull-right">
						<a href="#" class="wminimize"><i class="fa fa-chevron-up"></i></a>
						<a href="#" class="wclose"><i class="fa fa-times"></i></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="widget-content">
					<div class="padd">
						<!-- Content goes here -->
						<form action="/MRSProject/EditTask/${task.taskID }" class="form-horizontal" role="form"
							method="POST">
							<div class="form-group">
								<label class="col-lg-2 control-label">Mã đơn hàng:</label>
								<div class="col-lg-5">
									<input type="text" class="form-control"
										name="txtOrderDetail" disabled value="${task.orderDetailID }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">Dịch vụ:</label>
								<div class="col-lg-5">
									<input type="text" class="form-control"
										name="txtServiceName" disabled value="${task.serviceName }">
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">Thiết bị:</label>
								<div class="col-lg-5">
									<input type="text" class="form-control"
										name="txtEquipmentName" disabled value="${task.equipmentName }">
								</div>
							</div>
							<script type="text/javascript">
								items = [];
								<c:forEach items="${listUser}" var="user">
							       items.push("${user.username}");
								</c:forEach>
							</script>
							<div class="form-group">
								<label class="col-lg-2 control-label">Nhân viên:</label>
								<div class="col-lg-5">
									<input type="text" class="form-control" id="staffUsername"
										name="txtStaffUsername" value="${task.currentStaffUsername }">
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-6">
									<input type="submit" class="btn btn-sm btn-primary" value="Lưu" />
									<input type="reset" class="btn btn-sm btn-default"
										value="Reset" />
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-6" id="createSuccess">
								</div>
							</div>
						</form>
					</div>
					<div class="widget-foot">
						<!-- Footer goes here -->
					</div>
				</div>
			</div>

		</div>
	</div>
</body>
</html>