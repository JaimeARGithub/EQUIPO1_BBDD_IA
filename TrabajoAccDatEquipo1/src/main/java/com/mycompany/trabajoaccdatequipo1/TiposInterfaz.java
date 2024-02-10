/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.Collection;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author pokem
 */
public class TiposInterfaz extends javax.swing.JFrame {

    /**
     * Creates new form TiposInterfaz
     */
    
    // Recogemos los datos de todos los tipos para pasárselos como datos a la tabla
    public static Collection<Tipos> tiposTabla;
    DefaultTableModel modelo;
    
    public TiposInterfaz() {
        initComponents();
        
        modelo = (DefaultTableModel) tablaTipos.getModel();
        
        // quito el autoresize para que no se auto-ajusten las dos columnas al cambiar el ancho de la ventana
        tablaTipos.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_OFF);
        
        // a la primera columna le fijo el ancho y a la segunda se lo dejo expandible
        tablaTipos.getColumnModel().getColumn(0).setPreferredWidth(200);
        
        tablaTipos.getColumnModel().getColumn(1).setPreferredWidth(1000);
        tablaTipos.getColumnModel().getColumn(1).setResizable(true);

        // A la tabla se le pasan como datos la info recogida sobre los tipos
        actualizarTabla();
        
        
        // Para hacer que los botones Modificar, Eliminar y Consultar se deshabiliten y habiliten:
        // se establece un listener de la selección
        tablaTipos.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                
                // Si la fila seleccionada es la de posición 0 o más, se habilitan
                if (tablaTipos.getSelectedRow() > -1) {
                    btnModificarTipos.setEnabled(true);
                    btnEliminarTipos.setEnabled(true);
                    btnConsultarTipos.setEnabled(true);
                    
                // Si no, se deshabilitan
                } else {
                    btnModificarTipos.setEnabled(false);
                    btnEliminarTipos.setEnabled(false);
                    btnConsultarTipos.setEnabled(false);
                }
            }
        } );
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnNuevoTipos = new javax.swing.JButton();
        btnModificarTipos = new javax.swing.JButton();
        btnEliminarTipos = new javax.swing.JButton();
        btnConsultarTipos = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaTipos = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Tipos"));

        btnNuevoTipos.setText("Nuevo");
        btnNuevoTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNuevoTiposActionPerformed(evt);
            }
        });

        btnModificarTipos.setText("Modificar");
        btnModificarTipos.setEnabled(false);
        btnModificarTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarTiposActionPerformed(evt);
            }
        });

        btnEliminarTipos.setText("Eliminar");
        btnEliminarTipos.setEnabled(false);
        btnEliminarTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarTiposActionPerformed(evt);
            }
        });

        btnConsultarTipos.setText("Consultar");
        btnConsultarTipos.setEnabled(false);
        btnConsultarTipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnConsultarTiposActionPerformed(evt);
            }
        });

        tablaTipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Tipo", "Descripción"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(tablaTipos);
        if (tablaTipos.getColumnModel().getColumnCount() > 0) {
            tablaTipos.getColumnModel().getColumn(0).setResizable(false);
            tablaTipos.getColumnModel().getColumn(1).setResizable(false);
        }

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnNuevoTipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnModificarTipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnEliminarTipos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnConsultarTipos, javax.swing.GroupLayout.DEFAULT_SIZE, 116, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnNuevoTipos)
                .addGap(18, 18, 18)
                .addComponent(btnModificarTipos)
                .addGap(18, 18, 18)
                .addComponent(btnEliminarTipos)
                .addGap(18, 18, 18)
                .addComponent(btnConsultarTipos)
                .addContainerGap(123, Short.MAX_VALUE))
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
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

    private void btnNuevoTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNuevoTiposActionPerformed
        tablaTipos.clearSelection();
        
        TiposInterfazInsertar dialog = new TiposInterfazInsertar(TiposInterfaz.this, true);
        
        dialog.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosed(WindowEvent e) {
                actualizarTabla();
            }
        });
        dialog.setVisible(true);
    }//GEN-LAST:event_btnNuevoTiposActionPerformed

    private void btnModificarTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarTiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnModificarTiposActionPerformed

    private void btnConsultarTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnConsultarTiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnConsultarTiposActionPerformed

    private void btnEliminarTiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarTiposActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarTiposActionPerformed

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
            java.util.logging.Logger.getLogger(TiposInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TiposInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TiposInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TiposInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TiposInterfaz().setVisible(true);
            }
        });
    }
    
    
    public void actualizarTabla() {
        // se elimina la fila inicial de la tabla
        while (modelo.getRowCount() > 0) {
            modelo.removeRow(0);
        }
        
        // se recupera la info sobre los tipos
        tiposTabla = Metodos.selectAllTipos();
        
        // se recorre la colección devuelta, y mediante sus datos se rellena la tabla
        for (Tipos e:tiposTabla) {
            String tipo = e.getTipo();
            String desc = e.getDescripcion();
            
            // los datos se pasan a la tabla en forma de array de objetos
            Object[] fila = {tipo, desc};
            modelo.addRow(fila);
        }
        
        // y se actualiza la tabla
        modelo.fireTableDataChanged();
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnConsultarTipos;
    private javax.swing.JButton btnEliminarTipos;
    private javax.swing.JButton btnModificarTipos;
    private javax.swing.JButton btnNuevoTipos;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaTipos;
    // End of variables declaration//GEN-END:variables
}
