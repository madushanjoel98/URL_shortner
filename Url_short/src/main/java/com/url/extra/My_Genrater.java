package com.url.extra;

import org.apache.commons.lang3.RandomStringUtils;

public class My_Genrater {
	
	public static String iuids() {
		String characters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxy";
		int randoms=Integer.parseInt(RandomStringUtils.random(1, "45"));
	 String id = RandomStringUtils.random(randoms, characters); 
	 return id;
	}

}
