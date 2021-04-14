<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LOGIN</title>
    <link rel="stylesheet" href="inputForm.css">
</head>
<body>
<div class="login-container">
    <form action="/login" method="post">
        <div class="row">
            <div class="login-col">
                <label for="login"> Login : </label>
            </div>
            <div class="login-col">
                <input type="text" id="login" name="login" placeholder="Login">
            </div>
        </div>
        <div class="row">
            <div class="login-col">
                <label for="password"> Password : </label>
            </div>
            <div class="login-col">
                <input type="text" id="password" name="password" placeholder="Password">
            </div>
        </div>
        <div class="row">
            <input type="submit" value="Sign In"/>
        </div>
    </form>
</div>
<div>
    <#if error??>
        LOGIN INCORRECT
    </#if>
</div>
</body>
</html>