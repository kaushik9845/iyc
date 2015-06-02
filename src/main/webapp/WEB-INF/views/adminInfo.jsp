
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Info</title>


<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
<!--script src="resources/js/less-1.3.3.min.js"></script-->
<!--append '#!watch' to the browser URL, then refresh the page. -->

<link href="resources/css/bootstrap.min.css" rel="stylesheet">
<link href="resources/css/style.css" rel="stylesheet">
<link href="resources/css/simple-sidebar.css" rel="stylesheet">
<link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dataTables.css">
	<link rel="stylesheet" type="text/css"
	href="resources/css/jquery-ui-1.10.4.custom.css">
	<link rel="stylesheet" type="text/css"
	href="resources/css/jquery-ui-1.10.4.custom.min.css">

<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
<!--[if lt IE 9]>
    <script src="resources/js/html5shiv.js"></script>
  <![endif]-->

<!-- Fav and touch icons -->
<link rel="apple-touch-icon-precomposed" sizes="144x144"
	href="resources/img/apple-touch-icon-144-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="114x114"
	href="resources/img/apple-touch-icon-114-precomposed.png">
<link rel="apple-touch-icon-precomposed" sizes="72x72"
	href="resources/img/apple-touch-icon-72-precomposed.png">
<link rel="apple-touch-icon-precomposed"
	href="resources/img/apple-touch-icon-57-precomposed.png">
<link rel="shortcut icon" href="resources/img/favicon.png">


<script type="text/javascript" src="resources/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.10.4.custom.js"></script>
<script type="text/javascript" src="resources/js/jquery-ui-1.10.4.custom.min.js"></script>
<script type="text/javascript" src="resources/js/bootstrap.min.js"></script>
<script type="text/javascript" src="resources/js/scripts.js"></script>
<script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>
<script type="text/javascript" src="resources/js/jquery.dataTables.min.js"></script>


</head>



<body>

<div id="deletepopup" style="display:none; width:150px;" >
 <label class="control-label">Are You sure you want to delete</label>

<div class="control-group">
 
  <div class="controls">
    <button id="no" name="button1id" class="btn btn-primary">No</button>
    <button id="yes" name="button2id" class="btn btn-primary">Yes</button>
  </div>
</div>


</div>

<div id="popup" style="display:none; width:450px;" >


<form:form id="fileUploadForm" modelAttribute="uploadForm"
								enctype="multipart/form-data" >
		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
		
		<input id="InfoId" name="InfoId" style="display:none" type="text" >
				<div class="row" style="margin:10px;">
					<div class="col-lg-12">

						
						<div class="col-lg-3"><label>Category</label></div>
						<div class="col-lg-3">
						<select id="select" name="selectCategory"></select>
						</div>
						<div class="col-lg-3"></div>
						
							
						</div>
					</div>
				
				
				
				<div class="row" style="margin:10px;">
					<div class="col-lg-12">

						
						<div class="col-lg-3"><label>Title</label></div>
						<div class="col-lg-3"><input type="text" id="title" name="title" required></div>
						<div class="col-lg-3"></div>
						
							
						</div>
					</div>
					
					<div class="row" style="margin:10px;">
					<div class="col-lg-12">

						
						<div class="col-lg-3"><label>Image</label></div>
						<div class="col-lg-3"><input type="file" id="files" name="files" required></div>
						<div class="col-lg-3"></div>
						<div class="col-lg-3"><img id="imgSrc" width="50" height="50"></div>
							
						</div>
										
					</div>
					
					<div class="row" style="margin:10px;">
					<div class="col-lg-12">

						
						<div class="col-lg-3"><label>Description</label></div>
						<div class="col-lg-3"><textarea type="text" id="description" name="description" required></textarea></div>
						<div class="col-lg-3"></div>
						
							
						</div>
					</div>
					
					<div class="row" style="margin:10px;">
					<div class="col-lg-12">

						
						<div class="col-lg-3"><label>Last Updated</label></div>
						<div class="col-lg-3"><input id="lastupdated" disabled></input></div>
						<div class="col-lg-3"></div>
						
							
						</div>
					</div>
					
					<div class="row" style="margin:10px;">
					<div class="col-lg-12">

						
						<div class="col-lg-3"></div>
						<div class="col-lg-3">
						<button id="Upload" name="Upload" class="btn btn-primary" type="button">Submit</button>
						</div>
						<div class="col-lg-3"></div>
						
							
						</div>
					</div>
					
															
				</div>
			</div>
			
			</form:form></div>



	<form id="submitForm" action="login" ></form>

	<div class="panel panel-default">
		<div class="panel-body">

			<div class="row clearfix">
				<div class="col-md-2 column">

					<a href='Home'><img src="resources/images/logo2.png" class="headerCss" alt="Cinque Terre" id="logo" ></a>

				</div>
				<div class="col-md-8 column">
					<h3 class="text-primary text-center bs-header">Upload Info Details</h3>

				</div>
				<label class="span9">${sessionScope.userName}: <span id="logout"
					class="glyphicon glyphicon-off"></span></label>

				<script>
		 $("#logout").click(function(){
			 $("#submitForm").attr('action','login');
			 $("#submitForm").removeAttr('target');
			 $("#submitForm").submit();
		 });
		 </script>

			</div>



		</div>
	</div>

	<div id="wrapper">

		<!-- Sidebar -->
		<div id="sidebar-wrapper">
			<ul class="sidebar-nav">

				<li class="active"><a href="adminHome">Home </a></li>
				<li><a href="adminEvent">Event</a></li>
				<li><a href="adminInfo">Info</a></li>
				<li><a href="adminDirectory">Directory</a></li>
				<li ><a href="adminPanel">Category Master
						Data</a></li>
				<li><a href="subCategory">Sub Category Master Data </a></li>
				<li ><a href="service">Service Master Data</a></li>
				<li><a href="area">Area Master Data </a></li>

			</ul>
		</div>
		<!-- /#sidebar-wrapper -->

<div id="page-content-wrapper">
			
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">

						<div class="controls" style="margin:10px;">
							<button id="addbutton" name="singlebutton"
								class="btn btn-primary">Add</button>
						</div>

						<table id="InfoTable" class="display" style="height: 100%;" cellspacing="0" width="100%" height="100%">
							<thead>
								<tr>
									<th style="display:none;">ID</th>
									
									<th>Category</th>
									<th style="display:none;">Category ID</th>
									
									<th>Title</th>
									
									
									<th>Image</th>
									<th style="display:none;">Description</th>
									<th >Short Description</th>
									<th>Last Updated</th>
									<th>Action</th>
									
								</tr>
							</thead>
						</table>
			</div>
		</div>
		</div>
		<!-- /#page-content-wrapper -->
</div>

	<!-- /#wrapper -->
</div>
	
</body>

<script >

var action='';
var title='';

$.ajax({
	url:'getSubCategory',
	async:false,
	success:function(json)
	{
		$("#select").empty();
		var jsonArray=json.data;
		$.each(jsonArray,function(i,item){
			if(item.categoryId==2)
			$("#select").append('<option value='+item.id+'>'+item.subCategory+'</option>');
		});
		
				
	}
});


var table = $('#InfoTable').DataTable({
	ajax : 'getAllInfodetails',
	order:[[7,"desc"]],
	columns : [ 
	           {data:"id",
	        	    "visible": false ,
	           },
	            
	           {
	       		data : "subCategory"
	       	},
	       	{
	       		data : "subCategoryId","visible": false 
	       	},
	           
	           {
		data : "title"
	}, 
	
	{
		data:"fileName",
		"render":function(data,type,full,meta)
		{
			 return "<img class='.img-rounded' src="+data+" width='40' height='40'>";
			},
	},
	{
		data:"description","visible": false 
	},
	{
		data:"shortDescription",
	},
	{
		data:"updatedDate",
	},
	{
		defaultContent: "<button class='Edit'>Edit</button><button class='Delete'>Delete</button>",
	}
	],
	
	

});

$('#InfoTable tbody').on( 'click', '.Edit', function () {
	
	var data = table.row( $(this).parents('tr') ).data();
	action='updateInfodata';
	 
	    $("#popup").dialog({
	    	width:600,
	    	title:'Edit Data'
	    });
	    $("#files").val('');
	    $("#InfoId").val(data.id);
	    $("#select").val(data.subCategoryId);
	    $("#title").val(data.title);
	    $("#description").val(data.description);
	    $("#lastupdated").val(data.updatedDate);
	    $("#imgSrc").attr('src',data.fileName);
	    
	    
	
});

$('#addbutton').unbind("click").click(function(){
	
	
	action='addInfodata';
	 
	    $("#popup").dialog({
	    	width:600,
	    	title:'Add Data'
	    });
	    $("#files").val('');
	    $("#InfoId").val(0);
	    $("#select").val(30);
	    $("#title").val('');
	    $("#description").val('');
	    $("#imgSrc").attr('src','');
	    
	    
	    
	
});

$('#InfoTable tbody').on( 'click', '.Delete', function () {
    var data = table.row( $(this).parents('tr') ).data();
    $("#InfoId").val(data.id);
    
    $("#deletepopup").attr('title','Delete Data');
    $("#deletepopup").dialog();
    
         	
    	  $("#yes").unbind("click").click(function()
    		{
    	
    		  var formData = new FormData($("form#fileUploadForm")[0]);
    		  
    		  $("#InfoId").val(data.id);
    		  
    		  
    		  
        $.ajax(
        {
            url : 'deleteInfodata',
            type : "POST",
            data: formData,
	        async: false,
	        cache: false,
	        contentType: false,
	        processData: false,
    success : function(data)
    {
        
        alert(data.status);
        $( "#deletepopup" ).dialog( "close" );
        table.ajax.reload();
    }
    ,
    error : function()
    {
        alert('error');
        $( "#deletepopup" ).dialog( "close" );
        table.ajax.reload();
    }
    }
    );
   
    	} );

		
} );

$("#no").unbind("click").click(function()
		{
		$( "#deletepopup" ).dialog( "close" );
} );

$("#Upload").unbind("click").click(function()
		{
		
	var formData = new FormData($("form#fileUploadForm")[0]);
	
	$.ajax(
		    {
		        url: action,
		        type: 'POST',
		        data: formData,
		        async: false,
		        cache: false,
		        contentType: false,
		        processData: false,
		success: function (returndata)
		{
		    alert("success");
		    $( "#popup" ).dialog( "close" );
	        table.ajax.reload();
		}
		,
		error:function()
		{
		    alert("error");
		}
		}
		);
	
		});
		
		
		
</script>


</html>