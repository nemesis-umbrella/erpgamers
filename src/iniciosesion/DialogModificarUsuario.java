/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniciosesion;

import conexion.Conexion;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class DialogModificarUsuario extends java.awt.Dialog {
    InicioSesion inicio = null;
    /**
     * Creates new form DialogAgregarUsuario
     */
    public DialogModificarUsuario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        cargarConf();
    }

    public void pasarDatos(InicioSesion inicio){
        this.inicio = inicio;
        cargarDatos();
    }
    
    public void cargarDatos(){
        jTextFieldLogin.setText(inicio.getLogin());
        jTextFieldNombre.setText(inicio.getNombre());
        jTextFieldApPaterno.setText(inicio.getApellidop());
        jTextFieldApMaterno.setText(inicio.getApellidom());
        String genero = inicio.getGenero()+"";
        if(genero.equals("M")){
            jRadioButtonMasculino.setSelected(true);
        }
        if(genero.equals("F")){
            jRadioButtonFemenino.setSelected(true);
        }
        jTextFieldEmail.setText(inicio.getEmail());
        jComboBoxTipo.setSelectedIndex(inicio.getTipo()-1);
        if(inicio.isActivo()){
            jCheckBoxHabilitar.setSelected(true);
        }
    }
    
    public void cargarConf() {
        setTitle("Agregar usuario");
        setLocationRelativeTo(null);
        jComboBoxTipo.removeAllItems();
        jComboBoxTipo.addItem("Administrador");
        jComboBoxTipo.addItem("Ventas");
        jComboBoxTipo.addItem("Consultor");
    }

    private void guardar() {
        InicioSesionOperaciones iniop = new InicioSesionOperaciones();
        String login = jTextFieldLogin.getText();
        char[] cPass = jPasswordFieldContra.getPassword();
        String pass = new String(cPass);
        String nombre = jTextFieldNombre.getText();
        String apellidop = jTextFieldApPaterno.getText();
        String apellidom = jTextFieldApMaterno.getText();
        String genero = "";
        String email = jTextFieldEmail.getText();
        int tipo = jComboBoxTipo.getSelectedIndex() + 1;
        boolean habilitado = false;
        if (!login.equals("")) {       
                if (!nombre.equals("")) {
                    if (!apellidop.equals("")) {
                        if (!apellidom.equals("")) {
                            if (jRadioButtonMasculino.isSelected() || jRadioButtonFemenino.isSelected()) {
                                if (!email.equals("")) {
                                    if (jCheckBoxHabilitar.isSelected()) {
                                        habilitado = true;
                                    }
                                    if (jRadioButtonMasculino.isSelected()) {
                                        genero = "M";
                                    }
                                    if (jRadioButtonFemenino.isSelected()) {
                                        genero = "F";
                                    }
                                    if (pass.equals("")) {
                                        pass = null;
                                    }
                                    InicioSesion inicio = new InicioSesion(login, pass, nombre, apellidop, apellidom, genero.charAt(0), email, tipo, genero, null, null, habilitado, false);
                                    try {
                                        iniop.guardar(Conexion.obtener(), inicio);
                                        setVisible(false);
                                        dispose();
                                    } catch (Exception e) {
                                        JOptionPane.showMessageDialog(null, "Error: "+e);
                                    }
                                } else {
                                    JOptionPane.showMessageDialog(null, "Debes ingresar un correo");
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Debes especificar un genero");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Debes ingresar el apellido materno");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Debes ingresar el apellido paterno");
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Debes ingresar un nombre");
                }            
        } else {
            JOptionPane.showMessageDialog(null, "Debes ingresar un login");
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroupGenero = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jTextFieldLogin = new javax.swing.JTextField();
        jPasswordFieldContra = new javax.swing.JPasswordField();
        jTextFieldNombre = new javax.swing.JTextField();
        jTextFieldApPaterno = new javax.swing.JTextField();
        jTextFieldApMaterno = new javax.swing.JTextField();
        jRadioButtonMasculino = new javax.swing.JRadioButton();
        jRadioButtonFemenino = new javax.swing.JRadioButton();
        jTextFieldEmail = new javax.swing.JTextField();
        jComboBoxTipo = new javax.swing.JComboBox<>();
        jCheckBoxHabilitar = new javax.swing.JCheckBox();

        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                closeDialog(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jLabel1.setText("Agregar usuario");

        jLabel2.setText("Login: ");
        jLabel2.setToolTipText("");

        jLabel3.setText("Contraseña: ");

        jLabel4.setText("Nombre:");

        jLabel5.setText("Ap. Paterno: ");

        jLabel6.setText("Ap. Materno:");

        jLabel7.setText("Genero:");

        jLabel8.setText("E-mail:");

        jLabel9.setText("Tipo:");

        jLabel10.setText("Habilitado:");

        jButton1.setBackground(new java.awt.Color(0, 177, 50));
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("Aceptar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
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

        buttonGroupGenero.add(jRadioButtonMasculino);
        jRadioButtonMasculino.setText("Masculino");

        buttonGroupGenero.add(jRadioButtonFemenino);
        jRadioButtonFemenino.setText("Femenino");

        jTextFieldEmail.setToolTipText("");

        jComboBoxTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        jCheckBoxHabilitar.setText("Habilitar");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 590, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6)
                            .addComponent(jLabel10)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jTextFieldApPaterno)
                            .addComponent(jTextFieldApMaterno)
                            .addComponent(jTextFieldEmail)
                            .addComponent(jComboBoxTipo, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jRadioButtonMasculino)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jRadioButtonFemenino))
                                    .addComponent(jCheckBoxHabilitar))
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPasswordFieldContra)
                            .addComponent(jTextFieldNombre)
                            .addComponent(jTextFieldLogin)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jTextFieldLogin, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jPasswordFieldContra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jTextFieldNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jTextFieldApPaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jTextFieldApMaterno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jRadioButtonMasculino)
                    .addComponent(jRadioButtonFemenino))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(jTextFieldEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jComboBoxTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jCheckBoxHabilitar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 7, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap())
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

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        guardar();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        setVisible(false);
        dispose();
    }//GEN-LAST:event_jButton2ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                DialogModificarUsuario dialog = new DialogModificarUsuario(new java.awt.Frame(), true);
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
    private javax.swing.ButtonGroup buttonGroupGenero;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBoxHabilitar;
    private javax.swing.JComboBox<String> jComboBoxTipo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPasswordField jPasswordFieldContra;
    private javax.swing.JRadioButton jRadioButtonFemenino;
    private javax.swing.JRadioButton jRadioButtonMasculino;
    private javax.swing.JTextField jTextFieldApMaterno;
    private javax.swing.JTextField jTextFieldApPaterno;
    private javax.swing.JTextField jTextFieldEmail;
    private javax.swing.JTextField jTextFieldLogin;
    private javax.swing.JTextField jTextFieldNombre;
    // End of variables declaration//GEN-END:variables
}
