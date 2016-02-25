$(document).ready(function() {
	$('.linkView').click(function() {
		window.open($(this).attr('href'));
		return false;
	});

	$(window).load(function() {
		// Animate loader off screen
		$(".se-pre-con").fadeOut("slow");
		;
	});
	$('.imagelink').focusout(function() {
		$('#imageFood').attr("src", $('#txtImage').val());
		$('#imageFood').attr("src", $('#txtImageLink').val());
		$("#imageZoom").attr("href", $('#txtImageLink').val());
		$("#imageZoom").attr("href", $('#txtImage').val());
	});
	$('.imagelink').keyup(function(e) {
		if (e.keyCode == 13) {
			$('#imageFood').attr("src", $('#txtImage').val());
			$('#imageFood').attr("src", $('#txtImageLink').val());
			$("#imageZoom").attr("href", $('#txtImage').val());
			$('#imageZoom').attr("href", $('#txtImageLink').val());
		}
	});
	$('.imagelink').focus(function() {
		$(this).select();
	});

	$('select').on('change', function(e) {
		var optionSelected = $("option:selected", this);
		var valueSelected = this.value;
		var oTable = $('#data-table-1').DataTable();
		if (valueSelected == 0) {
			oTable.search('Đã duyệt').draw();
		}
		if (valueSelected == 1) {
			oTable.search('Đang xử lý').draw();
			oTable.search('', true);
		}

	});
});