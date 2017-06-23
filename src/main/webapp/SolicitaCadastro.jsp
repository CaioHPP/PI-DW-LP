 nm<!DOCTYPE html>
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
        <script src="jquery.min.js"></script>
        <script src="jquery.mask.js"></script>
        <script type="text/javascript">
            
            $(document).ready(function () {
                $('#telefone').mask('(00)00000-0000');
            });
            $(document).ready(function () {
                $('#cpf').mask('000.000.000-00');
            });
            $(document).ready(function () {
                $('#login').mask('AAAAAAAAAA');
            });
            $(document).ready(function () {
                $('#senha').mask('AAAAAAAAAA');
            });
            
        
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
                    cpf.value = cpf.value + "."; //quando come�amos a digitar, o script ir� inserir um par�nteses no come�o do campo.
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
           
            <form action="gerenciamento" method="post">

                Nome: <input type="text" name="nome" placeholder="Nome.." >
                Telefone: <input type="text" name="tel" id="telefone" size="20" maxlength="14" onkeypress="mascara(this)" placeholder="Telefone.."><br/>
                CPF: <input type="text" name="cpf" id="cpf" maxlength="14" onkeypress="mascaracpf(this)" placeholder="CPF..">
                E-mail: <input type="email" name="email" placeholder="E-mail.."><br/>
                Endere�o: <input type="text" name="endere�o" placeholder="Endere�o..">
                <br/>
                Data de Nascimento: <input type="date" name="dataN" placeholder="Data de Nascimento.."  ><br/>
                <div class="panel">Sexo:         <br/>
                    <input type="radio" name="genero" value="Masculino" checked=""><span>Masculino</span>
                    <input type="radio" name="genero" value="Feminino"><span>Feminino</span><br/></div>
                Instrumento Musical:
                <select  name="instrumento">
                    <option value="violao">Viol�o</option>
                    <option value="guita">Guitarra</option>
                    <option value="baixo">Baixo</option>
                    <option value="bateria">Bateria</option>
                    <option value="ctr-baixo">Contra-Baixo</option>
                    <option value="flauta">Flauta Harm�nica</option>
                    <option value="piano">Piano</option>
                    <option value="outro">Outro</option>
                </select>
                Login: <input id="login" type="text" name="login" placeholder="Login..">
                Senha: <input id="senha" type="password" name="senha" placeholder="Senha..">
                <input type="reset" value="Limpar Dados">
                <input type="submit" value="Pr�ximo" >
                <a href="SevletExibir"> <input type ="button" value="Exibir"></a>

            </form>
        </section>


    </body>
</html>
