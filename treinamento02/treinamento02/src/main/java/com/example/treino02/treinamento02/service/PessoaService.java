package com.example.treino02.treinamento02.service;


import com.example.treino02.treinamento02.models.Pessoa;
import com.example.treino02.treinamento02.repository.PessoaRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
@Service
@Validated
public class PessoaService {

    private final PessoaRepository pessoaRepository;

    public PessoaService(PessoaRepository pessoaRepository) {
        this.pessoaRepository = pessoaRepository;
    }

    public List<Pessoa> listarTodos() {
        return pessoaRepository.findAll();
    }

    public Pessoa salvar(@Valid Pessoa pessoa) {
        if (pessoaRepository.findByEmail(pessoa.getEmail()).isPresent()) {
            throw new IllegalArgumentException("Pessoa já cadastrada");
        } else {
            return pessoaRepository.save(pessoa);
        }
    }

    public Pessoa atualizar(@Valid Pessoa pessoa) {
        Pessoa pessoaAtualiza = pessoaRepository.findById(pessoa.getId())
                .orElseThrow(() -> new RuntimeException("Pessoa não encontrada"));

        pessoaAtualiza.setNome(pessoa.getNome());
        pessoaAtualiza.setDatNascimento(pessoa.getDatNascimento());
        pessoaAtualiza.setEmail(pessoa.getEmail());
        pessoaAtualiza.setSexo(pessoa.getSexo());
        pessoaAtualiza.setTelefone(pessoa.getTelefone());

        return pessoaRepository.save(pessoaAtualiza);
    }

    public void excluir(Long id) {
        Pessoa pessoa = pessoaRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Pessoa não encontrada"));
        pessoaRepository.deleteById(id);
    }
}


