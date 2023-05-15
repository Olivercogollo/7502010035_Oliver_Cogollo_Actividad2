<%-- 
    Document   : index
    Created on : 12/05/2023, 07:30:31 PM
    Author     : Oliver
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <center>
        <h1>
        <b>Sistema de Estudiantes</B>
    </h1>
    </center>
        <hr style="width: 50%">
        <div style="text-aling: center">
            <table border="1" style="margin: 0 auto; text-aling: left">              
                <tr><td> <a href=""><h2>Gestionar Usuarios</h2></a></td></tr>
            <tr>
                <th><h1><a href="web/usuario/agregar.jap" >Agregar</a></h1></th>
            </tr>
            <tr>
                <td><h1><a href="web/usuario/buscar.jsp" >Buscar</a></h1></td>
            </tr>
                <tr> <td><h1><a href="web/usuario/modificar.jap" >Modificar</a></h1></td>
            </tr>
                <tr> <td><h1><a href="web/usuario/eliminar.jap" >Eliminar</a></h1></td>
            </tr>
                <tr> <td><h1><a href="usuario?accion-listartodo" >Listar</a></h1></td>
            </tr>
                <tr> <td><h1><a href="/ejemplosesion/usuario?accion-logout" >Salir</a></h1>
            </tr> 
            </tbody>
         </table>
    </center>
        </div>
    </body>
</html>
