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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class EmpleadoOperaciones {
    //Este método recupera a todos los empleados
    public List<Empleado> recuperarTodas(Connection conexion) throws SQLException{
        List<Empleado> empleados = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT e.matemp, i.login, CONCAT(i.nombre,' ',i.apellidop,' ',i.apellidom) As 'nombrecompleto', i.email FROM empleado e INNER JOIN iniciosesion i ON e.login = i.login;");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                empleados.add(new Empleado(resultado.getInt("matemp"), resultado.getString("login"), resultado.getString("nombrecompleto"), resultado.getString("email")));
            }
        } catch (Exception e) {
            throw new SQLException(e);
        }
        return empleados;
    }
    
    //Este método recupera al empleado por la matricula
    public Empleado recuperarPorMatEmp(Connection conexion, int matemp) throws SQLException {
        Empleado empleado = null;
        boolean verificar = true;
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT e.matemp, i.login, CONCAT(i.nombre,' ',i.apellidop,' ',i.apellidom) As 'nombrecompleto', i.email FROM empleado e INNER JOIN iniciosesion i ON e.login = i.login WHERE matemp = ?;");
            consulta.setInt(1, matemp);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                empleado = new Empleado(resultado.getInt("matemp"), resultado.getString("login"), resultado.getString("nombrecompleto"), resultado.getString("email"));
                verificar = false;
            }
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
        if(verificar){
            empleado = new Empleado();
        }
        return empleado;
    }
    
    //Método encargado de encontrar varias por nombre
    public List<Empleado> recuperarVariasPorBusqueda(Connection conexion, String buscar) throws SQLException {
        List<Empleado> empleados = new ArrayList<>();
        try {
            PreparedStatement consulta = conexion.prepareStatement("SELECT e.matemp, i.login, CONCAT(i.nombre,' ',i.apellidop,' ',i.apellidom) As 'nombrecompleto', i.email FROM empleado e INNER JOIN iniciosesion i ON e.login = i.login WHERE CONCAT(i.login,' ',i.nombre,' ',i.apellidop,' ',i.apellidom,' ',i.email) like('%"+buscar+"%');");
            ResultSet resultado = consulta.executeQuery();
            while(resultado.next()){
                empleados.add(new Empleado(resultado.getInt("matemp"), resultado.getString("login"), resultado.getString("nombrecompleto"), resultado.getString("email")));
            }
        } catch (Exception e) {
            throw new SQLDataException(e);
        }
        return empleados;
    }
    
    public static void main(String[] args){
        EmpleadoOperaciones empop = new EmpleadoOperaciones();
        try {
            //Ejemplo de como obtener varios empleados
            /*
            List<Empleado> empleados;
            empleados = empop.recuperarTodas(Conexion.obtener());
            for (Empleado empleado : empleados) {
                System.out.println(empleado.toString());
            }
            */
            //Ejemplo de búsqueda por matemp
            /*
            Empleado empleado;
            empleado = empop.recuperarPorMatEmp(Conexion.obtener(), 201420485);
            System.out.println(empleado.toString());
            */
            //Ejemplo de búsqueda general, se puede ingresar nombre, apellido, usuario o correo electrónico
            /*
            List<Empleado> empleados;
            String buscar = "jill";
            empleados = empop.recuperarVariasPorBusqueda(Conexion.obtener(), buscar);
            for (Empleado empleado : empleados) {
                System.out.println(empleado.toString());
            }
            */
        } catch (Exception e) {
            System.out.println("Error: "+e);
        }        
    }
}