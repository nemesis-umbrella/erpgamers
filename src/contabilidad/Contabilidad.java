/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contabilidad;

import java.awt.Color;
import recursos.Colores;
import recursos.Fuente;
import recursos.Imagenes;

/**
 *
 * @author poron
 */
public class Contabilidad extends javax.swing.JFrame {

    /**
     * Creates new form Contabilidad
     */
    public Contabilidad() {
        initComponents();
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
        jPassword.setFont(Fuente.fuenteTexto12());
        jPassword.setForeground(Color.WHITE);
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
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLogo = new javax.swing.JLabel();
        jLabelUsuario = new javax.swing.JLabel();
        jLabelPassword = new javax.swing.JLabel();
        jTextUsuario = new javax.swing.JTextField();
        jPassword = new javax.swing.JTextField();
        jButtonInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(jLogo, new org.netbeans.lib.awtextra.AbsoluteConstraints(24, 11, 356, 150));

        jLabelUsuario.setText("Usuario");
        getContentPane().add(jLabelUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jLabelPassword.setText("Contraseña");
        getContentPane().add(jLabelPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 240, -1, -1));
        getContentPane().add(jTextUsuario, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 200, 330, -1));
        getContentPane().add(jPassword, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 270, 330, -1));

        jButtonInicio.setText("Iniciar Sesion");
        getContentPane().add(jButtonInicio, new org.netbeans.lib.awtextra.AbsoluteConstraints(150, 310, -1, -1));

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Contabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Contabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Contabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Contabilidad.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Contabilidad().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonInicio;
    private javax.swing.JLabel jLabelPassword;
    private javax.swing.JLabel jLabelUsuario;
    private javax.swing.JLabel jLogo;
    private javax.swing.JTextField jPassword;
    private javax.swing.JTextField jTextUsuario;
    // End of variables declaration//GEN-END:variables
}
