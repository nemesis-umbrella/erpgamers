/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logistica;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JCheckBox;
import javax.swing.JComponent;//Importaciones
import javax.swing.JTable;
import javax.swing.table.TableCellRenderer;

/**
 *
 * @author Jorge L. Mondragón <nemesis_umbrella@outlook.com>
 */
public class Render_CheckBox extends JCheckBox implements TableCellRenderer {

    //
        private final JComponent component = new JCheckBox();

        /** Constructor de clase */
        public Render_CheckBox() {
            setOpaque(true);
    }

      @Override
      public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
          //Color de fondo de la celda
          ( (JCheckBox) component).setBackground( new Color(98,138,183) );
          //obtiene valor boolean y coloca valor en el JCheckBox
          boolean b = ((Boolean) value).booleanValue();
          ( (JCheckBox) component).setSelected( b );
          return ( (JCheckBox) component);
      }
    
}
