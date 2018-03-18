/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package terminos;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import recursos.Imagenes;
import menuprincipal.MenuPrincipal;
import iniciosesion.FormInicioSesion;
/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class Licencia extends JFrame implements ActionListener, ChangeListener {

    private JCheckBox check1;
    private JLabel label1, label2;
    private JTextArea textArea1;
    private JScrollPane scrollPane1;
    private JButton boton1, boton2;
    String nombre = "";

    public Licencia() {
        //Elementos de la ventana
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("Licencia de uso");
        setIconImage(new ImageIcon(getClass().getResource("/Images/icono.png")).getImage());
        nombre = "Usuario"; //Esta línea debe contener el nombre del usuario

        //Label terminos y condiciones
        label1 = new JLabel("TÉRMINOS Y CONDICIONES");
        label1.setBounds(215, 5, 200, 30);
        label1.setFont(new Font("Andale Mono", 1, 14));
        label1.setForeground(new Color(0, 0, 0));
        add(label1);

        //Se agrega el textArea con terminos y condiciones
        textArea1 = new JTextArea();
        textArea1.setEditable(false);
        textArea1.setFont(new Font("Andale Mono", 0, 9));
        textArea1.setText("\n\n       TÉRMINOS Y CONDICIONES"
                + "\n\n         A. PROHIBIDA SU VENTA O DISTRIBUCIÓN SIN AUTORIZACIÓN DE UMBRELLA CORPORATION"
                + "\n         B. PROHIBIDA LA ALTERACIÓN DEL CÓDIGO FUENTE O DISEÑO DE LA INTERFAZ GRÁFICA"
                + "\n         C. UMBRELLA CORPORATION NO SE HACE RESPONSABLE DEL MAL USO DE ESTE SOFTWARE"
                + "\n\n         LOS ACUERDOS LEGALES EXPUESTOS A CONTINUACIÓN RIGE EL USO QUE USTED HAGA DE ESTE SOFTWARE"
                + "\n         (UMBRELLA CORPORATION Y EL AUTOR ALBERT WESKER), NO SE RESPONSABILIZAN DEL USO QUE USTED"
                + "\n         HAGA DE ESTE SOFTWARE Y SUS SERVICIOS. PARA ACEPTAR ESTOS TÉRMINOS HAGA CLIC EN (ACEPTO)"
                + "\n         SI USTED NO ACEPTA ESTOS TERMINOS, HAGA CLIC EN (NO ACEPTO) Y NO UTILICE ESTE SOFTWARE."
                + "\n\n        PARA MAYOR INFORMACIÓN SOBRE NUESTROS PRODUCTOS O SERVICIOS, POR FAVOR VISITE"
                + "\n         http://www.umbrella.com");

        scrollPane1 = new JScrollPane(textArea1);
        scrollPane1.setBounds(10, 40, 575, 200);
        add(scrollPane1);

        //CheckBox de aceptar condiciones
        check1 = new JCheckBox("Yo " + nombre + " Acepto.");
        check1.setBounds(10, 250, 300, 30);
        check1.addChangeListener(this);
        add(check1);

        //Se agregan los botones
        boton1 = new JButton("Continuar");
        boton1.setBounds(10, 290, 100, 30);
        boton1.addActionListener(this);
        boton1.setEnabled(false);
        add(boton1);

        boton2 = new JButton("No acepto");
        boton2.setBounds(120, 290, 100, 30);
        boton2.addActionListener(this);
        boton2.setEnabled(true);
        add(boton2);

        //Se agrega imagen corpotativ
        label2 = new JLabel("");
        label2.setBounds(380, 235, 180, 105);
        label2.setIcon(Imagenes.ajustarImagen("src/Images/logogamers_blanco.png", label2.getWidth(), label2.getHeight()));
        add(label2);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == boton1) {
            cargarMenuPrincipal();
        } else if (e.getSource() == boton2) {
            cargarInicioSesion();
        }
    }

    @Override
    public void stateChanged(ChangeEvent e) {
        if (check1.isSelected() == true) {
            boton1.setEnabled(true);
            boton2.setEnabled(false);
        } else {
            boton1.setEnabled(false);
            boton2.setEnabled(true);
        }
    }

    public void cargarMenuPrincipal() {
        MenuPrincipal princ = new MenuPrincipal();
        princ.setVisible(true);
        princ.setResizable(false);
        princ.setLocationRelativeTo(null);
        dispose();
    }

    public void cargarInicioSesion(){
        FormInicioSesion princ = new FormInicioSesion();
        princ.setVisible(true);
        princ.setResizable(false);
        princ.setLocationRelativeTo(null);
        dispose();
    }
    public static void main(String[] args) {
        Licencia lic = new Licencia();
        lic.setBounds(0, 0, 600, 360);
        lic.setVisible(true);
        lic.setResizable(false);
        lic.setLocationRelativeTo(null);
    }
}
