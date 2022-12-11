/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.url.controllers;

import com.url.services.Service_controller;
import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 *
 * @author madushan
 */
@Controller
@ResponseBody
@RequestMapping("/")
public class WebControll {

    @Autowired
    Service_controller scon = new Service_controller();

    @GetMapping("/{id}")
    public void url(@PathVariable String id, HttpServletResponse res) throws Exception {
       
            String url = scon.urlre(id).toString();
            System.out.println(url);
            res.sendRedirect(url);
          
      
       
    }

@GetMapping("/hi")
public String hii(){
return "hi";
}
}
