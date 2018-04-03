/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import conexion.Conexion;
import iniciosesion.InicioSesionOperaciones;
import iniciosesion.Perfil;
import java.awt.Color;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class Colores {
    private static int seleccion = 0;

    public static int getSeleccion() {
        return seleccion;
    }

    public static void setSeleccion(int seleccion) {
        Colores.seleccion = seleccion;
    }
    
    public static Color cargarColor(){
        Color color;
        switch(seleccion){
            case 0:
                color = new Color(0, 71, 179);
                break;
            case 1: 
                color = new Color(0,0,0);
                break;
            case 2:
                color = new Color(178,0,44);
                break;
            case 3:
                color = new Color(80,0,255);
                break;
            default:
                color = new Color(0, 71, 179);
                break;
        } 
        return color;
    }
    
    public static Color colorAzul(){
        return new Color(0, 71, 179);
    }
    public static Color colorBlanco(){
        return new Color(255, 255, 255);
    }
    
    public static Color colorBlancoOsc(){ 
       return new Color(224,224,224);
    }
    
    public static Color colorRojo(){
        return new Color(178,0,44);
    }
    
    public static Color colorMorado(){
        return new Color(80,0,255);
    }
    
    public static String guardarColorNuevo(int sel){
        String error = "";
        InicioSesionOperaciones iniop = new InicioSesionOperaciones();
        try {
            Colores.setSeleccion(sel);
            iniop.guardarColor(Conexion.obtener(), Perfil.getLogin(), sel);
        } catch (Exception e) {
            error = "Error: "+e;
        }
        return error;
    }
}
