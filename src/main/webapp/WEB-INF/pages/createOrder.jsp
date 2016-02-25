<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Order</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="widget">
				<div class="widget-head">
					<div class="pull-left">Tạo mới Đơn hàng</div>
					<div class="widget-icons pull-right">
						<a href="#" class="wminimize"><i class="fa fa-chevron-up"></i></a>
						<a href="#" class="wclose"><i class="fa fa-times"></i></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="widget-content">
					<div class="padd">
						<!-- Content goes here -->
						<form action="/MRSProject/CreateOrder" class="form-horizontal" role="form"
							method="POST">
							<div class="form-group">
								<label class="col-lg-2 control-label">Khách hàng:</label>
								<div class="col-lg-5">
									<input type="text" class="form-control"
										placeholder="Nhập tên khách hàng" name="txtUsername" value="${pro.customerUsername }">
									<!-- <input type="hidden" name="txtUsername" /> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">Tên máy:</label>
								<div class="col-lg-5">
									<input type="text" class="form-control"
										placeholder="Nhập tên máy" name="txtProductName" value="${pro.productName }">
									<input type="hidden" name="txtProductID" value="${pro.productID }" />
								</div>
							</div>
							<script type="text/javascript">
								items = [];
								listSymptomID = [];
								<c:forEach items="${listSymptom}" var="symp">
							       items.push("${symp.symptomName}");
							       listSymptomID.push("${symp.symptomID}");
								</c:forEach>
							</script>
							<div class="form-group">
								<label class="col-lg-2 control-label">Lỗi:</label>
								<div class="col-lg-5">
									<input id="symptom" type="text" class="form-control"
										placeholder="Nhập lỗi" name="txtSymptom">
								</div>
								<input type="hidden" name="txtSymptomID" id="symptomID" />
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