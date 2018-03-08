/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conexion.Conexion;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class Ejemplo {
    //El código que se va a mostra a continuación es para hacer pruebas de 
    //Conexión a MySQL
    private final String tabla = "alumno";
    public void guardar(Connection conexion, Alumno alumno) throws SQLException{
        try {
            PreparedStatement consulta;
            if(alumno.getId()==null){
                consulta = conexion.prepareStatement("INSERT INTO "+this.tabla+"(nombre,apellidoP,apellidoM) VALUES(?,?,?)");
                consulta.setString(1, alumno.getNombre());
                consulta.setString(2, alumno.getApellidoP());
                consulta.setString(3, alumno.getApellidoM());
            }else{
                consulta = conexion.prepareStatement("UPDATE" + this.tabla + "SET nombre = ?, apellidoP = ?, apellidoM = ? WHERE id = ?");
                consulta.setString(1, alumno.getNombre());
                consulta.setString(2, alumno.getApellidoP());
                consulta.setString(3, alumno.getApellidoM());
                consulta.setInt(4, alumno.getId());
            }
            consulta.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
    public Alumno recuperarPorId(Connection conexion, int id) throws SQLException{
        Alumno alumno = null;
        try {
            PreparedStatement consulta = conexion.prepareStatement("select nombre, apellidoP, apellidoM FROM "+this.tabla+" WHERE id = ?");
            consulta.setInt(1, id);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                alumno = new Alumno(id,resultado.getString("nombre"), resultado.getString("apellidoP"), resultado.getString("apellidoM"));               
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return alumno;
    }
    public void eliminar(Connection conexion, int id) throws SQLException{
        try {
            PreparedStatement consulta = conexion.prepareStatement("DELETE FROM "+ this.tabla+" WHERE id = ?");
            consulta.setInt(1, id);
            consulta.executeUpdate();
        } catch (Exception e) {
            throw new SQLException(e);
        }
    }
    public List<Alumno> recuperarTodas(Connection conexion) throws SQLException{
        List<Alumno> alumnos = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT id, nombre, apellidoP, apellidoM FROM "+ this.tabla);
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                alumnos.add(new Alumno(resultado.getInt("id"),resultado.getString("nombre"),resultado.getString("apellidoP"),resultado.getString("apellidoM")));
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return alumnos;
    }
    public static void main(String[] args) throws SQLException, ClassNotFoundException{
        Ejemplo ejemplo = new Ejemplo();
        //Búsqueda de un alumno por ID
        Alumno alum = ejemplo.recuperarPorId(Conexion.obtener(), 1);
        System.out.println("Nombre: "+alum.getNombre());
        System.out.println("Apellido paterno: "+alum.getApellidoP());
        System.out.println("Apellido materno: "+alum.getApellidoM());
        //Búsqueda de toda la tabla
        System.out.println("Consulta toda la tabla");
        List<Alumno> alumnos = ejemplo.recuperarTodas(Conexion.obtener());
        for (Alumno alumno : alumnos) {
            System.out.println("Id: "+alumno.getId());
            System.out.println("Nombre: "+alumno.getNombre());
            System.out.println("Apellido paterno: "+alumno.getApellidoP());
            System.out.println("Apellido materno: "+alumno.getApellidoM());
        }
        //Guardar alumno
        /*
        System.out.println("Guardado de alumno");
        Alumno alumnoN = new Alumno();
        alumnoN.setNombre("Diego");
        alumnoN.setApellidoP("Escalona");
        alumnoN.setApellidoM("Gómez");
        ejemplo.guardar(Conexion.obtener(), alumnoN);
        */
        //Eliminación del alumno
        /*
        ejemplo.eliminar(Conexion.obtener(), 3);
        */
    }
}
