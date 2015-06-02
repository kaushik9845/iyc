<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

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
	margin: 1%;
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

							<li><a href="ImportantContacts">Directory</a></li>

							<li><a class="menu-top-active" href="BldReq">Blood Request</a></li>
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
                    <h4 class="page-head-line">Blood Request</h4>

                </div>

            </div>
        <br />
         <br /> 
         
    
  

    
           
            <div class="row">
                
                <div class="col-md-8">
                 
                     <div class="Compose-Message">               
                <div class="panel panel-success">
                <form id="sendMail" action="sendMail" method="POST">
                    
                    <div class="panel-body" style="height:523px;">
                      <div class="row rowMargin">
				<div class="col-md-2 column"></div>
				<div class="col-md-4 column">
					<label>Patient Name</label>
				</div>
				<div class="col-md-6 column">
					<input name="patientName" type="text">
				</div>
			</div>

			<div class="row rowMargin ">
				<div class="col-md-2 column"></div>
				<div class="col-md-4 column">
					<label>Blood Group</label>
				</div>
				<div class="col-md-6 column">
					<select name="bloodGroup">
						<option>A+</option>
						<option>A-</option>
						<option>B+</option>
						<option>B-</option>
						<option>AB+</option>
						<option>AB-</option>
						<option>O+</option>
						<option>O-</option>
					</select>
				</div>
			</div>

			<div class="row rowMargin ">
			<div class="col-md-2 column"></div>
				<div class="col-md-4 column">
					<label>Gaurdian Name</label>
				</div>
				<div class="col-md-6 column">
					<input name="gaurdianName" type="text">
				</div>
			</div>

			<div class="row rowMargin ">
			<div class="col-md-2 column"></div>
				<div class="col-md-4 column">
					<label>Gaurdian Number</label>
				</div>
				<div class="col-md-6 column">
					<input name="gaurdianNumber" type="number" onkeypress="" maxlength="12">
				</div>
			</div>

			<div class="row rowMargin ">
			<div class="col-md-2 column"></div>
				<div class="col-md-4 column">
					<label>Hospital Name</label>
				</div>
				<div class="col-md-6 column">
					<input name="hospitalName" type="text" >
				</div>
			</div>

			<div class="row rowMargin ">
			<div class="col-md-2 column"></div>
				<div class="col-md-4 column">
					<label>Hospital Number</label>
				</div>
				<div class="col-md-6 column">
					<input name="hospitalNumber" type="number" maxlength="12">
				</div>
			</div>
			
			<div class="row rowMargin ">
			<div class="col-md-2 column"></div>
				<div class="col-md-4 column">
					<label>Message</label>
				</div>
				<div class="col-md-6 column">
					<textarea name="message" ></textarea>
				</div>
			</div>

			<div class="row rowMargin ">
			<div class="col-md-2 column"></div>
				<div class="col-md-4 column"></div>
				<div class="col-md-6 column">
					<button type="submit">Submit</button>
				</div>
			</div>
			</form>
			<div class="row rowMargin ">
			<div class="col-md-2 column"></div>
				<div class="col-md-4 column"></div>
				<div class="col-md-6 column">
					<c:if test="${model.status != '' }"><label style="color:red;">${model.status}</label></c:if>
				</div>
			</div>  
                         
					   
				<div class="text-center alert alert-warning">
                        <a href="#" class="btn btn-social btn-facebook btn-xs">
                            <i class="fa fa-facebook"></i>&nbsp; Facebook</a>
                        <a href="#" class="btn btn-social btn-google btn-xs">
                            <i class="fa fa-google-plus"></i>&nbsp; Google</a>
                        <a href="#" class="btn btn-social btn-twitter btn-xs">
                            <i class="fa fa-twitter"></i>&nbsp; Twitter </a>
                        <a href="#" class="btn btn-social btn-linkedin btn-xs">
                            <i class="fa fa-linkedin"></i>&nbsp; Linkedin </a>
                    </div>
                    	   
                    </div>
                  
                </div>
                     </div>
                </div>
				
				
				<div class="col-md-3">
                      <div class="notice-board">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                          Static  ADs 
                                
                            </div>
                            <div class="panel-body">
                                 <img src="resources/images/velvety-green.jpg" style=" width: 240px;height: 170px;" > 
                                
                            </div>
                           
                        </div>
                    </div>
                   
                     
                </div>
				<div class="col-md-3">
                      <div class="notice-board">
                        <div class="panel panel-success">
                            <div class="panel-heading">
                          Static  ADs 
                                
                            </div>
                            <div class="panel-body">
                                 <img src="resources/images/images.jpg" style=" width: 240px;height: 170px;" > 
                                
                            </div>
                           
                        </div>
                    </div>
                   
                     
                </div>
				
				
				
				
            </div>
        </div>
    </div>
    <!-- CONTENT-WRAPPER SECTION END-->
    
   
    <!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY SCRIPTS -->
    <script src="resources/js/jquery-1.11.1.js"></script>
    <!-- BOOTSTRAP SCRIPTS  -->
    <script src="resources/js/bootstrap.js"></script>
    <script src="resources/js/jquery.validate.min.js"></script>
    <script>
    $("#sendMail").validate({
    	rules:
    		{
    		patientName:"required",
    		bloodGroup:"required",
    		gaurdianName:"required",
    		gaurdianNumber:{
    			required:true,
    			number:true,
    			minlength:10
    		},
    		hospitalName:"required",
    		
    		hospitalNumber:{
    			required:true,
    			number:true,
    			minlength:10
    		}
    		}
    });
    </script>
</body>
</html>
