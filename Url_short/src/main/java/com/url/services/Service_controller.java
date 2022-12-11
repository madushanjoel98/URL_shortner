package com.url.services;

import com.google.gson.Gson;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.mysql.cj.xdevapi.JsonArray;
import com.sun.webkit.network.URLs;
import com.url.controllers.db.Url_dbc;
import com.url.extra.Entityr;
import com.url.extra.My_Genrater;
import com.url.dao.URLs_DAO;
import com.url.model.URL_insert_model;
import com.url.model.URLmodel;
import java.util.ArrayList;
import java.util.List;

@Service
public class Service_controller {
	   URLs_DAO dbc1=new URLs_DAO();
	
	public  String UNIQUE_TEXT;
	public URL urlre(String unid) throws MalformedURLException, SQLException { 
		URL url=new URL(dbc1.geturlByUniqueID(unid));
		return url;	
	}
	
	@SuppressWarnings("static-access")
	public boolean insertURL(URL_insert_model model) throws SQLException, Exception {
            UNIQUE_TEXT=My_Genrater.iuids();
	boolean catcher=false;
        URLmodel modeler=new URLmodel(model.getUrl().toString());
            catcher=dbc1.insertNew(modeler,UNIQUE_TEXT);
            if(catcher==false){
            UNIQUE_TEXT=null;
            }
          return catcher;
	}

	public String all(){
            Gson json=new Gson();
            List<URLmodel> list=dbc1.selected_all();
        return json.toJson(list);
        }
        
}
