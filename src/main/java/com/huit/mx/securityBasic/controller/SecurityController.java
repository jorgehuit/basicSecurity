package com.huit.mx.securityBasic.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huit.mx.securityBasic.dto.Greet;

@RestController
public class SecurityController {
	
	@GetMapping("/")
	Greet greet() {
		return new Greet("Hello World!");
	}

}
