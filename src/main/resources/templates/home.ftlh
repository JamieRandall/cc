<!DOCTYPE HTML>
<html>
<head>
    <title>Home</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
</head>
<body>
<form action="/logout" method="post">
    <input type="submit" value="LOG OUT"/>
</form>
<div>
    <form action="/channels" method="get">
        <button type="submit">CHANNELS</button>
    </form>
    <form action="/satellites" method="get">
        <button type="submit">SATELLITES</button>
    </form>
    <#if isAdmin == true>
        <form action="/logs" method="get">
            <button type="submit">LOGS</button>
        </form>
        <form action="/users" method="get">
            <button type="submit">USERS</button>
        </form>
    </#if>
</div>
</body>
</html>