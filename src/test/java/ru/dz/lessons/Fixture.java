package ru.dz.lessons;

import ru.dz.lessons.model.Todo;

import java.util.Arrays;
import java.util.List;

/**
 * Created by blvp on 27.03.15.
 */
public class Fixture {

    public static final String TODO_TEXT = "blablabla";
    public static final boolean TODO_CHECKED = false;
    public static Long TODO_ID = 1L;

    public static Todo standardTodo(){
        Todo todo = new Todo();
        todo.setId(TODO_ID);
        todo.setText(TODO_TEXT);
        todo.setChecked(TODO_CHECKED);
        return todo;
    }

    public static List<Todo> standardTodoList(){
        return Arrays.asList(standardTodo(), standardTodo());
    }
}
