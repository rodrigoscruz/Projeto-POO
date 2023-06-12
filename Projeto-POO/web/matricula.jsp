<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Matrícula</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css">
</head>
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

<body>
    <%@include file="/WEB-INF/jspf/header.jspf" %>
<h1>Cadastro de Matricula</h1>
    <div class="container">
        <div class="row justify-content-center mt-4">
            <div class="col-md-6">
                <div class="card">
                    
                    <div class="card-body">
                        <form action="processarMatricula.jsp" method="post">
                            <div class="mb-3">
                                <label for="nivelMatricula" class="form-label">Nível do idioma:</label>
                                <input type="text" class="form-control" id="nivelMatricula" name="nivel" required>
                            </div>

                            <div class="mb-3">
                                <label for="presencaMatricula" class="form-label">Presença / Frequência:</label>
                                <input type="text" class="form-control" id="presencaMatricula" name="presenca" required>
                            </div>

                            <div class="mb-3">
                                <label for="valorMatricula" class="form-label">Valor Mensalidade:</label>
                                <input type="text" class="form-control" id="valorMatricula" name="valor_mensalidade" required>
                            </div>

                            <div class="text-center">
                                <button type="submit" class="btn btn-primary">Cadastrar</button>
                            </div>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
