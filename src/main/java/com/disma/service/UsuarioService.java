/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disma.service;

import com.disma.dao.UsuarioDao;
import com.disma.domain.Usuario;
import com.disma.util.Decode64;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import org.jboss.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author HP PC
 */
@Service
public class UsuarioService {
    @Autowired
    private UsuarioDao<Serializable> genericDao;
    
    public Logger l = Logger.getLogger("logger");
    public Decode64 decoder = new Decode64();
    
    public String authenticate(String credentials){
        HashMap decodedCreds;
        try{
            decodedCreds = decoder.decode64(credentials);
        }
        catch(IllegalArgumentException e){
            return "Not64Encoded";
        }
        ArrayList<String> listCredentials = new ArrayList();
        listCredentials.add((String)decodedCreds.get("usuario"));
        listCredentials.add((String)decodedCreds.get("password"));
        Usuario usuario;
        try{
         usuario =  genericDao.getUniqueValue("select * from public.usuario usuario where usuario.usuario = ?1 and usuario.password = ?2 limit 1", listCredentials);
        }
        catch(Exception e){
            return "False";
        }
        if(usuario == null){
            return "False";
        }
        else{ 
            l.info(usuario.getNombreUsuario());
            return "True";
        
                }
                                 
    }
    
}
