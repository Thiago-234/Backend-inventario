package com.projeto.inventario.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.projeto.inventario.dto.TokenDTO;
import com.projeto.inventario.dto.UsuarioDTO;
import com.projeto.inventario.entities.StatusRole;
import com.projeto.inventario.entities.Usuario;
import com.projeto.inventario.repositories.UsuarioRepository;
import com.projeto.inventario.service.TokenService;

@RestController
@RequestMapping(value = "/auth")
public class AuthController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private PasswordEncoder encoder;

    @PostMapping(value = "/register")
    public ResponseEntity<?> register(@RequestBody UsuarioDTO dto) {
        if (dto.getRole() == null) {
            dto.setRole(StatusRole.USUARIO);
        }

        Usuario usuario = new Usuario(
            dto.getLogin(),
            encoder.encode(dto.getSenha()),
            dto.getRole()
        );
        usuarioRepository.save(usuario);
        return ResponseEntity.ok().build();
    }
    
    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody UsuarioDTO dto) {
        var authToken = new UsernamePasswordAuthenticationToken(dto.getLogin(), dto.getSenha());
        var auth = authenticationManager.authenticate(authToken);

        var token = tokenService.gerarToken((Usuario) auth.getPrincipal());
        return ResponseEntity.ok(new TokenDTO(token));
    }
    
}
