/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.trabajoaccdatequipo1;

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
        
        Metodos.selectIa(2);

        Metodos.cerrarConexion();
    }
}
