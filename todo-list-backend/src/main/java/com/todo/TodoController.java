package com.todo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class TodoController {

    private final TodoRepository repository;

    @Autowired
    public TodoController(TodoRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Todo> getAllTodos() {
        return repository.findAll();
    }

    @PostMapping
    public Todo createNewTodo(@RequestBody Todo newTodo) {
        return repository.save(newTodo);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Todo> updateTodo(@PathVariable Long id, @RequestBody Todo updatedTodo) {
        Todo todoToUpdate = repository.findById(id)
                .orElseThrow(() -> new TodoNotFoundException(id));
        todoToUpdate.setTask(updatedTodo.getTask());
        todoToUpdate.setPriority(updatedTodo.getPriority());
        return ResponseEntity.ok(repository.save(todoToUpdate));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteTodoById(@PathVariable Long id) {
        repository.deleteById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
