<%-- 
    Document   : ContactoVTA
    Created on : 17/08/2021, 11:27:04 AM
    Author     : daser
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Página 1</title>
    </head>
    <body>
        <h1>Página 1</h1>
        <form method="post" action="ContactoCTO?Action=Agregar">
            <fieldset>
                <legend>Datos Personales</legend>
                <label>Nombre:</label>
                <input type="text" name="txtNombre" required>
                <label>Email:</label>
                <input type="email" name="txtEmail" required>
                <label>Asunto:</label>
                <input type="text" name="txtAsunto" required>
                <label>Descripción:</label>
                <textarea type="text" name="txtMensaje" required></textarea>
                <input type="submit" value="Enviar Comentario">
                <input type="reset" value="Limpiar">
            </fieldset>    
        </form>
    </body>

