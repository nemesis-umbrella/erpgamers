/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package producto;


import conexion.Conexion;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.text.NumberFormat;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
//import javafx.scene.input.KeyCode;
import javax.swing.DefaultCellEditor;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.NumberFormatter;
import recursos.Colores;
import recursos.Fuente;

/**
 *

 */
public class FormPlataforma extends javax.swing.JFrame {

    PlataformaOperaciones plataformaOp = new PlataformaOperaciones();

    /**
     * Creates new form FormRuta
     */
    public FormPlataforma() {
        initComponents();
        cargarConf();
        inicioTabla();
        cargarDatos();
    }

    public void cargarConf() {
        //Cofiguración de la ventana
        setTitle("Plataforma");
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

        //Título del formulario
        jLabelTitulo.setFont(Fuente.fuenteTitulos());
        jLabelTitulo.setForeground(Color.WHITE);

        //Configuración de Búsqueda clave
        jLabelBusqClave.setFont(Fuente.fuenteTexto14());
        jLabelBusqClave.setForeground(Color.WHITE);

        jTextFieldBusqClave.setFont(Fuente.fuenteTexto12());
        jTextFieldBusqClave.setForeground(Color.BLUE);
        jTextFieldBusqClave.setBackground(Colores.colorBlancoOsc());
        

        jButtonBusqClave.setFont(Fuente.fuenteTexto14());
        jButtonBusqClave.setBackground(Color.WHITE);
        jButtonBusqClave.setForeground(Color.BLUE);

        //Configuración de Búsqueda por nombre
        jLabelBusqFabricante.setFont(Fuente.fuenteTexto14());
        jLabelBusqFabricante.setForeground(Color.WHITE);

        jTextFieldBusqFabricante.setFont(Fuente.fuenteTexto12());
        jTextFieldBusqFabricante.setForeground(Color.BLUE);
        jTextFieldBusqFabricante.setBackground(Colores.colorBlancoOsc());

        jButtonBusqFabricante.setFont(Fuente.fuenteTexto14());
        jButtonBusqFabricante.setBackground(Color.WHITE);
        jButtonBusqFabricante.setForeground(Color.BLUE);

        //Configuración del título de la lista
        jLabelListPlataforma.setFont(Fuente.fuenteTexto14());
        jLabelListPlataforma.setForeground(Color.WHITE);
        
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
        jTb.getColumnModel().getColumn(1).setPreferredWidth(200);
        jTb.getColumnModel().getColumn(2).setPreferredWidth(150);
        jTb.getColumnModel().getColumn(3).setPreferredWidth(100);
        jTb.getColumnModel().getColumn(4).setPreferredWidth(250);
        jTb.getColumnModel().getColumn(5).setPreferredWidth(100);
        jTb.getColumnModel().getColumn(6).setPreferredWidth(200);
        jTb.getColumnModel().getColumn(7).setPreferredWidth(200);
        //Indicamos el DefaultTableModel de nuestra tabla
        model = (DefaultTableModel) jTb.getModel();
        //Indicamos el número de filas
        model.setNumRows(0);
    }

    //Método para agregar datos a la tabla.
    private void cargarDatos() {
        try {
            List<Plataforma> plataformas = plataformaOp.recuperarTodas(Conexion.obtener());
            JCheckBox check = new JCheckBox();
            for (Plataforma plataforma : plataformas) {
                model.addRow(new Object[]{
                    plataforma.getClave(), plataforma.getNombre(), plataforma.getFabricante(), plataforma.getDisponibilidad(), plataforma.getLanzamiento(), plataforma.getTiempo(), plataforma.getFechacreacion(), plataforma.getFechamod()
                });
            }
            //Agregamos el JCheckBox utilizando CellEditor y la clase CellRenderer creado más abajo
            jTb.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(check));
            jTb.getColumnModel().getColumn(3).setCellRenderer(new Render_CheckBox());
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
            plataformaOp.eliminar(Conexion.obtener(), Integer.parseInt(model.getValueAt(sel, 0).toString()));
            JOptionPane.showMessageDialog(null, "Se ha eliminado la plataforma con la clave: " + model.getValueAt(sel, 0));
            model.removeRow(sel);
            sel = -1;
        } else {
            JOptionPane.showMessageDialog(null, "Selecciona una fila.");
        }
    }

    private void modificar() throws SQLException, ClassNotFoundException {
        seleccion();
        if (sel >= 0) {
            Plataforma plataforma = plataformaOp.recuperarPorClave(Conexion.obtener(), Integer.parseInt(model.getValueAt(sel, 0).toString()));
            ModificarPlataforma modplataforma = new ModificarPlataforma(this, true);
            modplataforma.asignarPlataforma(plataforma);
            modplataforma.setVisible(true);
            limpiar();
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
        jLabelBusqClave = new javax.swing.JLabel();
        jTextFieldBusqClave = new javax.swing.JTextField();
        jButtonBusqClave = new javax.swing.JButton();
        jLabelBusqFabricante = new javax.swing.JLabel();
        jTextFieldBusqFabricante = new javax.swing.JTextField();
        jButtonBusqFabricante = new javax.swing.JButton();
        jLabelListPlataforma = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButtonRegresar = new javax.swing.JButton();
        jButtonRecargar = new javax.swing.JButton();
        jLabelDerechos = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTb = new javax.swing.JTable();
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

        jLabelTitulo.setText("Plataforma");

        jLabelBusqClave.setText("Búsqueda por clave: ");

        jTextFieldBusqClave.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBusqClaveKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBusqClaveKeyTyped(evt);
            }
        });

        jButtonBusqClave.setText("Buscar");
        jButtonBusqClave.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusqClaveActionPerformed(evt);
            }
        });

        jLabelBusqFabricante.setText("Búsqueda por Fabricante:");

        jTextFieldBusqFabricante.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextFieldBusqFabricanteKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                jTextFieldBusqFabricanteKeyTyped(evt);
            }
        });

        jButtonBusqFabricante.setText("Buscar");
        jButtonBusqFabricante.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBusqFabricanteActionPerformed(evt);
            }
        });

        jLabelListPlataforma.setText("Lista de Plataformas");

        jButton1.setBackground(new java.awt.Color(1, 197, 163));
        jButton1.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton1.setForeground(new java.awt.Color(254, 254, 254));
        jButton1.setText("Modificar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setBackground(new java.awt.Color(1, 123, 5));
        jButton2.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButton2.setForeground(new java.awt.Color(255, 250, 250));
        jButton2.setText("Agregar nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
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

        jButtonRegresar.setBackground(new java.awt.Color(38, 121, 49));
        jButtonRegresar.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
        jButtonRegresar.setForeground(new java.awt.Color(254, 254, 254));
        jButtonRegresar.setText("Regresar");
        jButtonRegresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonRegresarActionPerformed(evt);
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

        jTb.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Clave", "Nombre", "Fabricante", "", "Lanzamiento", "Fecha Creacion", "Fecha Modificacion "
            }
        ));
        jTb.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        jScrollPane1.setViewportView(jTb);

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
                .addGap(130, 130, 130)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(26, 26, 26)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(jButtonRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(142, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(12, 12, 12)
                                .addComponent(jLabelTitulo))
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabelListPlataforma)))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabelBusqClave)
                                .addGap(3, 3, 3)
                                .addComponent(jTextFieldBusqClave, javax.swing.GroupLayout.PREFERRED_SIZE, 132, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButtonBusqClave)
                                .addGap(18, 18, 18)
                                .addComponent(jLabelBusqFabricante)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jTextFieldBusqFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jButtonBusqFabricante))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(jLabelDerechos)
                                .addGap(86, 86, 86)
                                .addComponent(jButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 832, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabelTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelBusqClave)
                    .addComponent(jTextFieldBusqClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBusqClave)
                    .addComponent(jLabelBusqFabricante)
                    .addComponent(jTextFieldBusqFabricante, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonBusqFabricante))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabelListPlataforma)
                .addGap(13, 13, 13)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 358, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonRecargar, javax.swing.GroupLayout.PREFERRED_SIZE, 38, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonRegresar, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelDerechos))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            modificar();
        } catch (SQLException ex) {
            Logger.getLogger(FormPlataforma.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormPlataforma.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int reply = JOptionPane.showConfirmDialog(null, "¿Estás seguro(a) que deseas eliminar la ruta?", "Eliminar", JOptionPane.YES_NO_OPTION);
        if (reply == JOptionPane.YES_OPTION) {
            try {
                eliminar();
            } catch (SQLException ex) {
                Logger.getLogger(FormPlataforma.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(FormPlataforma.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void limpiar() {
        int a = model.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(i);
        }
        cargarDatos();
    }

    private void soloLimpia() {
        int a = model.getRowCount() - 1;
        for (int i = a; i >= 0; i--) {
            model.removeRow(i);
        }
    }

    private void busquedaPorId() {
        if (!"".equals(jTextFieldBusqClave.getText())) {
            Plataforma plataforma = null;
            try {
                plataforma = plataformaOp.recuperarPorClave(Conexion.obtener(), Integer.parseInt(jTextFieldBusqClave.getText()));
                if (plataforma.getClave() != null) {
                    soloLimpia();
                    JCheckBox check = new JCheckBox();
                    model.addRow(new Object[]{
                        plataforma.getClave(), plataforma.getNombre(), plataforma.getFabricante(), plataforma.getDisponibilidad(), plataforma.getLanzamiento(), plataforma.getTiempo(), plataforma.getFechacreacion(), plataforma.getFechamod()
                    });
                    //Agregamos el JCheckBox utilizando CellEditor y la clase CellRenderer creado más abajo
                    jTb.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(check));
                    jTb.getColumnModel().getColumn(3).setCellRenderer(new Render_CheckBox());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontró el id");
                    limpiar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar una clave");
        }
    }

    private void busquedaPorAlias() {
        if (!"".equals(jTextFieldBusqFabricante.getText())) {
            List<Plataforma> plataformas;
            try {
                plataformas = plataformaOp.recuperarVariasPorNombre(Conexion.obtener(), jTextFieldBusqFabricante.getText());
                if (!plataformas.isEmpty()) {
                    soloLimpia();
                    JCheckBox check = new JCheckBox();
                    for (Plataforma plataforma : plataformas) {
                        model.addRow(new Object[]{
                            plataforma.getClave(), plataforma.getNombre(), plataforma.getFabricante(), plataforma.getDisponibilidad(), plataforma.getLanzamiento(), plataforma.getTiempo(), plataforma.getFechacreacion(), plataforma.getFechamod()
                        });
                    }
                    //Agregamos el JCheckBox utilizando CellEditor y la clase CellRenderer creado más abajo
                    jTb.getColumnModel().getColumn(3).setCellEditor(new DefaultCellEditor(check));
                    jTb.getColumnModel().getColumn(3).setCellRenderer(new Render_CheckBox());
                } else {
                    JOptionPane.showMessageDialog(null, "No se encontraron coincidencias");
                    limpiar();
                }
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, "Ocurrio un error: " + e);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un nombre a buscar");
        }
    }
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        new NuevaPlataforma(this, true).setVisible(true);
        limpiar();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonRegresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRegresarActionPerformed
         Producto producto = new Producto();
        producto.setVisible(true);
        producto.setLocationRelativeTo(null);
        dispose();
    }//GEN-LAST:event_jButtonRegresarActionPerformed

    private void jButtonBusqClaveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusqClaveActionPerformed
        busquedaPorId();
    }//GEN-LAST:event_jButtonBusqClaveActionPerformed

    private void jButtonRecargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRecargarActionPerformed
        limpiar();
        jTextFieldBusqFabricante.setText("");
        jTextFieldBusqClave.setText("");
    }//GEN-LAST:event_jButtonRecargarActionPerformed

    private void jButtonBusqFabricanteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBusqFabricanteActionPerformed
        busquedaPorAlias();
    }//GEN-LAST:event_jButtonBusqFabricanteActionPerformed

    private void jTextFieldBusqClaveKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBusqClaveKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            busquedaPorId();
        }
    }//GEN-LAST:event_jTextFieldBusqClaveKeyPressed

    private void jTextFieldBusqFabricanteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBusqFabricanteKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            busquedaPorAlias();
        }
    }//GEN-LAST:event_jTextFieldBusqFabricanteKeyPressed

    private void jTextFieldBusqClaveKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBusqClaveKeyTyped
        char car = evt.getKeyChar();
        if((car<'0' || car>'9')) evt.consume();
        int pValor = 10;
        if (jTextFieldBusqClave.getText().length()>=pValor){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldBusqClaveKeyTyped

    private void jTextFieldBusqFabricanteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextFieldBusqFabricanteKeyTyped
        int pValor = 50;
        if (jTextFieldBusqFabricante.getText().length()>=pValor){
            evt.consume();
        }
    }//GEN-LAST:event_jTextFieldBusqFabricanteKeyTyped

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
            java.util.logging.Logger.getLogger(FormPlataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormPlataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormPlataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormPlataforma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                FormPlataforma form = new FormPlataforma();
                form.setVisible(true);
                form.setLocationRelativeTo(null);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonBusqClave;
    private javax.swing.JButton jButtonBusqFabricante;
    private javax.swing.JButton jButtonRecargar;
    private javax.swing.JButton jButtonRegresar;
    private javax.swing.JLabel jLabelBusqClave;
    private javax.swing.JLabel jLabelBusqFabricante;
    private javax.swing.JLabel jLabelDerechos;
    private javax.swing.JLabel jLabelListPlataforma;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTb;
    private javax.swing.JTextField jTextFieldBusqClave;
    private javax.swing.JTextField jTextFieldBusqFabricante;
    // End of variables declaration//GEN-END:variables
}
