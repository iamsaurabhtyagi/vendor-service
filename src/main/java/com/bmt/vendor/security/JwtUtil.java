package com.bmt.vendor.security;

import com.common.exception.InvalidJwtSignatureException;
import com.common.exception.InvalidJwtTokenException;
import com.common.security.UserContext;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

@Component
public class JwtUtil {

    private static final String SECRET_KEY = "your-secret-key-saurabh-kumar-tyagi-140288";

    private Key getSignKey() {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String extractUsername(String token) {
        return extractAllClaims(token).getSubject();
    }

    public Date extractExpiration(String token) {
        return extractAllClaims(token).getExpiration();
    }

    public boolean isTokenExpired(String token) {
        return extractExpiration(token).before(new Date());
    }

    public Claims extractAllClaims(String token) {
        try {
            return Jwts.parserBuilder()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
        } catch (SignatureException e) {
            throw new InvalidJwtSignatureException("Invalid JWT Signature");
        } catch (Exception e) {
            throw new InvalidJwtTokenException("Invalid JWT Token");
        }
    }

    public boolean validateToken(String token, String username) {
        final String extractedUsername = extractUsername(token);
        return (extractedUsername.equals(username) && !isTokenExpired(token));
    }

    public boolean validateToken(String token) {
        return !isTokenExpired(token);
    }

    public UserContext getUserDetails() {
        //Map<String, Object> claims = (Map<String, Object>) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        String username = (String) auth.getPrincipal();
        Map<String, Object> claims = (Map<String, Object>) auth.getDetails();

        UserContext userContext = new UserContext();
        userContext.setUsername((String) claims.get("username"));
        userContext.setUserId(UUID.fromString((String) claims.get("userId")));
        userContext.setUserType((String) claims.get("userType"));
        userContext.setUserCategory((String) claims.get("userCategory"));
        userContext.setActive((Boolean) claims.get("active"));

        return userContext;
    }
}
