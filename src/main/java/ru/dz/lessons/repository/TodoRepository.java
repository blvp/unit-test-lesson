package ru.dz.lessons.repository;

import org.springframework.data.repository.CrudRepository;
import ru.dz.lessons.model.Todo;


public interface TodoRepository extends CrudRepository<Todo, Long> {
    Todo findByTextAndChecked(String text, Boolean checked);
}
