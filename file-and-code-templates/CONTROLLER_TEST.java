package ${PACKAGE_NAME};

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest(${OBJECT}Controller.class)
public class ${NAME} {
    @Autowired
    private MockMvc mvc;

    @MockBean
    private ${SERVICE_OR_DAO_CLASS} ${SERVICE_OR_DAO};

    private static final ${OBJECT} ${OBJECT}_NO_ID = new ${OBJECT}(//fill me in boi);
    private static final ${OBJECT} ${OBJECT}_ID = new ${OBJECT}(1, //fill me in boi);
    private static final List<${OBJECT}> ${OBJECT}_LIST = new ArrayList<>(Arrays.asList(${OBJECT}_ID));
    private static final ${OBJECT} ${OBJECT}_UPDATED = new ${OBJECT}(1, //fill me in boi);
    private static final ${OBJECT} ${OBJECT}_BAD_UPDATE = new ${OBJECT}(7, //fill me in boi);
    private static final String SUCCESS = "Success";
    private static final String FAIL = "Fail";
    
    private ObjectMapper mapper = new ObjectMapper();

    @Before
    public void setUpMock() { //might need to be changed to fit with jpa methods
        when(${SERVICE_OR_DAO}.save${OBJECT}(${OBJECT}_NO_ID)).thenReturn(${OBJECT}_ID);
        when(${SERVICE_OR_DAO}.get${OBJECT}(1)).thenReturn(${OBJECT}_ID);
        when(${SERVICE_OR_DAO}.getAll${OBJECT}s()).thenReturn(${OBJECT}_LIST);
        
        //success and failure messages sent from service layer if applicable
        //when(${SERVICE_OR_DAO}.update${OBJECT}(${OBJECT}_UPDATED)).thenReturn("Update: "+ SUCCESS);
        //when(${SERVICE_OR_DAO}.delete${OBJECT}(1)).thenReturn("Delete: " + SUCCESS);
        //when(${SERVICE_OR_DAO}.update${OBJECT}(${OBJECT}_BAD_UPDATE)).thenReturn("Update: "+ FAIL);
        //when(${SERVICE_OR_DAO}.delete${OBJECT}(1)).thenReturn("Delete: " + FAIL);
        
        //exceptions
        //when(${SERVICE_OR_DAO}.update${OBJECT}(${OBJECT}_BAD_UPDATE)).thenThrow(new ${EXCEPTION}("bad thing"));
        //when(${SERVICE_OR_DAO}.delete${OBJECT}(7)).thenThrow(new ${EXCEPTION}("bad thing"));        
    }
    
    @Test
    public void save${OBJECT}() throws Exception{
        String input_json = mapper.writeValueAsString(${OBJECT}_NO_ID);
        String output_json = mapper.writeValueAsString(${OBJECT}_ID);
        
        mvc.perform(post("/${ENDPOINT}")
            .content(input_json)
            .contentType(MediaType.APPLICATION_JSON)
        )
            .andDo(print())
            .andExpect(status().isCreated())
            .andExpect(content().json(output_json));
    }

    @Test
    public void get${OBJECT}() throws Exception{
        String output_json = mapper.writeValueAsString(${OBJECT}_ID);
        
        mvc.perform(get("/${ENDPOINT}/{id}", 1))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json(output_json));
    }
    
    @Test
    public void getAll${OBJECT}s() throws Exception{
        String output_json = mapper.writeValueAsString(${OBJECT}_LIST);
        
        mvc.perform(get("/${ENDPOINT}"))
            .andDo(print())
            .andExpect(status().isOk())
            .andExpect(content().json(output_json));
    }

    @Test
    public void update${OBJECT}() throws Exception {
        String input_json = mapper.writeValueAsString(${OBJECT}_UPDATED);
        
        mvc.perform(put("/${ENDPOINT}")
                .content(input_json)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isOk());
      
        //for things with random or json parsing errors
        //.andExpect(jsonPath("$.id").value("" + REAL_LOCATION.getId()))
        //.andExpect(jsonPath("$.description").value(REAL_LOCATION.getDescription()))
        //.andExpect(jsonPath("$.location").value(REAL_LOCATION.getLocation()));
    }

    @Test
    public void delete${OBJECT}() throws Exception {
        mvc.perform(delete("/${ENDPOINT}/{id}", 1))
                .andDo(print())
                .andExpect(status().isNoContent());
    }

    //exception test
    /*
    @Test
    public void exceptionTest() throws ${EXCEPTION} throws Exception {
        String input_json = mapper.writeValueAsString(${OBJECT}_BAD_UPDATE);
        mvc.perform(put("/${ENDPOINT}")
                .content(input_json)
                .contentType(MediaType.APPLICATION_JSON)
        )
                .andDo(print())
                .andExpect(status().isUnprocessableEntity()) //or whatever status code you set your exception to be, this is a default value
                .andExpect(content().string(containsString("bad thing")));
    }
    */
}
