/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniciosesion;

import recursos.Colores;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class Perfil {
    private static String login;
    private static String nombre;
    private static String nomcompleto;
    private static String email;
    private static String genero;
    private static String ultimaconexion;
    private static int tipo;

    public static String getNomcompleto() {
        return nomcompleto;
    }

    public static void setNomcompleto(String nomcompleto) {
        Perfil.nomcompleto = nomcompleto;
    }

    public static String getGenero() {
        return genero;
    }

    public static void setGenero(String genero) {
        Perfil.genero = genero;
    }

    public static String getUltimaconexion() {
        return ultimaconexion;
    }

    public static void setUltimaconexion(String ultimaconexion) {
        Perfil.ultimaconexion = ultimaconexion;
    }

    public static int getTipo() {
        return tipo;
    }

    public static void setTipo(int tipo) {
        Perfil.tipo = tipo;
    }
    public static String getLogin() {
        return login;
    }

    public static void setLogin(String login) {
        Perfil.login = login;
    }

    public static String getNombre() {
        return nombre;
    }

    public static void setNombre(String nombre) {
        Perfil.nombre = nombre;
    }

    public static String getEmail() {
        return email;
    }

    public static void setEmail(String email) {
        Perfil.email = email;
    }
    
    public static void pasar(String login1, String nombre1, String nomcompleto1,String email1, String genero1, String ultimaconexion1, int tipo1){
        Perfil.login = login1;
        Perfil.nombre = nombre1;
        Perfil.email = email1;
        Perfil.nomcompleto = nomcompleto1;
        Perfil.genero = genero1;
        Perfil.ultimaconexion = ultimaconexion1;
        Perfil.tipo = tipo1;
    }
    
    public static void limpiar(){
        Perfil.login = null;
        Perfil.nombre = null;
        Perfil.email = null;
        Perfil.nomcompleto = null;
        Perfil.genero = null;
        Perfil.ultimaconexion = null;
        Perfil.tipo = 0;
        Colores.setSeleccion(0);
    }
}
