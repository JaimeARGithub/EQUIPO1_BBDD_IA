/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import static com.mycompany.trabajoaccdatequipo1.TrabajoAccDatEquipo1.interfaz;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lucas
 * 
 * La interfaz de usuario para la gestión de prompts.
 * Permite visualizar, añadir y eliminar prompts, así como ver las IAs asociadas a cada uno.
 */
public class PromptsInterfaz extends javax.swing.JFrame {

    private int filaSeleccionada = -1; // -1 indica que no hay ninguna fila seleccionada inicialmente
    private List<Prompts> listPrompts = MetodosLucas.obtenerTodosLosPrompts();
    
    /**
     * Constructor de la clase.
     * Inicializa los componentes de la interfaz y configura la tabla de prompts.
     */
    public PromptsInterfaz() {
        initComponents();
        desactivarBotones();

        establecerTabla();
        cargarDatosEnTabla();
    }

    /**
     * Carga los datos de los prompts en la tabla de la interfaz.
     * Actualiza el modelo de la tabla con la lista de prompts más reciente.
     */
    public void cargarDatosEnTabla(){
        
        listPrompts = MetodosLucas.obtenerTodosLosPrompts();
        DefaultTableModel modelo = (DefaultTableModel) tablaPrompts.getModel();
        
        modelo.setRowCount(0);
        
        for(Prompts p: listPrompts){
            String texto = p.getTexto();
            Object[] fila = new Object[]{texto};
            modelo.addRow(fila);
        }
    }
    
    /**
     * Desactiva los botones que requieren que una fila esté seleccionada.
     * Se llama al inicio y después de eliminar un prompt para asegurar el estado correcto de los botones.
     */
    public void desactivarBotones(){
        eliminarBoton.setEnabled(false);
        iasAsociadasBoton.setEnabled(false);
    }
    
    /**
     * Configura la tabla de prompts.
     * Inicializa el modelo de la tabla con una estructura básica sin datos.
     */
    public void establecerTabla(){
        tablaPrompts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null}, // Inicializa con dos columnas en lugar de cuatro
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Prompts" // Cambia los títulos de las columnas aquí
            }
        ));
    }
    
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrollPane1 = new java.awt.ScrollPane();
        jPanel1 = new javax.swing.JPanel();
        atrasBoton = new javax.swing.JButton();
        iasAsociadasBoton = new javax.swing.JButton();
        eliminarBoton = new javax.swing.JButton();
        añadirBoton = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaPrompts = new javax.swing.JTable();
        refrescarBoton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Prompts"));

        atrasBoton.setText("Atrás");
        atrasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                atrasBotonActionPerformed(evt);
            }
        });

        iasAsociadasBoton.setText("Ver IAs asociadas");
        iasAsociadasBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                iasAsociadasBotonActionPerformed(evt);
            }
        });

        eliminarBoton.setText("Eliminar prompts");
        eliminarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                eliminarBotonActionPerformed(evt);
            }
        });

        añadirBoton.setText("Añadir prompt");
        añadirBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                añadirBotonActionPerformed(evt);
            }
        });

        tablaPrompts.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tablaPrompts.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tablaPrompts.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tablaPromptsMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tablaPrompts);

        refrescarBoton.setText("Refrescar tabla");
        refrescarBoton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refrescarBotonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 592, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(iasAsociadasBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(eliminarBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(añadirBoton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(atrasBoton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(refrescarBoton)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 312, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(iasAsociadasBoton)
                    .addComponent(eliminarBoton)
                    .addComponent(añadirBoton))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(atrasBoton)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(refrescarBoton))))
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

    // Gestores de eventos para los botones y la tabla.
    
    private void atrasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_atrasBotonActionPerformed
        dispose();
        interfaz();
    }//GEN-LAST:event_atrasBotonActionPerformed

    private void iasAsociadasBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_iasAsociadasBotonActionPerformed
        int filaSeleccionada = tablaPrompts.getSelectedRow();
        if (filaSeleccionada >= 0) { // Asegúrate de que hay una fila seleccionada
            filaSeleccionada = tablaPrompts.convertRowIndexToModel(filaSeleccionada);// Convierte a índice del modelo si es necesario
            
            Prompts p = listPrompts.get(filaSeleccionada);
            int idPrompt = p.getIdprompt();
            
            MostrarPromptsIAS ventanaIAs = new MostrarPromptsIAS(idPrompt);
            ventanaIAs.setVisible(true);
        }
    }//GEN-LAST:event_iasAsociadasBotonActionPerformed

    private void eliminarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_eliminarBotonActionPerformed
        int filaSeleccionada = tablaPrompts.getSelectedRow();
        if (filaSeleccionada >= 0) { // Asegúrate de que hay una fila seleccionada
            filaSeleccionada = tablaPrompts.convertRowIndexToModel(filaSeleccionada);// Convierte a índice del modelo si es necesario
            
            int confirmacion = JOptionPane.showConfirmDialog(this, 
                "¿Estás seguro de que deseas eliminar este prompt?", "Confirmar eliminación", 
                JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
            
            if (confirmacion == JOptionPane.YES_OPTION) {
            
                Prompts p = listPrompts.get(filaSeleccionada);
                int idPrompt = p.getIdprompt();

                MetodosLucas.borrarPrompt(idPrompt);

                cargarDatosEnTabla();

                desactivarBotones();
            }
        }
    }//GEN-LAST:event_eliminarBotonActionPerformed

    
    private void tablaPromptsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tablaPromptsMouseClicked
        int filaSeleccionada = tablaPrompts.getSelectedRow();
        
        eliminarBoton.setEnabled(true);
        iasAsociadasBoton.setEnabled(true);
    }//GEN-LAST:event_tablaPromptsMouseClicked

    private void añadirBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_añadirBotonActionPerformed
        crearPromptInterfaz.main(null);
    }//GEN-LAST:event_añadirBotonActionPerformed

    private void refrescarBotonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refrescarBotonActionPerformed
        cargarDatosEnTabla(); 
    }//GEN-LAST:event_refrescarBotonActionPerformed

    /**
     * @param args the command line arguments
     * Método principal para ejecutar la interfaz.
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
            java.util.logging.Logger.getLogger(PromptsInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(PromptsInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(PromptsInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PromptsInterfaz.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new PromptsInterfaz().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton atrasBoton;
    private javax.swing.JButton añadirBoton;
    private javax.swing.JButton eliminarBoton;
    private javax.swing.JButton iasAsociadasBoton;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton refrescarBoton;
    private java.awt.ScrollPane scrollPane1;
    private javax.swing.JTable tablaPrompts;
    // End of variables declaration//GEN-END:variables
}
