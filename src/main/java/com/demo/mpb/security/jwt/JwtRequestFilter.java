package com.demo.mpb.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetails;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import com.demo.mpb.service.impl.UsuarioServiceImpl;

import io.jsonwebtoken.ExpiredJwtException;

@Component
public class JwtRequestFilter extends OncePerRequestFilter {

	@Autowired
	private JwtTokenUtil jwtTokenUtil;

	@Autowired
	private UsuarioServiceImpl userDetailsService;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Filtro interceptado");

		String uri = request.getRequestURI();

		if (!uri.contains("/authenticate")) {
			final String requestTokenHeader = request.getHeader("Authorization");

			String username;
			String jwttoken;

			if (requestTokenHeader != null && requestTokenHeader.startsWith("Bearer ")) {
				jwttoken = requestTokenHeader.substring(7);
				username = jwtTokenUtil.getUsernameFromToken(jwttoken);
				if (username != null && SecurityContextHolder.getContext().getAuthentication() == null) {
					UserDetails userDetails = userDetailsService.loadUserByUsername(username);
					if (jwtTokenUtil.validateToken(jwttoken, userDetails)) {
						UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(
								userDetails.getUsername(), userDetails.getPassword(), userDetails.getAuthorities());
						usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetails(request));
						SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
					} else {
						System.out.println("El token es invalido");
						throw new ExpiredJwtException(null, null, "Token invalido");
					}
				}
			} else {
				System.out.println("No hay token en la peticion");
				throw new IllegalArgumentException("Peticion inválida, no hay token");
			}
		}
		
		filterChain.doFilter(request, response);
	}
}
