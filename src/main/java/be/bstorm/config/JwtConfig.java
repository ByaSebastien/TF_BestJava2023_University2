package be.bstorm.config;

import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;

@Component
public class JwtConfig {

    private byte[] secret = "Yabadabadooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo".getBytes(StandardCharsets.UTF_8);

    public int expireAt = 86400; // 1Day

    public SecretKey secretKey = new SecretKeySpec(secret,"HmacSHA384");
}
