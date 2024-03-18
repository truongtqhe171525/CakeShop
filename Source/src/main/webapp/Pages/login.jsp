<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title> Cake Shop </title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="../Styles/login.css">
    <link rel="stylesheet" href="../Styles/reset.css">
<body>
<div class="wrapper">
    <div class="inner">
        <form action="/login" method="Post">
            <h3> Login </h3>

            <div class="form-wrapper">
                <input type="text" placeholder="Email or Phone Number" class="form-control" name="account"
                       value="${account}">
            </div>

            <div class="form-wrapper">
                <input type="password" placeholder="Password" class="form-control" name="password" value="${password}">
            </div>

            <div class="form-button">
                <p> ${failSignin.message} </p>
                <button> Login</button>
            </div>
            <i> </i>
            <p><a href="/signin"> Don't have account? Sign In </a></p>
        </form>
        <div class="image-holder">
            <img src="https://www.shutterstock.com/shutterstock/photos/1746471788/display_1500/stock-vector-set-of-abstract-organic-shapes-abstract-organic-blobs-vector-collection-1746471788.jpg" alt>
        </div>
    </div>
</div>

</body>
</html>