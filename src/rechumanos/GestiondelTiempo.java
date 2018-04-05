/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rechumanos;

import logistica.*;
import java.sql.Time;
import java.sql.Timestamp;


/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class GestiondelTiempo {
    private final Integer idruta;
    private String alias;
    private Double costo;
    private Boolean disponibilidad;
    private String descrip;
    private Time tiempo;
    private Timestamp fechacreacion;
    private Timestamp fechamod;
    public GestiondelTiempo(){
        this.idruta = null;
        this.alias = null;
        this.costo = null;
        this.disponibilidad = null;
        this.descrip = null;
        this.tiempo = null;
        this.fechacreacion = null;
        this.fechamod = null;
    }
    public GestiondelTiempo(Integer idruta, String alias, Double costo,Boolean disponibilidad, String descrip, Time tiempo, Timestamp fechacreacion, Timestamp fechamod){
        this.idruta = idruta;
        this.alias = alias;
        this.costo = costo;
        this.disponibilidad = disponibilidad;
        this.descrip = descrip;
        this.tiempo = tiempo;
        this.fechacreacion = fechacreacion;
        this.fechamod = fechamod;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public String getDescrip() {
        return descrip;
    }

    public void setDescrip(String descrip) {
        this.descrip = descrip;
    }

    public Time getTiempo() {
        return tiempo;
    }

    public void setTiempo(Time tiempo) {
        this.tiempo = tiempo;
    }

    public Timestamp getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(Timestamp fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public Timestamp getFechamod() {
        return fechamod;
    }

    public void setFechamod(Timestamp fechamod) {
        this.fechamod = fechamod;
    }

    
    
    @Override 
    public String toString(){
        return "Ruta{idruta="+this.idruta+", alias="+this.alias+", costo="+this.costo+", disponibilidad="+this.disponibilidad+", descrip="+this.descrip+", tiempo="+this.tiempo+", fechacreacion="+this.fechacreacion+", fechamod="+this.fechamod+"}";
    }

    public Integer getIdruta() {
        return idruta;
    }
    
}
