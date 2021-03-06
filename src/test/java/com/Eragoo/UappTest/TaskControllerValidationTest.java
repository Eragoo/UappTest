package com.Eragoo.UappTest;

import com.Eragoo.UappTest.task.TaskCommand;
import com.Eragoo.UappTest.task.TaskController;
import com.Eragoo.UappTest.task.TaskService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.time.Instant;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TaskController.class)
public class TaskControllerValidationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TaskService taskService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenInputInvalidDtoThenReturnsStatus422() throws Exception {
        TaskCommand task = new TaskCommand("","",null, null, null);
        String body = objectMapper.writeValueAsString(task);

        performTaskCommandRequestsWithInvalidDto(body);
    }

    @Test
    void whenInputTaskWithBlankNameThenReturnsStatus422() throws Exception {
        TaskCommand task = new TaskCommand("","desc",1, Instant.now(), null);
        String body = objectMapper.writeValueAsString(task);

        performTaskCommandRequestsWithInvalidDto(body);
    }

    @Test
    void whenInputTaskWithBlankDescThenReturnsStatus422() throws Exception {
        TaskCommand task = new TaskCommand("name","",1, Instant.now(), null);
        String body = objectMapper.writeValueAsString(task);

        performTaskCommandRequestsWithInvalidDto(body);
    }

    @Test
    void whenInputTaskWithEmptyCreationDateThenReturnsStatus422() throws Exception {
        TaskCommand task = new TaskCommand("name","desc",1, null, null);
        String body = objectMapper.writeValueAsString(task);

        performTaskCommandRequestsWithInvalidDto(body);
    }

    private void performTaskCommandRequestsWithInvalidDto(String body) throws Exception {
        mockMvc.perform(post("/api/task")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isUnprocessableEntity());

        mockMvc.perform(put("/api/task/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isUnprocessableEntity());
    }
}
