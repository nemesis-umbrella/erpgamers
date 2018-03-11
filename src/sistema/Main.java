/*
 * Creado por Jorge L. Mondragón
 * Versión 1.0
 * Creado el 24/02/2018
 */
package sistema;
import iniciosesion.InicioSesion;
/**
 *
 * @author nemesis
 */
public class Main { 
    public static void main(String[] args){
        InicioSesion inicio = new InicioSesion();
        inicio.setVisible(true);
        inicio.setResizable(false);
        inicio.setLocationRelativeTo(null);   
    }
}
