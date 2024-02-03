/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.trabajoaccdatequipo1;

import java.io.Serializable;
import java.util.Objects;
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
    private int idregistro;
    @JoinColumn(name = "IDIA", referencedColumnName = "IDIA")
    @ManyToOne
    private Ias idia;
    @JoinColumn(name = "IDPROMPT", referencedColumnName = "IDPROMPT")
    @ManyToOne
    private Prompts idprompt;

    public IasPrompts() {
    }

    public IasPrompts(int idregistro) {
        this.idregistro = idregistro;
    }

    public int getIdregistro() {
        return idregistro;
    }

    public void setIdregistro(int idregistro) {
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
        final IasPrompts other = (IasPrompts) obj;
        if (this.idregistro != other.idregistro) {
            return false;
        }
        if (!Objects.equals(this.idia, other.idia)) {
            return false;
        }
        return Objects.equals(this.idprompt, other.idprompt);
    }

    

    @Override
    public String toString() {
        return "com.mycompany.trabajoaccdatequipo1.IasPrompts[ idregistro=" + idregistro + " ]";
    }
    
}
