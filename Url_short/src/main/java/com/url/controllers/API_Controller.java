package com.url.controllers;

import com.google.gson.Gson;
import com.url.model.Inserted_Model;
import com.url.model.URL_insert_model;
import com.url.services.Service_controller;
import java.io.IOException;
import java.sql.SQLException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/API")
public class API_Controller {

    @Autowired
    Service_controller scon = new Service_controller();

    @PostMapping("/insert")
    public String url(@RequestBody URL_insert_model uRLmodel) throws IOException, SQLException, Exception {
        Gson json = new Gson();
        String respons = null;
        boolean insert = scon.insertURL(uRLmodel);
        if (insert == true) {
            Inserted_Model responmiodel = new Inserted_Model(uRLmodel.getUrl().toString(), scon.UNIQUE_TEXT, "inserted");
            respons = json.toJson(responmiodel);
        }
        return respons;

    }

    @GetMapping("/all")
    public String getALL() {
        return scon.all();
    }
}
