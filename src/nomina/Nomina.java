/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package nomina;

import conexion.Conexion;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import recursos.Colores;

/**
 *
 * @author poron
 */
public class Nomina extends javax.swing.JFrame {
    
    ResultSet rs;
    Conexion cc= new Conexion();
    Statement sent;
    
    private void cargarConf() {
        //Cofiguración de la ventana
        setTitle("Nomina");
        setIconImage(new ImageIcon(getClass().getResource("/Images/icono.png")).getImage());
        getContentPane().setBackground(Colores.cargarColor());
        setLocationRelativeTo(null);
                }

    /**
     * Creates new form Nomina
     */
    public Nomina() {
        initComponents();
        setUndecorated(true);
        setLocationRelativeTo(null);
        setResizable(false);
        setTitle("Empleados");
        mostrarDatos(); 
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        rfc = new javax.swing.JLabel();
        rfctxt = new javax.swing.JTextField();
        matemp = new javax.swing.JLabel();
        matemptxt = new javax.swing.JTextField();
        NOMINA = new javax.swing.JLabel();
        tipocontrato = new javax.swing.JLabel();
        tipocontratotxt = new javax.swing.JTextField();
        tipojornada = new javax.swing.JLabel();
        tipojornadatxt = new javax.swing.JTextField();
        fechacreacion = new javax.swing.JLabel();
        fechacreaciontxt = new javax.swing.JTextField();
        fechamod = new javax.swing.JLabel();
        fechamodtxt = new javax.swing.JTextField();
        consultar = new javax.swing.JButton();
        modificar = new javax.swing.JButton();
        eliminar = new javax.swing.JButton();
        siguiente = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        rfc.setText("RFC");

        rfctxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rfctxtActionPerformed(evt);
            }
        });

        matemp.setText("MATRICULA EMPLEADO");

        matemptxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matemptxtActionPerformed(evt);
            }
        });

        NOMINA.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        NOMINA.setText("NOMINA");

        tipocontrato.setText("TIPO DE CONTRATO");

        tipojornada.setText("TIPO DE JORNADA ");

        fechacreacion.setText("FECHA DE CREACION");

        fechamod.setText("FECHA DE MODIFICACION");

        fechamodtxt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                fechamodtxtActionPerformed(evt);
            }
        });

        consultar.setText("CONSULTAR");
        consultar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                consultarActionPerformed(evt);
            }
        });

        modificar.setText("MODIFICAR");
        modificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                modificarActionPerformed(evt);
            }
        });

        eliminar.setText("ELIMINAR");
        eliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarActionPerformed(evt);
            }
        });

        siguiente.setText("SIGUIENTE");
        siguiente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                siguienteActionPerformed(evt);
            }
        });

        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(NOMINA, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(fechacreacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(matemp)
                                                .addComponent(tipocontrato))
                                            .addGap(31, 31, 31))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(fechamod)
                                            .addGap(18, 18, 18)))
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(fechamodtxt, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(matemptxt)
                                            .addComponent(tipocontratotxt)
                                            .addComponent(fechacreaciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(18, 18, 18)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(tipojornada)
                                        .addComponent(rfc, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(consultar)
                                .addGap(31, 31, 31)
                                .addComponent(modificar)
                                .addGap(39, 39, 39)
                                .addComponent(eliminar)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(tipojornadatxt, javax.swing.GroupLayout.DEFAULT_SIZE, 201, Short.MAX_VALUE)
                                .addComponent(rfctxt))
                            .addComponent(siguiente, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(30, 30, 30))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 685, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(21, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(NOMINA)
                .addGap(32, 32, 32)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(matemp)
                        .addComponent(matemptxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(rfc))
                    .addComponent(rfctxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tipocontrato)
                    .addComponent(tipocontratotxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tipojornada)
                    .addComponent(tipojornadatxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(fechacreaciontxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(fechacreacion))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fechamod)
                    .addComponent(fechamodtxt, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(50, 50, 50)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 74, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(consultar)
                    .addComponent(modificar)
                    .addComponent(eliminar)
                    .addComponent(siguiente))
                .addGap(46, 46, 46))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void rfctxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rfctxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rfctxtActionPerformed

    private void matemptxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matemptxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matemptxtActionPerformed

    private void fechamodtxtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_fechamodtxtActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_fechamodtxtActionPerformed

    private void siguienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_siguienteActionPerformed
new Pago().setVisible(true);    
dispose();        // TODO add your handling code here:
    }//GEN-LAST:event_siguienteActionPerformed

    private void consultarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_consultarActionPerformed
//
//        Habilitar();
//         String rfc,tipocontrato,tipojornada,fechacreacion,fechamod,matemp;
//        
//         
//         rfc = rfctxt.getText();
//         tipocontrato = tipocontratotxt.getText();
//         tipojornada =  tipojornadatxt.getText();
//         fechacreacion = fechacreaciontxt.getText();
//         fechamod = fechamodtxt.getText();
//         matemp = matemptxt.getText();
//         
        
         // TODO add your handling code here:
    }//GEN-LAST:event_consultarActionPerformed

    private void modificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_modificarActionPerformed
//         // TODO add your handling code here:
//         
//        Habilitar();
//        
//      String rfc,tipocontrato,tipojornada,fechacreacion,fechamod,matemp;
//        
//         
//         rfc = rfctxt.getText();
//         tipocontrato = tipocontratotxt.getText();
//         tipojornada =  tipojornadatxt.getText();
//         fechacreacion = fechacreaciontxt.getText();
//         fechamod = fechamodtxt.getText();
//         matemp = matemptxt.getText();
//         try{
//             
//            CallableStatement pst;
//            pst = cn..prepareCall("EXEC Nomina ?,?,?,?,?,?");
//            
//            pst.setString(1, rfc);
//            pst.setString(2, tipocontrato);
//            pst.setString(3, tipojornada);
//            pst.setString(4, fechacreacion);
//            pst.setString(5, fechamod);
//            pst.setString(6, matemp);
//           
//            
//            pst.execute();
//            JOptionPane.showMessageDialog(null,"Modificacion Exitoso, Presione Actualizar");
//            Limpiar();
//            mostrarDatos();
//            
//        }catch (SQLException es){
//            System.out.println("Fallo algo........"+es);
//        }
//        
        
    }//GEN-LAST:event_modificarActionPerformed

    private void eliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarActionPerformed
        // TODO add your handling code here:
//        
//          Habilitar();
//        
//        String idp = matemptxt.getText();
//        
//        try {
//            
//            CallableStatement pst;
//              pst = cn.prepareCall("exec Nomina @matemptxt='"+idp+"'");
//                pst.executeUpdate();
//                JOptionPane.showMessageDialog(null,"Borrado Exitoso, Presione Actualizar");
//                Limpiar();
//                mostrarDatos();
//            
//        }catch (SQLException ex) {
//                System.out.print(ex.getMessage());
//        }
    }//GEN-LAST:event_eliminarActionPerformed

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
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Nomina.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Nomina().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel NOMINA;
    private javax.swing.JButton consultar;
    private javax.swing.JButton eliminar;
    private javax.swing.JLabel fechacreacion;
    private javax.swing.JTextField fechacreaciontxt;
    private javax.swing.JLabel fechamod;
    private javax.swing.JTextField fechamodtxt;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel matemp;
    private javax.swing.JTextField matemptxt;
    private javax.swing.JButton modificar;
    private javax.swing.JLabel rfc;
    private javax.swing.JTextField rfctxt;
    private javax.swing.JButton siguiente;
    private javax.swing.JLabel tipocontrato;
    private javax.swing.JTextField tipocontratotxt;
    private javax.swing.JLabel tipojornada;
    private javax.swing.JTextField tipojornadatxt;
    // End of variables declaration//GEN-END:variables

    private void Habilitar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void Limpiar() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private void mostrarDatos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
        
}
