package com.url.controllers;

import java.io.IOException;
import java.net.MalformedURLException;
import java.sql.SQLException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigurationPackage;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.url.controllers.db.Url_dbc;
import com.url.controllers.extra.Entityr;

@RestController
@AutoConfigurationPackage
public class API_Controller {

	@Autowired 
	Service_controller scon=new Service_controller();
	
	@GetMapping("/{id}") 
	public String url(@PathVariable String id,HttpServletResponse res)  {
		try {
String url=scon.urlre(id).toString();
res.sendRedirect(url);
return id;
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
			return "invalid id";
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return id;
	}
	
	@GetMapping("/api/gen") 
	public String url(@RequestBody Entityr e) throws IOException, SQLException {

		return scon.urlIDgenra(e.getUrl().toString());
	}
	
}
