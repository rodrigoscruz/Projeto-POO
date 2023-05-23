<%-- 
    
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Sistema da Secretaria</title>
        <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    
<h1>Sistema da Secretaria</h1>

    <form action="logado.jsp">
            <label for="fname">Login</label><br>
            <input type="text" id="fname" name="fname"><br>
            <label for="lname">Senha</label><br>
            <input type="text" id="lname" name="lname"><br><br>
            <input type="submit" value="Submit">
         </form>         
</body>
</html>
