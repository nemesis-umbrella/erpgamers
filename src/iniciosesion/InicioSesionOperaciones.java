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
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import recursos.Colores;

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
                consulta = conexion.prepareStatement("CALL igmdiniciosesion(?,?,?,?,?,?,?,?,?,false);");
                consulta.setString(1, iniciosesion.getLogin());
                consulta.setString(2, iniciosesion.getPass());
                consulta.setString(3, iniciosesion.getNombre());
                consulta.setString(4, iniciosesion.getApellidop());
                consulta.setString(5, iniciosesion.getApellidom());
                consulta.setString(6, ""+iniciosesion.getGenero());
                consulta.setString(7, iniciosesion.getEmail());
                consulta.setInt(8, iniciosesion.getTipo());
                consulta.setBoolean(9, iniciosesion.isActivo());
            }
            consulta.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
  
    public int verificarInicio(Connection conexion, String login, String pass) throws SQLException{
        int tipo = 0;
        try {
            PreparedStatement consulta = conexion.prepareStatement("CALL verificariniciosesion(?,?);");
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
            PreparedStatement consulta = conexion.prepareStatement("CALL cambiarpass(?,?,?);");
            consulta.setString(1, login);
            consulta.setString(2, pass);
            consulta.setString(3, newpass);
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next()){
                tipo = Integer.parseInt(resultado.getString("resultado"));
            }
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
        return tipo;
    }
    
    public void cargarDatosUsuario(Connection conexion, String login) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT login, nombre, CONCAT(nombre,' ',apellidop,' ',apellidom) as 'nomcompleto',email, genero, ultimaconexion, tipo FROM iniciosesion WHERE login = ?;");
            consulta.setString(1, login);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                Perfil.pasar(resultado.getString("login"), resultado.getString("nombre"), resultado.getString("nomcompleto"), resultado.getString("email"), resultado.getString("genero"), resultado.getString("ultimaconexion"), resultado.getInt("tipo"));
            }
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
    }
    
    public void aceptarTerminos(Connection conexion, String login) throws SQLDataException{
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM iniciosesion WHERE login = ?;");
            consulta.setString(1, login);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                consulta = conexion.prepareStatement("UPDATE iniciosesion SET terminos = ?, ultimaconexion = ? WHERE login = ?");
                consulta.setBoolean(1, true);
                consulta.setTimestamp(2, Timestamp.from(Instant.now()));
                consulta.setString(3, login);
                consulta.executeUpdate();
            }
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
    }
    
     public List<InicioSesion> recuperarTodos(Connection conexion) throws SQLException{
        List<InicioSesion> iniciosesion = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT login, pass, nombre, apellidop, apellidom, genero, email, tipo, fechacreacion, fechamod, ultimaconexion, activo, terminos FROM iniciosesion;");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                iniciosesion.add(new InicioSesion(resultado.getString("login"), null, resultado.getString("nombre"), resultado.getString("apellidop"), resultado.getString("apellidom"), resultado.getString("genero").charAt(0), resultado.getString("email"), resultado.getInt("tipo"), resultado.getString("fechacreacion"), resultado.getString("fechamod"), resultado.getString("ultimaconexion"), resultado.getBoolean("activo"), resultado.getBoolean("terminos")));
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return iniciosesion;
    }
    
    public int cargarColor(Connection conexion, String login) throws SQLException{
       int color = 0;
        try {
            PreparedStatement consulta = conexion.prepareStatement("CALL cargarcolor(?);");
            consulta.setString(1, login);
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next()){
                color = Integer.parseInt(resultado.getString("color"));
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return color; 
    }
    
    public void guardarColor(Connection conexion, String login, int color) throws SQLException{
        try {
            Colores.setSeleccion(color);
            PreparedStatement consulta = conexion.prepareStatement("CALL guardarcolor(?,?);");
            consulta.setString(1, login);
            consulta.setInt(2, color);
            consulta.executeUpdate();
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
    }
    
    public InicioSesion buscarPorLogin(Connection conexion, String login) throws SQLDataException{
        InicioSesion inicio = null;
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT login, nombre, apellidop, apellidom, genero, email, tipo, fechacreacion, fechamod, ultimaconexion, activo, terminos FROM iniciosesion WHERE login = ?;");
            consulta.setString(1, login);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                inicio = new InicioSesion(resultado.getString("login"), null, resultado.getString("nombre"), resultado.getString("apellidop"), resultado.getString("apellidom"), resultado.getString("genero").charAt(0), resultado.getString("email"), resultado.getInt("tipo"), resultado.getString("fechacreacion"), resultado.getString("fechamod"), resultado.getString("ultimaconexion"), resultado.getBoolean("activo"), resultado.getBoolean("terminos"));
            }
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
        return inicio;
    }
    
    public void eliminarUsuario(Connection conexion, String login) throws SQLDataException{
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT login, nombre, apellidop, apellidom, genero, email, tipo, fechacreacion, fechamod, ultimaconexion, activo, terminos FROM iniciosesion WHERE login = ?;");
            consulta.setString(1, login);
            ResultSet resultado = consulta.executeQuery();
            if (resultado.next()) {
                consulta = conexion.prepareStatement("delete from iniciosesion where login = ?;");
                consulta.setString(1, login);
                consulta.executeUpdate();
            }
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
    }
    
    public List<InicioSesion> busquedaGeneral(Connection conexion, String busqueda) throws SQLException{
        List<InicioSesion> iniciosesion = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT login, pass, nombre, apellidop, apellidom, genero, email, tipo, fechacreacion, fechamod, ultimaconexion, activo, terminos FROM iniciosesion WHERE CONCAT(nombre,' ',apellidop,' ',apellidom,' ',email) like('%"+busqueda+"%');");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                iniciosesion.add(new InicioSesion(resultado.getString("login"), null, resultado.getString("nombre"), resultado.getString("apellidop"), resultado.getString("apellidom"), resultado.getString("genero").charAt(0), resultado.getString("email"), resultado.getInt("tipo"), resultado.getString("fechacreacion"), resultado.getString("fechamod"), resultado.getString("ultimaconexion"), resultado.getBoolean("activo"), resultado.getBoolean("terminos")));
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return iniciosesion;
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
            /*
            int resultado = inicioop.cambiarPassword(Conexion.obtener(), "ChrisRedfield", "Ab12345", "Ab123456");
            System.out.println(resultado);
            */
            //Consultar usuarios
            /*
            List<InicioSesion> sesiones;
            sesiones = inicioop.recuperarTodos(Conexion.obtener());
            for (InicioSesion inicioSesion : sesiones) {
                System.out.println(inicioSesion.toString());
            }
            */
            //Cargar color del perfil
            System.out.println(inicioop.cargarColor(Conexion.obtener(), "nemesis-umbrella"));
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
        
    }
}
