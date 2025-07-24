package com.example.treino01.treinamento01.controller;

import com.example.treino01.treinamento01.repository.UsuarioRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.treino01.treinamento01.model.Usuario;

import java.util.List;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
    private UsuarioRepository usuarioRepository;

    public UsuarioController(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    @GetMapping
    public List<Usuario> listarTodos(){
        return usuarioRepository.findAll();
    }

    @PostMapping
    public ResponseEntity<Usuario> salvar(@RequestBody Usuario usuario){
        usuarioRepository.save(usuario);
        return ResponseEntity.status(HttpStatus.CREATED).body(usuario);

    }

    @PutMapping
    public ResponseEntity<Usuario> atualizar(@RequestBody Usuario usuario){
     if(usuarioRepository.existsById(usuario.getId())){
         usuarioRepository.save(usuario);
     }
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id){
        usuarioRepository.deleteById(id);
        return ResponseEntity.ok().build();
    }


}
