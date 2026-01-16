package com.joana.gymtracker.controller;

import com.joana.gymtracker.model.Exercicio;
import com.joana.gymtracker.repository.ExercicioRepository;
import com.joana.gymtracker.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/exercicios")
public class ExercicioController {

    @Autowired
    private ExercicioRepository exercicioRepository;

    @Autowired
    private TreinoRepository treinoRepository;

    // Listar todos os exercícios
    @GetMapping
    public List<Exercicio> listar() {
        return exercicioRepository.findAll();
    }

    // Buscar exercício por ID
    @GetMapping("/{id}")
    public Exercicio buscarPorId(@PathVariable Long id) {
        return exercicioRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));
    }

    // Cadastrar exercício vinculado a um treino
    @PostMapping("/{treinoId}")
    public Exercicio cadastrar(@PathVariable Long treinoId, @RequestBody Exercicio exercicio) {
        return treinoRepository.findById(treinoId)
                .map(treino -> {
                    exercicio.setTreino(treino);
                    return exercicioRepository.save(exercicio);
                })
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));
    }

    // Atualizar exercício
    @PutMapping("/{id}")
    public Exercicio atualizar(@PathVariable Long id, @RequestBody Exercicio exercicioAtualizado) {
        return exercicioRepository.findById(id)
                .map(exercicio -> {
                    exercicio.setNome(exercicioAtualizado.getNome());
                    exercicio.setSeries(exercicioAtualizado.getSeries());
                    return exercicioRepository.save(exercicio);
                })
                .orElseThrow(() -> new RuntimeException("Exercício não encontrado"));
    }

    // Deletar exercício
    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!exercicioRepository.existsById(id)) {
            throw new RuntimeException("Exercício não encontrado");
        }
        exercicioRepository.deleteById(id);
    }
}