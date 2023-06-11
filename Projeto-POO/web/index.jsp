<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Matrícula</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <%@include file="/WEB-INF/jspf/header.jspf" %>
    <style>
        body {
            background-color: #f2f2f2;
        }

        .login-title {
            color: #333;
            text-align: center;
            padding: 20px;
            background-color: #fff;
        }

        .login-form {
            max-width: 300px;
            margin: 0 auto;
            background-color: #fff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        label {
            display: block;
            margin-bottom: 10px;
            font-weight: bold;
        }

        input[type="text"],
        input[type="password"] {
            width: 100%;
            padding: 10px;
            border-radius: 3px;
            border: 1px solid #ccc;
            box-sizing: border-box;
            font-size: 14px;
        }

        input[type="submit"] {
            background-color: #4CAF50;
            color: #fff;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #45a049;
        }
    </style>
</head>
<body>
    <h1 class="login-title">Sistema da Secretaria</h1>
    <div class="login-form">
        <form action="logado.jsp">
            <div class="mb-3">
                <label for="fname" class="form-label">Login:</label>
                <input type="text" class="form-control" id="fname" name="fname">
            </div>

            <div class="mb-3">
                <label for="lname" class="form-label">Senha:</label>
                <input type="password" class="form-control" id="lname" name="lname">
            </div>

            <button type="submit" class="btn btn-primary">Enviar</button>
        </form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
