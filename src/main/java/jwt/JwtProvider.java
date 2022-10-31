package jwt;

import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import model.User;

import java.security.Key;
import java.util.Date;
import java.util.Map;

public class JwtProvider {

    byte[] keyBytes = "secretString@12335576886533135675671".getBytes();
    Key secretKey = Keys.hmacShaKeyFor(keyBytes);

    public String createToken(User user) {
        Map<String, Object> claims;
        claims = Jwts.claims().setSubject(user.getUserName());
        claims.put("id", user.getUserId());
        Date now = new Date();
        Date exp = new Date(now.getTime() + 3600000);
        return Jwts.builder()
                .setClaims(claims)
                .setIssuedAt(now)
                .setExpiration(exp)
                .signWith(secretKey)
                .compact();
        //.setHeaderParam("kid", "myKeyId") // to add one o more header params

    }

    public boolean validate(String token) {
        try {
            Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token);
            return true;

        } catch (JwtException e) {
            return false;
        }
    }

    public String getUserNameFromToken(String token) {
        try {
            return Jwts.parserBuilder().setSigningKey(secretKey).build().parseClaimsJws(token).getBody().getSubject();
        } catch(JwtException e) {
            return "bad token";
        }
    }
}
