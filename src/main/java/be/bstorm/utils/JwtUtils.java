package be.bstorm.utils;

import be.bstorm.config.JwtConfig;
import be.bstorm.models.entities.Person;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.JwtParser;
import io.jsonwebtoken.Jwts;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtUtils {

    //Stock des info de config pour le jwtoken
    private final JwtConfig config;
    //Permet de creer(ecrire) un jwtoken
    private final JwtBuilder builder;
    //Permet de decrypter(lire) un jwtoken
    private final JwtParser parser;

    public JwtUtils(JwtConfig config) {
        this.config = config;
        this.builder = Jwts.builder().signWith(config.secretKey);
        this.parser = Jwts.parserBuilder().setSigningKey(config.secretKey).build();
    }

    //Permet de generer un token sur base de la class qui implement UserDetails (Person)
    public String generateToken(Person person){
        return builder
                .claim("id",person.getId())
                .claim("username",person.getUsername())
                .claim("role",person.getRole())
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + config.expireAt *1000L))
                .compact();
    }

    public Claims getClaims(String token){
        return parser.parseClaimsJws(token).getBody();
    }

    public String getId(String token){
        return getClaims(token).get("id", String.class);
    }

    public String getUsername(String token){
        return getClaims(token).get("username", String.class);
    }

    public String getRole(String token){
        return getClaims(token).get("role", String.class);
    }

    public boolean isValid(String token){
        Claims claims = getClaims(token);
        Date now = new Date();
        return getRole(token) != null && now.after(claims.getIssuedAt()) && now.before(claims.getExpiration());
    }
}
