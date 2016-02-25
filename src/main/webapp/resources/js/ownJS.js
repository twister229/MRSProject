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
			// <option value="${item}">${item }</option>
			$.each(result, function(key, item) {
				html += "<option value='" + item.modelID + "'>"
						+ item.modelName + "</option>"
			});
			$('#ddlModelName').find('option').remove().end().append(html);
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

function split(val) {
	return val.split(/,\s*/);
}
function extractLast(term) {
	return split(term).pop();
}

function getSympID(sympName) {
	for (j = 0; j < items.length; j++) {
		if (items[j] == sympName) {
			return listSymptomID[j];
		}
	}
	return -1;
}

$(document).ready(function() {
	$("#symptom").autocomplete({
		minLength : 0,
		source : function(request, response) {
			response($.ui.autocomplete.filter(items, extractLast(request.term)));
		},
		focus : function() {
			return false;
		},
		select : function(event, ui) {
			var terms = split(this.value);
			// remove the current input
			terms.pop();
			// add the selected item
			terms.push(ui.item.value);
			// add placeholder to get the comma-and-space at the end
			var tmp = [];
			for (i = 0; i < terms.length; i++) {
				tmp.push(getSympID(terms[i]));
			}
			$('#symptomID').val(tmp.join(","));
			terms.push("");
			this.value = terms.join(", ");
			return false;
		}
	});
	
	$("#staffUsername").autocomplete({
		minLength : 0,
		source : function(request, response) {
			response($.ui.autocomplete.filter(items, extractLast(request.term)));
		},
		focus : function() {
			return false;
		},
		select : function(event, ui) {
			this.value = ui.item.value
			return false;
		}
	});
});