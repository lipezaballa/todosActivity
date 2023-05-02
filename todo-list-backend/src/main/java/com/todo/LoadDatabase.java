package com.todo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class LoadDatabase implements CommandLineRunner {

    private final TodoRepository repository;

    public LoadDatabase(TodoRepository repository) {
        this.repository = repository;
    }

    @Override
    public void run(String... args) throws Exception {

        //ids are autogenerated, that is why I don't include them
        Todo todo1 = new Todo();
        todo1.setTask("Implement loading - frontend only");
        todo1.setPriority(1);
        repository.save(todo1);

        Todo todo2 = new Todo();
        todo2.setTask("Implement search - frontend only");
        todo2.setPriority(2);
        repository.save(todo2);

        Todo todo3 = new Todo();
        todo3.setTask("Implement delete on click - frontend only");
        todo3.setPriority(1);
        repository.save(todo3);

        Todo todo4 = new Todo();
        todo4.setTask("Replace mock service by integrating backend");
        todo4.setPriority(3);
        repository.save(todo4);
    }
}