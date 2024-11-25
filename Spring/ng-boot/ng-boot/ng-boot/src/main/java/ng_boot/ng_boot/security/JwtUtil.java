package ng_boot.ng_boot.security;

import java.util.Date;

import org.springframework.stereotype.Component;


import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import java.security.Key;


@Component
public class JwtUtil {
	
	  private static final Key SECRET_KEY = Keys.hmacShaKeyFor("TejasTejasTejasTejasTejasTejasTejasTejas".getBytes());

	    public static String generateToken(String username) {
	        return Jwts.builder()
	                .setSubject(username)
	                .setIssuedAt(new Date())
	                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60))
	                .signWith(SECRET_KEY, SignatureAlgorithm.HS256)
	                .compact();
	    }

	    public static Claims validateToken(String token) {
	        try {
	            return Jwts.parserBuilder()
	                    .setSigningKey(SECRET_KEY)
	                    .build()
	                    .parseClaimsJws(token)
	                    .getBody();
	        } catch (Exception e) {
	            // Handle the exception (e.g., token expiration, signature issues)
	        	System.out.println(e);
	        	e.printStackTrace();
	            return null;
	        }
	    }
}
