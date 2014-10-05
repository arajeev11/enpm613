<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta charset="utf-8">
<title>Green Board Login</title>
<link href="css/greenboard.css" rel="stylesheet" type="text/css">
</head>

<body class="login-body">
<div id=login-page">
	<div id="login-box">
    	<div id="inner-login">
               <h2> Green Board </h2>
               <form method = "post" action="LoginServlet" id="loginform">
               <div>
               	<span class="credentials">
                	<!--  <label for="userid" class="login-cred">
                    		<span class="userid">User Id</span>
                     </label>-->
                     <input type="text" class="userid" name="userid" length="32"/>
                </span>
                <span class="credentials">
                	<!--  <label for="userid" class="login-cred">
                    		<span class="userid">Password</span>
                     </label>-->
                     <input type="password" class="password" name="password" length="32"/>
                </span>
                <input type="submit" style="position: absolute; height: 0px; width: 0px; border: none; padding: 0px;" hidefocus="true" tabindex="-1">
                <button type="submit" class="login-btn">Log in</button>
                </div>
				</form>
        </div>
    </div>
</div>
</body>
</html>