/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import java.awt.CardLayout;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import com.mycompany.trabajoaccdatequipo1.TrabajoAccDatEquipo1;

/**
 *
 * @author javie
 */
public class IasInterfaz extends javax.swing.JFrame {

    public static Collection<Ias> iasTabla = Metodos.selectAllIa();
    static DefaultTableModel modelo;

    /**
     * Creates new form IAS_Interfaz
     */
    //Nombre, modelo, numero de usos y popularidad
    public IasInterfaz() {

        initComponents();

        // No es necesario crear un nuevo modelo, usa el modelo generado por NetBeans
        modelo = (DefaultTableModel) jTable1.getModel();

        actualizarTabla();

        jTable1.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            public void valueChanged(ListSelectionEvent event) {
                if (jTable1.getSelectedRow() > -1) {
                    // Si hay una fila seleccionada, activa los botones
                    jButton5.setEnabled(true);
                    jButton3.setEnabled(true);
                    jButton4.setEnabled(true);
                } else {
                    // Si no hay ninguna fila seleccionada, desactiva los botones
                    jButton5.setEnabled(false);
                    jButton3.setEnabled(false);
                    jButton4.setEnabled(false);
                }
            }
        });

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jToggleButton1 = new javax.swing.JToggleButton();
        jPanel1 = new javax.swing.JPanel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton5 = new javax.swing.JButton();
        jToggleButton2 = new javax.swing.JToggleButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        borrarMasivoBoton = new javax.swing.JButton();

        jButton1.setText("jButton1");

        jToggleButton1.setText("jToggleButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowClosing(java.awt.event.WindowEvent evt) {
                formWindowClosing(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Inicio"));

        jButton2.setText("Nuevo");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.setEnabled(false);
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Modificar");
        jButton4.setEnabled(false);
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nombre", "Modelo", "Usos", "Pupularidad"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        jScrollPane2.setViewportView(jTable1);

        jButton5.setText("Consultar");
        jButton5.setEnabled(false);
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jToggleButton2.setText("Consulta masiva");
        jToggleButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton2ActionPerformed(evt);
            }
        });

        jButton6.setText("Modif. masiva");
        jButton6.setToolTipText("");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Atras");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        borrarMasivoBoton.setText("Eliminacion Masiva");
        borrarMasivoBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                borrarMasivoBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jToggleButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(borrarMasivoBoton)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton4)
                        .addGap(18, 18, 18)
                        .addComponent(jButton3)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5)
                        .addGap(18, 18, 18)
                        .addComponent(jToggleButton2)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(borrarMasivoBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                        .addComponent(jButton7))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        IasInterfazInsertar dialog = new IasInterfazInsertar(IasInterfaz.this, true);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                actualizarTabla();
            }
        });

        dialog.setVisible(true);

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada >= 0) {
            // Muestra un diálogo emergente para confirmar la eliminación
            int respuesta = JOptionPane.showConfirmDialog(this,
                    "¿Estás seguro de que deseas eliminar esta fila?",
                    "Confirmar eliminación", JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                // Elimina la fila seleccionada del modelo de datos
                int idEncontrado = -1;
                for (Ias ia : iasTabla) {
                    if (ia.getNombre().equals(modelo.getValueAt(filaSeleccionada, 0))) {
                        idEncontrado = ia.getIdia();
                        break;
                    }
                }

                modelo.removeRow(filaSeleccionada);
                Metodos.deleteIA(Metodos.buscarIa(idEncontrado).getIdia());
                System.out.println("Eliminado con éxito");
            } else {
                System.out.println("Eliminación cancelada");
            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();

        String nombre = modelo.getValueAt(filaSeleccionada, 0).toString();
        String modelo1 = modelo.getValueAt(filaSeleccionada, 1).toString();

        String tipo = "null";
        for (Ias ia : iasTabla) {
            if (ia.getNombre() == null) {
                break;
            } else {
                if (ia.getNombre().equals(modelo.getValueAt(filaSeleccionada, 0))) {

                    tipo = Metodos.buscarIa(ia.getIdia()).getIdtipo().getTipo();
                    break;
                }
            }

        }

        IasInterfazModificar dialog = new IasInterfazModificar(IasInterfaz.this, true, nombre, modelo1, tipo, iasTabla);

        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                actualizarTabla();
            }
        });

        dialog.setVisible(true);
    }//GEN-LAST:event_jButton4ActionPerformed

    private void formWindowClosing(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowClosing
        Metodos.cerrarConexion();
    }//GEN-LAST:event_formWindowClosing

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int filaSeleccionada = jTable1.getSelectedRow();

        if (filaSeleccionada >= 0) {
            for (Ias ia : iasTabla) {
                System.out.println(modelo.getValueAt(filaSeleccionada, 0));
                if (ia.getNombre().equals(modelo.getValueAt(filaSeleccionada, 0))) {
                    IasInterfazConsulta dialog = new IasInterfazConsulta(IasInterfaz.this, true, Metodos.selectIa(ia.getIdia()));
                    dialog.setVisible(true);
                    break;
                }
            }

        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jToggleButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton2ActionPerformed
        IasInterfazConsultaMasiva dialog = new IasInterfazConsultaMasiva(IasInterfaz.this, true);
        dialog.setVisible(true);
        
         dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                actualizarTablaLista(iasTabla);
            }
        });
    }//GEN-LAST:event_jToggleButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        IasInterfazModifMasiva dialog = new IasInterfazModifMasiva(IasInterfaz.this, true);
        
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                actualizarTabla();
            }
        });
        
        dialog.setVisible(true);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        dispose();
        TrabajoAccDatEquipo1.interfaz();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void borrarMasivoBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_borrarMasivoBotonActionPerformed
        int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Estás seguro de que deseas eliminar TODAS las IAs?", "Confirmar eliminación", 
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
                    MetodosLucas.eliminarTodasLasIas();
                    actualizarTabla(); 
            }   
    }//GEN-LAST:event_borrarMasivoBotonActionPerformed

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
            java.util.logging.Logger.getLogger(IasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(IasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(IasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(IasInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new IasInterfaz().setVisible(true);
            }
        });
    }

    public static void actualizarTabla() {
        // Borrar todas las filas existentes
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }

        // Obtener los datos actualizados de la base de datos
        iasTabla = Metodos.selectAllIa();

        // Llenar la tabla con los datos actualizados
        for (Ias objetoIa : iasTabla) {
            System.out.println(" --- " + objetoIa.getModelo());
            String nombre = objetoIa.getNombre();
            String modeloIa = objetoIa.getModelo();
            int numeroUsos = objetoIa.getUsos();
            String popularidad = objetoIa.getPopularidad();

            Object[] fila = {nombre, modeloIa, numeroUsos, popularidad};
            modelo.addRow(fila);
        }

        // Actualizar la tabla
        modelo.fireTableDataChanged();
    }
    
     public void actualizarTablaLista(Collection<Ias> iasTablaLocal) {
        // Borrar todas las filas existentes
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        // Llenar la tabla con los datos actualizados
        for (Ias objetoIa : iasTablaLocal) {
            String nombre = objetoIa.getNombre();
            String modeloIa = objetoIa.getModelo();
            int numeroUsos = objetoIa.getUsos();
            String popularidad = objetoIa.getPopularidad();

            Object[] fila = {nombre, modeloIa, numeroUsos, popularidad};
            modelo.addRow(fila);
        }

        // Actualizar la tabla
        modelo.fireTableDataChanged();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton borrarMasivoBoton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JToggleButton jToggleButton2;
    // End of variables declaration//GEN-END:variables
}
