/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica;

import java.sql.Timestamp;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class Vehiculo {
    private final String matveh;
    
    private Integer matemp;
    private String marca;
    private Integer aniofab;
    private Boolean disponibilidad;
    private Timestamp fechacreacion;
    private Timestamp fechamod;
    
    public Vehiculo(){
        matveh = null;
        matemp = null;
        marca = null;
        aniofab = null;
        disponibilidad = null;
        fechacreacion = null;
        fechamod = null;
    }
    public Vehiculo(String matveh, Integer matemp, String marca, Integer aniofab, Boolean disponibilidad, Timestamp fechacreacion, Timestamp fechamod){
        this.matveh = matveh;
        this.matemp = matemp;
        this.marca = marca;
        this.aniofab = aniofab;
        this.disponibilidad = disponibilidad;
        this.fechacreacion = fechacreacion;
        this.fechamod = fechamod;
    }

    public String getMatveh() {
        return matveh;
    }

    
    public Integer getMatemp() {
        return matemp;
    }

    public void setMatemp(Integer matemp) {
        this.matemp = matemp;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public Integer getAniofab() {
        return aniofab;
    }

    public void setAniofab(Integer aniofab) {
        this.aniofab = aniofab;
    }

    public Boolean getDisponibilidad() {
        return disponibilidad;
    }

    public void setDisponibilidad(Boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
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
    
}
