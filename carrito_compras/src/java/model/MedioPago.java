/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Dany
 */
public class MedioPago {

    private int id;// id de usuario
    private int idMedioPago;
    private String nroTarjeta;
    private String nombreTitular;
    private String mesVenc;
    private String anioVenc;
    private String codSeguridad;

    public int getId() {
        return id;
    }

    public void setIdMedioPago(int idMedioPago) {
        this.idMedioPago = idMedioPago;
    }

    public int getIdMedioPago() {
        return idMedioPago;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNroTarjeta() {
        return nroTarjeta;
    }

    public void setNroTarjeta(String nroTarjeta) {
        this.nroTarjeta = nroTarjeta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public String getMesVenc() {
        return mesVenc;
    }

    public void setMesVenc(String mesVenc) {
        this.mesVenc = mesVenc;
    }

    public String getAnioVenc() {
        return anioVenc;
    }

    public void setAnioVenc(String anioVenc) {
        this.anioVenc = anioVenc;
    }

    public String getCodSeguridad() {
        return codSeguridad;
    }

    public void setCodSeguridad(String codSeguridad) {
        this.codSeguridad = codSeguridad;
    }



}
