package com.rohit.showBookKaro.services;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

@Service
public class JwtService {
private Long jwtExpiration;
@Value("${application.security.jwt.secret-key}")
private  String secretkey;
    public String generateToken(UserDetails userDetails) {

        return generateToken(new HashMap<String, Object>(), userDetails);
    }

    private String generateToken(Map<String, Object> claims,UserDetails userDetails) {

        return  buildToken(claims,userDetails,jwtExpiration);
    }
    private String buildToken(Map<String, Object> extraclaims,
                              UserDetails userDetails,
                              Long expiration) {

        var authorities=userDetails.getAuthorities()
                .stream()
                .map(GrantedAuthority::getAuthority)
                .toList();

        return Jwts.builder().setClaims(extraclaims)
                .setSubject(userDetails.getUsername())
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis()+expiration))
                .signWith(Keys.hmacShaKeyFor(secretkey.getBytes()))
                .claim("authorities",authorities)
                .compact();
    }

    public String extractUserName(String token) {
        return   extractClaim(token, Claims::getSubject);
    }
    public <T> T extractClaim(String token, Function<Claims, T> claimsResolver) {
        
        final Claims claims=extractAllClaims(token);
        return claimsResolver.apply(claims);
    }

    private Claims extractAllClaims(String token) {

        return  Jwts.parserBuilder()
                .setSigningKey(secretkey.getBytes())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public  boolean isTokenValid(String token,UserDetails userDetails) {
        final String username = extractUserName(token);
        return (username.equals(userDetails.getUsername()))&& !isTokenExpired(token);

    }

    private boolean isTokenExpired(String token) {
        
        return extractTokenExpiration(token).before(new Date());
    }

    private Date extractTokenExpiration(String token) {
        return  extractClaim(token,Claims::getExpiration);
    }
}
