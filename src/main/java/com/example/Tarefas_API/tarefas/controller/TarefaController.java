package com.example.Tarefas_API.tarefas.controller;

import com.example.Tarefas_API.tarefas.model.Tarefa;
import com.example.Tarefas_API.tarefas.repository.TarefaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/tarefas")
@CrossOrigin("*")
public class TarefaController {
    @Autowired
    private TarefaRepository tarefaRepository;

    //CRIAR TAREFA
    public Tarefa criarTarefa(@RequestBody Tarefa tarefa) {
        return tarefaRepository.save(tarefa);
    }
    //CONSULTAR TODAS AS TAREFAS
    public List<Tarefa> getAllTarefas() {
        return tarefaRepository.findAll();
    }

    //CONSULTAR TAREFA POR ID
    public ResponseEntity<List<Tarefa>> getTarefasById(@PathVariable Long id) {
        Optional<Tarefa> tarefa = tarefaRepository.findById(id);
        return tarefa.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
    //ATUALIZAR TAREFA
    @PutMapping("/{id}")
     public ResponseEntity<Tarefa> updateTarefa(@PathVariable Long id, @RequestBody Tarefa tarefaDetails) {
        Optional<Tarefa> optionalTarefa = tarefaRepository.findBy(id);

        if (optionalTarefa.isPresent()) {
            Tarefa tarefa = optionalTarefa.get();
            tarefa.setNome(tarefaDetails.getNome());
            tarefa.setResponsavel(tarefaDetails.getResponsavel());
            tarefa.setDataEntrega(tarefaDetails.getDataEntrega());

            Tarefa updateTarefa = tarefaRepository.save(tarefa);
            return ResponseEntity.ok(updateTarefa);
        }else {
            return ResponseEntity.notFound().build();
        }

        //REMOVER TAREFA
         public ResponseEntity<?> deleteTarefa(@PathVariableLonhg id){
            if (tarefaRepository.existsById(id)) {
                tarefaRepository.deleteById(id);
                return ResponseEntity.ok().build();
            }else  {
                return ResponseEntity.notFound().build();
        }
     }
}
