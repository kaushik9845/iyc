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
    <!-- CUSTOM STYLE  -->
    <link href="resources/css/style.css" rel="stylesheet" />
     <!-- HTML5 Shiv and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->
    
    </head>
<body>

<header>
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <strong>Email: </strong>4emptycups@gmail.com
                                       
                </div>

            </div>
        </div>
    </header>
    <!-- HEADER END-->
<div class="container">
<div class="panel panel-default">
  <div class="panel-body">
    
	<div class="row clearfix">
		<div class="col-md-12 column">
		<div class="col-md-1 column"></div>
<div class="col-md-11 column">
					<img src="resources/images/logo2.jpg">
</div>
				</div>
				
			<h3 class="text-primary text-center bs-header">
				Admin Login
			</h3>
		</div>
	</div>
	
	  
	
	<div class="row clearfix">
	<div class="col-md-4 column"></div>
		<div class="col-md-4 column">
			<form class="form-horizontal" role="form" action="validate" method="post">
				<div class="form-group">
					 <label for="inputEmail3" class="col-sm-3 control-label">Username</label>
					<div class="col-sm-8">
						<input class="form-control" id="inputEmail3" name="userName"  required/>
					</div>
				</div>
				<div class="form-group">
					 <label for="inputPassword3" class="col-sm-3 control-label">Password</label>
					<div class="col-sm-8">
						<input class="form-control" id="inputPassword3" name="password" type="password" required/>
					</div>
				</div>
			
				<div class="form-group">
					<div class="col-sm-offset-5 col-sm-5">
						 <button type="submit" class="btn btn-default">Log in</button>
					</div>
				</div>
				<c:if test="${model.status== 'failure'}">
			<label style="color: red">Invalid credentials</label>
				</c:if> 
				
			</form>
			
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
		<div class="col-md-3 column">
		<div class="row">
		<div >
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
                </div>
                
		</div>
	</div>
</div>

</div>
 <!-- CONTENT-WRAPPER SECTION END-->
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-12" style="text-align: center;">
                    &copy; 2015 IYC 
                </div>

            </div>
        </div>
    </footer>
    <!-- FOOTER SECTION END-->
    <!-- JAVASCRIPT AT THE BOTTOM TO REDUCE THE LOADING TIME  -->
    <!-- CORE JQUERY SCRIPTS -->
    <script src="assets/js/jquery-1.11.1.js"></script>
    <!-- BOOTSTRAP SCRIPTS  -->
    <script src="assets/js/bootstrap.js"></script>
</body>
</html>