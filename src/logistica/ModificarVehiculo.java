/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica;

import conexion.Conexion;
import java.sql.Time;
import java.sql.Timestamp;
import java.time.Instant;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class ModificarVehiculo extends javax.swing.JDialog {
    Vehiculo vehiculo = null;
    private static int matriculaemp = 0;

    /**
     * Creates new form NuevoVehiculo
     */
    public ModificarVehiculo(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarConf();
    }

    private void cargarConf() {
        setTitle("Agregar vehiculo");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    public static void setMatriculaemp(int matriculaemp1) {
        matriculaemp = matriculaemp1;
    }
    
    //Método para guardar los vehiculos
    public void guardar() {
        if (!"".equals(jTextFieldMatVeh.getText())) {
            if (!"".equals(jTextFieldMatEmp.getText())) {
                if (!"".equals(jTextFieldMarca.getText())) {
                    if (!"".equals(jTextFieldAnioFab.getText())) {
                        try {
                            String matveh = jTextFieldMatVeh.getText().toUpperCase();
                            int matemp = Integer.parseInt(jTextFieldMatEmp.getText());
                            String marca = jTextFieldMarca.getText();
                            int anioFab = Integer.parseInt(jTextFieldAnioFab.getText());
                            boolean disponible = false;
                            if (jCheckBoxDisp.isSelected() == true) {
                                disponible = true;
                            }
                            Vehiculo vehiculo = new Vehiculo(matveh, matemp, marca, anioFab, disponible, null, null);
                            VehiculoOperaciones vehop = new VehiculoOperaciones();
                            vehop.guardar(Conexion.obtener(), vehiculo);
                            setVisible(false);
                            dispose();
                        } catch (Exception e) {
                            JOptionPane.showMessageDialog(null, "Hubo un error: " + e);
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Falta ingresar el año de de fab del carro");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Falta ingresar la marca");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Falta ingresar la matricula del empleado");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Falta ingresar la matricula del vehiculo");
        }
    }
    
    //Carga los datos del vehiculo seleccionado
    private void cargarRuta(){
        jTextFieldMatVeh.setText(this.vehiculo.getMatveh());
        jTextFieldMatEmp.setText(this.vehiculo.getMatemp().toString());
        jTextFieldMarca.setText(this.vehiculo.getMarca());
        jTextFieldAnioFab.setText(this.vehiculo.getAniofab().toString());
        if(this.vehiculo.getDisponibilidad()){
            jCheckBoxDisp.setSelected(true);
        }
    }
    
    //Asigna los datos a objeto vehiculo
    public void asignarVehiculo(Vehiculo vehiculo){
        this.vehiculo = vehiculo;
        cargarRuta();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldMatVeh = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldMatEmp = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jTextFieldMarca = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextFieldAnioFab = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jCheckBoxDisp = new javax.swing.JCheckBox();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Mat. Vehiculo:");

        jTextFieldMatVeh.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMatVehKeyTyped(evt);
            }
        });

        jLabel2.setText("Mat. Empleado: ");

        jTextFieldMatEmp.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMatEmpKeyTyped(evt);
            }
        });

        jButton1.setText("...");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setText("Marca: ");

        jTextFieldMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldMarcaKeyTyped(evt);
            }
        });

        jLabel4.setText("Año de Fab.:");

        jTextFieldAnioFab.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFieldAnioFabActionPerformed(evt);
            }
        });
        jTextFieldAnioFab.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldAnioFabKeyTyped(evt);
            }
        });

        jLabel5.setText("Disponibilidad:");

        jCheckBoxDisp.setText("Disponible");

        jButton4.setBackground(new java.awt.Color(0, 177, 50));
        jButton4.setForeground(new java.awt.Color(254, 254, 254));
        jButton4.setText("Aceptar");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(233, 1, 48));
        jButton2.setForeground(new java.awt.Color(253, 251, 251));
        jButton2.setText("Cancelar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jCheckBoxDisp)
                            .addComponent(jTextFieldAnioFab, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jButton2))
                        .addGroup(layout.createSequentialGroup()
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jTextFieldMatEmp, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jTextFieldMatVeh, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 431, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldMatVeh, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldMatEmp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jTextFieldMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldAnioFab, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jCheckBoxDisp))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        matriculaemp = 0;
        guardar();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        matriculaemp = 0;
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTextFieldAnioFabActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFieldAnioFabActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFieldAnioFabActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        new DialogEmpleado(new javax.swing.JFrame(), true).setVisible(true);
        if (matriculaemp != 0) {
            jTextFieldMatEmp.setText("" + matriculaemp);
        }
        //limpiar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        matriculaemp = 0;
    }//GEN-LAST:event_formWindowClosed

    private void jTextFieldMatVehKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMatVehKeyTyped
        int pValor = 7;
        if (jTextFieldMatVeh.getText().length() >= pValor) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldMatVehKeyTyped

    private void jTextFieldMatEmpKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMatEmpKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        int pValor = 10;
        if (jTextFieldMatEmp.getText().length() >= pValor) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldMatEmpKeyTyped

    private void jTextFieldMarcaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldMarcaKeyTyped
        int pValor = 30;
        if (jTextFieldMarca.getText().length() >= pValor) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldMarcaKeyTyped

    private void jTextFieldAnioFabKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldAnioFabKeyTyped
        char car = evt.getKeyChar();
        if ((car < '0' || car > '9')) {
            evt.consume();
        }
        int pValor = 4;
        if (jTextFieldAnioFab.getText().length() >= pValor) {
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldAnioFabKeyTyped

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
            java.util.logging.Logger.getLogger(ModificarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ModificarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ModificarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ModificarVehiculo.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                ModificarVehiculo dialog = new ModificarVehiculo(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JCheckBox jCheckBoxDisp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JTextField jTextFieldAnioFab;
    private javax.swing.JTextField jTextFieldMarca;
    private javax.swing.JTextField jTextFieldMatEmp;
    private javax.swing.JTextField jTextFieldMatVeh;
    // End of variables declaration//GEN-END:variables
}