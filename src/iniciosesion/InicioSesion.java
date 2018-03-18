/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniciosesion;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class InicioSesion {
    private String login;
    private String pass;
    private String nombre;
    private String apellidop;
    private String apellidom;
    private char genero;
    private String email;
    private int tipo;
    private String fechacreacion;
    private String fechamod;
    private String ultimaconexion;
    private boolean activo;
    private boolean terminos;
    
    public InicioSesion(){
        this.login = null;
        this.pass = null;
        this.nombre = null;
        this.apellidop = null;
        this.apellidom = null;
        this.genero = ' ';
        this.email = null;
        this.tipo = 0;
        this.fechacreacion = null;
        this.fechamod = null; 
        this.ultimaconexion = null;
        this.activo = false;
        this.terminos = false;
    }
    public InicioSesion(String login, String pass, String nombre, String apellidop, String apellidom, char genero, String email, int tipo, String fechacreacion, String fechamod, String ultimaconexion, boolean activo, boolean terminos){
        this.login = login;
        this.pass = pass;
        this.nombre = nombre;
        this.apellidop = apellidop;
        this.apellidom = apellidom;
        this.genero = genero;
        this.email = email;
        this.tipo = tipo;
        this.fechacreacion = fechacreacion;
        this.fechamod = fechamod;
        this.ultimaconexion = ultimaconexion;
        this.activo = activo;
        this.terminos = terminos;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidop() {
        return apellidop;
    }

    public void setApellidop(String apellidop) {
        this.apellidop = apellidop;
    }

    public String getApellidom() {
        return apellidom;
    }

    public void setApellidom(String apellidom) {
        this.apellidom = apellidom;
    }

    public char getGenero() {
        return genero;
    }

    public void setGenero(char genero) {
        this.genero = genero;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getFechacreacion() {
        return fechacreacion;
    }

    public void setFechacreacion(String fechacreacion) {
        this.fechacreacion = fechacreacion;
    }

    public String getFechamod() {
        return fechamod;
    }

    public void setFechamod(String fechamod) {
        this.fechamod = fechamod;
    }

    public String getUltimaconexion() {
        return ultimaconexion;
    }

    public void setUltimaconexion(String ultimaconexion) {
        this.ultimaconexion = ultimaconexion;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }

    public boolean isTerminos() {
        return terminos;
    }

    public void setTerminos(boolean terminos) {
        this.terminos = terminos;
    }
    
    @Override
    public String toString(){
        return "InicioSesion{login="+this.login+", pass="+this.pass+", nombre="+this.nombre+", apellidop="+this.apellidop+""
                + ",  apellidom="+this.apellidom+", genero="+this.genero+", email="+this.email+", tipo="+this.tipo+""
                + ", fechacreacion="+this.fechacreacion+", fechamod="+this.fechamod+", ultimaconexion="+this.ultimaconexion+""
                + ", activo="+this.activo+", terminos="+this.activo;
    }
}
