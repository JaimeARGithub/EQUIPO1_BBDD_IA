/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author pokem
 */
public class Metodos {
    
    static EntityManagerFactory emf;
    static EntityManager em;
    
    /**
     * Método que establece la conexión a Oracle.
     */
    public static void establecerConexion() {
        emf = Persistence.createEntityManagerFactory("com.mycompany_TrabajoAccDatEquipo1_jar_1.0-SNAPSHOTPU");
        em = emf.createEntityManager();
        
        System.out.println("Conexión establecida.");
    }
    
    /**
     * Método que cierra la conexión con Oracle.
     */
    public static void cerrarConexion() {
        em.close();
        emf.close();
    }
}
