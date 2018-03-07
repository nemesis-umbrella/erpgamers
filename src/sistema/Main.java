/*
 * Creado por Jorge L. Mondragón
 * Versión 1.0
 * Creado el 24/02/2018
 */
package sistema;
import menuprincipal.MenuPrincipal;
/**
 *
 * @author nemesis
 */
public class Main {
    public static void main(String[] args){
        System.out.println("Hola mundo");
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        menu.setResizable(false);
        menu.setLocationRelativeTo(null);
    }
}
