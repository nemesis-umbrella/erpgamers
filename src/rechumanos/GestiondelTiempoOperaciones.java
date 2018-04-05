/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rechumanos;

import logistica.*;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import conexion.Conexion;
import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class GestiondelTiempoOperaciones {

    private final String tabla = "ruta";

    public void guardar(Connection conexion, Ruta ruta) throws SQLException {
        try {
            PreparedStatement consulta;
            if (ruta.getIdruta() == null) {
                consulta = conexion.prepareStatement("INSERT INTO " + this.tabla + "(alias,costo,disponibilidad,descrip,tiempo,fechacreacion) values (?,?,?,?,?,?);");
                consulta.setString(1, ruta.getAlias());
                consulta.setDouble(2, ruta.getCosto());
                consulta.setBoolean(3, ruta.getDisponibilidad());
                consulta.setString(4, ruta.getDescrip());
                consulta.setTime(5, ruta.getTiempo());
                consulta.setTimestamp(6, ruta.getFechacreacion());
            } else {
                consulta = conexion.prepareStatement("UPDATE " + this.tabla + " set alias=?,costo=?,disponibilidad=?,descrip=?,tiempo=?,fechamod=? WHERE idruta=?;");
                consulta.setString(1, ruta.getAlias());
                consulta.setDouble(2, ruta.getCosto());
                consulta.setBoolean(3, ruta.getDisponibilidad());
                consulta.setString(4, ruta.getDescrip());
                consulta.setTime(5, ruta.getTiempo());
                consulta.setTimestamp(6, ruta.getFechamod());
                consulta.setInt(7, ruta.getIdruta());
            }
            consulta.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }

    public Ruta recuperarPorId(Connection conexion, int idruta) throws SQLException {
        Ruta ruta = null;
        boolean verificar = true;
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idruta, alias, costo, disponibilidad, descrip, tiempo, fechacreacion, fechamod FROM ruta WHERE idruta = ?;");
            consulta.setInt(1, idruta);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                ruta = new Ruta(idruta, resultado.getString("alias"), resultado.getDouble("costo"), resultado.getBoolean("disponibilidad"), resultado.getString("descrip"), resultado.getTime("tiempo"), resultado.getTimestamp("fechacreacion"), resultado.getTimestamp("fechamod"));
                verificar = false;
            }
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
        if(verificar){
            ruta = new Ruta();
        }
        return ruta;
    }
    
    public List<Ruta> recuperarVariasPorAlias(Connection conexion, String alias) throws SQLException {
        List<Ruta> rutas = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idruta, alias, costo, disponibilidad, descrip, tiempo, fechacreacion, fechamod FROM ruta WHERE alias like('%"+alias+"%');");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                rutas.add(new Ruta(resultado.getInt("idruta"), resultado.getString("alias"), resultado.getDouble("costo"), resultado.getBoolean("disponibilidad"), resultado.getString("descrip"), resultado.getTime("tiempo"), resultado.getTimestamp("fechacreacion"), resultado.getTimestamp("fechamod")));
            }
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
        return rutas;
    }
    
    public void eliminar(Connection conexion, int idruta) throws SQLException{
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM "+this.tabla+" WHERE idruta = ?;");
            consulta.setInt(1, idruta);
            consulta.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
    
    public List<Ruta> recuperarTodas(Connection conexion) throws SQLException{
        List<Ruta> rutas = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT idruta, alias, costo, disponibilidad, descrip, tiempo, fechacreacion, fechamod FROM ruta;");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                rutas.add(new Ruta(resultado.getInt("idruta"), resultado.getString("alias"), resultado.getDouble("costo"), resultado.getBoolean("disponibilidad"), resultado.getString("descrip"), resultado.getTime("tiempo"), resultado.getTimestamp("fechacreacion"), resultado.getTimestamp("fechamod")));
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return rutas;
    }

    
    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        GestiondelTiempoOperaciones rutaOp = new GestiondelTiempoOperaciones();
        /*
        Ruta ruta;
        ruta = new Ruta(null, "La rancherita", 34000.00, true, "Una ruta extensa", Time.valueOf("05:45:30"), Timestamp.from(Instant.now()), Timestamp.from(Instant.now()));
        rutaOp.guardar(Conexion.obtener(), ruta);
        */
        //Ruta ruta = rutaOp.recuperarPorId(Conexion.obtener(), 1);
        //System.out.println(ruta.toString());
        /*
        System.out.println("Consulta de todas las rutas");
        List<Ruta> rutas = rutaOp.recuperarTodas(Conexion.obtener());
        for (Ruta ruta1 : rutas) {
            System.out.println(ruta1.toString());
        }
        //rutaOp.eliminar(Conexion.obtener(), 2);
        */
        //rutaOp.recuperarVariasPorAlias(Conexion.obtener(), "ruta");
    } 
}
