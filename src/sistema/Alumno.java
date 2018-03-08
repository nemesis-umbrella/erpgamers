/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sistema;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class Alumno {
    private final Integer id;

    public Integer getId() {
        return id;
    }
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    
    public Alumno(){
        this.id = null;
        this.nombre = null;
        this.apellidoP = null;
        this.apellidoM = null;
    }
    
    public Alumno(Integer id, String nombre, String apellidoP, String apellidoM){
        this.id = id;
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    } 
    @Override
    public String toString(){
        return "Tarea{" + "id="+id+", nombre="+nombre+", apellidoP="+apellidoP+" ,apellidoM="+apellidoM+"}";
    }
}
