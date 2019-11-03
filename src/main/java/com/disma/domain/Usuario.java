/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disma.domain;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author HP PC
 */
@Entity
@Table(schema = "public",name = "usuario")
public class Usuario implements Serializable {
    
    @Id
    @Column(name = "usuario")
    private String nombreUsuario;
    
    @Column(name="password")
    private String password;
    
    @Column(name="usuario_sap")
    private String usuarioSap;

    public Usuario() {
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUsuarioSap() {
        return usuarioSap;
    }

    public void setSapUsuario(String usuarioSap) {
        this.usuarioSap = usuarioSap;
    }
    
    
}
