
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

.rowMargin {
	margin: 2%;
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
                    <h4 class="page-head-line">Add Contact</h4>

                </div>

            </div>
        
     <section class="menu-section" style="margin-bottom: 20px;">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="navbar-collapse collapse ">
                        <ul id="menu-top" class="nav navbar-nav navbar-left">
                            <li id="1" ><a  href="ImportantContacts">Important Contacts</a></li>
                            <li id="15"><a href="searchDirectory">Search Directory</a></li>
                            <li id="16"><a class="menu-top-active" href="Directory">Add Contact</a></li>
                            
                           

                        </ul>
                    </div>
                </div>

            </div>
        </div>
    </section>
				<div class="col-md-1 column"></div>
				<div class="col-md-8 column">

<form id="popup">

		<div class="row" style="margin: 10px;color:white;padding-left: 51px;border:1px solid #F0677C;">
			<!-- Text input-->
			<div class="row rowMargin" style="margin-top:10px;">
				<label class="col-lg-3" for="textinput">Name</label>
				<div class="col-lg-9">
					<input id="name" name="name" class="input-xlarge" type="text" style="color:black;">
				</div>
			</div>

<br />
			<!-- Dropdown input-->
			<div class="row rowMargin">
				<label class="col-lg-3" for="textinput">Service Provided</label>
				<div class="col-lg-9">
					<select id="service" name="service" class="input-xlarge" style="color:black;">
					
					</select>
				</div>
			</div>

<br />
			<!-- Dropdown input-->
			<div class="row rowMargin">
				<label class="col-lg-3" for="textinput">Area Located</label>
				<div class="col-lg-9">
					<select id="area" name="area" class="input-xlarge" style="color:black;">
					
					</select>
				</div>
			</div>
<br />
			<!-- Text input-->
			<div class="row rowMargin">
				<label class="col-lg-3" for="textinput">Mobile</label>
				<div class="col-lg-9">
					<input id="mobile" name="mobile" class="input-xlarge" type="number"
						maxlength="10" size="10" style="color:black;">
				</div>
			</div>
<br />		

			<!-- Text Area-->
			<div class="row rowMargin">
				<label class="col-lg-3" for="textinput">Description</label>
				<div class="col-lg-9">
					<textarea id="description" name="description" class="input-xlarge" style="color:black;"></textarea>
				</div>
			</div>

<br />			

			<!-- Button -->
			<div class="row rowMargin">
				<div class="col-lg-3"></div>
				<div class="col-lg-9" style="margin-bottom:10px;">
					<button id="singlebutton" name="singlebutton"
						class="btn btn-primary" >Submit</button>
				</div>
			</div>

		</div>

	</form>

						
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
		
		</div>
</body>

<script type="text/javascript" src="resources/js/jquery-1.10.2.js"></script>
<script src="resources/js/jquery.validate.min.js"></script>

<script>



$.ajax({
	url:'getArea',
	async:false,
	success:function(json)
	{
		$("#area").empty();
		var jsonArray=json.data;
		$("#area").append('<option value="default" disabled="disabled">Select Area</option>');
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
		$("#service").append('<option value="default" disabled="disabled">Select Service</option>');
		$.each(jsonArray,function(i,item){
			$("#service").append('<option value='+item.id+'>'+item.service+'</option>');
			
		});
		
		}
});

	
	$("#popup").validate({
    	rules:
		{
		name:"required",
		service:"required",
		area:"required",
		mobile:{
			required:true,
			number:true,
			minlength:10,
			maxlength:12
		},
		description:"required",
		
		
		}
});
	
	$("#popup").submit(function(e){
		
		if($("#popup").valid())
		{
			ajaxrequest();
		}
		e.preventDefault();
	});
	
	
	
/* function validate()
{
	
	
	
	
	var name=$("#name").val();
	var serviceId=$("#service").val();
	var areaId=$("#area").val();
	var mobile=$("#mobile").val();
	var mobileLength=mobile.length;
	var description=$("#description").val();
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
	
	
	else
		{
		 ajaxrequest();
		}
} */



	function ajaxrequest()
	{
		
		var name=$("#name").val();
		var serviceId=$("#service").val();
		var areaId=$("#area").val();
		var mobile=$("#mobile").val();
		var description=$("#description").val();
		
		
		
    	
    	var jsonObj =
        {
            'id': 0 , 'name': name,'serviceId':serviceId,areaId:areaId,
            'mobile':mobile,'description':description,'important':0
        };
        $.ajax(
        {
            url : 'addDirectory',
            type : "POST",
            data : JSON.stringify(jsonObj ),
            contentType: 'application/json',
    success : function(data)
    {
        
        alert(data.status);
        $("#name").val('');
		$("#mobile").val('');
		$("#description").val('');
		//$("#service").val('default');
		//$("#area").val('default');
		
		
		
    }
    ,
    error : function()
    {
        alert('error');
    }
    }
    );
	}
	
	
    
    
	
	
</script>
</html>