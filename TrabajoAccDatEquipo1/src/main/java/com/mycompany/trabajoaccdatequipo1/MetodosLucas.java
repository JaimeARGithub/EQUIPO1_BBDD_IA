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
    

    
    private void borrarPromptTipicoIA(int id){
        
        em.getTransaction().begin();
        
        Prompts prompt = null;
        prompt = em.find(Prompts.class,id,LockModeType.PESSIMISTIC_READ);
        
        if(prompt!=null){
            em.remove(prompt);
            
            TypedQuery<IasPrompts> query = em.createQuery(
                "select iap from IasPrompts iap where iap.idprompt=:idPro" , 
                IasPrompts.class);
            query.setParameter("idPro", id);
            
            try{
                IasPrompts promptia=null;
                promptia = query.getSingleResult();
                em.remove(promptia);
            }catch(NoResultException e){
                System.out.println("No existe un usuario con ese id");
            }
        }
    }
    
    
    private void mostrarPromptsYIasAsociadas(int id){
        
        Prompts prompt = null;
        TypedQuery<Prompts> query = em.createNamedQuery(
                "Prompts.findById" , 
                Prompts.class);
        query.setParameter("idprompt", id);
        try{
            prompt = query.getSingleResult();
            if(prompt!=null){
                System.out.println("Prompt: "+prompt.getTexto());
                System.out.println("Ias en las que se usa: ");
                
                Collection<IasPrompts> coleccion = prompt.getIasPromptsCollection();
                Iterator<IasPrompts> it = coleccion.iterator();
                
                while (it.hasNext()){
                    IasPrompts iap = it.next();
                    Ias ia=iap.getIdia();
                    System.out.println("- "+ia.getNombre());
                }
            }
        }catch(NoResultException e){
            System.out.println("No existen usuarios");
        }
    }   
    
    private void mostrarTodosLosPrompts(){
        em.getTransaction().begin();
        
        TypedQuery<Prompts> query = em.createQuery("SELECT p FROM Prompts u", Prompts.class);

        List<Prompts> prompts = query.getResultList();

        if (!prompts.isEmpty()) {
            for (Prompts prompt : prompts) {
                System.out.println("Prompt: " + prompt.getTexto());
            }
        } else {
            System.out.println("No hay prompts en la base de datos.");
        }
        
        em.getTransaction().commit();
    }
}
