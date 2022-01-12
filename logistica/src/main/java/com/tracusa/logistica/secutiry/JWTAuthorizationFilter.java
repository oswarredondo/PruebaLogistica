package com.tracusa.logistica.secutiry;

import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.UnsupportedJwtException;

public class JWTAuthorizationFilter extends OncePerRequestFilter {

	private final String HEADER = "Authorization";
	private final String PREFIX = "Bearer ";
	private final String SECRET = "lzh85xxkVZAE0LxDhfP48hOJ6ajC+Z/3uaV9LTmZvVhpoqIEWXSSnO5piCacZyk2rt+"
			+"lrMkeUfwuKifnuA7eH9FnQD8RonuhLobB46Fksw+e+6b3PP4d6aNHRN7ZR0azzKUZL2FVgubiIyoJ3"
			+"uzGXKqsjkL+QLs6XOzBJ+sGEBq+8BN5aAiMmUot9Q812gTTmZKTOTPQsCzomsOQHqFtB/3KI4d3g0q/"
			+"79uUvFeL9o4qF8H8PiHg8DnApUYdCrfrUqBAGsRB0Re1TgX+lFJQChhgbd8GU4OBIF3IIv1sAt7VOf0"
			+"d7sKJSOmSc1K6xCC2puFINuS9FC5HVVlt/tr0+DQVzeZwc/ClmlfnxunJ2bIPx6DuGnJUEkU6Zxso7K2"
			+"F9nKB5G6nYn25eNkSI1GxiasrTR7JcAPVsgciDm5EtTi3y3x6hKMf9kEpECEyE8yD+fJ+icNGoGq3t5jcC"
			+ "2rsdf6Hm0QyyPq7bds4UzDKlxVW55KchbaPnA";
	
	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws ServletException, IOException {
		try {
			if (existeJWTToken(request, response)) {
				Claims claims = validateToken(request);
				if (claims.get("authorities") != null) {
					setUpSpringAuthentication(claims);
				} else {
					SecurityContextHolder.clearContext();
				}
			} else {
					SecurityContextHolder.clearContext();
			}
			chain.doFilter(request, response);
		} catch (ExpiredJwtException | UnsupportedJwtException | MalformedJwtException e) {
			response.setStatus(HttpServletResponse.SC_FORBIDDEN);
			((HttpServletResponse) response).sendError(HttpServletResponse.SC_FORBIDDEN, e.getMessage());
			return;
		}
	}	

	private Claims validateToken(HttpServletRequest request) {
		//String jwtToken = request.getHeader(HEADER).replace(PREFIX, "");
		String jwtToken = request.getHeader(HEADER);
		return Jwts.parser().setSigningKey(SECRET.getBytes()).parseClaimsJws(jwtToken).getBody();
	}

	/**
	 * Metodo para autenticarnos dentro del flujo de Spring
	 * 
	 * @param claims
	 */
	private void setUpSpringAuthentication(Claims claims) {
		@SuppressWarnings("unchecked")
		List<String> authorities = (List) claims.get("authorities");

		UsernamePasswordAuthenticationToken auth = new UsernamePasswordAuthenticationToken(claims.getSubject(), null,
				authorities.stream().map(SimpleGrantedAuthority::new).collect(Collectors.toList()));
		SecurityContextHolder.getContext().setAuthentication(auth);

	}

	private boolean existeJWTToken(HttpServletRequest request, HttpServletResponse res) {
		String authenticationHeader = request.getHeader(HEADER);
		//if (authenticationHeader == null || !authenticationHeader.startsWith(PREFIX))
		if (authenticationHeader == null)
			return false;
		return true;
	}

}