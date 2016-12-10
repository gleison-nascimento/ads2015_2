/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function valicaCampos() {
    var nome = document.getElementById("nome").value;
    var cpf = document.getElementById("cpf").value;
    var sexo = document.getElementById("sexo").value;
    var endereco = document.getElementById("endereco").value;
    var email = document.getElementById("email").value;
    var perfil = document.getElementById("perfil").value;
    var username =document.getElementById("username").value;
    var senha = document.getElementById("senha").value;
    var senha1 = document.getElementById("senha1").value;
    
    if (nome == '') {
        alert('Nome deve ser preenchido');
        return false;
    }
    
    if (cpf == '') {
        alert('CPF deve ser preenchido');
        return false;
    }
    
    if (sexo == '') {
        alert('Sexo deve ser preenchido');
        return false;
    }
    
    if (endereco == '') {
        alert('Endereco deve ser preenchido');
        return false;
    }
    if (email == '') {
        alert('Email deve ser preenchido');
        return false;
    }
    if (perfil == '') {
        alert('Perfil deve ser preenchido');
        return false;
    }
    if (username == '') {
        alert('Username deve ser preenchido');
        return false;
    }
    if (senha == '') {
        alert('Senha deve ser preenchido');
        return false;
    }
    if (senha1 == '') {
        alert('Senha de confirmacao deve ser preenchido');
        return false;
    }    
    if(senha != senha1){
        alert('As senhas devem ser iguais');
    }
    return true;
}

