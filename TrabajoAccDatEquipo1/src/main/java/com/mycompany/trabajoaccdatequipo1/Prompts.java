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
@Table(name = "PROMPTS")
@NamedQueries({
    @NamedQuery(name = "Prompts.findAll", query = "SELECT p FROM Prompts p"),
    @NamedQuery(name = "Prompts.findByIdprompt", query = "SELECT p FROM Prompts p WHERE p.idprompt = :idprompt"),
    @NamedQuery(name = "Prompts.findByTexto", query = "SELECT p FROM Prompts p WHERE p.texto = :texto")})
public class Prompts implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "IDPROMPT")
    private Short idprompt;
    @Column(name = "TEXTO")
    private String texto;
    @OneToMany(mappedBy = "idprompt")
    private Collection<IasPrompts> iasPromptsCollection;

    public Prompts() {
    }

    public Prompts(Short idprompt) {
        this.idprompt = idprompt;
    }

    public Short getIdprompt() {
        return idprompt;
    }

    public void setIdprompt(Short idprompt) {
        this.idprompt = idprompt;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Collection<IasPrompts> getIasPromptsCollection() {
        return iasPromptsCollection;
    }

    public void setIasPromptsCollection(Collection<IasPrompts> iasPromptsCollection) {
        this.iasPromptsCollection = iasPromptsCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idprompt != null ? idprompt.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Prompts)) {
            return false;
        }
        Prompts other = (Prompts) object;
        if ((this.idprompt == null && other.idprompt != null) || (this.idprompt != null && !this.idprompt.equals(other.idprompt))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.mycompany.trabajoaccdatequipo1.Prompts[ idprompt=" + idprompt + " ]";
    }
    
}
