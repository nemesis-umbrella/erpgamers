/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica;

import conexion.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.time.LocalDateTime;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class VehiculoOperaciones {
    private final String tabla = "vehiculo";

    public void guardar(Connection conexion, Vehiculo vehiculo) throws SQLException {
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT * FROM vehiculo WHERE matveh=?;");
            consulta.setString(1, vehiculo.getMatveh());
            ResultSet resultado = consulta.executeQuery();
            if(resultado.next()){
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " set matemp=?,marca=?,aniofab=?,disponibilidad=?,fechamod=? WHERE matveh=?;");
                consulta.setInt(1, vehiculo.getMatemp());
                consulta.setString(2, vehiculo.getMarca());
                consulta.setInt(3, vehiculo.getAniofab());
                consulta.setBoolean(4, vehiculo.getDisponibilidad());
                consulta.setTimestamp(5, Timestamp.from(Instant.now()));
                consulta.setString(6, vehiculo.getMatveh());
            }
            else{
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(matveh,matemp,marca,aniofab,disponibilidad,fechacreacion) values (?,?,?,?,?,?);");
                consulta.setString(1, vehiculo.getMatveh());
                consulta.setInt(2, vehiculo.getMatemp());
                consulta.setString(3, vehiculo.getMarca());
                consulta.setInt(4, vehiculo.getAniofab());
                consulta.setBoolean(5, vehiculo.getDisponibilidad());
                consulta.setTimestamp(6, Timestamp.from(Instant.now()));
            }
            consulta.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
    public static void main(String[] args){
        VehiculoOperaciones vehop = new VehiculoOperaciones();
        Vehiculo vehiculo = new Vehiculo("ZXN4862",201420484, "VW", 2014, false, null, null);
        try {
            vehop.guardar(Conexion.obtener(), vehiculo);
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
}
