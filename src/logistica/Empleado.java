/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class Empleado {
    private final Integer matemp;
    private final String login;
    private String nombrecompleto;
    private String email;
    public Empleado(){
        matemp = null;
        login = null;
        nombrecompleto = null;
        email = null;
    }
    public Empleado(Integer matemp, String login, String nombrecompleto, String email){
        this.matemp = matemp;
        this.login = login;
        this.nombrecompleto = nombrecompleto;
        this.email = email;
    }

    public Integer getMatemp() {
        return matemp;
    }

    public String getLogin() {
        return login;
    }

    public String getNombrecompleto() {
        return nombrecompleto;
    }

    public void setNombrecompleto(String nombrecompleto) {
        this.nombrecompleto = nombrecompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    @Override
    public String toString(){
        return "Empleado {matemp= "+this.matemp+", login= "+this.login+", nombrecompleto= "+this.nombrecompleto+", email= "+this.email+"}";
    }    
}
