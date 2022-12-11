/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.url.model;

/**
 *
 * @author madushan
 */
public class URLmodel {
  private  long  id;
   private String URL;
   private String unique_ID;
   private String create_Date;

    public URLmodel() {
    }

    public URLmodel(String URL) {
        this.URL = URL;
    }

    public URLmodel(long id, String URL, String unique_ID, String create_Date) {
        this.id = id;
        this.URL = URL;
        this.unique_ID = unique_ID;
        this.create_Date = create_Date;
    }
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getURL() {
        return URL;
    }

    public void setURL(String URL) {
        this.URL = URL;
    }

    public String getUnique_ID() {
        return unique_ID;
    }

    public void setUnique_ID(String unique_ID) {
        this.unique_ID = unique_ID;
    }

    public String getCreate_Date() {
        return create_Date;
    }

    public void setCreate_Date(String create_Date) {
        this.create_Date = create_Date;
    }
    
    
}
