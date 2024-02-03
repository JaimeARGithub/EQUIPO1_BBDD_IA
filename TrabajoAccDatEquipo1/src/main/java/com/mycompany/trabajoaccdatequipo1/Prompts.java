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
    private int idprompt;
    @Column(name = "TEXTO")
    private String texto;
    @OneToMany(mappedBy = "idprompt")
    private Collection<IasPrompts> iasPromptsCollection;

    
    
    // CONSTRUCTORES
    public Prompts() {
    }

    // LÓGICA DE NEGOCIO: AL CREAR UN PROMPT, DEBE IR ASOCIADO A UNA SERIE
    // DE IAS, MÍNIMO UNA. NO PUEDE HABER PROMPTS SIN IAS.
    public Prompts(int idprompt, String texto, Collection<IasPrompts> iasPromptsCollection) {
        this.idprompt = idprompt;
        this.texto = texto;
        this.iasPromptsCollection = iasPromptsCollection;
    }
    

    
    // GETTERS Y SETTERS
    public int getIdprompt() {
        return idprompt;
    }

    public void setIdprompt(int idprompt) {
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

    
    
    // HASHCODE, EQUALS, TOSTRINGS
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
        final Prompts other = (Prompts) obj;
        if (this.idprompt != other.idprompt) {
            return false;
        }
        if (!Objects.equals(this.texto, other.texto)) {
            return false;
        }
        return Objects.equals(this.iasPromptsCollection, other.iasPromptsCollection);
    }

    

    @Override
    public String toString() {
        return "com.mycompany.trabajoaccdatequipo1.Prompts[ idprompt=" + idprompt + " ]";
    }
    
}
