package com.demo.mpb.security.jwt.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.mpb.security.jwt.JwtRequest;
import com.demo.mpb.security.jwt.JwtResponse;
import com.demo.mpb.security.jwt.JwtTokenUtil;
import com.demo.mpb.service.impl.UsuarioServiceImpl;

@RestController
@CrossOrigin
@RequestMapping("/authenticate")
public class JwtAuthenticationController {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;
	
	@Autowired
	private UsuarioServiceImpl userDetailsService;
	
	@Autowired
	private AuthenticationManager authenticationManager;
	
	@PostMapping
	public ResponseEntity<?> createAuthenticateToken(@RequestBody JwtRequest authenticateRequest){
		authenticate(authenticateRequest.getUsername(),authenticateRequest.getPassword());
	
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticateRequest.getUsername());
		final String token = jwtTokenUtil.generateToken(userDetails);
		return new ResponseEntity<>(new JwtResponse(token),HttpStatus.OK);
	}

	private void authenticate(String username, String password) {
		authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
	}

}
