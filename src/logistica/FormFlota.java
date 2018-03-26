/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica;

import conexion.Conexion;
import java.awt.Color;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import recursos.Colores;
import recursos.Fuente;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class FormFlota extends javax.swing.JFrame {
    VehiculoOperaciones vehop = new VehiculoOperaciones();
    /**
     * Creates new form Flota
     */
    public FormFlota() {
        initComponents();
        cargarConf();
        inicioTabla();
        cargarDatos();
    }

    public void cargarConf(){
         //Cofiguración de la ventana
        setTitle("Flota");
        setIconImage(new ImageIcon(getClass().getResource("/Images/icono.png")).getImage());
        getContentPane().setBackground(Colores.colorAzul());
        setLocationRelativeTo(null);
        
        //Configuración del menubar
        jMenuPerfil.setIcon(new ImageIcon(getClass().getResource("/Images/menu/icon-user.png")));
        jMenuColor.setIcon(new ImageIcon(getClass().getResource("/Images/menu/fondo.png")));
        jMenuCerrarSesion.setIcon(new ImageIcon(getClass().getResource("/Images/menu/cerrar.png")));
        jMenuSalir.setIcon(new ImageIcon(getClass().getResource("/Images/menu/salir.png")));
        jMenuAcercaDe.setIcon(new ImageIcon(getClass().getResource("/Images/menu/acerca.png")));
        jMenuDefault.setIcon(new ImageIcon(getClass().getResource("/Images/menu/colorAzul.png")));
        jMenuNegro.setIcon(new ImageIcon(getClass().getResource("/Images/menu/colorNegro.png")));
        jMenuMorado.setIcon(new ImageIcon(getClass().getResource("/Images/menu/colorMorado.png")));
        jMenuRojo.setIcon(new ImageIcon(getClass().getResource("/Images/menu/colorRojo.png")));

        //Configuración de Labels 
        //Título del formulario
        jLabelTitulo.setFont(Fuente.fuenteTitulos());
        jLabelTitulo.setForeground(Color.WHITE);
        
        //Configuración de búsqueda general
        jLabelBusqGeneral.setFont(Fuente.fuenteTexto14());
        jLabelBusqGeneral.setForeground(Color.WHITE);

        jTextFieldBusqMarc.setFont(Fuente.fuenteTexto12());
        jTextFieldBusqMarc.setForeground(Color.BLUE);
        jTextFieldBusqMarc.setBackground(Colores.colorBlancoOsc());

        jButtonBusqMarc.setFont(Fuente.fuenteTexto14());
        jButtonBusqMarc.setBackground(Color.WHITE);
        jButtonBusqMarc.setForeground(Color.BLUE);
        
        //Label de derechos reservados
        jLabelDerechos.setFont(Fuente.fuenteTexto14());
        jLabelDerechos.setForeground(Color.WHITE);

    }
    
    private DefaultTableModel model;//Modelo para tabla
    private int sel = -1;//Variable para obtener fila seleccionada de tabla.

    private void inicioTabla() {
        //Método para configurar el DefaultTableModel de la tabla.
        //Especificamos el tamaño de cada columna
        jTb.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTb.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTb.getColumnModel().getColumn(2).setPreferredWidth(200);
        jTb.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTb.getColumnModel().getColumn(4).setPreferredWidth(100);
        jTb.getColumnModel().getColumn(5).setPreferredWidth(200);
        jTb.getColumnModel().getColumn(6).setPreferredWidth(200);
        //Indicamos el DefaultTableModel de nuestra tabla
        model = (DefaultTableModel) jTb.getModel();
        //Indicamos el número de filas
        model.setNumRows(0);
    }

    //Método para agregar datos a la tabla.
    private void cargarDatos() {
        try {
            List<Vehiculo> vehiculos = vehop.recuperarTodas(Conexion.obtener());
            JCheckBox check = new JCheckBox();
            for (Vehiculo vehiculo : vehiculos) {
                model.addRow(new Object[]{
                    vehiculo.getMatveh(), vehiculo.getMatemp(), vehiculo.getMarca(), vehiculo.getAniofab(), vehiculo.getDisponibilidad(),vehiculo.getFechacreacion(),vehiculo.getFechamod()
                });
            }
            //Agregamos el JCheckBox utilizando CellEditor y la clase CellRenderer creado más abajo
            jTb.getColumnModel().getColumn(4).setCellEditor(new DefaultCellEditor(check));
            jTb.getColumnModel().getColumn(4).setCellRenderer(new Render_CheckBox());
            //limpiar();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e);
        }

    }

    //Método para obtener la fila seleccionada de la tabla
    private void seleccion() {
        if (jTb.getRowCount() > 0) {
            sel = jTb.getSelectedRow();
        }
    }

    //Método para eliminar la fila seleccionada de la tabla.
    private void eliminar() throws SQLException, ClassNotFoundException {
        seleccion();
        if (sel >= 0) {
            vehop.eliminar(Conexion.obtener(), model.getValueAt(sel, 0).toString());
            JOptionPane.showMessageDialog(null, "Se ha eliminado el vehiculo con la matricula: " + model.getValueAt(sel, 0));
            model.removeRow(sel);
            sel = -1;
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila.");
        }
    }

    private void modificar() throws SQLException, ClassNotFoundException {
        seleccion();
        if (sel >= 0) {
            Vehiculo vehiculo = vehop.recuperarPorMatVeh(Conexion.obtener(), model.getValueAt(sel, 0).toString());
            /*
            ModificarRuta modruta = new ModificarRuta(this, true);
            modruta.asignarRuta(ruta);
            modruta.setVisible(true);
            */
            //limpiar();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila.");
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

        jLabelTitulo = new javax.swing.JLabel();
        jLabelBusqGeneral = new javax.swing.JLabel();
        jTextFieldBusqMarc = new javax.swing.JTextField();
        jButtonBusqMarc = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTb = new javax.swing.JTable();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonRecargar = new javax.swing.JButton();
        jLabelDerechos = new javax.swing.JLabel();
        jButtonRegresar = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuPerfil = new javax.swing.JMenuItem();
        jMenuColor = new javax.swing.JMenu();
        jMenuDefault = new javax.swing.JMenuItem();
        jMenuNegro = new javax.swing.JMenuItem();
        jMenuRojo = new javax.swing.JMenuItem();
        jMenuMorado = new javax.swing.JMenuItem();
        jMenuCerrarSesion = new javax.swing.JMenuItem();
        jMenuSalir = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuAcercaDe = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabelTitulo.setText("Flota");

        jLabelBusqGeneral.setText("Búsqueda general:");

        jButtonBusqMarc.setText("Buscar");
        jButtonBusqMarc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusqMarcActionPerformed(evt);
            }
        });

        jTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mat. Vehiculo", "Mat. Empleado", "Marca", "Año de fab.", "Disponibilidad", "Fecha de creación", "Fecha mod."
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTb.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTb);

        jButton2.setBackground(new java.awt.Color(1, 123, 5));
        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 250, 250));
        jButton2.setText("Agregar nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton1.setBackground(new java.awt.Color(1, 197, 163));
        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(223, 22, 32));
        jButton3.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton3.setForeground(new java.awt.Color(254, 254, 254));
        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButtonRecargar.setBackground(new java.awt.Color(110, 141, 136));
        jButtonRecargar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonRecargar.setForeground(new java.awt.Color(254, 254, 254));
        jButtonRecargar.setText("Recargar");
        jButtonRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecargarActionPerformed(evt);
            }
        });

        jLabelDerechos.setText("Copyright © GamersRetail  | Todos los derechos reservados");

        jButtonRegresar.setBackground(new java.awt.Color(38, 121, 49));
        jButtonRegresar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonRegresar.setForeground(new java.awt.Color(254, 254, 254));
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
            }
        });

        jMenu1.setText("Opciones");

        jMenuPerfil.setText("Perfil");
        jMenuPerfil.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuPerfilActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuPerfil);

        jMenuColor.setText("Color de fondo");

        jMenuDefault.setText("Default");
        jMenuColor.add(jMenuDefault);

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
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 881, Short.MAX_VALUE)
                    .addComponent(jLabelTitulo)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelBusqGeneral)
                        .addGap(4, 4, 4)
                        .addComponent(jTextFieldBusqMarc, javax.swing.GroupLayout.PREFERRED_SIZE, 604, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButtonBusqMarc))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(171, 171, 171)
                                .addComponent(jLabelDerechos))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(114, 114, 114)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButtonRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabelTitulo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabelBusqGeneral)
                            .addComponent(jTextFieldBusqMarc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonBusqMarc))
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jButtonRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jLabelDerechos)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPerfilActionPerformed

    }//GEN-LAST:event_jMenuPerfilActionPerformed

    private void jButtonBusqMarcActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusqMarcActionPerformed
        //busquedaPorAlias();
    }//GEN-LAST:event_jButtonBusqMarcActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        /*
        new NuevaRuta(this, true).setVisible(true);
        limpiar();
        */
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        /*
        try {
            modificar();
        } catch (SQLException ex) {
            Logger.getLogger(FormRuta.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormRuta.class.getName()).log(Level.SEVERE, null, ex);
        }
        */
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        /*
        int reply = JOptionPane.showConfirmDialog(null, "¿Estás seguro(a) que deseas eliminar la ruta?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                eliminar();
            } catch (SQLException ex) {
                Logger.getLogger(FormRuta.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormRuta.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        */
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButtonRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecargarActionPerformed
        /*
        limpiar();
        jTextFieldBusqAlias.setText("");
        jTextFieldBusqId.setText("");
        */
    }//GEN-LAST:event_jButtonRecargarActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        Logistica logistica = new Logistica();
        logistica.setVisible(true);
        logistica.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

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
            java.util.logging.Logger.getLogger(FormFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormFlota.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormFlota().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBusqMarc;
    private javax.swing.JButton jButtonRecargar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabelBusqGeneral;
    private javax.swing.JLabel jLabelDerechos;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenuItem jMenuAcercaDe;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuCerrarSesion;
    private javax.swing.JMenu jMenuColor;
    private javax.swing.JMenuItem jMenuDefault;
    private javax.swing.JMenuItem jMenuMorado;
    private javax.swing.JMenuItem jMenuNegro;
    private javax.swing.JMenuItem jMenuPerfil;
    private javax.swing.JMenuItem jMenuRojo;
    private javax.swing.JMenuItem jMenuSalir;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTb;
    private javax.swing.JTextField jTextFieldBusqMarc;
    // End of variables declaration//GEN-END:variables
}
