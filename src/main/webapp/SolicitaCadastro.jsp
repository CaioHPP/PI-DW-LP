<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>Solicita��o de Cadastro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link type="text/css" href="CSS/css.css" rel="stylesheet">
        <script>
            function mascara(telefone) {
                if (telefone.value.length === 0)
                    telefone.value = "(" + telefone.value; //quando come�amos a digitar, o script ir� inserir um par�nteses no come�o do campo.
                if (telefone.value.length === 3)
                    telefone.value = telefone.value + ")"; //quando o campo j� tiver 3 caracteres (um par�nteses e 2 n�meros) o script ir� inserir mais um par�nteses, fechando assim o c�digo de �rea.

                if (telefone.value.length === 9)
                    telefone.value = telefone.value + '-'; //quando o campo j� tiver 8 caracteres, o script ir� inserir um tracinho, para melhor visualiza��o do telefone.
            }
            function mascaracpf(cpf) {
                if (cpf.value.length === 3)
                    cpf.value = cpf.value +"."; //quando come�amos a digitar, o script ir� inserir um par�nteses no come�o do campo.
                if (cpf.value.length === 7)
                    cpf.value = cpf.value + "."; //quando o campo j� tiver 3 caracteres (um par�nteses e 2 n�meros) o script ir� inserir mais um par�nteses, fechando assim o c�digo de �rea.

                if (cpf.value.length === 11)
                    cpf.value = cpf.value + '-'; //quando o campo j� tiver 8 caracteres, o script ir� inserir um tracinho, para melhor visualiza��o do cpf.
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
                Endere�o: <input type="text" name="endere�o">
                
            </form>
        </section>


    </body>
</html>
