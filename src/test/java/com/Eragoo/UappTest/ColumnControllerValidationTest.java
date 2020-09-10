package com.Eragoo.UappTest;

import com.Eragoo.UappTest.column.ColumnCommand;
import com.Eragoo.UappTest.column.ColumnController;
import com.Eragoo.UappTest.column.ColumnService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(ColumnController.class)
public class ColumnControllerValidationTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private ColumnService service;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void whenInputInvalidDtoThenReturnsStatus422() throws Exception {
        ColumnCommand command = new ColumnCommand("", null);
        String body = objectMapper.writeValueAsString(command);

        performTaskCommandRequestsWithInvalidDto(body);
    }

    @Test
    void whenInputColumnWithBlankNameThenReturnsStatus422() throws Exception {
        ColumnCommand command = new ColumnCommand("", 1);
        String body = objectMapper.writeValueAsString(command);

        performTaskCommandRequestsWithInvalidDto(body);
    }

    @Test
    void whenInputTaskWithNullPriorityThenReturnsStatus422() throws Exception {
        ColumnCommand command = new ColumnCommand("name", null);
        String body = objectMapper.writeValueAsString(command);

        performTaskCommandRequestsWithInvalidDto(body);
    }

    private void performTaskCommandRequestsWithInvalidDto(String body) throws Exception {
        mockMvc.perform(post("/api/column")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isUnprocessableEntity());

        mockMvc.perform(put("/api/column/1")
                .contentType(MediaType.APPLICATION_JSON)
                .content(body))
                .andExpect(status().isUnprocessableEntity());
    }
}
