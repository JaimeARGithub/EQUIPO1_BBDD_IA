/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pokem, bacho, lucas
 */
@Entity
@Table(name = "IAS")
@NamedQueries({
    @NamedQuery(name = "Ias.findAll", query = "SELECT i FROM Ias i"),
    @NamedQuery(name = "Ias.findByIdia", query = "SELECT i FROM Ias i WHERE i.idia = :idia"),
    @NamedQuery(name = "Ias.findByNombre", query = "SELECT i FROM Ias i WHERE i.nombre = :nombre"),
    @NamedQuery(name = "Ias.findByModelo", query = "SELECT i FROM Ias i WHERE i.modelo = :modelo"),
    @NamedQuery(name = "Ias.findByUsos", query = "SELECT i FROM Ias i WHERE i.usos = :usos"),
    @NamedQuery(name = "Ias.findByPopularidad", query = "SELECT i FROM Ias i WHERE i.popularidad = :popularidad")})
public class Ias implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDIA")
    private int idia;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "USOS")
    private int usos;
    @Column(name = "POPULARIDAD")
    private String popularidad;
    @OneToMany(mappedBy = "idia")
    private Collection<IasPrompts> iasPromptsCollection;
    @JoinColumn(name = "IDTIPO", referencedColumnName = "IDTIPO")
    @ManyToOne
    private Tipos idtipo;

    
    
    // CONSTRUCTORES
    public Ias() {
    }

    // LÓGICA DE NEGOCIO: LAS IAS PUEDEN CREARSE SIN PROMPTS TÍPICOS ASOCIADOS,
    // PERO EN EL MOMENTO DE LA CREACIÓN FORZOSAMENTE TENDRÁN QUE TENER ASOCIADO
    // UN TIPO DE IA
    // TODAS LAS IAS SE CREARÁN CON CERO USOS Y NO POPULARIDAD, ELLO IRÁ AUMENTANDO
    // AUTOMÁTICAMENTE A MEDIDA QUE SE BUSQUEN SUS PROMPTS TÍPICOS ASOCIADOS
    public Ias(int idia, String nombre, String modelo, Tipos idtipo) {
        this.idia = idia;
        this.nombre = nombre;
        this.modelo = modelo;
        this.usos = 0;
        this.popularidad = "No popular.";
        this.idtipo = idtipo;
    }
    
    
    public Ias(String nombre, String modelo, Tipos idtipo) {
        this.idia = Metodos.autoIdIA();
        this.nombre = nombre;
        this.modelo = modelo;
        this.usos = 0;
        this.popularidad = "No popular.";
        this.idtipo = idtipo;
    }
    

    
    // GETTERS Y SETTERS
    public int getIdia() {
        return idia;
    }

    public void setIdia(int idia) {
        this.idia = idia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getUsos() {
        return usos;
    }

    public void setUsos(int usos) {
        this.usos = usos;
    }

    public String getPopularidad() {
        return popularidad;
    }

    public void setPopularidad(String popularidad) {
        this.popularidad = popularidad;
    }

    public Collection<IasPrompts> getIasPromptsCollection() {
        return iasPromptsCollection;
    }

    public void setIasPromptsCollection(Collection<IasPrompts> iasPromptsCollection) {
        this.iasPromptsCollection = iasPromptsCollection;
    }

    public Tipos getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Tipos idtipo) {
        this.idtipo = idtipo;
    }

    
    
    // HASHCODE, EQUALS, TOSTRING
    @Override
    public int hashCode() {
        int hash = 7;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Ias other = (Ias) obj;
        if (this.idia != other.idia) {
            return false;
        }
        if (this.usos != other.usos) {
            return false;
        }
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        if (!Objects.equals(this.modelo, other.modelo)) {
            return false;
        }
        if (!Objects.equals(this.popularidad, other.popularidad)) {
            return false;
        }
        if (!Objects.equals(this.iasPromptsCollection, other.iasPromptsCollection)) {
            return false;
        }
        return Objects.equals(this.idtipo, other.idtipo);
    }

    

    @Override
    public String toString() {
        return "com.mycompany.trabajoaccdatequipo1.Ias[ idia=" + idia + " ]";
    }
    
}
