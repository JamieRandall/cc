<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>LOGIN</title>
</head>
<body>
</div>
<form action="/login" method="post">
    <div><label> User Name : <input type="text" name="username"/> </label></div>
    <div><label> Password: <input type="password" name="password"/> </label></div>
    <div><label> Remember me <input type="checkbox" name="remember-me"> </label></div>
    <div><input type="submit" value="Sign In"/></div>
</form>
<div>
    <#if error??>
        LOGIN INCORRECT
    </#if>
</div>
</body>
</html>