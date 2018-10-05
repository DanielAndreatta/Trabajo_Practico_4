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


 <%

        if(!request.getParameter("nroTarjeta").isEmpty() && !request.getParameter("nombreTitular").isEmpty() && !request.getParameter("codSeguridad").isEmpty() ){

            MedioPago mediopago= new MedioPago();
            Venta venta=new Venta();
            VentaDAO ventadao=new VentaDAO();
            VentaDAO mediopagodao=new VentaDAO();
            java.util.Date date = new Date();
            java.sql.Date fechaActual = new java.sql.Date(date.getTime());

            mediopago.setId(usuario.getId());
            mediopago.setNombreTitular(request.getParameter("nombreTitular"));
            mediopago.setNroTarjeta(request.getParameter("nroTarjeta"));
            mediopago.setCodSeguridad(request.getParameter("codSeguridad"));
            mediopago.setMesVenc(request.getParameter("mesVenc"));
            mediopago.setAnioVenc(request.getParameter("anioVenc"));

            venta.setId(usuario.getId());
            venta.setMediopago((mediopago));
            venta.setMontoTotal(carrito.sumarMontoProductos());
            venta.setFechaActual((fechaActual));
            venta.setProductos(carrito.getProductos());

            mediopagodao.guardarMedioPago(mediopago);
            ventadao.guardarVenta(venta, mediopago);


            session.removeAttribute("carrito");

        }

      %>
