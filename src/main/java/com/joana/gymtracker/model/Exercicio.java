package com.joana.gymtracker.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

@Entity
public class Exercicio {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;   // Ex: "Agachamento", "Rosca direta"
    private String series; // Ex: "3x12"

    // Relacionamento: cada exercício pertence a um treino
    @ManyToOne
    @JoinColumn(name = "treino_id")
    @JsonBackReference
    private Treino treino;

    // Getters e Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getSeries() { return series; }
    public void setSeries(String series) { this.series = series; }

    public Treino getTreino() { return treino; }
    public void setTreino(Treino treino) { this.treino = treino; }
}