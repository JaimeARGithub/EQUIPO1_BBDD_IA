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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author pokem
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
    private Short idia;
    @Column(name = "NOMBRE")
    private String nombre;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "USOS")
    private Short usos;
    @Column(name = "POPULARIDAD")
    private String popularidad;
    @OneToMany(mappedBy = "idia")
    private Collection<IasPrompts> iasPromptsCollection;
    @JoinColumn(name = "IDTIPO", referencedColumnName = "IDTIPO")
    @ManyToOne
    private Tipos idtipo;

    public Ias() {
    }

    public Ias(Short idia) {
        this.idia = idia;
    }

    public Short getIdia() {
        return idia;
    }

    public void setIdia(Short idia) {
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

    public Short getUsos() {
        return usos;
    }

    public void setUsos(Short usos) {
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idia != null ? idia.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ias)) {
            return false;
        }
        Ias other = (Ias) object;
        if ((this.idia == null && other.idia != null) || (this.idia != null && !this.idia.equals(other.idia))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.trabajoaccdatequipo1.Ias[ idia=" + idia + " ]";
    }
    
}
