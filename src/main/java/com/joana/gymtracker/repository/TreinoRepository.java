package com.joana.gymtracker.repository;

import com.joana.gymtracker.model.Treino;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TreinoRepository extends JpaRepository<Treino, Long> {
    // Aqui você pode adicionar métodos customizados se precisar
    // Exemplo: List<Treino> findByTipo(String tipo);
}