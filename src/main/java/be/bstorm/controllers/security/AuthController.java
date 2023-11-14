package be.bstorm.controllers.security;

import be.bstorm.models.entities.Person;
import be.bstorm.models.forms.auth.RegisterForm;
import be.bstorm.services.security.AuthService;
import be.bstorm.utils.JwtUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class AuthController {

    private final AuthService authService;
    private final JwtUtils jwtUtils;

    public AuthController(AuthService authService, JwtUtils jwtUtils) {
        this.authService = authService;
        this.jwtUtils = jwtUtils;
    }

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody RegisterForm form){
        Person p = authService.register(form.toEntity());
        String token = jwtUtils.generateToken(p);
        return ResponseEntity.ok(token);
    }

    @GetMapping("login")
    public ResponseEntity<String> login(
            @RequestParam String username,
            @RequestParam String password
    ){
        Person p = authService.login(username,password);
        String token = jwtUtils.generateToken(p);
        return ResponseEntity.ok(token);
    }
}
