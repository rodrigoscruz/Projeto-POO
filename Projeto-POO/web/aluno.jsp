<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Aluno</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <%@include file="/WEB-INF/jspf/header.jspf" %>
    <style>
        body {
            background-color: #f2f2f2;
        }

        .card {
            max-width: 400px;
            margin: 0 auto;
            margin-top: 50px;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        h1 {
            color: #333;
            text-align: center;
            padding: 20px;
            background-color: #fff;
        }

        label {
            font-weight: bold;
        }
    </style>
</head>
<body>
    <h1>Cadastro de Aluno</h1>
    <div class="card">
        <form action="/action_page.php">
            <div class="mb-3">
                <label for="nomeAluno" class="form-label">Nome:</label>
                <input type="text" class="form-control" id="nomeAluno" name="nomeAluno" placeholder="Nome do Aluno" required>
            </div>

            <div class="mb-3">
                <label for="dtNascimento" class="form-label">Nascimento:</label>
                <input type="date" class="form-control" id="dtNascimento" name="dtNascimento" placeholder="Data de Nascimento" required>
            </div>

            <div class="mb-3">
                <label for="cpfAluno" class="form-label">CPF:</label>
                <input type="number" class="form-control" id="cpfAluno" name="cpfAluno" placeholder="CPF do Aluno" required>
            </div>

            <div class="mb-3">
                <label for="nomeResponsavel" class="form-label">Responsável:</label>
                <input type="text" class="form-control" id="nomeResponsavel" name="nomeResponsavel" placeholder="Nome do Responsável" required>
            </div>

            <div class="mb-3">
                <label for="endereco" class="form-label">Endereço:</label>
                <input type="text" class="form-control" id="endereco" name="endereco" placeholder="Endereço do Aluno" required>
            </div>

            <div class="mb-3">
                <label for="telefone" class="form-label">Telefone:</label>
                <input type="tel" class="form-control" id="telefone" name="telefone" placeholder="Telefone do Responsável" required>
            </div>

            <div class="mb-3">
                <label for="email" class="form-label">Email:</label>
                <input type="email" class="form-control" id="email" name="email" placeholder="Email do Responsável" required>
            </div>

            <button type="submit" class="btn btn-primary">Cadastrar</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
