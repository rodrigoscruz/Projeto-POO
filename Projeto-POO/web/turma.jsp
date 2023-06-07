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
    
<h1>Turma</h1>


            
</body>
</html>
