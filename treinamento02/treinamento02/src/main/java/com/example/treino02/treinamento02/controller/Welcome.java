package com.example.treino02.treinamento02.controller;

import com.example.treino02.treinamento02.models.Pessoa;
import com.example.treino02.treinamento02.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/pessoa")
public class Welcome {

    private PessoaService pessoaService;


    public Welcome(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @GetMapping
    public List<Pessoa> listarTodos(){
        return pessoaService.listarTodos();
    }

    @PostMapping("/salvar")
    public ResponseEntity<Map<String, Object>> salvar(@Valid @RequestBody Pessoa pessoa){
        pessoaService.salvar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(Map.of("message", "Pessoa cadastrada com sucesso!"));
    }

    @PutMapping("/atualizar")
    public ResponseEntity<String> deletar(@Valid @RequestBody Pessoa pessoa){
        pessoaService.atualizar(pessoa);
        return ResponseEntity.status(HttpStatus.CREATED).body("Pessoa Atualizada");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletar(@PathVariable Long id){
        pessoaService.excluir(id);
        return ResponseEntity.ok().body("Pessoa excluída com sucesso!");
    }

}
