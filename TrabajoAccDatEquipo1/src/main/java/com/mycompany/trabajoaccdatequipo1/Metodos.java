/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import java.math.BigDecimal;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.LockModeType;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.swing.JOptionPane;

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
        Tipos tipo1 = new Tipos(autoIdTipo(), "Generación de texto por chat", "IAs con capacidad de recibir prompts en forma de texto y responder a ellas en formato chat.");
        em.persist(tipo1);
        Tipos tipo2 = new Tipos(autoIdTipo(), "Generación de imágenes", "IAs que indexan búsquedas en internet y mezclan resultados para generar una imagen que responde a una serie de prompts proporcionados.");
        em.persist(tipo2);

        // INSERT DE LAS IAS
        //las del tipo 1
        Ias ia1 = new Ias(autoIdIA(), "ChatGPT", "GPT", tipo1);
        em.persist(ia1);
        Ias ia2 = new Ias(autoIdIA(), "Cloudyu", "Mixtral", tipo1);
        em.persist(ia2);
        Ias ia3 = new Ias(autoIdIA(), "Llama2", "GPT", tipo1);
        em.persist(ia3);
        //las del tipo 2
        Ias ia4 = new Ias(autoIdIA(), "Dall-e", "GPT", tipo2);
        em.persist(ia4);
        Ias ia5 = new Ias(autoIdIA(), "Midjourney", "GPT", tipo2);
        em.persist(ia5);
        Ias ia6 = new Ias(autoIdIA(), "Dreambooth", "Stable Diffusion", tipo2);
        em.persist(ia6);

        // INSERT DE LOS PROMPTS
        //los de texto
        Prompts p1 = new Prompts(autoIdPrompt(), "Resume este texto", null);
        em.persist(p1);
        Prompts p2 = new Prompts(autoIdPrompt(), "Ofusca este texto", null);
        em.persist(p2);
        Prompts p3 = new Prompts(autoIdPrompt(), "Reescribe este texto de manera más sensible al contenido", null);
        em.persist(p3);
        //los de imagen
        Prompts p4 = new Prompts(autoIdPrompt(), "Genera un paisaje surrealista con colores vibrantes.", null);
        em.persist(p4);
        Prompts p5 = new Prompts(autoIdPrompt(), "Diseña un animal mitológico híbrido entre mantícora y centauro.", null);
        em.persist(p5);
        Prompts p6 = new Prompts(autoIdPrompt(), "Crea una represntación visual de la teoría de cuerdas, concepto científico abstracto.", null);
        em.persist(p6);

        // INSERT DE LAS INSTANCIAS INTERMEDIAS PARA LA TABLA N:M
        // las de texto:
        //combinaciones de ia1 con p1, p2 y p3
        IasPrompts ip1 = new IasPrompts(autoIdIaPrompt(), ia1, p1);
        em.persist(ip1);
        IasPrompts ip2 = new IasPrompts(autoIdIaPrompt(), ia1, p2);
        em.persist(ip2);
        IasPrompts ip3 = new IasPrompts(autoIdIaPrompt(), ia1, p3);
        em.persist(ip3);
        //combinaciones de ia2 con p1, p2 y p3
        IasPrompts ip4 = new IasPrompts(autoIdIaPrompt(), ia2, p1);
        em.persist(ip4);
        IasPrompts ip5 = new IasPrompts(autoIdIaPrompt(), ia2, p2);
        em.persist(ip5);
        IasPrompts ip6 = new IasPrompts(autoIdIaPrompt(), ia2, p3);
        em.persist(ip6);
        //combinaciones de ia3 con p1, p2 y p3
        IasPrompts ip7 = new IasPrompts(autoIdIaPrompt(), ia3, p1);
        em.persist(ip7);
        IasPrompts ip8 = new IasPrompts(autoIdIaPrompt(), ia3, p2);
        em.persist(ip8);
        IasPrompts ip9 = new IasPrompts(autoIdIaPrompt(), ia3, p3);
        em.persist(ip9);

        // las de imagen:
        //combinaciones de ia4 con p4, p5 y p6
        IasPrompts ip10 = new IasPrompts(autoIdIaPrompt(), ia4, p4);
        em.persist(ip10);
        IasPrompts ip11 = new IasPrompts(autoIdIaPrompt(), ia4, p5);
        em.persist(ip11);
        IasPrompts ip12 = new IasPrompts(autoIdIaPrompt(), ia4, p6);
        em.persist(ip12);
        //combinaciones de ia5 con p4, p5 y p6
        IasPrompts ip13 = new IasPrompts(autoIdIaPrompt(), ia5, p4);
        em.persist(ip13);
        IasPrompts ip14 = new IasPrompts(autoIdIaPrompt(), ia5, p5);
        em.persist(ip14);
        IasPrompts ip15 = new IasPrompts(autoIdIaPrompt(), ia5, p6);
        em.persist(ip15);
        //combinaciones de ia6 con p4, p5 y p6
        IasPrompts ip16 = new IasPrompts(autoIdIaPrompt(), ia6, p4);
        em.persist(ip16);
        IasPrompts ip17 = new IasPrompts(autoIdIaPrompt(), ia6, p5);
        em.persist(ip17);
        IasPrompts ip18 = new IasPrompts(autoIdIaPrompt(), ia6, p6);
        em.persist(ip18);

        em.getTransaction().commit();
    }

    /**
     * Método que permite realizar la inserción de un tipo de ia en la base de
     * datos. Antes de realizarse la inserción, se hace una búsqueda en la base
     * de datos por nombre. Si el tipo de IA que se intenta insertar NO existe,
     * se inserta.
     *
     * @param nombre nombre del tipo de IA
     * @param desc descripción de los usos para los que se emplea el tipo de ia
     */
    public static void insertarTipo(String nombre, String desc) {
        em.getTransaction().begin();
        Tipos tipoBusca = null;

        // Se busca por nombre; si existe, mensaje de error; si no, se inserta
        TypedQuery<Tipos> query = em.createQuery("select t from Tipos t where t.tipo=:NOMBREP", Tipos.class);
        query.setParameter("NOMBREP", nombre);
        try {

            tipoBusca = query.getSingleResult();
            JOptionPane.showMessageDialog(null, "Ya existe un tipo con ese nombre en la base de datos.");
            System.out.println("Ya existe un tipo con ese nombre en la base de datos.");

        } catch (NoResultException e) {

            Tipos tipoInsertar = new Tipos(nombre, desc);
            em.persist(tipoInsertar);
            System.out.println("Tipo insertado con éxito.");

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
     * Método que realiza una consulta a la base de datos para hallar toda la
     * información relativa a los tipos de IAs y la devuelve en forma de
     * colección de objetos.
     *
     * @return Colección de objetos con la información de la tabla Tipos en
     * forma de colección de objetos Tipos.
     */
    public static Collection<Tipos> selectAllTipos() {
        TypedQuery<Tipos> query = em.createQuery("select t from Tipos t", Tipos.class);
        return query.getResultList();
    }

    /**
     * Método que recibe por parámetro el ID de un Tipo y devuelve una String que
     * contiene toda la información relativa a dicho tipo y a sus relaciones con
     * la tabla IAs, mostrando los datos de las IAs que tenga asociadas. Si no 
     * existe un Tipo con el ID introducido, se devuelve un mensaje de error.
     *
     * @param id id del tipo a encontrar, cuya info se mostrará
     * @return String que contiene toda la información relativa al tipo encontrado
     */
    public static String verTipoDatos(int id) {
        em.getTransaction().begin();
        
        StringBuilder datos = new StringBuilder();
        
        Tipos tipo = null;
        tipo = em.find(Tipos.class, id, LockModeType.PESSIMISTIC_READ);

        
        if (tipo == null) {
            datos.append("No se han encontrado tipos con el ID proporcionado.\n");
        } else {

            datos.append("Tipo seleccionado: \n").append(tipo.getTipo()).append("\n");
            datos.append("Descripción: \n").append(tipo.getDescripcion()).append("\n\n\n");

            Collection<Ias> colec = tipo.getIasCollection();
            
            if (colec.isEmpty()) {
                datos.append("El tipo no tiene IAs asociadas.");
            } else {

                datos.append("El tipo dispone de IAs asociadas.\n\n");

                Ias ia = null;
                Iterator<Ias> it = colec.iterator();
                while (it.hasNext()) {
                    
                    ia = it.next();
                    datos.append("Nombre de la IA: ").append(ia.getNombre()).append("\n");
                    datos.append("Modelo en que está basada: ").append(ia.getModelo()).append("\n");
                    datos.append("Número de usos: ").append(ia.getUsos()).append("\n");
                    datos.append("Popularidad: ").append(ia.getPopularidad()).append("\n\n");

                }
            }

        }
        
        em.getTransaction().commit();
        
        return datos.toString();
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

    /**
     * Método que realiza el borrado de un registro de la tabla IAs, buscándolo
     * por su id. En primer lugar se verifica que exista la IA correspondiente
     * al id introducido; si no existe, mensaje de error. Si existe, se borra la
     * IA Y TAMBIÉN SE BORRAN los registros que la asocian con la tabla
     * intermedia, borrando las relaciones entre la tabla IasPrompts y la IA
     * borrada.
     *
     * @param idIa id de la ia a borrar
     */
    public static void deleteIA(int idIa) {
        em.getTransaction().begin();

        Ias ia = em.find(Ias.class, idIa, LockModeType.PESSIMISTIC_READ);
        if (ia != null) {
            // Primero eliminamos las relaciones en la tabla intermedia
            Collection<IasPrompts> iasPromptsCollection = ia.getIasPromptsCollection();
            for (IasPrompts iasPrompts : iasPromptsCollection) {
                em.remove(iasPrompts);
            }

            // Luego eliminamos la IA
            em.remove(ia);
        } else {
            System.out.println("La Ia no existe");
        }

        em.getTransaction().commit();
    }

    /**
     * Método que permite hacer la inserción de una IA, recibiendo por parámetro
     * el objeto IA a insertar y el id del Tipo al que irá asociada. En primer
     * lugar se verifica que el tipo al que se va a asociar exista. Si existe,
     * se verifica que no existan previamente en la base de datos el ID y el
     * nombre de la IA que se va a insertar. Si se superan las comprobaciones,
     * la IA se inserta en la base de datos.
     *
     * @param iaActual objeto IA cuyos datos se insertarán
     * @param nombreTipo nombre del tipo al que se asociará la ia
     */
    public static void insertIa(Ias iaActual, String nombreTipo) {
        em.getTransaction().begin();

        // Buscar el objeto Tipos que corresponde al nombre del tipo
        TypedQuery<Tipos> queryTipo = em.createQuery("SELECT t FROM Tipos t WHERE t.tipo = :tipo", Tipos.class);
        queryTipo.setParameter("tipo", nombreTipo);
        Tipos tipo = queryTipo.getSingleResult();

        if (tipo == null) {
            System.out.println("El tipo no existe");
            return;
        }

        Ias ia = em.find(Ias.class, iaActual.getIdia(), LockModeType.PESSIMISTIC_READ);

        if (ia != null) {
            System.out.println("El ID de la IA ya existe.");
            return;
        }

        TypedQuery<Ias> query = em.createQuery("SELECT i FROM Ias i WHERE i.nombre = :nombre", Ias.class);
        query.setParameter("nombre", iaActual.getNombre());
        Collection<Ias> iasConMismoNombre = query.getResultList();
        if (!iasConMismoNombre.isEmpty()) {
            JOptionPane.showMessageDialog(null, "El nombre de la IA ya existe.");
            System.out.println("El nombre de la IA ya existe.");
            return;
        }

        iaActual.setIdtipo(tipo);
        em.persist(iaActual);
        em.getTransaction().commit();
    }

    /**
     * Modifica los atributos de una entidad Ias específica.
     *
     * @param iaActual La entidad Ias actual que se va a modificar.
     * @param nombre El nuevo nombre para la entidad Ias.
     * @param modelo El nuevo modelo para la entidad Ias.
     * @param tipo El nuevo tipo para la entidad Ias.
     */
    public static void modificarIa(Ias iaActual, String nombre, String modelo, String tipo) {

        // Iniciar una transacción para modificar la entidad
        em.getTransaction().begin();

        // Comprobamos si el nombre de la IA ya existe en otra IA
        TypedQuery<Ias> query = em.createQuery("SELECT i FROM Ias i WHERE i.nombre = :nombre", Ias.class);
        query.setParameter("nombre", nombre);
        Collection<Ias> iasConMismoNombre = query.getResultList();

        // Buscamos el objeto Tipos correspondiente al tipo
        TypedQuery<Tipos> queryTipo = em.createQuery("SELECT t FROM Tipos t WHERE t.tipo = :tipo", Tipos.class);
        queryTipo.setParameter("tipo", tipo);
        Tipos tipoObjeto = queryTipo.getSingleResult();

        // Buscamos la entidad Ias a modificar
        Ias ia = em.find(Ias.class, iaActual.getIdia(), LockModeType.PESSIMISTIC_READ);

        // Si la entidad Ias existe, modificamos sus atributos
        if (ia != null) {
            ia.setNombre(nombre);
            ia.setModelo(modelo);
            ia.setIdtipo(tipoObjeto);
        }

        // Confirmar la transacción para aplicar los cambios
        em.getTransaction().commit();
    }

    /**
     * Método que recoge toda la información relativa a la tabla de IAs.
     *
     * @return Colección de todas las IAs
     */
    public static Collection<Ias> selectAllIa() {
        TypedQuery<Ias> query = em.createQuery("SELECT i FROM Ias i", Ias.class);
        Collection<Ias> ias = query.getResultList();

        return ias;
    }

    /**
     * Busca y devuelve una colección de entidades Ias que coinciden con un
     * modelo específico.
     *
     * @param modeloEspecifico El modelo específico a buscar.
     * @return Una colección de entidades Ias que coinciden con el modelo
     * especificado.
     */
    public static Collection<Ias> selectIasByModelo(String modeloEspecifico) {
        TypedQuery<Ias> query = em.createQuery("SELECT i FROM Ias i WHERE i.modelo = :modelo", Ias.class);
        query.setParameter("modelo", modeloEspecifico);
        return query.getResultList();
    }

    /**
     * Busca y devuelve una colección de entidades Ias que coinciden con una
     * popularidad específica.
     *
     * @param popularidadEspecifico La popularidad específica a buscar.
     * @return Una colección de entidades Ias que coinciden con la popularidad
     * especificada.
     */
    public static Collection<Ias> selectIasByPopularidad(String popularidadEspecifico) {
        TypedQuery<Ias> query = em.createQuery("SELECT i FROM Ias i WHERE i.popularidad = :popularidad", Ias.class);
        query.setParameter("popularidad", popularidadEspecifico);
        return query.getResultList();
    }

    /**
     * Busca y devuelve una colección de entidades Ias que coinciden con un
     * modelo y una popularidad específicos.
     *
     * @param modeloEspecifico El modelo específico a buscar.
     * @param popularidadEspecifico La popularidad específica a buscar.
     * @return Una colección de entidades Ias que coinciden con el modelo y la
     * popularidad especificados.
     */
    public static Collection<Ias> selectIasByModeloYPopularidad(String modeloEspecifico, String popularidadEspecifico) {
        TypedQuery<Ias> query = em.createQuery("SELECT i FROM Ias i WHERE i.modelo = :modelo AND i.popularidad = :popularidad", Ias.class);
        query.setParameter("modelo", modeloEspecifico);
        query.setParameter("popularidad", popularidadEspecifico);
        return query.getResultList();
    }

    /**
     * Devuelve una colección de entidades Ias únicas, eliminando duplicados
     * basados en el nombre del modelo.
     *
     * @return Una colección de entidades Ias únicas.
     */
    public static Collection<Ias> selectAllUniqueIa() {
        Map<String, Ias> uniqueIasMap = new HashMap<>(); // Mapa para rastrear modelos únicos por nombre de modelo

        // Realizar la consulta
        TypedQuery<Ias> query = em.createQuery("SELECT i FROM Ias i", Ias.class);
        Collection<Ias> allIas = query.getResultList();

        // Filtrar modelos duplicados basados en el nombre de modelo
        for (Ias ias : allIas) {
            String modelo = ias.getModelo();
            if (!uniqueIasMap.containsKey(modelo)) {
                // Si el nombre de modelo no está en el mapa, agrégalo
                uniqueIasMap.put(modelo, ias);
            }
            // Si ya existe un modelo con el mismo nombre, no lo agregues nuevamente
        }

        // Devolver la colección de modelos únicos
        return uniqueIasMap.values();
    }

    /**
     * Método que recibe por parámetro el ID de una IA y devuelve una String con
     * toda la información relativa a esa IA y a sus relaciones con las tablas
     * de Tipos y Prompts que tenga asociados. Si la IA (buscada por ID) no
     * existe, se muestra un mensaje de error.
     *
     * @param idIa id de la IA cuya información se mostrará
     * @return String con toda la información relativa a la IA
     */
    public static String selectIa(int idIa) {
        StringBuilder info = new StringBuilder();

        Ias ia = em.find(Ias.class, idIa);

        if (ia != null) {
            info.append("    Nombre: ").append(ia.getNombre()).append("\n");
            info.append("    Modelo: ").append(ia.getModelo()).append("\n");
            info.append("    Usos: ").append(ia.getUsos()).append("\n");
            info.append("    Popularidad: ").append(ia.getPopularidad()).append("\n");

            // Obtener el tipo de esta IA
            Tipos tipo = ia.getIdtipo();
            info.append("Tipo: ").append(tipo.getTipo()).append("\n");
            info.append("    Descripción del Tipo: ").append(tipo.getDescripcion()).append("\n");

            // Obtener la colección de prompts asociados a esta IA
            Collection<IasPrompts> prompts = ia.getIasPromptsCollection();
            info.append("Prompts asociados:\n");
            for (IasPrompts prompt : prompts) {
                info.append("        Texto del Prompt: ").append(prompt.getIdprompt().getTexto()).append("\n");
                // Agrega cualquier otra información que desees mostrar sobre los prompts
            }
        } else {
            info.append("No se encontró ninguna IA con el ID proporcionado.\n");
        }

        return info.toString();
    }

    /**
     * Método que genera automáticamente un id para tipos de ia. Realiza una
     * consulta inicial a la base de datos para hallar el número de registros;
     * si es 0, devuelve un 1 como primer id, y si no lo es, halla el id máximo
     * existente y devuelve su valor más uno.
     *
     * @return id automático para tipos de ia
     */
    public static int autoIdTipo() {
        int id = 0;

        TypedQuery<Long> query = em.createQuery("select count(t) from Tipos t", Long.class);
        int recuento = (query.getSingleResult()).intValue();

        if (recuento == 0) {
            id = 1;
        } else {
            TypedQuery<Integer> queryMax = em.createQuery("select max(t.idtipo) from Tipos t", Integer.class);
            id = (queryMax.getSingleResult()) + 1;
        }

        return id;
    }

    /**
     * Método que genera automáticamente un id para ias. Realiza una consulta
     * inicial a la base de datos para hallar el número de registros; si es 0,
     * devuelve un 1 como primer id, y si no lo es, halla el id máximo existente
     * y devuelve su valor más uno.
     *
     * @return id automático para ias
     */
    public static int autoIdIA() {
        int id = 0;

        TypedQuery<Long> query = em.createQuery("select count(i) from Ias i", Long.class);
        int recuento = (query.getSingleResult()).intValue();

        if (recuento == 0) {
            id = 1;
        } else {
            TypedQuery<Integer> queryMax = em.createQuery("select max(i.idia) from Ias i", Integer.class);
            id = (queryMax.getSingleResult()) + 1;
        }

        return id;
    }

    /**
     * Método que genera automáticamente un id para prompts. Realiza una
     * consulta inicial a la base de datos para hallar el número de registros;
     * si es 0, devuelve un 1 como primer id, y si no lo es, halla el id máximo
     * existente y devuelve su valor más uno.
     *
     * @return id automático para prompts
     */
    public static int autoIdPrompt() {
        int id = 0;

        TypedQuery<Long> query = em.createQuery("select count(p) from Prompts p", Long.class);
        int recuento = (query.getSingleResult()).intValue();

        if (recuento == 0) {
            id = 1;
        } else {
            TypedQuery<Integer> queryMax = em.createQuery("select max(p.idprompt) from Prompts p", Integer.class);
            id = (queryMax.getSingleResult()) + 1;
        }

        return id;
    }

    /**
     * Método que genera automáticamente un id para registros intermedios
     * ia-prompt. Realiza una consulta inicial a la base de datos para hallar el
     * número de registros; si es 0, devuelve un 1 como primer id, y si no lo
     * es, halla el id máximo existente y devuelve su valor más uno.
     *
     * @return id automático para registros intermedios ia-prompt.
     */
    public static int autoIdIaPrompt() {
        int id = 0;

        TypedQuery<Long> query = em.createQuery("select count(ip) from IasPrompts ip", Long.class);
        int recuento = (query.getSingleResult()).intValue();

        if (recuento == 0) {
            id = 1;
        } else {
            TypedQuery<Integer> queryMax = em.createQuery("select max(ip.idregistro) from IasPrompts ip", Integer.class);
            id = (queryMax.getSingleResult()) + 1;
        }

        return id;
    }

    /**
     * Método que busca por ID y devuelve un objeto Ia.
     *
     * @param idIa id de la IA a buscar
     * @return el objeto IA correspondiente al id introducito
     */
    public static Ias buscarIa(int idIa) {
        return em.find(Ias.class, idIa);
    }

    /**
     * Método que recibe por parámetro una ia y suma 1 al número de veces que ha
     * sido empleada, actualizando también su valor de popularidad en función
     * del número de veces que haya sido empleada.
     *
     * @param ia IA cuya popularidad se actualizará
     */
    public static void actualizarPopularidad(Ias ia) {
        ia.setUsos(ia.getUsos() + 1);

        if (ia.getUsos() < 4) {
            ia.setPopularidad("No popular.");
        } else if (ia.getUsos() >= 4 && ia.getUsos() < 8) {
            ia.setPopularidad("Moderadamente popular.");
        } else if (ia.getUsos() >= 8 && ia.getUsos() < 12) {
            ia.setPopularidad("Popular.");
        } else {
            ia.setPopularidad("Muy popular.");
        }
    }
    
    /**
     * Método que ajusta el campo "Popularidad" de las IAs almacenadas, ajustándole
     * un valor de entre varios predefinidos en función del número de usos que tengan.
     * 
     * Método usado en las actualizaciones masivas, en las que es posible modificar el
     * valor del número de usos de una IA.
     */
    public static void ajustarPopularidad() {
        em.getTransaction().begin();
        Query query1 = em.createQuery("update Ias a set a.popularidad='No popular.' where a.usos<4");
        Query query2 = em.createQuery("update Ias a set a.popularidad='Moderadamente popular.' where a.usos>=4 and a.usos<8");
        Query query3 = em.createQuery("update Ias a set a.popularidad='Popular.' where a.usos>=8 and a.usos<12");
        Query query4 = em.createQuery("update Ias a set a.popularidad='Muy popular.' where a.usos>=12");
        
        query1.executeUpdate();
        query2.executeUpdate();
        query3.executeUpdate();
        query4.executeUpdate();
        
        em.getTransaction().commit();
    }
    
    /**
     * Método que realiza una modificación de múltiples registros IA de la base de
     * datos, filtrando según aquellos cuyos modelo y/o popularidad se indiquen
     * y asignando los valores que se introduzcan por parámetro a los campos de
     * modelo y número de usos. Al final, se ajustan las popularidades de las IAs
     * modificadas en función del nuevo número de usos.
     * Si modelo está vacío, sólo se ajusta número de usos.
     * Si número de usos es menor que cero, sólo se ajusta modelo.
     * En los filtros de modelo y popularidad, si valen "-", ese filtro no se usa.
     * 
     * @param modelo Nuevo valor a establecer para el campo modelo
     * @param numUsos Nuevo valor a establecer para el campo número de usos
     * @param modeloFiltro Modelo por el que se filtrarán las IAs a modificar
     * @param popularidadFiltro Popularidad por la que se filtrarán las IAs a modificar
     */
    public static void modificacionMasiva(String modelo, int numUsos, String modeloFiltro, String popularidadFiltro) {
        Query query = null;
        
        em.getTransaction().begin();
        
        // Cuando no se filtre por modelo ni por popularidad
        if (modeloFiltro.equals("-") && popularidadFiltro.equals("-")) {

            if (numUsos<0) {
                query = em.createQuery("update Ias set modelo=:modeloP");
                query.setParameter("modeloP", modelo);
            } else if (modelo.isEmpty()) {
                query = em.createQuery("update Ias set usos=:usosP");
                query.setParameter("usosP", numUsos);
            } else {
                query = em.createQuery("update Ias set modelo=:modeloP, usos=:usosP");
                query.setParameter("modeloP", modelo);
                query.setParameter("usosP", numUsos);
            }
            
        // Cuando no se filtre por modelo
        } else if (modeloFiltro.equals("-")) {
        
            if (numUsos<0) {
                query = em.createQuery("update Ias set modelo=:modeloP where popularidad=:popuP");
                query.setParameter("modeloP", modelo);
                query.setParameter("popuP", popularidadFiltro);
            } else if (modelo.isEmpty()) {
                query = em.createQuery("update Ias set usos=:usosP where popularidad=:popuP");
                query.setParameter("usosP", numUsos);
                query.setParameter("popuP", popularidadFiltro);
            } else {
                query = em.createQuery("update Ias set modelo=:modeloP, usos=:usosP where popularidad=:popuP");
                query.setParameter("modeloP", modelo);
                query.setParameter("usosP", numUsos);
                query.setParameter("popuP", popularidadFiltro);
            }
            
        // Cuando no se filtre por popularidad
        } else if (popularidadFiltro.equals("-")) {
        
            if (numUsos<0) {
                query = em.createQuery("update Ias set modelo=:modeloP where modelo=:modeP");
                query.setParameter("modeloP", modelo);
                query.setParameter("modeP", modeloFiltro);
            } else if (modelo.isEmpty()) {
                query = em.createQuery("update Ias set usos=:usosP where modelo=:modeP");
                query.setParameter("usosP", numUsos);
                query.setParameter("modeP", modeloFiltro);
            } else {
                query = em.createQuery("update Ias set modelo=:modeloP, usos=:usosP where modelo=:modeP");
                query.setParameter("modeloP", modelo);
                query.setParameter("usosP", numUsos);
                query.setParameter("modeP", modeloFiltro);
            }
            
        // Cuando se filtre por modelo y popularidad
        } else {
            
            if (numUsos<0) {
                query = em.createQuery("update Ias set modelo=:modeloP where popularidad=:popuP and modelo=:modeP");
                query.setParameter("modeloP", modelo);
                query.setParameter("popuP", popularidadFiltro);
                query.setParameter("modeP", modeloFiltro);
            } else if (modelo.isEmpty()) {
                query = em.createQuery("update Ias set usos=:usosP where popularidad=:popuP and modelo=:modeP");
                query.setParameter("usosP", numUsos);
                query.setParameter("popuP", popularidadFiltro);
                query.setParameter("modeP", modeloFiltro);
            } else {
                query = em.createQuery("update Ias set modelo=:modeloP, usos=:usosP where popularidad=:popuP and modelo=:modeP");
                query.setParameter("modeloP", modelo);
                query.setParameter("usosP", numUsos);
                query.setParameter("popuP", popularidadFiltro);
                query.setParameter("modeP", modeloFiltro);
            }
            
        }
        
        
        query.executeUpdate();
        em.getTransaction().commit();
        
        ajustarPopularidad();
    }
}
