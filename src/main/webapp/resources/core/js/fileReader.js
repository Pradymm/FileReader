var oTable = null;
var bTable = null;

$(document).ready(function() {

});

// Click on select file dropdown and it populates file-names.
$("#selFile").click(
		function() {
			$.ajax({
				dataType : "json",
				type : "GET",
				url : 'get_file_list',
				data : "",
				success : function(msg) {
					$('#selFile').empty();
					$('#selFile').append(
							$('<option>').text('Select').attr('value', '0'));
					for (var x = 0; x < msg.length; x++) {
						$('#selFile').append(
								$('<option>').text(msg[x])
										.attr('value', msg[x]));
					}
				},
				error : function(xhr, ajaxOptions, thrownError) {
					alert("err" + thrownError + xhr.responseText);
				}
			});
		});

// Click on show table button and it loads both the tables on screen
// it passes fileName to server side using ajax and reads from the filename
// selected on server side.
$("#ShowTable")
		.click(
				function() {

					if ($("#selFile").val() != "0" && oTable == null) {
						$('#div').empty();
						tableLoad();
					} else if ($("#selFile").val() != "0" && oTable != null) {

						oTable.fnDestroy();
						bTable.fnDestroy();
						tableLoad();
						$('#div').empty();
					} else if ($("#selFile").val() == "0") {
						$('#div').empty();
						$("#div")
								.append(
										"<div style='color:red'>Please select file name from drop down </div>");
					}
				});

// clears all ajax related cache
$.ajaxSetup({
	cache : false
});

// This function loads all Datatable on the File Reader screen
function tableLoad() {
	// Populates 1st datatable File details with count
	oTable = $('#fileReaderTable').dataTable({
		"bJQueryUI" : true,
		"sServerMethod" : "GET",
		"bServersSide" : true,
		"bFilter" : false,
		"bAutoWidth" : false,
		"bLengthChange" : false,
		"bRetrieve" : true,
		"bSort" : false,
		"bDestroy" : true,
		"bInfo" : false,
		"sAjaxSource" : "get_file_data",
		"aoColumns" : [ {
			"mDataProp" : "category"
		}, {
			"mDataProp" : "count"
		} ],
		// Passing file-name to Serverside
		"fnServerData" : function(sSource, aoData, fnCallback) {
			aoData.push({
				"name" : "fileName",
				"value" : $("#selFile").val()
			});
			$.ajax({
				dataType : 'json',
				type : "GET",
				url : "get_file_data",
				data : aoData,
				success : function(json) {
					fnCallback(json);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				}
			});
		},
	});

	// Populates seccond datatable File Contents
	bTable = $('#fileContentTable').dataTable({
		"bJQueryUI" : true,
		"sPaginationType" : "full_numbers",
		"sServerMethod" : "GET",
		"bServersSide" : true,
		"bFilter" : false,
		"bAutoWidth" : false,
		"bLengthChange" : false,
		"bRetrieve" : true,
		"bSort" : false,
		"bDestroy" : true,
		"bInfo" : false,
		"sAjaxSource" : "get_file_content",
		"aoColumns" : [ {
			"mDataProp" : "fileContent"
		} ],
		// Passing file-name to Serverside
		"fnServerData" : function(sSource, aoData, fnCallback) {
			aoData.push({
				"name" : "fileName",
				"value" : $("#selFile").val()
			});
			$.ajax({
				dataType : 'json',
				type : "GET",
				url : "get_file_content",
				data : aoData,
				success : function(json) {
					fnCallback(json);
				},
				error : function(XMLHttpRequest, textStatus, errorThrown) {
				}
			});
		},
	});

}
