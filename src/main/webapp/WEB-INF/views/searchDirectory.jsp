<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
    <meta charset="utf-8" />
    <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1" />
    <meta name="description" content="" />
    <meta name="author" content="" />
    <!--[if IE]>
        <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
        <![endif]-->
    <title>In Your City</title>
    <!-- BOOTSTRAP CORE STYLE  -->
    <link href="resources/css/bootstrap.css" rel="stylesheet" />
    <!-- FONT AWESOME ICONS  -->
    <link href="resources/css/font-awesome.css" rel="stylesheet" />
    <link href="resources/css/HeaderImage.css" rel="stylesheet" />
    <!-- CUSTOM STYLE  -->
    <link href="resources/css/style.css" rel="stylesheet" />
    
    <link rel="stylesheet" type="text/css"
	href="resources/css/jquery.dataTables.css">
	
     <!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
	
	
<!-- <style>
.listL{
	
    padding: 1.5px 15px;
 }
 .page-head-line {
  font-weight: 900;
  padding-bottom: 0px;
  border-bottom: 2px solid #F0677C;
  text-transform: uppercase;
  color: #F0677C;
  font-size: 20px;
  margin-bottom: 0px !important;
}
</style> -->
</head>
<body>
     <header style="  background-color: #fbfbfb;">
        <div class="container">
            <div class="row">
			
                <div class="col-md-12">
				<a href='Home'><img src="resources/images/logo2.png" class="headerCss" alt="Cinque Terre" id="logo" ></a>
                    <strong><a href="login" style="cursor: pointer;color:#F0677C;">Admin Login</a></strong>
                    
                </div>

            </div>
        </div>
    </header>
    <!-- HEADER END-->
    
    <!-- LOGO HEADER END-->
    <section class="menu-section">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="navbar-collapse collapse ">
                        <ul id="menu-top" class="nav navbar-nav navbar-right">
							<li ><a   href="Home">Home</a></li>
							<li><a href="Event" >Events</a></li>

							<li><a href="Info">Info</a></li>

							<li><a class="menu-top-active" href="ImportantContacts">Directory</a></li>

							<li><a href="BldReq">Blood Request</a></li>
							<li><a href="AboutUs">About Us</a></li>
							<li><a href="ContactUs">Contact Us</a></li>
						</ul>
                    </div>
                </div>

            </div>
        </div>
    </section>
    <!-- MENU SECTION END-->
     <div class="content-wrapper" style="  padding-bottom: 0px;  margin-top: 0px;">
        <div class="container" style="z-index: 1000;">
        	
        	 <div class="row selectionDivRow">
                <div class="col-md-12">
                
                <div class="containerImg">
				<img src="resources/images/city.jpg" class="" alt="img5">
				<img src="resources/images/velvety-green.jpg" alt="img4">
				<img src="resources/images/Natural-mountain-wallpapers.jpg" alt="img3">
				<img src="resources/images/images.jpg" alt="img2">
				<img src="resources/images/city.jpg" alt="img1">
				</div>
				                
                
                </div>
                </div>
                
                
            <div class="row selectionDivRow">
                <div class="col-md-12">
                    <h4 class="page-head-line">Search Directory</h4>

                </div>

            </div>
        
     <section class="menu-section" style="margin-bottom: 20px;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="navbar-collapse collapse ">
                        <ul id="menu-top" class="nav navbar-nav navbar-left">
                            <li id="1" ><a  href="ImportantContacts">Important Contacts</a></li>
                            <li id="15"><a class="menu-top-active" href="searchDirectory">Search Directory</a></li>
                            <li id="16"><a href="Directory">Add Contact</a></li>
                            
                           

                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </section>
				<div class="col-md-1 column"></div>
				<div class="col-md-8 column">
					
					<div  class="row" style="padding-bottom:20px;background-color: white;margin-left: -74px; margin-right: 1px;">
						
							<div class="col-md-5 column" style="padding-top:6px;">
							<label>Services</label>
							<select id="services"></select>
							</div>	
							<div class="col-md-5 column" style="padding-top:6px;">
							<label>Area</label>
							<select id="areas"></select>
							</div>
							
							<div class="col-md-1 column">
							<button id="searchButton" name="searchButton"
								class="btn btn-primary">Search</button>
								</div>
							</div> 
					
					<div style="border: 1px solid grey; margin-left: -75px;background-color: white;">

					<table id="directory" class="display" style="height: 100%;"
						cellspacing="0" width="100%">
						<thead>
							<tr>
								<th style="display: none;">ID</th>
								<th>Serial No</th>
								<th>Name</th>
								<th style="display: none;">Service ID</th>
								<th>Service</th>
								<th style="display: none;">Area ID</th>
								<th>Area</th>
								<th>Mobile</th>
								<th>Description</th>
								<th style="display: none;">Short Description</th>
								


							</tr>
						</thead>
					</table>

						
					</div>

					


				</div>
				
				<div class="col-md-3">
				<div >
                      <div class="notice-board">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                          Static  ADs 
                                
                            </div>
                            <div class="panel-body">
                                 <img src="resources/images/velvety-green.jpg" style=" width: 225px;height: 170px;" > 
                                
                            </div>
                           
                        </div>
                    </div>
                   
                     
                </div>
				<div >
                      <div class="notice-board">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                          Static  ADs 
                                
                            </div>
                            <div class="panel-body">
                                 <img src="resources/images/images.jpg" style=" width: 225px;height: 170px;" > 
                                
                            </div>
                           
                        </div>
                    </div>
			 </div>
		</div>
		
		</div>
</body>

<script type="text/javascript" src="resources/js/jquery-1.10.2.js"></script>
<script type="text/javascript" src="resources/js/jquery.dataTables.js"></script>
<script type="text/javascript"
	src="resources/js/jquery.dataTables.min.js"></script>

<script>

var action='';
var dataId=0;

$.ajax({
	url:'getArea',
	async:false,
	success:function(json)
	{
		$("#areas").empty();
		var jsonArray=json.data;
		$("#areas").append('<option value=0>All</option>');
		$.each(jsonArray,function(i,item){
			
			$("#areas").append('<option value='+item.id+'>'+item.area+'</option>');
		});
		
		}
});

$.ajax({
	url:'getService',
	async:false,
	success:function(json)
	{
		$("#services").empty();
		var jsonArray=json.data;
		$("#services").append('<option value=0>All</option>');
		$.each(jsonArray,function(i,item){
			$("#service").append('<option value='+item.id+'>'+item.service+'</option>');
			$("#services").append('<option value='+item.id+'>'+item.service+'</option>');
		});
		
		}
});

var important=0;
var serviceId=$("#services").val();
var areaId=$("#areas").val();

var url='getDirectorySearch?important='+important+'&serviceId='+serviceId+'&areaId='+areaId;
var table='';



table = $('#directory').DataTable({
		ajax :url,
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
			data : "description",
		},
		{
			data : "shortDescription","visible":false,
		}
		
		],
		
		

	});
	
	

$("#searchButton").unbind("click").click(function()
		{
		 
		
		 serviceId=$("#services").val();
		 areaId=$("#areas").val();

		 url='getDirectorySearch?important='+0+'&serviceId='+serviceId+'&areaId='+areaId;
		
		 table.ajax.url(url).load();
		 
	
	

		});
	

	
</script>
</html>