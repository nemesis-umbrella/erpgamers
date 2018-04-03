/*
 * Creado por Jorge L. Mondragón
 * Versión 1.0
 * Creado el 24/02/2018
 */
package menuprincipal;

import acercade.AcercaDe;
import conexion.Conexion;
import iniciosesion.DialogPerfil;
import iniciosesion.FormInicioSesion;
import iniciosesion.FormUsuarios;
import iniciosesion.InicioSesionOperaciones;
import iniciosesion.Perfil;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import recursos.Colores;
import recursos.Imagenes;
import recursos.Fuente;
import logistica.Logistica;
/**
 *
 * @author nemesis-umbrella
 */
public class MenuPrincipal extends javax.swing.JFrame {

    /**
     * Creates new form MenuPrincipal
     */
    public MenuPrincipal() {
        initComponents();
        cargarDisenio();
    }
    
    public void cargarDisenio(){
        //Cofiguración de la ventana
        setTitle("Menú principal");
        setIconImage(new ImageIcon(getClass().getResource("/Images/icono.png")).getImage());
        getContentPane().setBackground(Colores.cargarColor());
        setLocationRelativeTo(null);
        
        //Configuración del menubar
        jMenuPerfil.setIcon(new ImageIcon(getClass().getResource("/Images/menu/icon-user.png")));
        jMenuColor.setIcon(new ImageIcon(getClass().getResource("/Images/menu/fondo.png")));
        jMenuCerrarSesion.setIcon(new ImageIcon(getClass().getResource("/Images/menu/cerrar.png")));
        jMenuSalir.setIcon(new ImageIcon(getClass().getResource("/Images/menu/salir.png")));
        jMenuAcercaDe.setIcon(new ImageIcon(getClass().getResource("/Images/menu/acerca.png")));
        jMenuDefualt.setIcon(new ImageIcon(getClass().getResource("/Images/menu/colorAzul.png")));
        jMenuNegro.setIcon(new ImageIcon(getClass().getResource("/Images/menu/colorNegro.png")));
        jMenuMorado.setIcon(new ImageIcon(getClass().getResource("/Images/menu/colorMorado.png")));
        jMenuRojo.setIcon(new ImageIcon(getClass().getResource("/Images/menu/colorRojo.png")));
        
        //Carga de imagenes en los labels
        jLabelLogo.setIcon(Imagenes.ajustarImagen("src/Images/logogamers_blanco.png", jLabelLogo.getWidth(), jLabelLogo.getHeight()));
        //Cargar de fuente a los labels
        //Título del formulario
        jLabelTitulo.setFont(Fuente.fuenteTitulos());
        jLabelTitulo.setForeground(Color.WHITE);
        //Label de bienvenido
        jLabelBienvenido.setFont(Fuente.fuenteTitulos());
        jLabelBienvenido.setForeground(Color.WHITE);
        jLabelBienvenido.setText("Bienvenido: "+Perfil.getNombre());
        //Label de recursos humanos
        jLabelRecHum.setFont(Fuente.fuenteTexto14());
        jLabelRecHum.setForeground(Color.WHITE);
        //Label de conta
        jLabelConta.setFont(Fuente.fuenteTexto14());
        jLabelConta.setForeground(Color.WHITE);
        //Label de logística
        jLabelLogistica.setFont(Fuente.fuenteTexto14());
        jLabelLogistica.setForeground(Color.WHITE);
        //Label de producto
        jLabelProducto.setFont(Fuente.fuenteTexto14());
        jLabelProducto.setForeground(Color.WHITE);
        //Label de nomina
        jLabelNomina.setFont(Fuente.fuenteTexto14());
        jLabelNomina.setForeground(Color.WHITE);
        //Label de nomina
        jLabelUsuarios.setFont(Fuente.fuenteTexto14());
        jLabelUsuarios.setForeground(Color.WHITE);
        //Label de derechos reservados
        jLabelDerechos.setFont(Fuente.fuenteTexto14());
        jLabelDerechos.setForeground(Color.WHITE);
        
        //Diseño de los botones
        //Botón de recursos humanos
        jButtonRecHum.setIcon(Imagenes.ajustarImagen("src/Images/menuprincipal/rechum.png", jButtonRecHum.getWidth(), jButtonRecHum.getHeight()));
        jButtonRecHum.setBackground(Colores.colorBlancoOsc());
        //Botón de contabilidad
        jButtonConta.setIcon(Imagenes.ajustarImagen("src/Images/menuprincipal/conta.png", jButtonRecHum.getWidth(), jButtonRecHum.getHeight()));
        jButtonConta.setBackground(Colores.colorBlancoOsc());
        //Botón de logística
        jButtonLogistica.setIcon(Imagenes.ajustarImagen("src/Images/menuprincipal/logistica.png", jButtonRecHum.getWidth(), jButtonRecHum.getHeight()));
        jButtonLogistica.setBackground(Colores.colorBlancoOsc());
        //Botón de Producto
        jButtonProducto.setIcon(Imagenes.ajustarImagen("src/Images/menuprincipal/producto.png", jButtonRecHum.getWidth(), jButtonRecHum.getHeight()));
        jButtonProducto.setBackground(Colores.colorBlancoOsc());
        //Botón de nomina
        jButtonNomina.setIcon(Imagenes.ajustarImagen("src/Images/menuprincipal/nomina.png", jButtonRecHum.getWidth(), jButtonRecHum.getHeight()));
        jButtonNomina.setBackground(Colores.colorBlancoOsc());
        
        //Botón de usuarios
        jButtonUsuarios.setIcon(Imagenes.ajustarImagen("src/Images/menuprincipal/usuarios.png", jButtonRecHum.getWidth(), jButtonRecHum.getHeight()));
        jButtonUsuarios.setBackground(Colores.colorBlancoOsc());
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabelLogo = new javax.swing.JLabel();
        jLabelBienvenido = new javax.swing.JLabel();
        jLabelTitulo = new javax.swing.JLabel();
        jButtonRecHum = new javax.swing.JButton();
        jLabelRecHum = new javax.swing.JLabel();
        jButtonConta = new javax.swing.JButton();
        jLabelConta = new javax.swing.JLabel();
        jButtonLogistica = new javax.swing.JButton();
        jLabelLogistica = new javax.swing.JLabel();
        jButtonProducto = new javax.swing.JButton();
        jLabelProducto = new javax.swing.JLabel();
        jButtonNomina = new javax.swing.JButton();
        jLabelNomina = new javax.swing.JLabel();
        jLabelDerechos = new javax.swing.JLabel();
        jButtonUsuarios = new javax.swing.JButton();
        jLabelUsuarios = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuPerfil = new javax.swing.JMenuItem();
        jMenuColor = new javax.swing.JMenu();
        jMenuDefualt = new javax.swing.JMenuItem();
        jMenuNegro = new javax.swing.JMenuItem();
        jMenuRojo = new javax.swing.JMenuItem();
        jMenuMorado = new javax.swing.JMenuItem();
        jMenuCerrarSesion = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelLogo.setToolTipText("");

        jLabelBienvenido.setText("Bienvenido: Nombre");

        jLabelTitulo.setText("Menú");

        jLabelRecHum.setText("Recursos humanos");

        jLabelConta.setText("Contabilidad");

        jButtonLogistica.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLogisticaActionPerformed(evt);
            }
        });

        jLabelLogistica.setText("Logística");

        jLabelProducto.setText("Producto");

        jLabelNomina.setText("Nómina");

        jLabelDerechos.setText("Copyright © GamersRetail  | Todos los derechos reservados");

        jButtonUsuarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonUsuariosActionPerformed(evt);
            }
        });

        jLabelUsuarios.setText("Usuarios");

        jMenu1.setText("Opciones");

        jMenuPerfil.setText("Perfil");
        jMenuPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPerfilActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuPerfil);

        jMenuColor.setText("Color de fondo");

        jMenuDefualt.setText("Default");
        jMenuDefualt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuDefualtActionPerformed(evt);
            }
        });
        jMenuColor.add(jMenuDefualt);

        jMenuNegro.setText("Negro");
        jMenuNegro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuNegroActionPerformed(evt);
            }
        });
        jMenuColor.add(jMenuNegro);

        jMenuRojo.setText("Rojo");
        jMenuRojo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuRojoActionPerformed(evt);
            }
        });
        jMenuColor.add(jMenuRojo);

        jMenuMorado.setText("Morado");
        jMenuMorado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuMoradoActionPerformed(evt);
            }
        });
        jMenuColor.add(jMenuMorado);

        jMenu1.add(jMenuColor);

        jMenuCerrarSesion.setText("Cerrar sesión");
        jMenuCerrarSesion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuCerrarSesionActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuCerrarSesion);

        jMenuSalir.setText("Salir");
        jMenuSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuSalirActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuSalir);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("Ayuda");

        jMenuAcercaDe.setText("Acerca de");
        jMenuAcercaDe.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuAcercaDeActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuAcercaDe);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(94, 94, 94)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonRecHum, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(9, 9, 9)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelRecHum)
                            .addComponent(jButtonProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabelProducto)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 80, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButtonConta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonNomina, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelConta)
                        .addGap(33, 33, 33))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabelNomina)
                        .addGap(61, 61, 61)))
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jButtonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jButtonLogistica, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabelUsuarios)))
                        .addGap(116, 116, 116))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelLogistica)
                        .addGap(134, 134, 134))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelBienvenido))
                .addGap(33, 33, 33))
            .addGroup(layout.createSequentialGroup()
                .addGap(160, 160, 160)
                .addComponent(jLabelDerechos)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(jLabelBienvenido))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonLogistica, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelLogistica)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonUsuarios, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelUsuarios))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonConta, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelConta)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabelNomina))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButtonRecHum, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelRecHum)
                        .addGap(18, 18, 18)
                        .addComponent(jButtonProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelProducto)))
                .addGap(18, 18, 18)
                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabelDerechos)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonLogisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogisticaActionPerformed
        Logistica logistica = new Logistica();
        logistica.setVisible(true);
        logistica.setResizable(false);
        logistica.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_jButtonLogisticaActionPerformed

    private void jMenuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPerfilActionPerformed
        new iniciosesion.DialogPerfil(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuPerfilActionPerformed

    private void jMenuDefualtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDefualtActionPerformed
        //Se encarga de guardar y mostrar el color seleccionado por el usuario
        String error = recursos.Colores.guardarColorNuevo(0);
        getContentPane().setBackground(recursos.Colores.cargarColor());
        if(!error.equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Error: "+error);
        }
    }//GEN-LAST:event_jMenuDefualtActionPerformed

    private void jMenuNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNegroActionPerformed
        //Se encarga de guardar y mostrar el color seleccionado por el usuario
        String error = recursos.Colores.guardarColorNuevo(1);
        getContentPane().setBackground(recursos.Colores.cargarColor());
        if(!error.equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Error: "+error);
        }
    }//GEN-LAST:event_jMenuNegroActionPerformed

    private void jMenuRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRojoActionPerformed
        //Se encarga de guardar y mostrar el color seleccionado por el usuario
        String error = recursos.Colores.guardarColorNuevo(2);
        getContentPane().setBackground(recursos.Colores.cargarColor());
        if(!error.equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Error: "+error);
        }
    }//GEN-LAST:event_jMenuRojoActionPerformed

    private void jMenuMoradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMoradoActionPerformed
        //Se encarga de guardar y mostrar el color seleccionado por el usuario
        String error = recursos.Colores.guardarColorNuevo(3);
        getContentPane().setBackground(recursos.Colores.cargarColor());
        if(!error.equals("")){
            javax.swing.JOptionPane.showMessageDialog(null, "Error: "+error);
        }
    }//GEN-LAST:event_jMenuMoradoActionPerformed

    private void jMenuCerrarSesionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuCerrarSesionActionPerformed
        int reply = javax.swing.JOptionPane.showConfirmDialog(null, "¿Estás seguro(a) que deseas cerrar sesión?", "Cerrar sesión", javax.swing.JOptionPane.YES_NO_OPTION);
        if (reply == javax.swing.JOptionPane.YES_OPTION) {
            iniciosesion.Perfil.limpiar();
            iniciosesion.FormInicioSesion inicio = new iniciosesion.FormInicioSesion();
            inicio.setVisible(true);
            dispose();
        }
    }//GEN-LAST:event_jMenuCerrarSesionActionPerformed

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        int reply = javax.swing.JOptionPane.showConfirmDialog(null, "¿Estás seguro(a) que deseas salir?", "Cerrar sesión", javax.swing.JOptionPane.YES_NO_OPTION);
        if (reply == javax.swing.JOptionPane.YES_OPTION) {
            System.exit(0);
        }
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jMenuAcercaDeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuAcercaDeActionPerformed
        new acercade.AcercaDe(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuAcercaDeActionPerformed

    private void jButtonUsuariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonUsuariosActionPerformed
        FormUsuarios usuarios = new FormUsuarios();
        usuarios.setVisible(true);
        usuarios.setResizable(false);
        usuarios.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_jButtonUsuariosActionPerformed

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
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MenuPrincipal principal =  new MenuPrincipal();
                principal.setVisible(true);
                principal.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonConta;
    private javax.swing.JButton jButtonLogistica;
    private javax.swing.JButton jButtonNomina;
    private javax.swing.JButton jButtonProducto;
    private javax.swing.JButton jButtonRecHum;
    private javax.swing.JButton jButtonUsuarios;
    private javax.swing.JLabel jLabelBienvenido;
    private javax.swing.JLabel jLabelConta;
    private javax.swing.JLabel jLabelDerechos;
    private javax.swing.JLabel jLabelLogistica;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNomina;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelRecHum;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelUsuarios;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuAcercaDe;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCerrarSesion;
    private javax.swing.JMenu jMenuColor;
    private javax.swing.JMenuItem jMenuDefualt;
    private javax.swing.JMenuItem jMenuMorado;
    private javax.swing.JMenuItem jMenuNegro;
    private javax.swing.JMenuItem jMenuPerfil;
    private javax.swing.JMenuItem jMenuRojo;
    private javax.swing.JMenuItem jMenuSalir;
    // End of variables declaration//GEN-END:variables
}
