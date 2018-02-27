/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perfil;

import java.awt.Color;

/**
 *
 * @author poron
 */
public class Configuracion {
    Color color;
    public Color fijarColor(int opcion){
        switch(opcion){
            case 1: 
                color = new Color(255,255,255);
            case 2: 
                color = new Color(255,255,255);
            default:
                color = new Color(245,240,200);
        }
        return color;
    }
}
