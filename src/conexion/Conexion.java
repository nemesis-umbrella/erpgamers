/*
 * Creado por Jorge L. Mondragón
 * Versión 1.0
 * Creado el 24/02/2018
 */
package conexion;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
/**
 *
 * @author nemesis-umbrella
 */
public class Conexion {
    public Conexion()
    {
        try {
            //Se registra el driver de MySQL
            DriverManager.registerDriver(new org.gjt.mm.mysql.Driver());
            // Se obtiene una conexión con la base de datos. Hay que 
            String URL = "jdbc:mysql://localhost/Prueba";
            Connection conexion = DriverManager.getConnection(URL,"Prueba","Ab12345");
            //Se crea un Statement, para realizar la consulta.
            Statement s = conexion.createStatement();
            //Se realiza la consulta. Los resultado se guardan en el ResultSet rs
            ResultSet rs = s.executeQuery("select * from persona");
            
            //Se recorre el ResultSet, mostrando por pantalla los resultados.
            while(rs.next()){
                System.out.println(rs.getInt("id") + " " + rs.getString(2) + " " + rs.getString(3) + " " + rs.getString(4));
            }
            //Se cierra la conexión con la base de datos.
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //Creación temporal de un método main para pruebas
    public static void main(String[] args){
        new Conexion();
    }
            
}
