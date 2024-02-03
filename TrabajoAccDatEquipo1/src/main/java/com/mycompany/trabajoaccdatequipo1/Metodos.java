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
 * @author pokem, bacho, lucas
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
    
    /**
     * Métodos para insertar datos de prueba con los que poder trabajar.
     */
    public static void insertarDatos() {
        em.getTransaction().begin();
        
        
        // INSERT DE LOS TIPOS
        Tipos tipo1 = new Tipos(1, "Generación de texto por chat", "IAs con capacidad de recibir prompts en forma de texto y responder a ellas en formato chat.");
        em.persist(tipo1);
        Tipos tipo2 = new Tipos(2, "Generación de imágenes", "IAs que indexan búsquedas en internet y mezclan resultados para generar una imagen que responde a una serie de prompts proporcionados.");
        em.persist(tipo2);
        
        
        // INSERT DE LAS IAS
        //las del tipo 1
        Ias ia1 = new Ias(1, "ChatGPT", "GPT", tipo1);
        em.persist(ia1);
        Ias ia2 = new Ias(2, "Cloudyu", "Mixtral", tipo1);
        em.persist(ia2);
        Ias ia3 = new Ias(3, "Llama2", "GPT", tipo1);
        em.persist(ia3);
        //las del tipo 2
        Ias ia4 = new Ias(4, "Dall-e", "GPT", tipo2);
        em.persist(ia4);
        Ias ia5 = new Ias(5, "Midjourney", "GPT", tipo2);
        em.persist(ia5);
        Ias ia6 = new Ias(6, "Dreambooth", "Stable Diffusion", tipo2);
        em.persist(ia6);
        
        
        
        // INSERT DE LOS PROMPTS
        //los de texto
        Prompts p1 = new Prompts(1, "Resume este texto", null);
        em.persist(p1);
        Prompts p2 = new Prompts(2, "Ofusca este texto", null);
        em.persist(p2);
        Prompts p3 = new Prompts(3, "Reescribe este texto de manera más sensible al contenido", null);
        em.persist(p3);
        //los de imagen
        Prompts p4 = new Prompts(4, "Genera un paisaje surrealista con colores vibrantes.", null);
        em.persist(p4);
        Prompts p5 = new Prompts(5, "Diseña un animal mitológico híbrido entre mantícora y centauro.", null);
        em.persist(p5);
        Prompts p6 = new Prompts(6, "Crea una represntación visual de la teoría de cuerdas, concepto científico abstracto.", null);
        em.persist(p6);
        
        
        
        // INSERT DE LAS INSTANCIAS INTERMEDIAS PARA LA TABLA N:M
        // las de texto:
        //combinaciones de ia1 con p1, p2 y p3
        IasPrompts ip1 = new IasPrompts(1, ia1, p1);
        em.persist(ip1);
        IasPrompts ip2 = new IasPrompts(2, ia1, p2);
        em.persist(ip2);
        IasPrompts ip3 = new IasPrompts(3, ia1, p3);
        em.persist(ip3);
        //combinaciones de ia2 con p1, p2 y p3
        IasPrompts ip4 = new IasPrompts(4, ia2, p1);
        em.persist(ip4);
        IasPrompts ip5 = new IasPrompts(5, ia2, p2);
        em.persist(ip5);
        IasPrompts ip6 = new IasPrompts(6, ia2, p3);
        em.persist(ip6);
        //combinaciones de ia3 con p1, p2 y p3
        IasPrompts ip7 = new IasPrompts(7, ia3, p1);
        em.persist(ip7);
        IasPrompts ip8 = new IasPrompts(8, ia3, p2);
        em.persist(ip8);
        IasPrompts ip9 = new IasPrompts(9, ia3, p3);
        em.persist(ip9);

        // las de imagen:
        //combinaciones de ia4 con p4, p5 y p6
        IasPrompts ip10 = new IasPrompts(10, ia4, p4);
        em.persist(ip10);
        IasPrompts ip11 = new IasPrompts(11, ia4, p5);
        em.persist(ip11);
        IasPrompts ip12 = new IasPrompts(12, ia4, p6);
        em.persist(ip12);
        //combinaciones de ia5 con p4, p5 y p6
        IasPrompts ip13 = new IasPrompts(13, ia5, p4);
        em.persist(ip13);
        IasPrompts ip14 = new IasPrompts(14, ia5, p5);
        em.persist(ip14);
        IasPrompts ip15 = new IasPrompts(15, ia5, p6);
        em.persist(ip15);
        //combinaciones de ia6 con p4, p5 y p6
        IasPrompts ip16 = new IasPrompts(16, ia6, p4);
        em.persist(ip16);
        IasPrompts ip17 = new IasPrompts(17, ia6, p5);
        em.persist(ip17);
        IasPrompts ip18 = new IasPrompts(18, ia6, p6);
        em.persist(ip18);
        
        
        em.getTransaction().commit();
    }
}
