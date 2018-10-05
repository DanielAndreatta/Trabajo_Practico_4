/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

/**
 *
 *
 */
public class Venta implements Serializable {

    private int id; //id de usuario
    private int idVenta;
    private MedioPago mediopago;
    private java.sql.Date fechaActual;
    private BigDecimal montoTotal;
    private List<Producto> productos = new ArrayList();

    public int getId() {
        return id;
    }

    public void setId(int id) {
            this.id = id;
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public MedioPago getMediopago() {
        return mediopago;
    }

    public void setMediopago(MedioPago mediopago) {
        this.mediopago = mediopago;
    }

    public Date getFechaActual() {
        return fechaActual;
    }

    public void setFechaActual(Date fechaActual) {
        this.fechaActual = fechaActual;
    }

    public BigDecimal getMontoTotal() {
        return montoTotal;
    }

    public void setMontoTotal(BigDecimal montoTotal) {
        this.montoTotal = montoTotal;
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }


}
