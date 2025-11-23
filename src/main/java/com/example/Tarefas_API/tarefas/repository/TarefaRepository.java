package com.example.Tarefas_API.tarefas.repository;

import com.example.Tarefas_API.tarefas.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaRepository extends JpaRepository<Tarefa, Long> {
    // Spring Data JPA will automatically provide CRUD operations:
    // save(), findAll(), findById(), deleteById(), etc.
}
