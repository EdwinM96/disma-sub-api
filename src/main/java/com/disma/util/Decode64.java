/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disma.util;

import java.util.Base64;
import java.util.HashMap;
import java.util.logging.Logger;

/**
 *
 * @author HP PC
 */
public class Decode64 {

    public Decode64() {
    }
    
    public HashMap decode64(String credentials){
        byte[] decodedArray = Base64.getDecoder().decode(credentials);        
        String decodedString = new String(decodedArray);
        Logger.getLogger("Logg").info(decodedString);
        try{
            String[] credentialsVector = decodedString.split(":");
            HashMap credentialsMap = new HashMap();
            credentialsMap.put("usuario", credentialsVector[0]);
            credentialsMap.put("password", credentialsVector[1]);
            return credentialsMap;
        }
        catch(Exception e){
            return null;
        }   
    }
}
