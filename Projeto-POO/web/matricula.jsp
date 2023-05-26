<%-- 
    
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Matricula</title>
        <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Cadastro de Matrícula</h1>
    <form action="processarMatricula.jsp" method="post">

        <label for="nivel">Nível do idioma:</label>
        <input type="text" id="nivelMatricula" name="nivel" required><br><br>

        <label for="presenca">Presença / Frequencia :</label>
        <input type="text" id="presencaMatricula" name="presenca" required><br><br>

        <label for="valor">Valor Mensalidade:</label>
        <input type="text" id="valorMatricula" name="valor_mensalidade" required><br><br>

        <input type="submit" value="Cadastrar">
    </form>
</body>
</html>
