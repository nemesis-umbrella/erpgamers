/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniciosesion;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import logistica.Vehiculo;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class InicioSesionOperaciones {
  private final String tabla = "iniciosesion";
  public void guardar(Connection conexion, InicioSesion iniciosesion) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM "+tabla+" WHERE login=?;");
            consulta.setString(1, iniciosesion.getLogin());
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next()){
                consulta = conexion.prepareStatement("CALL igmdiniciosesion(?,?,?,?,?,?,?,?,?,?);");
                consulta.setString(1, iniciosesion.getLogin());
                consulta.setString(2, iniciosesion.getPass());
                consulta.setString(3, iniciosesion.getNombre());
                consulta.setString(4, iniciosesion.getApellidop());
                consulta.setString(5, iniciosesion.getApellidom());
                consulta.setString(6, ""+iniciosesion.getGenero());
                consulta.setString(7, iniciosesion.getEmail());
                consulta.setInt(8, iniciosesion.getTipo());
                consulta.setBoolean(9, iniciosesion.isActivo());
                consulta.setBoolean(10, iniciosesion.isTerminos());
            }
            else{
                consulta = conexion.prepareStatement("CALL igmdiniciosesion(?,?,?,?,?,?,?,?,false,false);");
                consulta.setString(1, iniciosesion.getLogin());
                consulta.setString(2, iniciosesion.getPass());
                consulta.setString(3, iniciosesion.getNombre());
                consulta.setString(4, iniciosesion.getApellidop());
                consulta.setString(5, iniciosesion.getApellidom());
                consulta.setString(6, ""+iniciosesion.getGenero());
                consulta.setString(7, iniciosesion.getEmail());
                consulta.setInt(8, iniciosesion.getTipo());
            }
            consulta.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
  
    public int verificarInicio(Connection conexion, String login, String pass) throws SQLException{
        int tipo = 0;
        try {
            PreparedStatement consulta = conexion.prepareStatement("CALL verificariniciosesion(?,?)");
            consulta.setString(1, login);
            consulta.setString(2, pass);
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next()){
                tipo = Integer.parseInt(resultado.getString("resultado"));
            }
        } catch (Exception e) {
        }
        return tipo;
    }
    
    public int cambiarPassword(Connection conexion, String login, String pass, String newpass) throws SQLException{
        int tipo = 0;
        try {
            PreparedStatement consulta = conexion.prepareStatement("CALL cambiarpass(?,?,?)");
            consulta.setString(1, login);
            consulta.setString(2, pass);
            consulta.setString(3, newpass);
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next()){
                tipo = Integer.parseInt(resultado.getString("resultado"));
            }
        } catch (Exception e) {
        }
        return tipo;
    }
    
    public static void main(String[] args){
        InicioSesionOperaciones inicioop = new InicioSesionOperaciones();
        try {
            //Creación de un nuevo usuario
            /*
            InicioSesion inicio = new InicioSesion("ChrisRedfield", "Ab123456", "Chris", "Redfield", "Peréz", 'M', "chris@bssa.org", 1, null, null, null, true, false);
            inicioop.guardar(Conexion.obtener(), inicio);
            */
            //Comprobar un inicio de sesión
            /*
            int resultado = inicioop.verificarInicio(Conexion.obtener(), "ChrisRedfield", "Ab123456");
            System.out.println(resultado);
            */
            //Cambiar contraseña de un usuario
            int resultado = inicioop.cambiarPassword(Conexion.obtener(), "ChrisRedfield", "Ab12345", "Ab123456");
            System.out.println(resultado);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
    }
}
