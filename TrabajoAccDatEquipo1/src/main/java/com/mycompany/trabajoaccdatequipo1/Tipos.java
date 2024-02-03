/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pokem
 */
@Entity
@Table(name = "TIPOS")
@NamedQueries({
    @NamedQuery(name = "Tipos.findAll", query = "SELECT t FROM Tipos t"),
    @NamedQuery(name = "Tipos.findByIdtipo", query = "SELECT t FROM Tipos t WHERE t.idtipo = :idtipo"),
    @NamedQuery(name = "Tipos.findByTipo", query = "SELECT t FROM Tipos t WHERE t.tipo = :tipo"),
    @NamedQuery(name = "Tipos.findByDescripci\u00f3n", query = "SELECT t FROM Tipos t WHERE t.descripci\u00f3n = :descripci\u00f3n")})
public class Tipos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDTIPO")
    private Short idtipo;
    @Column(name = "TIPO")
    private String tipo;
    @Column(name = "DESCRIPCI\u00d3N")
    private String descripción;
    @OneToMany(mappedBy = "idtipo")
    private Collection<Ias> iasCollection;

    public Tipos() {
    }

    public Tipos(Short idtipo) {
        this.idtipo = idtipo;
    }

    public Short getIdtipo() {
        return idtipo;
    }

    public void setIdtipo(Short idtipo) {
        this.idtipo = idtipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getDescripción() {
        return descripción;
    }

    public void setDescripción(String descripción) {
        this.descripción = descripción;
    }

    public Collection<Ias> getIasCollection() {
        return iasCollection;
    }

    public void setIasCollection(Collection<Ias> iasCollection) {
        this.iasCollection = iasCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idtipo != null ? idtipo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tipos)) {
            return false;
        }
        Tipos other = (Tipos) object;
        if ((this.idtipo == null && other.idtipo != null) || (this.idtipo != null && !this.idtipo.equals(other.idtipo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.trabajoaccdatequipo1.Tipos[ idtipo=" + idtipo + " ]";
    }
    
}
