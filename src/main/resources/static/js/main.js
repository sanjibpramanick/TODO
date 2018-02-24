$(document).ready(function() {
	$('.table .cBtn, .table .dBtn').on('click', function(event) {
		event.preventDefault();
		var url = $(this).attr('href');
		$.get(url, function(data, status) {
			if (data) {
				location.assign("/welcome");
				location.reload(true);
			}
		});
	});// end of on

	$('.table .eBtn').on('click', function(event) {
		console.log('Edit Button Clicked')
		event.preventDefault();
		var url = $(this).attr('href');
		$.get(url, function(data, status) {
			$("#noteId").val(data.id);
			$("#noteContent").val(data.content);
		});
		$("#todoModal").modal();

	});// end of on

	$("#addNote").on('click', function() {
		$("#noteId").val('');
		$("#noteContent").val('');
		$("#todoModal").modal();
	});// end of on

	$("#sBtn").on('click', function(event) {
		var note = {
			"id" : $("#noteId").val(),
			"content" : $("#noteContent").val()
		};
		$.ajax({
			type : "POST",
			url : "/note",
			data : JSON.stringify(note),
			success : function(result) {
				location.assign("/welcome");
				location.reload(true);
			},
			dataType : "json",
			contentType : "application/json"
		});
	});// end of on
	
	$('[data-toggle="tooltip"]').tooltip(); 

});// end of ready
