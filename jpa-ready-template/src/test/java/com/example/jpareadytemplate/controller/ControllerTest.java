package com.example.jpareadytemplate.controller;

import com.example.jpareadytemplate.model.ExampleModel;
import com.example.jpareadytemplate.service.ServiceLayer;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.ImportAutoConfiguration;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@WebMvcTest(Controller.class)
//@ImportAutoConfiguration(RefreshAutoConfiguration.class) for eureka @RefreshScope?
public class ControllerTest {
    @MockBean
    private ServiceLayer serviceLayer;

    @Autowired
    MockMvc mockMvc;
    private JacksonTester<ExampleModel> modelJacksonTester;
    private JacksonTester<List<ExampleModel>> listJacksonTester;


    @Before
    public void setUp() throws Exception {
        JacksonTester.initFields(this,new ObjectMapper());
    }

    @Test
    public void shouldPutTestsHere(){}
    /* BELOW IS PART OF AN EXAMPLE FROM ANOTHER SERVICE USING tvm AS VIEWMODEL

    public void shouldGetTaskById() throws Exception{

        given(service.fetchTask(1))
                .willReturn(tvm);

        MockHttpServletResponse response = mockMvc.perform(
                get("/tasks/1")
                        .accept(MediaType.APPLICATION_JSON))
                .andReturn().getResponse();

        assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
        assertThat(response.getContentAsString()).isEqualTo(
                taskViewModelJacksonTester.write(tvm).getJson());
    }

     */

}