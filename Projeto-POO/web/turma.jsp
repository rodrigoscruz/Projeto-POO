<%-- 
    
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Turma</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
        <script defer src="https://cdn.jsdelivr.net/npm/alpinejs@3.x.x/dist/cdn.min.js"></script>
</head>
<body>
    <script>
        async function request(url = "", methd, data) {
            const response = await fetch(url, {
                method: methd,
                headers: {"Content-Type": "application/json"},
                body: JSON.stringify(data)
            });
            return response.json();
        }
        
        function taskAluno(){
            return {
                newTask: '',
                list: [],
                async loadTasks(){
                    request("/Projeto-POO/tasksAluno", "GET").then((data)=>{
                        this.list = data.list;
                    });
                }, async addTasks(){
                    request("/Projeto-POO/tasksAluno", "POST", {nomeAluno: this.newTask}).then((data)=>{
                        this.newTask = '';
                        this.list = data.list;
                    });
                }, async removeTasks(taskAluno){
                    request("/Projeto-POO/tasksAluno?nomeAluno="+taskAluno, "DELETE").then((data)=>{
                        this.list = data.list;
                    });
                }
            };
        }
       
    </script> 
    
<nav class="navbar bg-body-tertiary">
        <div class="container-fluid"> 
            <span class="navbar-brand mb-0 h1">Cadastro de Turma</span>
        </div>
    </nav>

<nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
    <form action="/action_page.php">
        <div class="mb-3">
            <label for="email" class="form-label">Nome:</label>
            <input type="text" class="form-control" id="nomeTurma" placeholder="Nome da Turma" name="nomeTurma">
        </div>
        <div class="mb-3">
            <label for="idioma">Idioma:</label>
            <select id="idioma" name="idioma">
              <option value="ingles">Inglês</option>
              <option value="espanhol">Espanhou</option>
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
            <label for="horarioInicioAula" class="form-label">Horario de Inicio:</label>
            <input type="number" class="form-control" id="horarioInicioAula" placeholder="horário de início da aula" name="horarioInicioAula">
        </div>
        <div class="mb-3">
            <label for="horarioTerminoAula" class="form-label">Horario de Término:</label>
            <input type="number" class="form-control" id="horarioTerminoAula" placeholder="horário de término da aula" name="horarioTerminoAula">
        </div>
        <div class="mb-3">
            <label for="valor" class="form-label">Valor do Curso:</label>
            <input type="number" class="form-control" id="valor" placeholder="Valor total do curso" name="valor">
        </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
        </div>
    </nav> 
            
</body>
</html>
