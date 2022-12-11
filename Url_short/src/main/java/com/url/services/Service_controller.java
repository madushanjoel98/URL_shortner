package com.url.controllers;

import java.net.MalformedURLException;
import java.net.URL;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;

import org.apache.commons.lang3.RandomStringUtils;
import org.json.JSONObject;
import org.springframework.stereotype.Service;

import com.mysql.cj.xdevapi.JsonArray;
import com.url.controllers.db.Url_dbc;
import com.url.controllers.extra.Entityr;
import com.url.controllers.extra.My_Genrater;

@Service
public class Service_controller {
	Url_dbc dbc1=new Url_dbc();
	
	
	public URL urlre(String id) throws MalformedURLException, SQLException { 
		URL url=new URL(dbc1.geturl(id));
		
		return url;	
	}
	
	@SuppressWarnings("static-access")
	public String urlIDgenra(String url) throws SQLException {
		JSONObject urlob=new JSONObject();
		switch (Url_dbc.geturfl(url.toString())) {
		case 1:
			urlob.put("URL_id",dbc1.geturlid(url.toString()));
			return  urlob.toString();
		 default:
			String url_id=My_Genrater.iuids();
			dbc1.insertData(url_id, url.toString());
			urlob.put("URL_id", url_id);
			return urlob.toString();
		}
		
	}

	
}
