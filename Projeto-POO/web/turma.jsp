<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>Turma</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet">
    <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
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
    <script>
        async function request(url = "", method, data) {
            const response = await fetch(url, {
                method: method,
                headers: { "Content-Type": "application/json" },
                body: JSON.stringify(data)
            });
            return response.json();
        }

        function taskAluno() {
            return {
                newTask: '',
                list: [],
                async loadTasks() {
                    request("/Projeto-POO/tasksAluno", "GET").then((data) => {
                        this.list = data.list;
                    });
                },
                async addTasks() {
                    request("/Projeto-POO/tasksAluno", "POST", { nomeAluno: this.newTask }).then((data) => {
                        this.newTask = '';
                        this.list = data.list;
                    });
                },
                async removeTasks(taskAluno) {
                    request("/Projeto-POO/tasksAluno?nomeAluno=" + taskAluno, "DELETE").then((data) => {
                        this.list = data.list;
                    });
                }
            };
        }
    </script>
<h1 >Cadastro de Turma</h1>
    <div class="container mt-5">
        <div class="card">
            <div class="card-body">
                
                <form action="/action_page.php">
                    <div class="mb-3">
                        <label for="nomeTurma" class="form-label">Nome:</label>
                        <input type="text" class="form-control" id="nomeTurma" placeholder="Nome da Turma" name="nomeTurma">
                    </div>
                    <div class="mb-3">
                        <label for="idioma" class="form-label">Idioma:</label>
                        <select id="idioma" class="form-select" name="idioma">
                            <option value="ingles">Inglês</option>
                            <option value="espanhol">Espanhol</option>
                            <option value="frances">Francês</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label for="cargaHoraria" class="form-label">Carga Horária:</label>
                        <input type="number" class="form-control" id="cargaHoraria" placeholder="Carga horária do curso" name="cargaHoraria">
                    </div>
                    <div class="mb-3">
                        <label for="professor" class="form-label">Professor:</label>
                        <input type="text" class="form-control" id="professor" placeholder="Nome do Professor" name="professor">
                    </div>
                    <div class="mb-3">
                        <label for="horarioInicioAula" class="form-label">Horário de Início:</label>
                        <input type="text" class="form-control" id="horarioInicioAula" placeholder="Horário de início da aula" name="horarioInicioAula">
                    </div>
                    <div class="mb-3">
                        <label for="horarioTerminoAula" class="form-label">Horário de Término:</label>
                        <input type="text" class="form-control" id="horarioTerminoAula" placeholder="Horário de término da aula" name="horarioTerminoAula">
                    </div>
                    <div class="mb-3">
                        <label for="valor" class="form-label">Valor do Curso:</label>
                        <input type="text" class="form-control" id="valor" placeholder="Valor total do curso" name="valor">
                    </div>
                    <button type="submit" class="btn btn-primary">Cadastrar</button>
                </form>
            </div>
        </div>
    </div>

</body>
</html>
