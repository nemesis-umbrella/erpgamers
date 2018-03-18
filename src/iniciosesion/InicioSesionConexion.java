/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniciosesion;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexion.Conexion;
/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class InicioSesionConexion {
    private final String tabla="iniciosesion";
    public void guardar(Connection conexion, InicioSesion iniciosesion) throws SQLException{
        try {
            PreparedStatement consulta;
            
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
    public InicioSesion recuperarPorId(Connection conexion, String login) throws SQLException{
        InicioSesion iniciosesion = null;
        try {
            PreparedStatement consulta = conexion.prepareStatement("select login,nombre,apellidop,apellidom,genero,email,tipo,fechacreacion,fechamod,ultimaconexion,activo,terminos from "+this.tabla+" WHERE login like("+login+");");
            //consulta.setAsciiStream(0, "");
            
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return iniciosesion;
    }
}
