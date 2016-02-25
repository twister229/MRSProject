<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Order Detail</title>
</head>
<body>
	<form action="/MRSProject/EditOrder/${orderID }" method="POST">
		<div class="row">
			<div class="col-md-12">
				<c:forEach items="${listSymptom }" var="item" varStatus="counter">
					<c:set var="num" scope="session" value="${counter.count }" />
					<div class="widget">
						<div class="widget-head">
							<div class="pull-left">Chi tiết Đơn hàng</div>
							<div class="widget-icons pull-right">
								<a href="#" class="wminimize"><i class="fa fa-chevron-up"></i></a>
								<a href="#" class="wclose"><i class="fa fa-times"></i></a>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="widget-content">
							<div class="padd">
								<!-- Content goes here -->
								<div class="form-horizontal" role="form">
									<div class="form-group">
										<label class="col-lg-2 control-label">Tên máy:</label>
										<div class="col-lg-5">
											<input type="text" class="form-control"
												placeholder="Nhập tên máy" name="txtProductName"
												value="${pro.productName }"> <input type="hidden"
												name="txtProductID" value="${pro.productID }" />
										</div>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">Lỗi:</label>
										<div class="col-lg-5">
											<input id="symptom" type="text" class="form-control"
												placeholder="Nhập lỗi" name="txtSymptom"
												value="${item.symptomName }">
										</div>
										<input type="hidden" name="txtSymptomID" id="symptomID" />
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">Dịch vụ:</label>
										<div class="col-lg-2">
											<select class="form-control" id="ddlService${counter.count }"
												name="ddlService${counter.count }"
												onchange="changeService()">
												<option value="0">-----Chọn dịch vụ------</option>
												<c:forEach items="${listService }" var="serItem">
													<option value="${serItem.serviceID}">${serItem.serviceName }</option>
												</c:forEach>
											</select>
										</div>
										<%-- <div class="col-lg-2">
										<div class="col-lg-5">
											<input id="symptom" type="text" class="form-control"
												name="txtServicePrice${counter.count }" placeholder="Giá"
												id="txtServicePrice${counter.count }" />
										</div>
									</div> --%>
									</div>
									<div class="form-group">
										<label class="col-lg-2 control-label">Thiết bị:</label>
										<div class="col-lg-2">
											<select class="form-control"
												id="ddlEquipment${counter.count }"
												name="ddlEquipment${counter.count }"
												onchange="changeEquip()">
												<option value="0">-----Chọn thiết bị------</option>
												<c:forEach items="${listEquipment }" var="equipItem">
													<option value="${equipItem.equipmentID}">${equipItem.equipmentName }</option>
												</c:forEach>
											</select>
										</div>
										<%-- <div class="col-lg-2">
										<div class="col-lg-5">
											<input id="symptom" type="text" class="form-control"
												name="txtEquipPrice${counter.count }" placeholder="Giá"
												id="txtEquipPrice${counter.count }" />
										</div>
									</div> --%>
									</div>
								</div>
							</div>
							<div class="widget-foot">
								<!-- Footer goes here -->
							</div>
						</div>
					</div>
				</c:forEach>
				<input type="hidden" name="txtNum" value="${num }" />
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-6">
						<input type="submit" class="btn btn-sm btn-primary" value="Lưu" />
						<input type="reset" class="btn btn-sm btn-default" value="Reset" />
					</div>
				</div>
				<div class="form-group">
					<div class="col-lg-offset-2 col-lg-6" id="createSuccess"></div>
				</div>
			</div>
		</div>
	</form>
</body>
</html>