function changeBrand() {
	var brand = $('#ddlBrandName').val();
	$.ajax({
		type : "GET",
		url : "/MRSProject/GetModel",
		async : false,
		data : {
			"brand" : brand,
		},
		dataType : "json",
		success : function(result) {
			var html = "";
			//<option value="${item}">${item }</option>
			$.each(result, function(key, item) {
				html +=  "<option value='" + item.modelID + "'>" + item.modelName + "</option>"
			});
			$('#ddlModelName')
				.find('option')
			    .remove()
			    .end()
			    .append(html);
			$("#ddlModelName").prop("selectedIndex", 0);
			
			var brand = $('#ddlBrandName option:selected').text();
			var model = $('#ddlModelName option:selected').text();
			$('#txtModelName').val(brand + " " + model);
		},
		error : function(jqXHR, textStatus, ex) {
			alert("Mất kết nối tới server!");
			console.log(textStatus + "," + ex + "," + jqXHR.responseText);
		}
	});
}

function changeModel() {
	var brand = $('#ddlBrandName option:selected').text();
	var model = $('#ddlModelName option:selected').text();
	$('#txtModelName').val(brand + " " + model);
}