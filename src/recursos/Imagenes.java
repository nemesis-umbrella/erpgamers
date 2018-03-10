/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package recursos;

import java.awt.Image;
import javax.swing.ImageIcon;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class Imagenes {
    public static ImageIcon ajustarImagen(String ico, int ancho, int alto)
    {
        ImageIcon tmpIconAux = new ImageIcon(ico);
        //Escalar Imagen
        ImageIcon tmpIcon = new ImageIcon(tmpIconAux.getImage().getScaledInstance(ancho, alto, Image.SCALE_DEFAULT));
        return tmpIcon;
    }
}
