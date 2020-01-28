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

    Logger logger = Logger.getLogger("Logger");
    public Decode64() {
    }
    
    public HashMap decode64(String credentials){
        if(credentials.contains("Bearer")){
            credentials = credentials.replace("Bearer","");
        }
        if(credentials.contains("Basic")){
            credentials = credentials.replace("Basic","");
        }
        //LA SIGUIENTE LINEA PODRÍA DAR ERROR!!!!
        if(credentials.contains(" ")){
            credentials = credentials.replaceAll(" ", "");
        }
        byte[] decodedArray = Base64.getDecoder().decode(credentials);        
        String decodedString = new String(decodedArray);
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
