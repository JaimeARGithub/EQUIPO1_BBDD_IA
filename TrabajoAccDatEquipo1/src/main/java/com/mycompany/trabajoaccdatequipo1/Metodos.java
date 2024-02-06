/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collection;
import java.util.Iterator;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.TypedQuery;

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

    /**
     * Método que permite realizar la inserción de un tipo de ia en la base de
     * datos. Antes de realizarse la inserción, se hace una búsqueda en la base
     * de datos; primero por id y luego por nombre. Si el tipo de IA que se
     * intenta insertar NO existe, se inserta.
     *
     * @param id id del tipo a insertar
     * @param nombre nombre del tipo de IA
     * @param desc descripción de los usos para los que se emplea el tipo de ia
     */
    public static void insertarTipo(int id, String nombre, String desc) {
        em.getTransaction().begin();
        Tipos tipoBusca = null;

        // Primero se busca por id; si existe, mensaje de error
        tipoBusca = em.find(Tipos.class, id, LockModeType.PESSIMISTIC_READ);
        if (tipoBusca != null) {
            System.out.println("Ya existe ese tipo en la base de datos.");
        } else {

            // Luego se busca por nombre; si existe, mensaje de error; si no, se inserta
            TypedQuery<Tipos> query = em.createQuery("select t from Tipos t where t.tipo=:NOMBREP", Tipos.class);
            query.setParameter("NOMBREP", nombre);
            try {

                tipoBusca = query.getSingleResult();
                System.out.println("Ya existe un tipo con ese nombre en la base de datos.");

            } catch (NoResultException e) {

                Tipos tipoInsertar = new Tipos(id, nombre, desc);
                em.persist(tipoInsertar);
                System.out.println("Tipo insertado con éxito.");

            }
        }

        em.getTransaction().commit();
    }

    /**
     * Método para ver todos los datos existentes en la tabla "tipos de IAs".
     * Aunque la rúbrica especifica hacerlo sin JPQL, no es posible hacer una
     * select de todos los datos sin él, por lo que el uso de una typed query es
     * forzoso.
     */
    public static void verTipos() {
        em.getTransaction().begin();

        TypedQuery<Tipos> query = em.createQuery("select t from Tipos t", Tipos.class);

        Collection<Tipos> colec = query.getResultList();
        if (colec.isEmpty()) {
            System.out.println("No existen datos en la tabla 'Tipos de IAs'.");
        } else {
            Tipos tipo = null;
            Iterator<Tipos> it = colec.iterator();
            while (it.hasNext()) {
                tipo = it.next();
                System.out.println("ID del tipo: " + tipo.getIdtipo());
                System.out.println("Tipo: " + tipo.getTipo());
                System.out.println("Descripción: " + tipo.getDescripcion());
                System.out.println("--------------------------------------------------");
            }
        }

        em.getTransaction().commit();
    }

    /**
     * Método que localiza, SIN USAR JPQL, un tipo en base a su id. Si el tipo
     * no existe, muestra un mensaje de error. Una vez encontrado, muestra sus
     * datos y los de la colección de IAs que tenga asociada.
     *
     * @param id id del tipo a encontrar
     */
    public static void verTipoDatos(int id) {
        em.getTransaction().begin();

        Tipos tipo = null;
        tipo = em.find(Tipos.class, id, LockModeType.PESSIMISTIC_READ);

        if (tipo == null) {
            System.out.println("No existe el tipo con id " + id + ".");
        } else {

            System.out.println("ID del tipo: " + tipo.getIdtipo());
            System.out.println("Tipo: " + tipo.getTipo());
            System.out.println("Descripción: " + tipo.getDescripcion());
            System.out.println("--------------------------------------------------");
            System.out.println("--------------------------------------------------");

            Collection<Ias> colec = tipo.getIasCollection();
            if (colec.isEmpty()) {
                System.out.println("El tipo con id " + tipo.getIdtipo() + "no tiene IAs asociadas.");
            } else {

                System.out.println("El tipo con id " + tipo.getIdtipo() + " dispone de IAs asociadas.");
                System.out.println("");
                Ias ia = null;
                Iterator<Ias> it = colec.iterator();
                while (it.hasNext()) {

                    ia = it.next();
                    System.out.println("ID de la IA: " + ia.getIdia());
                    System.out.println("Nombre de la IA: " + ia.getNombre());
                    System.out.println("Modelo en que está basada: " + ia.getModelo());
                    System.out.println("Nº de veces usada: " + ia.getUsos());
                    System.out.println("Popularidad: " + ia.getPopularidad());
                    System.out.println("--------------------------------------------------");

                }
            }

        }

        em.getTransaction().commit();
    }

    /**
     * LÓGICA DE NEGOCIO: NO PUEDEN BORRARSE REGISTROS DE LOS QUE DEPENDAN OTROS
     * PRIMERO HABRÁ QUE BORRAR ESOS OTROS REGISTROS DEPENDIENTES Método que
     * hace el borrado de un tipo buscándolo por su ID. Primero se controla que
     * el tipo exista. Si no existe, mensaje de error. Tras ver que exista, se
     * controla que tenga registros que dependan de él. Si los tiene, mensaje de
     * error. Si el tipo existe y no hay IAs que dependan de él, el borrado se
     * hace correctamente.
     *
     * @param id id del tipo a borrar
     */
    public static void borrarTipo(int id) {
        em.getTransaction().begin();
        Tipos tipo = null;

        // Se busca el tipo
        tipo = em.find(Tipos.class, id, LockModeType.PESSIMISTIC_READ);

        // Si el tipo no existe, mensaje de error
        if (tipo == null) {
            System.out.println("No existe el tipo con id " + id + ".");
        } else {

            // Antes de hacer el borrado, se verifica que el tipo no tenga registros asociados
            // Se recoge su lista de IAs asociadas
            // Si está vacía, el registro se borra correctamente
            // Si no, mensaje de error para evitar que el usuario borre registros sin querer
            Collection<Ias> colec = tipo.getIasCollection();

            // Si la lista está vacía
            if (colec.isEmpty()) {
                em.remove(tipo);
                System.out.println("El tipo con id " + id + " se ha borrado correctamente.");
                // Si no    
            } else {
                System.out.println("No es posible borrar ese registro.");
                System.out.println("¡¡Existen otros registros que dependen de él!!");
                System.out.println("Borra esos registros e inténtalo de nuevo.");
            }

        }

        em.getTransaction().commit();
    }

    /**
     * Método que permite hacer la modificación de un registro "tipo de IA".
     * Para que se pueda modificar un registro, EL USUARIO TIENE QUE ESCRIBIR EN
     * TODOS LOS CAMPOS. SI NO ESTÁN TODOS RELLENOS, MENSAJE DE ERROR. Tras eso
     * se busca que exista el registro a modificar. Si no existe, mensaje de
     * error.
     *
     * @param id id del tipo a modificar
     * @param nombre nuevo nombre para el tipo
     * @param desc nueva descripción para el tipo
     */
    public static void modificarTipo(String id, String nombre, String desc) {
        if (id.isEmpty() || id.isBlank() || nombre.isEmpty() || nombre.isBlank() || desc.isEmpty() || desc.isBlank()) {

            System.out.println("Error en la modificación.");
            System.out.println("Se deben rellenar todos los campos.");

        } else {
            em.getTransaction().begin();

            int idTipo = Integer.parseInt(id);
            Tipos tipo = null;

            tipo = em.find(Tipos.class, idTipo, LockModeType.PESSIMISTIC_READ);
            if (tipo == null) {

                System.out.println("No existe el tipo con id " + idTipo + ".");

            } else {

                tipo.setTipo(nombre);
                tipo.setDescripcion(desc);
                System.out.println("Se ha modificado correctamente el tipo con id" + idTipo + " .");

            }

            em.getTransaction().commit();
        }
    }

    public void deleteIA(int idIa) {
        em.getTransaction().begin();

        Ias ia = em.find(Ias.class, idIa);
        em.remove(ia);

        em.getTransaction().commit();
    }

    public static void insertIa(Ias iaActual, Tipos tipoActual) {
        em.getTransaction().begin();
        Tipos tipo = em.find(Tipos.class, tipoActual.getIdtipo());

        if (tipo == null) {
            System.out.println("El tipo no existe");
            return;
        }

        Ias ia = em.find(Ias.class, iaActual.getIdia());

        if (ia != null) {
            System.out.println("El ID de la IA ya existe.");
            return;
        }

        TypedQuery<Ias> query = em.createQuery("SELECT i FROM Ias i WHERE i.nombre = :nombre", Ias.class);
        query.setParameter("nombre", iaActual.getNombre());
        Collection<Ias> iasConMismoNombre = query.getResultList();
        if (!iasConMismoNombre.isEmpty()) {
            System.out.println("El nombre de la IA ya existe.");
            return;
        }
        
        
        iaActual.setIdtipo(tipoActual);
        em.persist(iaActual);
        em.getTransaction().commit();
    }
    
    

}
