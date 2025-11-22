package com.example.Tarefas_API.tarefas.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

import java.time.LocalDate;

@Entity
@Table(name = "tarefas ")
public class Tarefa {
    private long id;
    private String nome;
    private LocalDate dataEntrega;
    private String responsavel;
}
