/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.trabajoaccdatequipo1;

import javax.swing.JOptionPane;

/**
 *
 * @author pokem, bacho, lucas
 */
public class TrabajoAccDatEquipo1 {

    public static void main(String[] args) {
        Metodos.establecerConexion();
        
        interfaz();
    }

    public static void interfaz() {
        String[] opciones = {"TIPOS", "IAS", "PROMPTS"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Selecciona una tabla", "Inicio",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        // Dependiendo de la opción seleccionada, puedes realizar acciones
        switch (opcionSeleccionada) {
            case 0:
                // Acción para la opción 1
                TiposInterfaz.main(null);
                break;
            case 1:
                // Acción para la opción 2
                IasInterfaz.main(null);
                break;
            case 2:
                // Acción para la opción 3
                PromptsInterfaz.main(null);
                break;
            default:
                // Código si se cierra el popup sin seleccionar ninguna opción
                System.out.println("No seleccionaste ninguna opción");
                break;
        }
    }  
}
