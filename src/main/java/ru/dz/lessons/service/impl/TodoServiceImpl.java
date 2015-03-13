package ru.dz.lessons.service.impl;

import com.google.common.collect.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.dz.lessons.model.Todo;
import ru.dz.lessons.repository.TodoRepository;
import ru.dz.lessons.service.TodoService;

import java.util.List;

/**
 * Created by blvp on 13.03.15.
 */
@Service
@Transactional
public class TodoServiceImpl implements TodoService {

    @Autowired
    private TodoRepository todoRepository;

    @Override
    public List<Todo> getAll() {
        Iterable<Todo> list = todoRepository.findAll();
        return Lists.newArrayList(list);
    }

    @Override
    public Todo getOneWithoutId(Long id) {
        Todo todo = todoRepository.findOne(id);
//        if (todo != null) {
//            todo.setId(null);
//        }
        return todo;
    }

    @Override
    public Todo createTodo(Todo todo) {
//        String capitalized = StringUtils.capitalize(todo.getText());
//        StringBuilder sb = new StringBuilder(capitalized);
//        sb.append(".");
//        todo.setText(sb.toString());

        return todoRepository.save(todo);
    }

    @Override
    public Todo getOne(Long id) {
        return todoRepository.findOne(id);
    }

    @Override
    public Todo updateChecked(Todo todo) {
        return todoRepository.save(todo);
    }
}
