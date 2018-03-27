/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica;

import conexion.Conexion;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class DialogEmpleado extends java.awt.Dialog {
    EmpleadoOperaciones empop = new EmpleadoOperaciones();
    /**
     * Creates new form DialogEmpleado
     */
    public DialogEmpleado(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarConf();
        inicioTabla();
        cargarDatos();
    }
    
    private void cargarConf(){
        setTitle("Buscar empleado");
        setLocationRelativeTo(null);
        setResizable(false);
    }

    private DefaultTableModel model;//Modelo para tabla
    private int sel = -1;//Variable para obtener fila seleccionada de tabla.

    private void inicioTabla() {
        //Método para configurar el DefaultTableModel de la tabla.
        //Especificamos el tamaño de cada columna
        jTb.getColumnModel().getColumn(0).setPreferredWidth(100);
        jTb.getColumnModel().getColumn(1).setPreferredWidth(150);
        jTb.getColumnModel().getColumn(2).setPreferredWidth(300);
        jTb.getColumnModel().getColumn(3).setPreferredWidth(250);
        //Indicamos el DefaultTableModel de nuestra tabla
        model = (DefaultTableModel) jTb.getModel();
        //Indicamos el número de filas
        model.setNumRows(0);
    }

    //Método para agregar datos a la tabla.
    private void cargarDatos() {
        try {
            List<Empleado> empleados = empop.recuperarTodas(Conexion.obtener());
            JCheckBox check = new JCheckBox();
            for (Empleado empleado : empleados) {
                model.addRow(new Object[]{
                    empleado.getMatemp(), empleado.getLogin(), empleado.getNombrecompleto(), empleado.getEmail()
                });
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e);
        }

    }
    
    //Método para buscar datos en la tabla.
    private void busqueda() {
        if (!"".equals(jTextFieldBusqueda.getText())) {
            List<Empleado> empleados;
            try {
                empleados = empop.recuperarVariasPorBusqueda(Conexion.obtener(), jTextFieldBusqueda.getText());
                if (!empleados.isEmpty()) {
                    soloLimpia();
                    JCheckBox check = new JCheckBox();
                    for (Empleado empleado : empleados) {
                        model.addRow(new Object[]{
                            empleado.getMatemp(), empleado.getLogin(), empleado.getNombrecompleto(), empleado.getEmail()
                        });
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                    limpiar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un alias a buscar");
        }
    }
    
    //Limpia toda la tabla
    private void soloLimpia() {
        int a = model.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(i);
        }
    }
    
    private void limpiar() {
        int a = model.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(i);
        }
        cargarDatos();
    }

    //Método para obtener la fila seleccionada de la tabla
    private void seleccion() {
        if (jTb.getRowCount() > 0) {
            sel = jTb.getSelectedRow();
        }
    }
    
    //Este método pasa la matricula del empleado seleccionado al otro JDialog
    private void pasarMatricula() throws SQLException, ClassNotFoundException {
        seleccion();
        if (sel >= 0) {
            NuevoVehiculo.setMatriculaemp(Integer.parseInt(model.getValueAt(sel, 0).toString()));
            setVisible(false);
            dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila.");
        }
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jTextFieldBusqueda = new javax.swing.JTextField();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTb = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButtonRecargar = new javax.swing.JButton();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
            public void windowClosed(java.awt.event.WindowEvent evt) {
                formWindowClosed(evt);
            }
        });

        jLabel1.setText("Búsqueda:");
        jLabel1.setToolTipText("");

        jTextFieldBusqueda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBusquedaKeyPressed(evt);
            }
        });

        jButtonBuscar.setBackground(new java.awt.Color(118, 159, 211));
        jButtonBuscar.setForeground(new java.awt.Color(254, 254, 254));
        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Mat. Empleado", "Login", "Nombre Completo", "Email"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTb.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTb);

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

        jButtonRecargar.setBackground(new java.awt.Color(110, 141, 136));
        jButtonRecargar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonRecargar.setForeground(new java.awt.Color(254, 254, 254));
        jButtonRecargar.setText("Reestablecer");
        jButtonRecargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRecargarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, 0)
                                .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, 500, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(10, 10, 10)
                                .addComponent(jButtonBuscar, javax.swing.GroupLayout.DEFAULT_SIZE, 97, Short.MAX_VALUE))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButtonRecargar)
                        .addGap(100, 100, 100)
                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextFieldBusqueda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jButtonBuscar)))
                .addGap(12, 12, 12)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton4)
                    .addComponent(jButton2)
                    .addComponent(jButtonRecargar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * Closes the dialog
     */
    private void closeDialog(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_closeDialog
        setVisible(false);
        dispose();
    }//GEN-LAST:event_closeDialog

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            pasarMatricula();
        } catch (Exception e) {
            JOptionPane.showConfirmDialog(null,"Error: "+e);
        }
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        busqueda();
    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void jButtonRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecargarActionPerformed
        limpiar();
    }//GEN-LAST:event_jButtonRecargarActionPerformed

    private void jTextFieldBusquedaKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBusquedaKeyPressed
         if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            busqueda();
        }
    }//GEN-LAST:event_jTextFieldBusquedaKeyPressed

    private void formWindowClosed(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosed
        //Sin nada
    }//GEN-LAST:event_formWindowClosed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogEmpleado dialog = new DialogEmpleado(new java.awt.Frame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonRecargar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTb;
    private javax.swing.JTextField jTextFieldBusqueda;
    // End of variables declaration//GEN-END:variables
}