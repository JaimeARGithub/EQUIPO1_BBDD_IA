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
        
        Ias iaActual = new Ias();
        iaActual.setIdia(8);
        iaActual.setNombre("IA1");
        iaActual.setModelo("Modelo1");
        iaActual.setUsos(0);
        iaActual.setPopularidad("Alta");

        Tipos tipoActual = new Tipos();
        tipoActual.setIdtipo(2);
        tipoActual.setTipo("Tipo1");
        tipoActual.setDescripción("Descripcion1");
        
        Metodos.insertIa(iaActual, tipoActual);
        
        Metodos.cerrarConexion();
    }
}
