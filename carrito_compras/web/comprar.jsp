<%@page contentType="text/html" language="java" pageEncoding="UTF-8"%>

<%@page import="RN.ProductoRN"%>
<%@page import="java.util.List"%>
<%@page import="model.Producto"%>
<%@page import="model.Carrito"%>
<%@page import="model.Usuario" session="true"%>

<%
  Usuario usuario= (Usuario) session.getAttribute("usuario");
  if (usuario==null) { %>

    <jsp:forward page="index.jsp">
        <jsp:param name="msjlog" value="Debe loguearse para Ver o Agregar un Producto al Carrito..."/>
    </jsp:forward>

    <%}
  //obtener objeto carrito de compras
    Carrito carrito=null;
    if (session.getAttribute("carrito")==null) {
        carrito=new Carrito();
        session.setAttribute("carrito", carrito);
    } else {
        carrito= (Carrito) session.getAttribute("carrito");
    }
%>

<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
        <link rel="stylesheet" href="estilos/estilos.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
        <title>Carrito de Compras</title>
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
            <h1>Formulario de Compra</h1>
            <br>

        <%
             if(request.getParameter("id")!=null && request.getParameter("op")!=null) {

                Producto producto= ProductoRN.obtenerProductoById(Integer.parseInt(request.getParameter("id"))); // obtengo instancia de producto de acuerdo al codigo recibido
                 if (producto==null) { %>

                    <jsp:forward page="index.jsp">
                        <jsp:param name="msjlog" value="No se encuentra el producto solicitado..."/>
                    </jsp:forward>

                <%}
                switch (request.getParameter("op")) {
                case "1":  // AGREGAR PRODUCTO AL CARRITO
                    carrito.agregarProducto(producto);
                    break;

                case "2": //ELIMINAR PRODUCTO
                    carrito.eliminarProducto(producto);
                    break;

                }
            }
       %>

        <div class="table-responsive">

            <table class="table table-hover table-striped ">
              <caption><h4>Usuario</h4></caption>
              <tr>
                <th><p>Nombre</p></th>
                <th><span class="glyphicon glyphicon-user"></span><%= usuario.getNombre()%></th>
              </tr>
            </table>


            <table class="table table-hover table-striped ">
                <caption><h4>Productos</h4></caption>
                <thead>
                    <tr>
                        <th>Código</th>
                        <th>Producto</th>
                        <th>Talle</th>
                        <th>Color</th>
                        <th>Precio</th>
                    </tr>
                </thead>
                <tfoot>
                    <tr>
                        <th colspan="6">Total productos del Carrito: <%= carrito.contarProductos()%></th>
                    </tr>
                    <tr>
                        <th colspan="6">Monto Total del Carrito: <%= carrito.sumarMontoProductos()%> </th>
                    </tr>

                  </tfoot>
                <tbody>

               <%
                for (Producto producto: carrito.getProductos()) { %>
                <tr>
                    <td><%= producto.getId() %></td>
                    <td><%= producto.getNombre() %></td>
                    <td><%= producto.getTalle() %></td>
                    <td><%= producto.getColor() %></td>
                    <td><%= producto.getPrecio() %></td>

                </tr>
                <% } %>
                </tbody>
            </table>

            <form action="mostrarCompra.jsp" method="POST">
              <table class="table table-hover table-striped ">
                <caption><h4>Datos de Tarjeta</h4></caption>
                <tr>
                  <th><label for="nombreTitular">Nombre Titular: </label></th>
                  <th><input type="text" id="nombreTitular" name="nombreTitular" required></th>
                </tr>
                <tr>
                  <th><label for="nroTarjeta">Numero Tarjeta: </label></th>
                  <th><input type="text" id="nroTarjeta" name="nroTarjeta"  maxlength="16" required></th>
                </tr>
                <tr>
                  <th><label for="codSeguridad">Codigo Seguridad: </label></th>
                  <th><input type="text" id="codSeguridad" name="codSeguridad" maxlength="4" required></th>
                </tr>
                <tr>
                  <th><label for="anioVenc">Año Vencimiento: </label></th>
                  <th><input type="text" id="anioVenc" name="anioVenc" maxlength="4" placeholder="AAAA" required></th>
                </tr>
                <tr>
                  <th><label for="mesVenc">Mes Vencimiento: </label></th>
                  <th><input type="text" id="mesVenc" name="mesVenc" maxlength="2" placeholder="MM" required></th>
                </tr>
              </table>
              <input type="submit" name="comprar" value="Finalizar Compra" class="btn btn-success" >
            </form>

        </div>
        <br><br>
        </div>
        <jsp:include page="footer.html" />
    </body>
</html>
