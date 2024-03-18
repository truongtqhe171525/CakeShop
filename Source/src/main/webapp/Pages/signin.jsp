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
        <div class="image-holder">
            <img src="https://i.pinimg.com/564x/86/c2/cf/86c2cf91642adaa272963c0f70c4e536.jpg" alt>
        </div>
        <form action="/signin" method="post">
            <h3>Registration Form</h3>
            <div class="form-wrapper">
                <input type="text" placeholder="Name" class="form-control" name="name" value="${name}">
                <i> ${failSignin.name} </i>
            </div>
            <div class="form-wrapper">
                <input type="text" placeholder="Email" class="form-control" name="email" value="${email}">
                <i> ${failSignin.email} </i>
            </div>
            <div class="form-wrapper">
                <input type="text" placeholder="Phone Number" class="form-control" name="phone" value="${phone}">
                <i> ${failSignin.phone} </i>
            </div>
            <div class="form-wrapper">
                <input type="password" placeholder="Password" class="form-control" name="password" value="${password}">
                <i> ${failSignin.password} </i>
            </div>
            <div class="form-wrapper">
                <input type="password" placeholder="Confirm Password" class="form-control" name="comfirmPassword"
                       value="${comfirmPassword}">
                <i> ${failSignin.comfirmPassword} </i>
            </div>
            <div class="form-button">
                <p> ${failSignin.message} </p>
                <button> Login</button>
            </div>
            <p><a href="/login"> Already user? Login </a></p>
        </form>
    </div>
</div>

</body>
</html>