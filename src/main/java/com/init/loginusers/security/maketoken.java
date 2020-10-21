package com.init.loginusers.security;

import java.util.Date;

import javax.json.Json;
import javax.json.JsonObject;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.init.loginusers.dto.User;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class maketoken {

	public JsonObject maketok (User user) {
	String KEY = "mi_clave";
	long tiempo = System.currentTimeMillis();
	String jwt = Jwts.builder().signWith(SignatureAlgorithm.HS256, KEY)

			.setSubject("QUICO NOHALES").setIssuedAt(new Date(tiempo + 900000)).setExpiration(new Date(tiempo))
			.claim("email", "Quiconohales@gmail.com").compact();
	JsonObject json = Json.createObjectBuilder().add("JWT", jwt).build();
		System.out.println("JWT" + json);
//	return new ResponseEntity<>(json, HttpStatus.CREATED);
		return json;
}
}