/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author pokem
 */
@Entity
@Table(name = "IAS_PROMPTS")
@NamedQueries({
    @NamedQuery(name = "IasPrompts.findAll", query = "SELECT i FROM IasPrompts i"),
    @NamedQuery(name = "IasPrompts.findByIdregistro", query = "SELECT i FROM IasPrompts i WHERE i.idregistro = :idregistro")})
public class IasPrompts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDREGISTRO")
    private Integer idregistro;
    @JoinColumn(name = "IDIA", referencedColumnName = "IDIA")
    @ManyToOne
    private Ias idia;
    @JoinColumn(name = "IDPROMPT", referencedColumnName = "IDPROMPT")
    @ManyToOne
    private Prompts idprompt;

    public IasPrompts() {
    }

    public IasPrompts(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public Integer getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(Integer idregistro) {
        this.idregistro = idregistro;
    }

    public Ias getIdia() {
        return idia;
    }

    public void setIdia(Ias idia) {
        this.idia = idia;
    }

    public Prompts getIdprompt() {
        return idprompt;
    }

    public void setIdprompt(Prompts idprompt) {
        this.idprompt = idprompt;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idregistro != null ? idregistro.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof IasPrompts)) {
            return false;
        }
        IasPrompts other = (IasPrompts) object;
        if ((this.idregistro == null && other.idregistro != null) || (this.idregistro != null && !this.idregistro.equals(other.idregistro))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.trabajoaccdatequipo1.IasPrompts[ idregistro=" + idregistro + " ]";
    }
    
}
