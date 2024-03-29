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
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pokem, bacho, lucas
 */
@Entity
@Table(name = "TIPOS")
@NamedQueries({
    @NamedQuery(name = "Tipos.findAll", query = "SELECT t FROM Tipos t"),
    @NamedQuery(name = "Tipos.findByIdtipo", query = "SELECT t FROM Tipos t WHERE t.idtipo = :idtipo"),
    @NamedQuery(name = "Tipos.findByTipo", query = "SELECT t FROM Tipos t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Tipos.findByDescripcion", query = "SELECT t FROM Tipos t WHERE t.descripcion = :descripcion")})
public class Tipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTIPO")
    private int idtipo;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "DESCRIPCION")
    private String descripcion;
    @OneToMany(mappedBy = "idtipo")
    private Collection<Ias> iasCollection;

    
    
    // CONSTRUCTORES
    public Tipos() {
    }

    // LÓGICA DE NEGOCIO: LOS TIPOS PUEDEN CREARSE SIN IAS Y ÉSTAS METERSE A POSTERIORI
    public Tipos(int idtipo, String tipo, String descripcion) {
        this.idtipo = idtipo;
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    
    public Tipos(String tipo, String descripcion) {
        this.idtipo = Metodos.autoIdTipo();
        this.tipo = tipo;
        this.descripcion = descripcion;
    }
    
    
    
    // GETTERS Y SETTERS
    public int getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(int idtipo) {
        this.idtipo = idtipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Collection<Ias> getIasCollection() {
        return iasCollection;
    }

    public void setIasCollection(Collection<Ias> iasCollection) {
        this.iasCollection = iasCollection;
    }

    
    
    // HASHCODE, EQUALS, TOSTRING
    @Override
    public int hashCode() {
        int hash = 3;
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
        final Tipos other = (Tipos) obj;
        if (this.idtipo != other.idtipo) {
            return false;
        }
        if (!Objects.equals(this.tipo, other.tipo)) {
            return false;
        }
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        return Objects.equals(this.iasCollection, other.iasCollection);
    }

    

    @Override
    public String toString() {
        return "com.mycompany.trabajoaccdatequipo1.Tipos[ idtipo=" + idtipo + " ]";
    }
    
}
