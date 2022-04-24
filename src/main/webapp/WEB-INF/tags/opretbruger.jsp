<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <style>
        body {
            font-family: Arial, Helvetica, sans-serif;
            background-color: black;
        }

        * {
            box-sizing: border-box;
        }

        /* Add padding to containers */
        .container {
            padding: 16px;
            background-color: white;
        }

        /* Full-width input fields */
        input[type=text], input[type=password] {
            width: 100%;
            padding: 15px;
            margin: 5px 0 22px 0;
            display: inline-block;
            border: none;
            background: #f1f1f1;
        }

        input[type=text]:focus, input[type=password]:focus {
            background-color: #ddd;
            outline: none;
        }

        /* Overwrite default styles of hr */
        hr {
            border: 1px solid #f1f1f1;
            margin-bottom: 25px;
        }

        /* Set a style for the submit button */
        .registerbtn {
            background-color: #04AA6D;
            color: white;
            padding: 16px 20px;
            margin: 8px 0;
            border: none;
            cursor: pointer;
            width: 100%;
            opacity: 0.9;
        }

        .registerbtn:hover {
            opacity: 1;
        }

        /* Add a blue text color to links */
        a {
            color: dodgerblue;
        }

        /* Set a grey background color and center the text of the "sign in" section */
        .signin {
            background-color: #f1f1f1;
            text-align: center;
        }
    </style>
</head>
<body>

<%--<form action="Register" method="get">--%>
<form action="OpretBrugerServlet">
    <div class="container">
        <h1>Opret Profil</h1>
        <p>Det er hurtigt og nemt.</p>
        <hr>

        <%--<label for="User_id"><b>User_id</b></label>
        <input type="text" placeholder="User_id" name="User_id" id="User_id" required>
--%>
        <label for="email"><b>E-mail</b></label>
        <input type="text" placeholder="e-mail" name="email" id="email" required>

        <label for="psw"><b>Kodeord</b></label>
        <input type="password" placeholder="kodeord" name="psw" id="psw" required>

        <label for="psw-repeat"><b>Gentag Kodeord</b></label>
        <input type="password" placeholder="gentag kodeord" name="psw-repeat" id="psw-repeat" required>

     <%--   <label for="Role_id"><b>Role_id</b></label>
        <input type="text" placeholder="Role_id" name="Role_id" id="Role_id" required>
        Skal bare sættes til bruger som standard, vroes startadmin, skal så kunne opgradere folk--%>

        <label for="firstname"><b>Fornavn</b></label>
        <input type="text" placeholder="Fornavn" name="firstname" id="firstname" required>

        <label for="surname"><b>Efternavn</b></label>
        <input type="text" placeholder="Efternavn" name="surname" id="surname" required>

        <label for="balance"><b>Saldo</b></label>
        <input readonly type="text" placeholder="Balance" name="balance" id="balance" value="100" checked required>

        <hr>
        <p>Ved at oprette en bruger accepterer du vores <a href="#">Betingelser</a>.</p>

        <button type="submit" class="registerbtn">Opret Profil</button>
    </div>

    <div class="container signin">
        <p>Har du allerede en konto? <a href="login.jsp">Log ind</a>.</p>
    </div>
</form>

</body>
</html>


</body>
</html>

