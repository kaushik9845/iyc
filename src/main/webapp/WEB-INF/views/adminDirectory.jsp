
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Admin Directory</title>


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
<script type="text/javascript" src="resources/js/jquery.validate.js"></script>
<script type="text/javascript" src="resources/js/jquery.validate.min.js"></script>

<style type="text/css">
#footer {
    background-color:black;
    color:white;
    clear:both;
    text-align:center;
   padding:5px;	 	 
}

.rowMargin
{
margin:2%;
}
</style>

</head>



<body>


<div id="popup" style="display:none;" >

<div class="row" style="margin:10px;">
<!-- Text input-->
<div class="row rowMargin">
  <label class="col-lg-3" for="textinput">Name</label>
  <div class="col-lg-9">
    <input id="name" name="name"  class="input-xlarge" type="text">
     </div>
</div>


<!-- Dropdown input-->
<div class="row rowMargin">
  <label class="col-lg-3" for="textinput">Service Provided</label>
  <div class="col-lg-9">
    <select id="service" name="service"  class="input-xlarge" >
    
    </select>
     </div>
</div>


<!-- Dropdown input-->
<div class="row rowMargin">
  <label class="col-lg-3" for="textinput">Area Located</label>
  <div class="col-lg-9">
    <select id="area" name="area"  class="input-xlarge" >
    
    </select>
     </div>
</div>

<!-- Text input-->
<div class="row rowMargin">
  <label class="col-lg-3" for="textinput">Mobile</label>
  <div class="col-lg-9">
    <input id="mobile" name="mobile"  class="input-xlarge" type="number"  maxlength="10" size="10">
     </div>
</div>

<!-- Text Area-->
<div class="row rowMargin">
  <label class="col-lg-3" for="textinput">Description</label>
  <div class="col-lg-9">
    <textarea id="description" name="description"  class="input-xlarge" ></textarea>
     </div>
</div>

<!-- Dropdown input-->
<div class="row rowMargin">
  <label class="col-lg-3" for="textinput">Important Contact?</label>
  <div class="col-lg-9">
    <select id="important" name="important"  class="input-xlarge" >
    <option id="0" value="0">Not Important</option>
    <option id="1" value="1">Important</option>
    </select>
     </div>
</div>

<!-- Button -->
<div class="row rowMargin">
  <div class="col-lg-3"></div>
  <div class="col-lg-9">
    <button id="singlebutton" name="singlebutton" class="btn btn-primary">Submit</button>
  </div>
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
					<h3 class="text-primary text-center bs-header">Admin Directory Data</h3>

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

				<li ><a href="adminHome">Home </a></li>
				<li><a href="adminEvent">Event</a></li>
				<li><a href="adminInfo">Info</a></li>
				<li class="active"><a href="adminDirectory">Directory</a></li>
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

						<table id="directory" class="display" style="height: 100%;" cellspacing="0" width="100%" height="100%">
							<thead>
								<tr>
									<th style="display:none;">ID</th>
									<th>Serial No</th>
									<th>Name</th>
									<th style="display:none;">Service ID</th>
									<th>Service</th>
									<th style="display:none;">Area ID</th>
									<th>Area</th>
									<th>Mobile</th>
									<th style="display:none;">Description</th>
									<th>Short Description</th>
									<th>Important</th>
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

var action='';
var dataId=0;
var table = $('#directory').DataTable({
		ajax : 'getDirectory',
		columns : [ 
		           {data:"id",
		        	    "visible": false ,
		           },
		            {
			data : "serialNo"
		}, 
		{
			data:"name"
		},
		{
			data:"serviceId","visible":false,
		},
		{
			data : "serviceName"
		},
		
		{
			data:"areaId","visible":false,
		},
		{
			data : "areaName"
		},
		{
			data : "mobile"
		},
		{
			data : "description","visible":false,
		},
		{
			data : "shortDescription"
		},
		{
			data : "important",
			"render" : function(data, type, full,
					meta) {
				if (data==1) 
				return "<td>Important</td>";
				else
					return "<td>Not Important</td>";
			},
		},
		{
			defaultContent: "<button class='Edit'>Edit</button><button class='Delete'>Delete</button>",
		}
		],
		
		

	});
	
	
$.ajax({
	url:'getArea',
	async:false,
	success:function(json)
	{
		$("#area").empty();
		var jsonArray=json.data;
		$.each(jsonArray,function(i,item){
			$("#area").append('<option value='+item.id+'>'+item.area+'</option>');
		});
		
		}
});

$.ajax({
	url:'getService',
	async:false,
	success:function(json)
	{
		$("#service").empty();
		var jsonArray=json.data;
		$.each(jsonArray,function(i,item){
			$("#service").append('<option value='+item.id+'>'+item.service+'</option>');
		});
		
		}
});
	
	
function validate()
{
	var name=$("#name").val();
	var serviceId=$("#service").val();
	var areaId=$("#area").val();
	var mobile=$("#mobile").val();
	var mobileLength=mobile.length;
	var description=$("#description").val();
	var important=$("#important").val();
	
	if(name=='')
		{
		alert('Please fill Name');
		return false;
		}	
	
	else if(serviceId== undefined)
		{
		alert('Please Select  Service Type');
		return false;
		}
	
	else if(areaId== undefined)
	{
	alert('Please Select  Area');
	return false;
	}
	
	else if(mobile== ''||mobileLength!=10)
	{
	alert(' Mobile Number  should be 10 digits');
	return false;
	}
	
	else if(description== '')
	{
	alert('Please fill  Description');
	return false;
	}
	
	else if(important== undefined)
	{
	alert('Please Select  whether important number or not');
	return false;
	}
	else
		{
		return true;
		}
}
	function ajaxRequest(url,dataId)
	{
		
		var name=$("#name").val();
		var serviceId=$("#service").val();
		var areaId=$("#area").val();
		var mobile=$("#mobile").val();
		var description=$("#description").val();
		var important=$("#important").val();
    	
		if(name=='')
			{
			alert('Please fill Name');
			return;
			}
    	
    	var jsonObj =
        {
            'id': dataId , 'name': name,'serviceId':serviceId,areaId:areaId,
            'mobile':mobile,'description':description,'important':important
        };
        $.ajax(
        {
            url : action,
            type : "POST",
            data : JSON.stringify(jsonObj ),
            contentType: 'application/json',
    success : function(data)
    {
        
        alert(data.status);
        table.ajax.reload();
    }
    ,
    error : function()
    {
        alert('error');
    }
    }
    );
	}
	
	$('#directory tbody').on( 'click', '.Edit', function () {
        var data = table.row( $(this).parents('tr') ).data();
        action='editDirectory';
        dataId=data.id;
        $("#popup").attr('title','Edit Data');
        $("#popup").dialog({
        	width:750,
        	title:'Edit Data'
        });
        
        $("#name").val(data.name);
        $("#service").val(data.serviceId);
        $("#area").val(data.areaId);
        $("#mobile").val(data.mobile);
        $("#description").val(data.description);
        $("#important").val(data.important);
        

    } );
	
	
	$("#singlebutton").unbind("click").click(function()
    		{
    	if(validate())
		{
    		ajaxRequest(action,dataId);
    		$( "#popup" ).dialog( "close" );
            table.ajax.reload();
		}
		
   
    		});
	
	
$('#addbutton').unbind("click").click(function() {
        
	$("#name").val('');
    $("#service").val('');
    $("#area").val('');
    $("#mobile").val('');
    $("#description").val('');
    $("#important").val('');
    
        $("#popup").attr('title','Add Data');
        $("#popup").dialog({
        	width:750,
        	title:'Add Data'
        });
        dataId=0;
        action='addDirectory';
       
    } );
    
    
$('#directory tbody').on( 'click', '.Delete', function () {
    var data = table.row( $(this).parents('tr') ).data();
    action='deleteDirectory';
    
    $("#deletepopup").attr('title','Delete Data');
    $("#deletepopup").dialog();
    
         	
    	  $("#yes").unbind("click").click(function()
    		{
    		  dataId=data.id;
    		  	$("#name").val(data.name);
    	        $("#service").val(data.serviceId);
    	        $("#area").val(data.areaId);
    	        $("#mobile").val(data.mobile);
    	        $("#description").val(data.description);
    	        $("#important").val(data.important);
    		  ajaxRequest(action,dataId);
    		  $( "#deletepopup" ).dialog( "close" );
    		 
    		  
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
		        url: 'uploadDirectory',
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
$("#submitForm").attr('action','getDirectoryTemplate');
$("#submitForm").attr('target','_blank');
$("#submitForm").submit();
		});
	
</script>
</html>