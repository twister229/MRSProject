<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Manage post</title>
</head>
<body onload="getFood()">
	<div class="row">
		<div class="col-md-12">

			<div class="widget">
				<div class="widget-head">
					<div class="pull-left">Danh sách sản phẩm</div>
					<div class="widget-icons pull-right">
						<a href="#" class="wminimize"><i class="fa fa-chevron-up"></i></a>
						<a href="#" class="wclose"><i class="fa fa-times"></i></a>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="form-group">
					<a href="CreateProduct" class="btn btn-sm btn-success">Tạo mới Sản phẩm</a>			
				</div>
				<div class="form-group">
					<form action="SearchProduct">
						<label class="col-lg-2 control-label">Tên khách hàng:</label>
						<div class="col-lg-5">
							<input type="text" class="form-control"
								placeholder="Nhập tên khách hàng" name="txtUsername">
						</div>
						<!-- <input type="hidden" name="txtUsername" />  -->
						<input type="submit" class="btn btn-sm btn-success" value="Search" />
					</form>
				</div>
				<c:if test="${not empty listProduct }">
					<div class="widget-content">
						<div class="padd">
							<div class="page-tables">
								<!-- Table -->
								<div class="table-responsive">
									<table cellpadding="0" cellspacing="0" border="0"
										id="data-table-1" width="100%">
										<thead>
											<tr>
												<th>STT</th>
												<th>ID</th>
												<th>Tên máy</th>
												<th>Mô tả</th>
												<th>Chỉnh sửa</th>
											</tr>
										</thead>
										<tbody>
											<c:forEach items="${listProduct }" var="item"
												varStatus="counter">
												<tr id="${item.productID}" class="thisrow">
													<td>${counter.count }</td>
													<td><a href="/MRSProject/Product/${item.productID}"
														class="linkView">${item.productID}</a></td>
													<td>${item.productName}</td>
													<td>${item.description}</td>
													<td width="80px">
														<div class="btn-group1">
															<button class="btn btn-xs btn-warning"
																value="${item.productID}">
																<i class="fa fa-pencil"></i>
															</button>
														</div>
													</td>
												</tr>
											</c:forEach>
										</tbody>
									</table>
								</div>
							</div>

						</div>
					</div>
				</c:if>
			</div>
		</div>
		<div id="myModal" class="modal fade" tabindex="-1" role="dialog"
			aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title">Modal title</h4>

					</div>
					<div class="modal-body">
						<table>
							<tr>
								<td><b>ID</b></td>
								<td><input type="text" id='txtID' disabled="true"></td>
							</tr>
							<tr>
								<td><b>Tên món ăn:</b></td>
								<td><input type="text" class="imagelink foodName"
									id='txtFoodName'></td>
							</tr>
							<tr>
								<td><b>Người post:</b></td>
								<td><input type="text" id='txtUser' disabled="true"></td>
							</tr>
							<tr>
								<td><b>Chủ đề:</b></td>
								<td><select class="form-control" id="cbbCategory">

								</select></td>

							</tr>
							<tr>
								<td></td>
								<td>
									<button type="button" class="btn btn-sm btn-info"
										id="btnNewCatelogue">Thêm chủ đề mới</button>
								</td>
							</tr>
							<tr>
								<td><b>Image Link</b></td>
								<td><input type="text" class="imagelink" id='txtImage'></td>
							</tr>
							<tr>
								<td width="70px"><b>Avatar: </b></td>
								<td>
									<!-- <img id="imageFood" src="" alt="Smiley face"
								height="240" width="480"> --> <a id="imageZoom"
									class="prettyPhoto[pp_gal]"><img id="imageFood" alt=""
										height="160" width="160"></a>
								</td>
							</tr>

							<tr>
								<td width="70px"><b>Mô tả: </b></td>
								<td><textarea id="txtDescription" cols="105" rows="5"></textarea></td>
								<br />
							</tr>

							<tr>
								<td width="70px"><b>Nguyên liệu: </b></td>
								<td><textarea id="txtMaterial" cols="105" rows="5"></textarea></td>
							</tr>
							<tr>
								<td width="70px"><b>Thông tin Nguyên liệu: </b></td>
								<td><textarea id="txtInfo" class="cleditor"></textarea></td>
							</tr>
							<br />
							<tr>
								<td width="70px"><b>Nội Dung: </b></td>
								<td><textarea id="txtContent" class="cleditor"></textarea></td>
							</tr>
							<tr>
								<td><b>Lượt xem:</b></td>
								<td><input type="text" id='txtView' disabled="true"></td>
							</tr>
							<tr>
								<td><b>Nguồn:</b></td>
								<td><input type="text" id='txtSource' disabled="true"></td>
							</tr>
						</table>


					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-default" data-dismiss="modal"
							aria-hidden="true">Close</button>
						<button type="button" class="btn btn-primary" id="btnSaveChange">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>
		<div id="myModalCatelogue" class="modal fade" tabindex="-1"
			role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
			<div class="modal-dialog">
				<div class="modal-content">
					<div class="modal-header">
						<button type="button" class="close" data-dismiss="modal"
							aria-hidden="true">×</button>
						<h4 class="modal-title">Thêm chủ đề mới:</h4>

					</div>
					<div class="modal-body">
						<table>
							<tr>
								<td width="80px"><b>Chủ đề mới:</b></td>
								<td><input type="text" id='txtCatelog' width="auto"></td>
							</tr>

						</table>


					</div>
					<div class="modal-footer">

						<button type="button" class="btn btn-default" data-dismiss="modal"
							aria-hidden="true">Close</button>
						<button type="button" class="btn btn-primary" id="btnSaveCatelog">Save
							changes</button>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>