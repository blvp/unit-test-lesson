package ru.dz.lessons.service;


import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.lessons.model.Todo;

import java.util.List;

/**
 * Created by blvp on 13.03.15.
 */

public interface TodoService {

    /**
     * Получаем весь список туду листа
     * @return должен вернуть null если список пуст в обратном случае список Todo
     */
    List<Todo> getAll();

    /**
     * Получаем тудушку без айди
     * @param id
     * @return null или объект без идентификатора ru.dz.lessons.model.Todo
     */
    Todo getOneWithoutId(Long id);

    /**
     * создает Todo
     * капитализирует текст тудушки и добавляет точку в конце
     * @param todo
     * @return todo объект
     */
    Todo createTodo(Todo todo);

    Todo getOne(Long id);

    Todo updateChecked(Todo todo);
}
