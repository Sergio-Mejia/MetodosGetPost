
<%@page import="Modelo.dto.UsuarioDTO"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Usuario</title>
    </head>
    <body>
        <h1>Lista de Usuarios</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Email</th>
                    <th>Contraseña</th>
                    <th>Rol</th>
                </tr>
            </thead>
            <tbody>
                <% Object Lista = request.getAttribute("Lista");

                    if (Lista != null) {

                        List<Object> listObj = (List) Lista;

                        for (Object i : listObj) {

                            UsuarioDTO usuario = (UsuarioDTO) i;
                %>
                <tr> 
                    <td> <%=usuario.getId()%> </td>
                    <td> <%=usuario.getNombre()%> </td>
                    <td> <%=usuario.getEmail()%> </td>
                    <td> <%=usuario.getPassword()%> </td>
                    <td> <%=usuario.getRol()%> </td>
                </tr>

                <% }
                } else {%>
            <h2>No hay datos</h2>
            <%}%>
        </tbody>         
    </table>
</body>
</html>
