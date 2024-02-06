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

        //Metodos.insertarDatos();
        //Metodos.insertarTipo(3, "Generación de audio y música", "Ias empleadas para generar y retransmitir audio, ya sean voces o ruidos, según las especificaciones dadas.");
        //Metodos.verTipos();
        //Metodos.verTipoDatos(2);
        //Metodos.borrarTipo(2);
        //Metodos.modificarTipo("2", "Cambio de nombre de prueba", "Cambio de descripción de prueba");
        //MetodosLucas.mostrarTodosLosPrompts();
        //MetodosLucas.borrarPrompt(2); PROBARPROBARPROBARPROBAR
        //MetodosLucas.instarPrompts();
        //MetodosLucas.mostrarPromptsYIasAsociadas(2);
        //Metodos.insertIa(iaActual, tipoActual);
        //MetodosLucas.insertarPrompts(1, 13,"OLIOLILLI");
        //MetodosLucas.mostrarPromptsYIasAsociadas(2);
        //Metodos.insertIa(iaActual, tipoActual);
        //Metodos.deleteIA(20);
        //Metodos.modificarIa(iaActual);
        
        Metodos.selectIa(1);
        
        //interfaz();
        
        Metodos.cerrarConexion();
    }

    public static void interfaz() {
        String[] opciones = {"IAS", "PROMPTS", "TIPOS"};
        int opcionSeleccionada = JOptionPane.showOptionDialog(null, "Selecciona una tabla", "Inicio",
                JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, opciones, opciones[0]);

        // Dependiendo de la opción seleccionada, puedes realizar acciones
        switch (opcionSeleccionada) {
            case 0:
                // Acción para la opción 1
               IasInterfaz.main(null);
                break;
            case 1:
                // Acción para la opción 2
                System.out.println("Seleccionaste la opción 2");
                break;
            case 2:
                // Acción para la opción 3
                System.out.println("Seleccionaste la opción 3");
                break;
            default:
                // Código si se cierra el popup sin seleccionar ninguna opción
                System.out.println("No seleccionaste ninguna opción");
                break;
        }
    }
}
