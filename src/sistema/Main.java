/*
 * Creado por Jorge L. Mondragón
 * Versión 1.0
 * Creado el 24/02/2018
 */
package sistema;
import iniciosesion.FormInicioSesion;
/**
 *
 * @author nemesis
 */
public class Main { 
    public static void main(String[] args){
        FormInicioSesion inicio = new FormInicioSesion();
        inicio.setVisible(true);
        inicio.setResizable(false);
        inicio.setLocationRelativeTo(null);   
    }
}
