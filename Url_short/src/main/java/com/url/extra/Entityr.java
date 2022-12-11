package com.url.controllers.extra;

import java.net.URL;
import java.util.Random;

public class Entityr {
URL url;
String unique;
public Entityr() {
	// TODO Auto-generated constructor stub
}
public Entityr(URL url, String unique) {
	super();
	this.url = url;
	this.unique = unique;
}
public URL getUrl() {
	return url;
}
public void setUrl(URL url) {
	this.url = url;
}
public String getUnique() {
	return unique;
}
public void setUnique(String unique) {
	this.unique = unique;
}


}
