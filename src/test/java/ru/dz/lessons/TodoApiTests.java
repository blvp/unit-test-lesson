package ru.dz.lessons;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.test.web.servlet.MockMvc;
import ru.dz.lessons.controller.api.v1_0.TodoApi;
import ru.dz.lessons.service.TodoService;

import static org.mockito.Matchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.setup.MockMvcBuilders.standaloneSetup;
import static ru.dz.lessons.Fixture.*;

/**
 * Created by blvp on 27.03.15.
 */
public class TodoApiTests {
    MockMvc mockMvc;

    private final String BASE_URL = "/api/v1_0/todo";

    @InjectMocks
    TodoApi controller;

    @Mock
    TodoService todoService;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        this.mockMvc = standaloneSetup(controller)
                .setMessageConverters(new MappingJackson2HttpMessageConverter()).build();
    }

    @Test
    public void testFindTodoById() throws Exception {
        when(todoService.getOne(any(Long.class))).thenReturn(standardTodo());

        this.mockMvc.perform(get(BASE_URL + "{id}", 1L).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$.id").doesNotExist())
                .andExpect(jsonPath("$.text").value(TODO_TEXT))
                .andExpect(jsonPath("$.checked").value(TODO_CHECKED))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindTodoByIdNotFound() throws Exception {
        when(todoService.getOne(any(Long.class))).thenReturn(null);
        this.mockMvc.perform(get(BASE_URL+"{id}", 1L).accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }

    @Test
    public void testFindAllTodos() throws Exception{
        when(todoService.getAll()).thenReturn(standardTodoList());

        this.mockMvc.perform(get(BASE_URL + "/list").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(jsonPath("$[0].id").value(TODO_ID))
                .andExpect(jsonPath("$[1].text").value(TODO_TEXT))
                .andExpect(status().isOk());
    }

    @Test
    public void testFindAllTodos_NotFound() throws Exception{
        when(todoService.getAll()).thenReturn(null);

        this.mockMvc.perform(get(BASE_URL + "/list").accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isNotFound());
    }


}
