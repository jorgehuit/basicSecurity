package com.huit.mx.securityBasic;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.codec.Base64;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import com.huit.mx.securityBasic.dto.Greet;

import lombok.extern.log4j.Log4j;

@RunWith(SpringRunner.class)
@SpringBootTest
@Log4j
public class SecurityBasicApplicationTests {

	@Test
	public void contextLoads() {
	}
	
	@Test
	public void testSecureService(){
		log.info("Colocamos el usuario y pass");
		String plainCreds = "huit:huit123";
		HttpHeaders httpHeaders = new HttpHeaders();
		log.info("Agregamos el objeto Authorization con el token");
		httpHeaders.add("Authorization", "Basic " +  new String (Base64.encode(plainCreds.getBytes())));
		HttpEntity<String> request = new HttpEntity<>(httpHeaders);
		RestTemplate restTemplate = new RestTemplate();
		
		ResponseEntity<Greet> response = restTemplate.exchange("http://localhost:8080/", HttpMethod.GET, request, Greet.class);
		Assert.assertEquals("Hello World!", response.getBody().getMessage());
		
	}

}
