<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Create Product</title>
</head>
<body>
	<div class="row">
		<div class="col-md-12">
			<div class="widget">
				<div class="widget-head">
					<div class="pull-left">Create Product</div>
					<div class="widget-icons pull-right">
						<a href="#" class="wminimize"><i class="fa fa-chevron-up"></i></a>
						<a href="#" class="wclose"><i class="fa fa-times"></i></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="widget-content">
					<div class="padd">
						<!-- Content goes here -->
						<form action="/MRSProject/CreateProduct" class="form-horizontal" role="form"
							method="POST">
							<div class="form-group">
								<label class="col-lg-2 control-label">Khách hàng:</label>
								<div class="col-lg-5">
									<input type="text" class="form-control"
										placeholder="Nhập tên khách hàng" name="txtUsername">
									<!-- <input type="hidden" name="txtUsername" /> -->
								</div>
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">Tên máy:</label>
								<div class="col-lg-2">
									<select class="form-control" id="ddlBrandName"
										onchange="changeBrand()">
										<option value="">-----Chọn model------</option>
										<c:forEach items="${listBrand }" var="item">
											<option value="${item}">${item }</option>
										</c:forEach>
									</select>
								</div>
								<div class="col-lg-2">
									<select class="form-control" name="ddlModelName"
										id="ddlModelName" onchange="changeModel()">
									</select>
								</div>
								<input type="hidden" name="txtModelName" id="txtModelName"
									value="">
							</div>
							<div class="form-group">
								<label class="col-lg-2 control-label">Mô tả:</label>
								<div class="col-lg-6">
									<textarea name="txtDescription" cols="100" rows="8"
										style="resize: none"></textarea>
								</div>
							</div>
							<div class="form-group">
								<div class="col-lg-offset-2 col-lg-6">
									<input type="checkbox" name="chkOrder" value="CHECK" /> <label
										class="control-label">Tạo Đơn hàng</label>
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