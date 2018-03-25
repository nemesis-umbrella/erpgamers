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
import java.sql.SQLDataException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

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
    
    public Vehiculo recuperarPorMatVeh(Connection conexion, String matveh) throws SQLException {
        Vehiculo vehiculo = null;
        boolean verificar = true;
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT matveh, matemp, marca, aniofab, disponibilidad, fechacreacion, fechamod FROM vehiculo WHERE matveh = ?;");
            consulta.setString(1, matveh);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                vehiculo = new Vehiculo(resultado.getString("matveh"), resultado.getInt("matemp"), resultado.getString("marca"), resultado.getInt("aniofab"), resultado.getBoolean("disponibilidad"), resultado.getTimestamp("fechacreacion"), resultado.getTimestamp("fechamod"));
                verificar = false;
            }
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
        if(verificar){
            vehiculo = new Vehiculo();
        }
        return vehiculo;
    }
    
    public List<Vehiculo> recuperarVariasPorMatEmp(Connection conexion, int matemp) throws SQLException {
        List<Vehiculo> vehiculos = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT matveh, matemp, marca, aniofab, disponibilidad, fechacreacion, fechamod FROM vehiculo WHERE matemp = ?;");
            consulta.setInt(1, matemp);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                vehiculos.add(new Vehiculo(resultado.getString("matveh"), resultado.getInt("matemp"), resultado.getString("marca"), resultado.getInt("aniofab"), resultado.getBoolean("disponibilidad"), resultado.getTimestamp("fechacreacion"), resultado.getTimestamp("fechamod")));
            }
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
        return vehiculos;
    }
    
    public void eliminar(Connection conexion, String matveh) throws SQLException{
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM "+this.tabla+" WHERE matveh = ?;");
            consulta.setString(1, matveh);
            consulta.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
    
    public List<Vehiculo> recuperarTodas(Connection conexion) throws SQLException{
        List<Vehiculo> vehiculos = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT matveh, matemp, marca, aniofab, disponibilidad, fechacreacion, fechamod FROM vehiculo;");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                vehiculos.add(new Vehiculo(resultado.getString("matveh"), resultado.getInt("matemp"), resultado.getString("marca"), resultado.getInt("aniofab"), resultado.getBoolean("disponibilidad"), resultado.getTimestamp("fechacreacion"), resultado.getTimestamp("fechamod")));
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return vehiculos;
    }
    public static void main(String[] args){
        VehiculoOperaciones vehop = new VehiculoOperaciones();
        try {
            //Este ejemplo guarda un vehiculo en la tabla vehiculo.
            /*
            Vehiculo vehiculo = new Vehiculo("RX85J28",201420484, "Ford", 2016, true, null, null);
            vehop.guardar(Conexion.obtener(), vehiculo);
            */
            /*
            //Este ejemplo devuelve la consulta de un vehiculo a través del campo matveh
            Vehiculo vehiculo;
            vehiculo = vehop.recuperarPorMatVeh(Conexion.obtener(), "ZXN4862");
            System.out.println(vehiculo.toString()); 
            */
            //Este ejemplo consulta varios vehiculos a través de la mat. del empleado
            /*
            List<Vehiculo> vehiculos;
            vehiculos = vehop.recuperarVariasPorMatEmp(Conexion.obtener(), 201420484);
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo.toString());
            }
            */
            //Ejemplo de como eliminar un vehiculo
            /*
            vehop.eliminar(Conexion.obtener(), "RX85J28");
            */
            //Ejemplo de consultar todos los vehiculos
            /*
            List<Vehiculo> vehiculos;
            vehiculos = vehop.recuperarTodas(Conexion.obtener());
            for (Vehiculo vehiculo : vehiculos) {
                System.out.println(vehiculo.toString());
            }
            */
            
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }
    }
}
