
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Panel</title>


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

<style type="text/css">
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
   padding:5px;	 	 
}
</style>

</head>



<body>


<div id="popup" style="display:none; width:150px;" >

<!-- Dropdown input-->
<div class="control-group">
  <label class="control-label" for="textinput">Category</label>
  <div class="controls">
    <select id="subCategorySelect" name="subCategorySelect"  class="input-xlarge" type="text">
    
    </select>
     </div>
</div>

<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">SubCategory</label>
  <div class="controls">
    <input id="textinput" name="textinput"  class="input-xlarge" type="text">
     </div>
</div>


<!-- Button -->
<div class="control-group">
  
  <div class="controls">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>
  </div>
</div>

</div>


<div id="addpopup" style="display:none; width:150px;" >


<!-- Select Category-->
<div class="control-group">
  <label class="control-label" for="textinput">Category</label>
  <div class="controls">
    <select id="selectCategory" name="selectCategory"  class="input-xlarge">
    </select>
     </div>
</div>


<!-- Text input-->
<div class="control-group">
  <label class="control-label" for="textinput">SubCategory</label>
  <div class="controls">
    <input id="addtextinput" name="addtextinput"  class="input-xlarge" type="text">
     </div>
</div>


<!-- Button -->
<div class="control-group">
  
  <div class="controls">
    <button id="addsinglebutton" name="addsinglebutton" class="btn btn-primary">Submit</button>
  </div>
</div>
</div>


<div id="deletepopup" style="display:none; width:150px;" >
 <label class="control-label">Are You sure you want to delete</label>

<div class="control-group">
 
  <div class="controls">
    <button id="no" name="button1id" class="btn btn-primary">No</button>
    <button id="yes" name="button2id" class="btn btn-primary">Yes</button>
  </div>
</div>


</div>

	<form id="submitForm" action="login"></form>

	<div class="panel panel-default">
		<div class="panel-body">

			<div class="row clearfix">
				<div class="col-md-2 column">

					<a href='Home'><img src="resources/images/logo2.png" class="headerCss" alt="Cinque Terre" id="logo" ></a>

				</div>
				<div class="col-md-8 column">
					<h3 class="text-primary text-center bs-header">Sub Category Master Data</h3>

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

		<!-- Page Content -->
		<div id="page-content-wrapper">
			<div class="container-fluid">
				<div class="row">
					<div class="col-lg-12">

						<div class="controls" style="margin:10px;">
							<button id="addbutton" name="singlebutton"
								class="btn btn-primary">Add</button>
						</div>

						<table id="subCategory" class="display" style="height: 100%;" cellspacing="0" width="100%" height="100%">
							<thead>
								<tr>
									<th style="display:none;">ID</th>
									<th>Serial No</th>
									<th>Category</th>
									<th style="display:none;">Category ID</th>
									<th>Sub Category</th>
									<th>Action</th>
									
								</tr>
							</thead>
						</table>
						
						<form:form id="fileUploadForm" modelAttribute="uploadForm"
								enctype="multipart/form-data" method="POST" action="uploadCategory">
							
							<div class="controls" style="margin:10px;">
							<button id="download" name="download"
								class="btn btn-primary" type="button">Get Template</button>
						</div>
							
							<!-- Text input-->
							<div class="form-group">
								<label class="col-md-4 control-label" for="textinput">File Upload
									</label>
								<div class="col-md-4">
									<input id="fileUpload" name="files" class="file" type="file"> 
								</div>
								
								<div class="controls" style="margin:10px;">
							<button id="Upload" name="Upload"
								class="btn btn-primary" type="button">Upload</button>
						</div>
								
							</div>
						</form:form>
						
							</div>
							</div>
							</div>
							</div>
							<!-- /#page-content-wrapper -->

							</div>
							<!-- /#wrapper -->

	
</body>



<script>


var table = $('#subCategory').DataTable({
		ajax : 'getSubCategory',
		columns : [ 
		           {data:"id",
		        	    "visible": false ,
		           },
		            {
			data : "serialNo"
		}, 
		{
			data:"category"
		},
		{
			data:"categoryId","visible":false,
		},
		{
			data : "subCategory"
		},
		{
			defaultContent: "<button class='Edit'>Edit</button><button class='Delete'>Delete</button>",
		}
		],
		
		

	});
	
	$('#subCategory tbody').on( 'click', '.Edit', function () {
        var data = table.row( $(this).parents('tr') ).data();
        $("#popup").attr('title','Edit Data');
        $("#popup").dialog();
        $("#textinput").val(data.subCategory);
        
        $.ajax({
        	url:'getCategory',
        	async:false,
        	success:function(json)
        	{
        		$("#subCategorySelect").empty();
        		var jsonArray=json.data;
        		$.each(jsonArray,function(i,item){
        			$("#subCategorySelect").append('<option value='+item.id+'>'+item.category+'</option>');
        		});
        		
        		$("#subCategorySelect").val(data.categoryId);
        		
        	}
        });
        
        
        	
        
        
        
        
        $("#singlebutton").unbind("click").click(function()
        		{
        	
        	var subCategory=$("#textinput").val();
        	var categoryId=$("#subCategorySelect option:selected").attr("value");
        	var jsonObj =
            {
                'id': data.id , 'subCategory': subCategory,'categoryId':categoryId
            };
            $.ajax(
            {
                url : 'editSubCategory',
                type : "POST",
                data : JSON.stringify(jsonObj ),
                contentType: 'application/json',
        success : function(data)
        {
            
            alert(data.status);
            $( "#popup" ).dialog( "close" );
            table.ajax.reload();
        }
        ,
        error : function()
        {
            alert('error');
        }
        }
        );
       
        		});
        
    } );
	
	
$('#addbutton').unbind("click").click(function() {
        
        $("#addpopup").attr('title','Add Data');
        $("#addpopup").dialog();
        
        
        $.ajax({
        	url:'getCategory',
        	async:false,
        	success:function(json)
        	{
        		$("#selectCategory").empty();
        		var jsonArray=json.data;
        		$.each(jsonArray,function(i,item){
        			$("#selectCategory").append('<option value='+item.id+'>'+item.category+'</option>');
        		});
        	}
        });
        
        
        	
        
        
        $("#addsinglebutton").unbind("click").click(function()
        		{
        	
        	var subCategory=$("#addtextinput").val();
        	var categoryId=$("#selectCategory option:selected").attr("value");
        	
        	var jsonObj =
            {
                'id':0 , 'subCategory': subCategory,'categoryId':categoryId
            };
            $.ajax(
            {
                url : 'addSubCategory',
                type : "POST",
                data : JSON.stringify(jsonObj ),
                contentType: 'application/json',
        success : function(data)
        {
            
            alert(data.status);
            $( "#addpopup" ).dialog( "close" );
            table.ajax.reload();
        }
        ,
        error : function()
        {
            alert('error');
        }
        }
        );
       
        		});
        
    } );
    
    
$('#subCategory tbody').on( 'click', '.Delete', function () {
    var data = table.row( $(this).parents('tr') ).data();
    
    $("#deletepopup").attr('title','Delete Data');
    $("#deletepopup").dialog();
    
         	
    	  $("#yes").unbind("click").click(function()
    		{
    	var jsonObj =
        {
            'id': data.id , 'subCategory': data.subCategory
        };
        $.ajax(
        {
            url : 'deleteSubCategory',
            type : "POST",
            data : JSON.stringify(jsonObj ),
            contentType: 'application/json',
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
    }
    }
    );
   
    	} );

		$("#no").unbind("click").click(function()
    		{
			$( "#deletepopup" ).dialog( "close" );
    } );
} );
	
$("#Upload").unbind("click").click(function()
		{
		
	var formData = new FormData($("form#fileUploadForm")[0]);
	
	$.ajax(
		    {
		        url: 'uploadSubCategory',
		        type: 'POST',
		        data: formData,
		        async: false,
		        cache: false,
		        contentType: false,
		        processData: false,
		success: function (returndata)
		{
		    alert("success");
		    $("#fileUpload").val('');
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

$("#download").unbind("click").click(function()
		{
$("#submitForm").attr('action','getSubCategoryTemplate');
$("#submitForm").attr('target','_blank');
$("#submitForm").submit();
		});
	
</script>
</html>