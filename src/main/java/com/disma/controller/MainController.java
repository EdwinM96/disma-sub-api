/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.disma.controller;

//import com.disma.service.AuthenticationService;
import com.disma.service.UsuarioService;
import javax.servlet.http.HttpServletRequest;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author HP PC
 */
@Controller
public class MainController {
    
    @Autowired
    UsuarioService authService;
    
    @RequestMapping(value="/", produces=MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody String auth(HttpServletRequest request)
    {
        String msg = authService.authenticate(request.getHeader("authorization"));
        
        if(msg=="Not64Encoded"){
            msg="False";
        }
        return msg;
    }
    
}
