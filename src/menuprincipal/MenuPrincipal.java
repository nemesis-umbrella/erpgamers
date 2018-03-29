/*
 * Creado por Jorge L. Mondragón
 * Versión 1.0
 * Creado el 24/02/2018
 */
package menuprincipal;

import java.awt.Color;
import javax.swing.ImageIcon;
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
        getContentPane().setBackground(Colores.colorAzul());
        
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

        jLabelNomina.setText("Nomina");

        jLabelDerechos.setText("Copyright © GamersRetail  | Todos los derechos reservados");

        jMenu1.setText("Opciones");

        jMenuPerfil.setText("Perfil");
        jMenu1.add(jMenuPerfil);

        jMenuColor.setText("Color de fondo");

        jMenuDefualt.setText("Default");
        jMenuColor.add(jMenuDefualt);

        jMenuNegro.setText("Negro");
        jMenuColor.add(jMenuNegro);

        jMenuRojo.setText("Rojo");
        jMenuColor.add(jMenuRojo);

        jMenuMorado.setText("Morado");
        jMenuColor.add(jMenuMorado);

        jMenu1.add(jMenuColor);

        jMenuCerrarSesion.setText("Cerrar sesión");
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
        jMenu2.add(jMenuAcercaDe);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabelBienvenido)
                .addGap(145, 145, 145))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(33, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jButtonRecHum, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jButtonConta, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(9, 9, 9)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabelRecHum)
                                            .addGap(65, 65, 65)
                                            .addComponent(jLabelConta))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jButtonProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(33, 33, 33)
                                            .addComponent(jButtonNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(46, 46, 46)
                                .addComponent(jLabelProducto)
                                .addGap(108, 108, 108)
                                .addComponent(jLabelNomina)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(jButtonLogistica, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(78, 78, 78)
                                .addComponent(jLabelLogistica))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addComponent(jLabelDerechos)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelTitulo)
                    .addComponent(jLabelBienvenido))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButtonRecHum, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonConta, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonLogistica, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelRecHum))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(jLabelLogistica))))
                    .addComponent(jLabelConta))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelProducto))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonNomina, javax.swing.GroupLayout.PREFERRED_SIZE, 107, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabelNomina)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelLogo, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(30, 30, 30)))
                .addComponent(jLabelDerechos)
                .addGap(30, 30, 30))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuSalirActionPerformed
        System.exit(0);
    }//GEN-LAST:event_jMenuSalirActionPerformed

    private void jButtonLogisticaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonLogisticaActionPerformed
        Logistica logistica = new Logistica();
        logistica.setVisible(true);
        logistica.setResizable(false);
        logistica.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_jButtonLogisticaActionPerformed

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
    private javax.swing.JLabel jLabelBienvenido;
    private javax.swing.JLabel jLabelConta;
    private javax.swing.JLabel jLabelDerechos;
    private javax.swing.JLabel jLabelLogistica;
    private javax.swing.JLabel jLabelLogo;
    private javax.swing.JLabel jLabelNomina;
    private javax.swing.JLabel jLabelProducto;
    private javax.swing.JLabel jLabelRecHum;
    private javax.swing.JLabel jLabelTitulo;
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
