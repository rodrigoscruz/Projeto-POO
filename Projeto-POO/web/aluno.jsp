<%-- 
    
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Aluno</title>
        <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h1>Cadastro de Alunos</h1>
    <form action="http://localhost:8080/Projeto-POO/tasks" method="post">

        <label for="nomeAluno">Nome :</label>
        <input type="text" id="nomeAluno" name="nomeAluno" required><br><br>

        
        <input type="submit" value="Cadastrar">
    </form>     
</body>
</html>
