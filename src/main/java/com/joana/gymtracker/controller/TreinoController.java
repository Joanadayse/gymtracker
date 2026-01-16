package com.joana.gymtracker.controller;

import com.joana.gymtracker.model.Treino;
import com.joana.gymtracker.repository.TreinoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/treinos")
public class TreinoController {

    @Autowired
    private TreinoRepository treinoRepository;

    // Endpoint para listar todos os treinos
    @GetMapping
    public List<Treino> listar() {
        return treinoRepository.findAll();
    }

    @GetMapping("/{id}")
    public Treino buscarPorId(@PathVariable Long id) {
        return treinoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));
    }

    // Endpoint para cadastrar um novo treino
    @PostMapping
    public Treino cadastrar(@RequestBody Treino treino) {
        if (treino.getExercicios() != null) {
            treino.getExercicios().forEach(exercicio -> exercicio.setTreino(treino));
        }
        return treinoRepository.save(treino);
    }

    @PutMapping("/{id}")
    public Treino atualizar(@PathVariable Long id, @RequestBody Treino treinoAtualizado) {
        return treinoRepository.findById(id)
                .map(treino -> {
                    treino.setTipo(treinoAtualizado.getTipo());
                    treino.getExercicios().clear();
                    treinoAtualizado.getExercicios().forEach(exercicio -> {
                        exercicio.setTreino(treino);
                        treino.getExercicios().add(exercicio);
                    });
                    return treinoRepository.save(treino);
                })
                .orElseThrow(() -> new RuntimeException("Treino não encontrado"));
    }


    @DeleteMapping("/{id}")
    public void deletar(@PathVariable Long id) {
        if (!treinoRepository.existsById(id)) {
            throw new RuntimeException("Treino não encontrado");
        }
        treinoRepository.deleteById(id);
    }


}