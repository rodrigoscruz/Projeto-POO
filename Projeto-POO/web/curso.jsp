<%-- 
    
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
        <link rel="stylesheet" type="text/css" href="style.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Curso</title> 
</head>
<body>
    
<h1>Cursos</h1>
<form action="http://localhost:8080/Projeto-POO/tasks" method="post">

        <label for="curso">Curso: </label>
        <input type="text" id="curso" name="curso" required><br><br>

        <label for="cargaHoraria">Carga Horária: </label>
        <input type="text" id="cargaHoraria" name="cargaHoraria" required><br><br>

        <label for="horário">Horário: </label>
        <input type="text" id="horario" name="horario" required><br><br>

        <label for="modulo">Módulo: </label>
        <input type="text" id="modulo" name="modulo" required><br><br>

        <label for="preco">Preço: </label>
        <input type="text" id="prec" name="modulo" required><br><br>

        
        <input type="submit" value="Cadastrar">
        
    </form>   
    
<!-- !!!!devemos inserir os botões para editar e inativar, todos em somente uma tela!!!!-->


</body>
</html>
