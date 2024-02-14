/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import static com.mycompany.trabajoaccdatequipo1.Metodos.em;
import java.util.Collection;
import java.util.List;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.TypedQuery;

/**
 *
 * @author lucas
 * Clase que contiene métodos para operaciones relacionadas con prompts e IAs.
 */
public class MetodosLucas {
    
    /**
     * Inserta un nuevo prompt en la base de datos junto con sus asociaciones a las IAs.
     * 
     * @param listaias Lista de IAs a las que el prompt será asociado.
     * @param texto El texto del prompt a ser insertado.
     */
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
    
     /**
     * Borra un prompt específico de la base de datos por su ID, incluyendo sus asociaciones a las IAs.
     * 
     * @param id El ID del prompt a borrar.
     */
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
    
    /**
     * Muestra los detalles de un prompt específico por su ID, incluyendo las IAs asociadas.
     * 
     * @param id El ID del prompt cuyos detalles se quieren mostrar.
     * @return Una cadena de texto que contiene los detalles del prompt y sus IAs asociadas.
     */
    public static String mostrarPromptsYIasAsociadas(int id){
        em.getTransaction().begin();
        
        StringBuilder resultado = new StringBuilder();
        Prompts prompt = em.find(Prompts.class, id);

        try {
            if (prompt != null) {
                resultado.append("Prompt: '").append(prompt.getTexto()).append("'\n");
                resultado.append("Ias en las que se usa: \n");

                List<IasPrompts> coleccion = ( List<IasPrompts> )prompt.getIasPromptsCollection();
                
                for(IasPrompts it: coleccion) {
                    Ias ia = it.getIdia();
                    
                    // Se actualiza la popularidad de todas aquellas IAs 
                    // asociadas al Prompt que se esté consultando
                    Metodos.actualizarPopularidad(ia);
                    
                    resultado.append("- ").append(ia.getNombre()).append("\n");
                }
                
                
                
            }
        } catch (NoResultException e) {
            resultado.append("No existen usuarios\n");
        }
        
        em.getTransaction().commit();
        
        return resultado.toString();
    }   
    
    public static Prompts obtenerPrompt(int id ){
        

        TypedQuery<Prompts> query = em.createQuery("SELECT p FROM Prompts p WHERE idprompt =:IDP", Prompts.class);
        query.setParameter("IDP",id);
        Prompts prom = query.getSingleResult();

        return prom;
    }
    
    /**
     * Muestra todos los prompts almacenados en la base de datos.
     * 
     * @return Una cadena de texto que lista todos los prompts existentes.
     */
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
    
    /**
     * Obtiene y devuelve todos los prompts almacenados en la base de datos como una lista.
     * 
     * @return Una lista de objetos {@link Prompts} que representan todos los prompts existentes.
     */
    public static List<Prompts> obtenerTodosLosPrompts() {
        
        StringBuilder cadenon = new StringBuilder();

        TypedQuery<Prompts> query = em.createQuery("SELECT p FROM Prompts p", Prompts.class);
        List<Prompts> prompts = query.getResultList();
        return prompts;
    }
    
    /**
     * Obtiene y devuelve todas las IAs almacenadas en la base de datos como una lista.
     * 
     * @return Una lista de objetos {@link Ias} que representan todas las IAs existentes.
     */
    public static List<Ias> obtenerTodasLasIAsEnLista() {

        // Realizar la consulta
        TypedQuery<Ias> query = em.createQuery("SELECT i FROM Ias i", Ias.class);
        List<Ias> ias = query.getResultList();
        
        return ias;
    }
    
    /**
    * Método para eliminar todas las instancias de IAs en la base de datos.
    */
    public static void eliminarTodasLasIas() {
        // Obtener una lista de todas las IAs desde la base de datos
        List<Ias> lista = (List<Ias>) Metodos.selectAllIa();
        // Variable para almacenar el ID de la IA a borrar
        int idBorrar;

        // Iterar sobre cada IA en la lista
        for (Ias ia : lista) {
            
            
            
            // Obtener el ID de la IA actual
            idBorrar = ia.getIdia();
            // Llamar al método para eliminar la IA de la base de datos
            Metodos.deleteIA(idBorrar);
        }
    }
}
