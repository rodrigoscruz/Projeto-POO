<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page language="java"%>
<!DOCTYPE html>
<html>
<head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Aluno</title>
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
            <span class="navbar-brand mb-0 h1">Cadastro aluno</span>
        </div>
    </nav>
    
    <div class="coiteiner-fluid m-2" x-data="taskAluno()" x-init="loadTasks()">
        <div class="input-group mb-3">
            <input type="text" class="form-control" x-model="newTask" placeholder="New Task">
            <button class="btn btn-primary" type="button" x-on:click="addTasks()">+</button>
        </div>
        
        <table class="table">
            <template x-for="task in list">
                <tr>
                    <td>
                        <button type="button" x-on:click="removeTasks(tasksAluno:nomeAluno)" class="btn btn-danger btn-sm">Excluir</button>
                        <span x-text="task.nomeAluno"></span>
                    </td>
                </tr>
            </template>
        </table>
    </div>
    
    <nav class="navbar bg-body-tertiary">
        <div class="container-fluid">
    <form action="/action_page.php">
        <div class="mb-3">
            <label for="email" class="form-label">Nome:</label>
            <input type="text" class="form-control" id="nomeAluno" placeholder="Nome do Aluno" name="nomeAluno">
        </div>
        <div class="mb-3">
            <label for="pwd" class="form-label">Nascimento:</label>
            <input type="data" class="form-control" id="dtNascimento" placeholder="Data de Nascimento" name="dtNascimento">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">CPF:</label>
            <input type="number" class="form-control" id="cpfAluno" placeholder="CPF aluno" name="cpfAluno">
        </div>
        <div class="mb-3">
            <label for="pwd" class="form-label">Responsável:</label>
            <input type="text" class="form-control" id="nomeResponsavel" placeholder="Nome do Responsável" name="nomeResponsavel">
        </div>
        <div class="mb-3">
            <label for="email" class="form-label">Endereço:</label>
            <input type="text" class="form-control" id="endereco" placeholder="Endereço do Aluno" name="endereco">
        </div>
        <div class="mb-3">
            <label for="pwd" class="form-label">Telefone:</label>
            <input type="tel" class="form-control" id="telefone" placeholder="Telefone do Responsável" name="telefone">
        </div>
        <div class="mb-3">
            <label for="pwd" class="form-label">Email:</label>
            <input type="email" class="form-control" id="email" placeholder="Email do Responsável" name="email">
        </div>
            <button type="submit" class="btn btn-primary">Cadastrar</button>
    </form>
        </div>
    </nav>    
        
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
    
</body>
</html>
