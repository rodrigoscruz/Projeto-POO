<%-- 
    
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Professores</title>
        <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
    <h1>Cadastro de Professor</h1>
    <form action="processarCadastro.jsp" method="post">
       

        <label for="nome">Nome do Professor:</label>
        <input type="text" id="nomeP" name="nome_professor" required><br><br>

        <label for="cpf">CPF do Professor:</label>
        <input type="text" id="cpfP" name="cpf_professor" required><br><br>

        <label for="endereco">Endereço do Professor:</label>
        <input type="text" id="enderecoP" name="endereco_professor" required><br><br>

        <label for="email">E-mail do Professor:</label>
        <input type="email" id="emailP" name="email_professor" required><br><br>

        <label for="telefone">Telefone do Professor:</label>
        <input type="text" id="telefoneP" name="telefone_professor" required><br><br>

        <label for="horarios">Horários:</label>
        <input type="text" id="horariosP" name="horarios" required><br><br>

        <label for="modulo">Módulo do Professor:</label>
        <input type="text" id="moduloP" name="modulo_professor" required><br><br>

        <input type="submit" value="CadastrarProfessor">
    </form>
</body>
</html>

