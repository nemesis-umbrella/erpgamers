/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package iniciosesion;

import conexion.Conexion;
import java.awt.Color;
import java.util.List;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import logistica.Render_CheckBox;
import menuprincipal.MenuPrincipal;
import recursos.Colores;
import recursos.Fuente;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class FormUsuarios extends javax.swing.JFrame {

    InicioSesionOperaciones iniop = new InicioSesionOperaciones();

    /**
     * Creates new form FormUsuarios
     */
    public FormUsuarios() {
        initComponents();
        cargarConf();
        inicioTabla();
        cargarDatos();
    }

    private void cargarConf() {
        //Cofiguración de la ventana
        setTitle("Usuarios");
        setIconImage(new ImageIcon(getClass().getResource("/Images/icono.png")).getImage());
        getContentPane().setBackground(Colores.cargarColor());
        setLocationRelativeTo(null);

        //Configuración de Labels 
        //Título del formulario
        jLabelTitulo.setFont(Fuente.fuenteTitulos());
        jLabelTitulo.setForeground(Color.WHITE);

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
        
        //Label de derechos reservados
        jLabelDerechos.setFont(Fuente.fuenteTexto14());
        jLabelDerechos.setForeground(Color.WHITE);
        
        //Configuración de búsqueda 
        jLabelbuscar.setFont(Fuente.fuenteTexto14());
        jLabelbuscar.setForeground(Color.WHITE);

        jTextFieldbuscar.setFont(Fuente.fuenteTexto12());
        jTextFieldbuscar.setForeground(Color.BLUE);
        jTextFieldbuscar.setBackground(Colores.colorBlancoOsc());

        jButtonbuscar.setFont(Fuente.fuenteTexto14());
        jButtonbuscar.setBackground(Color.WHITE);
        jButtonbuscar.setForeground(Color.BLUE);

    }

    private DefaultTableModel model;//Modelo para tabla
    private int sel = -1;//Variable para obtener fila seleccionada de tabla.

    private void inicioTabla() {
        //Método para configurar el DefaultTableModel de la tabla.
        jTb.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
        jTb.doLayout();

        //Especificamos el tamaño de cada columna
        jTb.getColumnModel().getColumn(0).setPreferredWidth(150); //Login
        jTb.getColumnModel().getColumn(1).setPreferredWidth(150); //Nombre
        jTb.getColumnModel().getColumn(2).setPreferredWidth(150); //Apellidop
        jTb.getColumnModel().getColumn(3).setPreferredWidth(150); //Apellidom
        jTb.getColumnModel().getColumn(4).setPreferredWidth(50);  //Genero
        jTb.getColumnModel().getColumn(5).setPreferredWidth(200); //Email
        jTb.getColumnModel().getColumn(6).setPreferredWidth(150); //Tipo
        jTb.getColumnModel().getColumn(7).setPreferredWidth(200);  //Fecha creacion
        jTb.getColumnModel().getColumn(8).setPreferredWidth(200); //Fecha modificacion
        jTb.getColumnModel().getColumn(9).setPreferredWidth(200); //Fecha ultima conexión
        jTb.getColumnModel().getColumn(10).setPreferredWidth(100); //Habilitado
        //Indicamos el DefaultTableModel de nuestra tabla
        model = (DefaultTableModel) jTb.getModel();
        //Indicamos el número de filas
        model.setNumRows(0);
    }

    //Método para agregar datos a la tabla.
    private void cargarDatos() {
        try {
            List<InicioSesion> inicios = iniop.recuperarTodos(Conexion.obtener());
            JCheckBox check = new JCheckBox();
            for (InicioSesion inicio : inicios) {
                String tipo = "";
                switch (inicio.getTipo()) {
                    case 1:
                        tipo = "Administrador";
                        break;
                    case 2:
                        tipo = "Ventas";
                        break;
                    case 3:
                        tipo = "Consultor";
                        break;
                    default:
                        break;
                }
                model.addRow(new Object[]{
                    inicio.getLogin(), inicio.getNombre(), inicio.getApellidop(), inicio.getApellidom(), inicio.getGenero(), inicio.getEmail(), tipo, inicio.getFechacreacion(), inicio.getFechamod(), inicio.getUltimaconexion(), inicio.isActivo()
                });
            }
            //Agregamos el JCheckBox utilizando CellEditor y la clase CellRenderer creado más abajo
            jTb.getColumnModel().getColumn(10).setCellEditor(new DefaultCellEditor(check));
            jTb.getColumnModel().getColumn(10).setCellRenderer(new Render_CheckBox());
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
    private void eliminar() {
        try {
            seleccion();
            if (sel >= 0) {
                int reply = JOptionPane.showConfirmDialog(null, "¿Estás seguro(a) que deseas eliminar la ruta?", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (reply == JOptionPane.YES_OPTION) {
                    //vehop.eliminar(Conexion.obtener(), model.getValueAt(sel, 0).toString());
                    JOptionPane.showMessageDialog(null, "Se ha eliminado el vehiculo con la matricula: " + model.getValueAt(sel, 0));
                    model.removeRow(sel);
                    sel = -1;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona una fila.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    private void limpiar() {
        int a = model.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(i);
        }
        cargarDatos();
    }

    private void modificar() {
        try {
            seleccion();
            if (sel >= 0) {
                /*
                Vehiculo vehiculo = vehop.recuperarPorMatVeh(Conexion.obtener(), model.getValueAt(sel, 0).toString());
                ModificarVehiculo modveh = new ModificarVehiculo(this, true);
                modveh.asignarVehiculo(vehiculo);
                modveh.setVisible(true);
                limpiar();
                 */
            } else {
                JOptionPane.showMessageDialog(null, "Selecciona una fila.");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Error: " + e);
        }
    }

    private void soloLimpia() {
        int a = model.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(i);
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
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonRecargar = new javax.swing.JButton();
        jLabelDerechos = new javax.swing.JLabel();
        jButtonRegresar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTb = new javax.swing.JTable();
        jLabelbuscar = new javax.swing.JLabel();
        jTextFieldbuscar = new javax.swing.JTextField();
        jButtonbuscar = new javax.swing.JButton();
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

        jLabelTitulo.setText("Usuarios");

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

        jTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Login", "Nombre", "Apellido paterno", "Apellido materno", "Genero", "Email", "Tipo", "Fecha creación", "Fecha modificación", "Última conexión", "Habilitado"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, true, true, true
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTb.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTb);

        jLabelbuscar.setText("Búsqueda:");

        jButtonbuscar.setText("Buscar");

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
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(113, 222, Short.MAX_VALUE)
                        .addComponent(jLabelDerechos)
                        .addGap(86, 86, 86)
                        .addComponent(jButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jScrollPane1))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTitulo)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(113, 113, 113)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(26, 26, 26)
                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(30, 30, 30)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(jButtonRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelbuscar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 611, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelTitulo)
                .addGap(8, 8, 8)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelbuscar)
                    .addComponent(jTextFieldbuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonbuscar))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 327, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 19, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelDerechos, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButtonRegresar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuPerfilActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuPerfilActionPerformed
        new iniciosesion.DialogPerfil(this, true).setVisible(true);
    }//GEN-LAST:event_jMenuPerfilActionPerformed

    private void jMenuDefualtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuDefualtActionPerformed
        //Se encarga de guardar y mostrar el color seleccionado por el usuario
        String error = recursos.Colores.guardarColorNuevo(0);
        getContentPane().setBackground(recursos.Colores.cargarColor());
        if (!error.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: " + error);
        }
    }//GEN-LAST:event_jMenuDefualtActionPerformed

    private void jMenuNegroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuNegroActionPerformed
        //Se encarga de guardar y mostrar el color seleccionado por el usuario
        String error = recursos.Colores.guardarColorNuevo(1);
        getContentPane().setBackground(recursos.Colores.cargarColor());
        if (!error.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: " + error);
        }
    }//GEN-LAST:event_jMenuNegroActionPerformed

    private void jMenuRojoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuRojoActionPerformed
        //Se encarga de guardar y mostrar el color seleccionado por el usuario
        String error = recursos.Colores.guardarColorNuevo(2);
        getContentPane().setBackground(recursos.Colores.cargarColor());
        if (!error.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: " + error);
        }
    }//GEN-LAST:event_jMenuRojoActionPerformed

    private void jMenuMoradoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuMoradoActionPerformed
        //Se encarga de guardar y mostrar el color seleccionado por el usuario
        String error = recursos.Colores.guardarColorNuevo(3);
        getContentPane().setBackground(recursos.Colores.cargarColor());
        if (!error.equals("")) {
            javax.swing.JOptionPane.showMessageDialog(null, "Error: " + error);
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
        limpiar();
        /*
        jTextFieldBusqAlias.setText("");
        jTextFieldBusqId.setText("");
        */
    }//GEN-LAST:event_jButtonRecargarActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
        MenuPrincipal menu = new MenuPrincipal();
        menu.setVisible(true);
        menu.setLocationRelativeTo(null);
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
            java.util.logging.Logger.getLogger(FormUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormUsuarios.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormUsuarios().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonRecargar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JButton jButtonbuscar;
    private javax.swing.JLabel jLabelDerechos;
    private javax.swing.JLabel jLabelTitulo;
    private javax.swing.JLabel jLabelbuscar;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTb;
    private javax.swing.JTextField jTextFieldbuscar;
    // End of variables declaration//GEN-END:variables
}
