<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Solicitação de Cadastro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="CSS/css.css" rel="stylesheet">
        <script>
            function mascara(telefone) {
                if (telefone.value.length === 0)
                    telefone.value = "(" + telefone.value; //quando começamos a digitar, o script irá inserir um parênteses no começo do campo.
                if (telefone.value.length === 3)
                    telefone.value = telefone.value + ")"; //quando o campo já tiver 3 caracteres (um parênteses e 2 números) o script irá inserir mais um parênteses, fechando assim o código de área.

                if (telefone.value.length === 9)
                    telefone.value = telefone.value + '-'; //quando o campo já tiver 8 caracteres, o script irá inserir um tracinho, para melhor visualização do telefone.
            }
            function mascaracpf(cpf) {
                if (cpf.value.length === 3)
                    cpf.value = cpf.value +"."; //quando começamos a digitar, o script irá inserir um parênteses no começo do campo.
                if (cpf.value.length === 7)
                    cpf.value = cpf.value + "."; //quando o campo já tiver 3 caracteres (um parênteses e 2 números) o script irá inserir mais um parênteses, fechando assim o código de área.

                if (cpf.value.length === 11)
                    cpf.value = cpf.value + '-'; //quando o campo já tiver 8 caracteres, o script irá inserir um tracinho, para melhor visualização do cpf.
            }
        </script>
    </head>
    <body>
        <section id="h1">
            <h1>Entre com seus dados</h1>
        </section>
        <section id="form">
            
            <form action="" method="post">
                Nome: <input type="text" name="nome" >
                Telefone: <input type="text" name="tel" id="telefone" size="20" maxlength="14" onkeypress="mascara(this)"><br/>
                Sexo:         
                Masculino <input type="radio" name="genero">
                Feminino <input type="radio" name="genero"><br/>
                CPF: <input type="text" name="cpf" id="cpf" maxlength="14" onkeypress="mascaracpf(this)">
                E-mail: <input type="email" name="email"><br/>
                Data de Nascimento: <input type="date" name="dataN">
                Endereço: <input type="text" name="endereço">
                
            </form>
        </section>


    </body>
</html>
