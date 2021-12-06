<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="css/style_register.css">
<title>RedFox | Register</title>
</head>
<body>
    <div class="login-page">
      <div class="form">
        <div class="login">
          <div class="login-header">
            <h3>Register</h3>
            <p>Please enter your credentials to create account.</p>
          </div>
        </div>
        <form class="login-form" action=adduser method=post>
          <input type="text" name=firstname placeholder="Firstname"/>
          <input type="text" name=lastname placeholder="Lastname"/>
          <input type="text" name=email placeholder="Email Address"/>
          <input type="password" name=password placeholder="Password"/>
          <input type="password" name=confirm_password placeholder="Confirm Password"/>
          <input class=button type=submit name=submit value=Register />
          <p class="message">Already registered? <a href="index.jsp">Login</a></p>
        </form>
      </div>
    </div>
</body>
</html>