/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniciosesion;

import conexion.Conexion;
import java.awt.Color;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;
import menuprincipal.MenuPrincipal;
import recursos.Imagenes;
import recursos.Colores;
import recursos.Fuente;
import terminos.Licencia;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class FormInicioSesion extends javax.swing.JFrame {

    /**
     * Creates new form InicioSesion
     */
    public FormInicioSesion() {
        initComponents();
        configuracion();
    }

    public void configuracion() {
        setTitle("Inicio de sesión");
        //El siguiente método permite poner un fondo a la ventana
        getContentPane().setBackground(Colores.colorAzul());
        //El siguiente método permite poner un icono a la ventana
        setIconImage(new javax.swing.ImageIcon(getClass().getResource("/Images/icono.png")).getImage());
        //Se asigana una image al jLogo
        jLogo.setIcon(Imagenes.ajustarImagen("src/Images/logogamers_blanco.png", jLogo.getWidth(), jLogo.getHeight()));
        //Este método centra la ventana en la pantalla
        setLocationRelativeTo(null);
        //Se fija la fuente y el color para el label de usuario
        jLabelUsuario.setFont(Fuente.fuenteTexto12());
        jLabelUsuario.setForeground(Color.WHITE);
        //Se fija la fuente y el color para el label de password
        jLabelPassword.setFont(Fuente.fuenteTexto12());
        jLabelPassword.setForeground(Color.WHITE);
        //Se fija el color del textBox usuario
        jTextUsuario.setFont(Fuente.fuenteTexto14());
        jTextUsuario.setForeground(Color.BLUE);
        jTextUsuario.setBackground(Colores.colorBlancoOsc());
        //Se fija el color del JPassword
        jPassword.setFont(Fuente.fuenteTexto14());
        jPassword.setForeground(Color.BLUE);
        jPassword.setBackground(Colores.colorBlancoOsc());
        //Se fija el color para el JButton Iniciar Sesión
        jButtonInicio.setFont(Fuente.fuenteTexto14());
        jButtonInicio.setBackground(Color.WHITE);
        jButtonInicio.setForeground(Color.BLUE);
        //Se fija el color el JLabelCopyRight
        jLabelCopyright.setFont(Fuente.fuenteTexto12());
        jLabelCopyright.setForeground(Color.WHITE);
    }

    private void iniciarsesion() {
        //Realiza la lectura de la contraseña 
        char[] arrayC = jPassword.getPassword();
        //Se convierte el resultado de char[] a String
        String pass = new String(arrayC);
        //Realiza la lectura del usuario
        String user = jTextUsuario.getText();
        if (!user.equals("")) {
            if (!pass.equals("")) {
                InicioSesionOperaciones iniop = new InicioSesionOperaciones();
                try {
                    int respuesta = iniop.verificarInicio(Conexion.obtener(), user.trim(), pass.trim());
                    if (respuesta > 0) {
                        iniop.cargarDatosUsuario(Conexion.obtener(), user);
                        Colores.setSeleccion(iniop.cargarColor(Conexion.obtener(), user));
                        switch (respuesta) {
                            case 1:
                                MenuPrincipal menu = new MenuPrincipal();
                                menu.setVisible(true);
                                menu.setResizable(false);
                                menu.setLocationRelativeTo(null);
                                dispose();
                                break;
                            case 2:
                                JOptionPane.showMessageDialog(null, "Password incorrecto");
                                jPassword.requestFocus();
                                jPassword.selectAll();
                                Perfil.limpiar();
                                break;
                            case 3:
                                JOptionPane.showMessageDialog(null, "No puedes tener acceso al sistema, consulta al administrador");
                                jTextUsuario.setText("");
                                jPassword.setText("");
                                Perfil.limpiar();
                                break;
                            case 4:
                                Licencia lic = new Licencia();
                                lic.setBounds(0, 0, 600, 360);
                                lic.setVisible(true);
                                lic.setResizable(false);
                                lic.setLocationRelativeTo(null);
                                dispose();
                                break;
                            default:
                                break;
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "El usuario no existe");
                        jTextUsuario.requestFocus();
                        jTextUsuario.selectAll();
                    }
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Error: " + e);
                }
            } else {
                JOptionPane.showMessageDialog(null, "Debe ingresar la contraseña");
                jPassword.requestFocus();
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar el usuario");
            jTextUsuario.requestFocus();
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLogo = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jLabelPassword = new javax.swing.JLabel();
        jPassword = new javax.swing.JPasswordField();
        jButtonInicio = new javax.swing.JButton();
        jLabelCopyright = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelUsuario.setText("Usuario: ");

        jTextUsuario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextUsuarioKeyPressed(evt);
            }
        });

        jLabelPassword.setText("Contraseña: ");

        jPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jPasswordKeyPressed(evt);
            }
        });

        jButtonInicio.setText("Iniciar sesión");
        jButtonInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonInicioActionPerformed(evt);
            }
        });

        jLabelCopyright.setText("©2018 Gamers Retail ");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLogo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPassword, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jTextUsuario, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabelUsuario)
                                    .addComponent(jLabelPassword))
                                .addGap(0, 314, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelCopyright)
                    .addComponent(jButtonInicio))
                .addGap(140, 140, 140))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabelUsuario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPassword, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addComponent(jButtonInicio)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                .addComponent(jLabelCopyright)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonInicioActionPerformed
        iniciarsesion();
    }//GEN-LAST:event_jButtonInicioActionPerformed

    private void jTextUsuarioKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextUsuarioKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            jPassword.requestFocus();
        }
    }//GEN-LAST:event_jTextUsuarioKeyPressed

    private void jPasswordKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jPasswordKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            iniciarsesion();
        }
    }//GEN-LAST:event_jPasswordKeyPressed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormInicioSesion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormInicioSesion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JLabel jLabelCopyright;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLogo;
    private javax.swing.JPasswordField jPassword;
    private javax.swing.JTextField jTextUsuario;
    // End of variables declaration//GEN-END:variables
}
