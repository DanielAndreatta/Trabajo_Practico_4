<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>

<%@page import="java.util.*" %>
<%@page import="RN.ProductoRN"%>
<%@page import="java.util.List"%>
<%@page import="model.Producto"%>
<%@page import="model.Carrito"%>
<%@page import="model.MedioPago"%>
<%@page import="model.Venta"%>
<%@page import="model.Usuario" session="true"%>
<%@page import="RN.UsuarioRN"%>
<%@page import="RN.CarritoRN"%>
<%@page import="dao.VentaDAO"%>

<%
  Usuario usuario= (Usuario) session.getAttribute("usuario");
  if (usuario==null) { %>
    <jsp:forward page="index.jsp">
        <jsp:param name="msjlog" value="Debe loguearse para Ver o Agregar un Producto al Carrito..."/>
    </jsp:forward>
    <%}
  //obtener objeto carrito de compras
    Carrito carrito=null;
    if (session.getAttribute("carrito")==null) { %>
        <jsp:forward page="index.jsp">
        <jsp:param name="msjlog" value="Debe agregar productos al carrito."/>
        </jsp:forward>
<%  }
    carrito= (Carrito) session.getAttribute("carrito");
    if(carrito.contarProductos()<1){%>
        <jsp:forward page="index.jsp">
        <jsp:param name="msjlog" value="Debe agregar productos al carrito."/>
        </jsp:forward>
<%  }
    %>

    <jsp:include page="procesarCompra.jsp"></jsp:include>




<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="estilos/estilos.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Compra realizada</title>
    </head>
    <body>
        <jsp:include page="encabezado.html" />
        <nav class="navbar navbar-inverse">
            <div class="container-fluid">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#myNavbar">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <a class="navbar-brand" href="#">Logo</a>
                </div>
                <div class="collapse navbar-collapse" id="myNavbar">
                    <ul class="nav navbar-nav">
                        <li class="active"><a href="index.jsp">Productos</a></li>
                        <li><a href="mostrar_carrito.jsp">Carrito</a></li>
                        <li><a href="#">Ofertas</a></li>
                        <li><a href="#">Tiendas</a></li>
                        <li><a href="#">Contacto</a></li>
                    </ul>

                    <% if(usuario==null) { %>
                        <form action="login.jsp" method="post" class="navbar-form navbar-right">
                            <div class="form-group">
                                <input type="text" class="form-control" name="email" placeholder="Email Usuario">
                            </div>
                            <div class="form-group">
                                <input type="password" class="form-control" name="password" placeholder="Contraseña">
                            </div>
                            <button type="submit" name="ingresar" class="btn btn-default">Ingresar</button>
                        </form>

                        <% } else { %>

                        <ul class="nav navbar-nav navbar-right">
                            <li><a href="#"><span class="glyphicon glyphicon-user"></span> <%= usuario.getNombre()%></a></li>
                            <li><a href="salir.jsp"><span class="glyphicon glyphicon-log-out"></span> Cerrar Sesión</a></li>
                            <li><a href="mostrar_carrito.jsp"><span class="glyphicon glyphicon-shopping-cart"></span> Carrito</a></li>
                        </ul>
                    <% } %>
                </div>
            </div>
        </nav>


        <div class="container">

          <h1>Compra realizada con exito!</h1><br><br><br>

        </div>
        <jsp:include page="footer.html" />
    </body>
</html>
