package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import java.util.List;
import model.Producto;
import RN.ProductoRN;
import model.Usuario;

public final class index_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("  \n");
      out.write("\n");
      out.write("\n");

    Usuario usuario= (Usuario) session.getAttribute("usuario");

      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta charset=\"UTF-8\">\n");
      out.write("        <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css\">\n");
      out.write("        <link rel=\"stylesheet\" href=\"estilos/estilos.css\">\n");
      out.write("        <script src=\"https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js\"></script>\n");
      out.write("        <script src=\"https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js\"></script>\n");
      out.write("        <title>Pagina de Inicio - Carrito de Compras</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "encabezado.html", out, false);
      out.write("\n");
      out.write("\n");
      out.write("        <nav class=\"navbar navbar-inverse\">\n");
      out.write("            <div class=\"container-fluid\">\n");
      out.write("                <div class=\"navbar-header\">\n");
      out.write("                    <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#myNavbar\">\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>\n");
      out.write("                        <span class=\"icon-bar\"></span>                        \n");
      out.write("                    </button>\n");
      out.write("                    <a class=\"navbar-brand\" href=\"#\">Logo</a>\n");
      out.write("                </div>\n");
      out.write("                <div class=\"collapse navbar-collapse\" id=\"myNavbar\">\n");
      out.write("                    <ul class=\"nav navbar-nav\">\n");
      out.write("                        <li class=\"active\"><a href=\"index.jsp\">Productos</a></li>\n");
      out.write("                        <li><a href=\"mostrar_carrito.jsp\">Carrito</a></li>\n");
      out.write("                        <li><a href=\"#\">Ofertas</a></li>\n");
      out.write("                        <li><a href=\"#\">Tiendas</a></li>\n");
      out.write("                        <li><a href=\"#\">Contacto</a></li>\n");
      out.write("                    </ul>\n");
      out.write("\n");
      out.write("                    ");
 if(usuario==null) { 
      out.write("\n");
      out.write("                        <form action=\"login.jsp\" method=\"post\" class=\"navbar-form navbar-right\">\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"text\" class=\"form-control\" name=\"email\" placeholder=\"Email Usuario\">\n");
      out.write("                            </div>\n");
      out.write("                            <div class=\"form-group\">\n");
      out.write("                                <input type=\"password\" class=\"form-control\" name=\"password\" placeholder=\"Contraseña\">\n");
      out.write("                            </div>\n");
      out.write("                            <button type=\"submit\" name=\"ingresar\" class=\"btn btn-default\">Ingresar</button>\n");
      out.write("                        </form>\n");
      out.write("\n");
      out.write("                        ");
 } else { 
      out.write("\n");
      out.write("                        \n");
      out.write("                        <ul class=\"nav navbar-nav navbar-right\">\n");
      out.write("                            <li><a href=\"#\"><span class=\"glyphicon glyphicon-user\"></span> ");
      out.print( usuario.getNombre());
      out.write("</a></li> \n");
      out.write("                            <li><a href=\"salir.jsp\"><span class=\"glyphicon glyphicon-log-out\"></span> Cerrar Sesión</a></li>\n");
      out.write("                            <li><a href=\"mostrar_carrito.jsp\"><span class=\"glyphicon glyphicon-shopping-cart\"></span> Carrito</a></li>\n");
      out.write("                        </ul>\n");
      out.write("                    ");
 } 
      out.write(" \n");
      out.write("                </div>\n");
      out.write("            </div>\n");
      out.write("        </nav>\n");
      out.write("\n");
      out.write("        <div class=\"container\"> \n");
      out.write("            \n");
      out.write("            ");
 if (request.getParameter("msjlog")!=null) { 
      out.write("\n");
      out.write("                <div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                    <strong>Atención!</strong> ");
 out.println(request.getParameter("msjlog")); 
      out.write("\n");
      out.write("                </div>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("\n");
      out.write("\n");
      out.write("            ");
 if (request.getParameter("msjcarr")!=null) { 
      out.write("\n");
      out.write("                <div class=\"alert alert-danger alert-dismissible\" role=\"alert\">\n");
      out.write("                    <button type=\"button\" class=\"close\" data-dismiss=\"alert\" aria-label=\"Close\"><span aria-hidden=\"true\">&times;</span></button>\n");
      out.write("                    <strong>Atención!</strong> ");
 out.println(request.getParameter("msjcarr")); 
      out.write("\n");
      out.write("                </div>\n");
      out.write("\n");
      out.write("                \t\n");
      out.write("\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("                <div class=\"row\">\n");
      out.write("                \n");
      out.write("                ");
    List<Producto> listaProductos = ProductoRN.listarProductos();

                for (Producto producto: listaProductos) { 
      out.write("\n");
      out.write("                    <div class=\"col-sm-4 col-lg-4 col-md-4\">\n");
      out.write("                        <div class=\"thumbnail\">\n");
      out.write("                            <img src=\"img/320x150.png\" alt=\"img-prod\"> <!--320x15-->\n");
      out.write("                            <div class=\"caption\">\n");
      out.write("                                <h4 class=\"pull-right\">$");
      out.print( producto.getPrecio());
      out.write("</h4>\n");
      out.write("                                <h4>");
      out.print( producto.getNombre() );
      out.write("</h4>\n");
      out.write("                                <p>Descripción: ");
      out.print( producto.getDescripcion() );
      out.write("</p>\n");
      out.write("                                <p>Talle: ");
      out.print( producto.getTalle() );
      out.write("</p>\n");
      out.write("                                <p>Color: ");
      out.print( producto.getColor() );
      out.write("</p>\n");
      out.write("                                <p><a href=\"mostrar_carrito.jsp?op=1&id=");
      out.print( producto.getId());
      out.write("\"><span class=\"glyphicon glyphicon-shopping-cart\"></span> Agregar a Carrito</a></p>\n");
      out.write("                            </div>\n");
      out.write("                        </div>\n");
      out.write("                    </div>\n");
      out.write("\n");
      out.write("                ");
 } 
      out.write("\n");
      out.write("            </div>\n");
      out.write("        </div>\n");
      out.write("        ");
      org.apache.jasper.runtime.JspRuntimeLibrary.include(request, response, "footer.html", out, false);
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
