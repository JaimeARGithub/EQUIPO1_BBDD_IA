/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import static com.mycompany.trabajoaccdatequipo1.Metodos.em;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author lucas
 */
public class MetodosLucas {
    
    
    public static void insertarPrompts(List<Ias> listaias, String texto){
        em.getTransaction().begin();
        
        Prompts promptDEF = new Prompts(texto,null);
        em.persist(promptDEF);
        for(Ias ia: listaias){
            IasPrompts iaps = new IasPrompts(ia,promptDEF);
            em.persist(iaps);
        }        
        em.getTransaction().commit();
    }
    
    public static void borrarPrompt(int id){
        
        em.getTransaction().begin();
        
        Prompts prompt = em.find(Prompts.class,id,LockModeType.PESSIMISTIC_READ);
        
        Collection<IasPrompts> colec = prompt.getIasPromptsCollection();
        
        for(IasPrompts iap: colec) {
            em.remove(iap);
        }
        
        em.remove(prompt);
        
        em.getTransaction().commit();
    }
    
    
    public static String mostrarPromptsYIasAsociadas(int id){
        
        StringBuilder resultado = new StringBuilder();
        Prompts prompt = null;
        prompt = em.find(Prompts.class, id);

        try {
            if (prompt != null) {
                resultado.append("Prompt: '").append(prompt.getTexto()).append("'\n");
                resultado.append("Ias en las que se usa: \n");

                Collection<IasPrompts> coleccion = prompt.getIasPromptsCollection();
                Iterator<IasPrompts> it = coleccion.iterator();

                em.getTransaction().begin();
                
                while (it.hasNext()) {
                    IasPrompts iap = it.next();
                    Ias ia = iap.getIdia();
                    
                    // Se actualiza la popularidad de todas aquellas IAs 
                    // asociadas al Prompt que se esté consultando
                    Metodos.actualizarPopularidad(ia);
                    
                    resultado.append("- ").append(ia.getNombre()).append("\n");
                }
                
                em.getTransaction().commit();
                
            }
        } catch (NoResultException e) {
            resultado.append("No existen usuarios\n");
        }
        return resultado.toString();
    }   
    
    
    public static String mostrarTodosLosPrompts(){
        em.getTransaction().begin();
        
        //TypedQuery<Prompts> query = em.createQuery("SELECT p FROM Prompts p", Prompts.class);
        TypedQuery<Prompts> query = em.createQuery("SELECT p FROM Prompts p ORDER BY p.idprompt ASC", Prompts.class);
        List<Prompts> prompts = query.getResultList();

        StringBuilder resultados = new StringBuilder();

        if (!prompts.isEmpty()) {
            for (Prompts prompt : prompts) {
                resultados.append("ID: ").append(prompt.getIdprompt()).append(" Prompt: ").append(prompt.getTexto()).append("\n");
            }
        } else {
            resultados.append("No hay prompts en la base de datos.");
        }

        em.getTransaction().commit();

        return resultados.toString();
    }
    
    public static List<Prompts> obtenerTodosLosPrompts() {
        
        StringBuilder cadenon = new StringBuilder();

        TypedQuery<Prompts> query = em.createQuery("SELECT p FROM Prompts p", Prompts.class);
        List<Prompts> prompts = query.getResultList();

        return prompts;
    }
    
    public static List<Ias> obtenerTodasLasIAsEnLista() {
        StringBuilder result = new StringBuilder();

        // Realizar la consulta
        TypedQuery<Ias> query = em.createQuery("SELECT i FROM Ias i", Ias.class);
        List<Ias> ias = query.getResultList();

        return ias;
    }
}
