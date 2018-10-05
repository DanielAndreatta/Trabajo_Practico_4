/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

/**
 *
 * @author Dany
 */

 import static java.lang.Integer.valueOf;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Carrito;
import model.MedioPago;
import model.Venta;
import model.Producto;


public class VentaDAO extends ConexionDAO{

    public void guardarVenta(Venta venta, MedioPago mediopago) throws Exception{
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int idVenta;

        try{
            conn = this.getDs().getConnection();
            String key[]={"id_venta"};
            java.util.Date d = new java.util.Date();
            String date = new String();

            String vsql="INSERT INTO venta (id_usuario,fecha,montototal,id_mediopago) VALUES (?,?,?,?)";
            ps = conn.prepareStatement(vsql,key);
            ps.setInt(1, venta.getId());
            ps.setDate(2, venta.getFechaActual());
            ps.setBigDecimal(3,venta.getMontoTotal());
            ps.setInt(4, mediopago.getIdMedioPago());

            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if(rs.next()){
                idVenta=rs.getInt(1);
                venta.setIdVenta(idVenta);
                this.guardaCarritos(venta);
            }

            ps.close();
            ps=null;
            conn.close();
            conn=null;

        } catch (Exception e) {
            throw e;
        }



    }



    public void guardarMedioPago(MedioPago mediopago) throws Exception{
        Connection conn= null;
        PreparedStatement ps=null;
        ResultSet rs=null;
        int idMedioPago;

        try{
            conn = this.getDs().getConnection();
            String key[]={"id_medio_pago"};
            java.util.Date d = new java.util.Date();
            String date = new String();

            String vsql="INSERT INTO medio_pago (nrotarjeta,nombretitular,mesvenc,aniovenc,codseguridad,id_usuario) VALUES (?,?,?,?,?,?)";
            ps = conn.prepareStatement(vsql,key);
            ps.setString(1,mediopago.getNroTarjeta());
            ps.setString(2, mediopago.getNombreTitular());
            ps.setString(3, mediopago.getMesVenc());
            ps.setString(4,mediopago.getAnioVenc());
            ps.setString(5,mediopago.getCodSeguridad());
            ps.setInt(6, mediopago.getId());


            ps.executeUpdate();

            rs = ps.getGeneratedKeys();
            if(rs.next()){
                idMedioPago=rs.getInt(1);
                mediopago.setIdMedioPago(idMedioPago);
            }

            ps.close();
            ps=null;
            conn.close();
            conn=null;

        } catch (Exception e) {
            throw e;
        }



    }


    public void guardaCarritos(Venta venta) throws Exception{
        Connection conn=null;
        PreparedStatement ps= null;


        try{
            conn = this.getDs().getConnection();

            for (Producto producto: venta.getProductos()) {

            String date = new String();

            String vsql="INSERT INTO venta_producto (id_producto, id_venta) VALUES (?,?)";
            ps = conn.prepareStatement(vsql);
            ps.setInt(1,producto.getId());
            ps.setInt(2,venta.getIdVenta());
            ps.executeUpdate();

            }

            ps.close();
            ps=null;
            conn.close();
            conn=null;

        } catch (Exception e){
            throw e;
        }

    }



}
