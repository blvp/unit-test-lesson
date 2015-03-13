package ru.dz.lessons.controller.api.v1_0;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.dz.lessons.model.Todo;
import ru.dz.lessons.service.TodoService;

import java.util.List;

/**
 * Created by blvp on 13.03.15.
 */
@RestController
@RequestMapping("/api/v1_0/todo")
public class TodoApi {

    @Autowired
    private TodoService todoService;

    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public ResponseEntity<List<Todo>> getAll(){
        List<Todo> list = todoService.getAll();
        if(list != null) {
            return new ResponseEntity<List<Todo>>(list, HttpStatus.OK);
        } else {
            return new ResponseEntity<List<Todo>>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "{id:[0-9]+}", method = RequestMethod.GET)
    public ResponseEntity<Todo> getOne(@PathVariable Long id){
        Todo todo = todoService.getOneWithoutId(id);
        if(todo != null){
            return new ResponseEntity<Todo>(todo, HttpStatus.OK);
        } else {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Todo> createOne(@RequestParam("text") String text){
        Todo todo = todoService.createTodo(new Todo(text));
        if(todo != null){
            return new ResponseEntity<Todo>(todo, HttpStatus.OK);
        } else {
            return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
        }
    }

    @RequestMapping(value = "{id:[0-9]+}", method = RequestMethod.PUT)
    public ResponseEntity<Todo> updateChecked(
            @PathVariable Long id,
            @RequestParam(value = "checked", defaultValue = "false") Boolean checked
    ){
        Todo todo = todoService.getOne(id);
        if(todo != null){
            todo.setChecked(checked);
            Todo updated = todoService.updateChecked(todo);
            if(updated != null){
                return new ResponseEntity<Todo>(updated, HttpStatus.OK);
            }
        }
        return new ResponseEntity<Todo>(HttpStatus.NOT_FOUND);
    }

}
