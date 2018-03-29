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
public class Perfil {
    private static String login;
    private static String nombre;
    private static String email;

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
    
    public static void pasar(String login1, String nombre1, String email1){
        Perfil.login = login1;
        Perfil.nombre = nombre1;
        Perfil.email = email1;
    }
    
    public static void limpiar(){
        Perfil.login = null;
        Perfil.nombre = null;
        Perfil.email = null;
    }
}
