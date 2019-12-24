package org.interventure.hackathon19.dumbodron;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.junit.runner.Runner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2019-12-24
 */
@RunWith(Runner.class)
@WebMvcTest(DronController.class)
class DronControllerTest {

  @MockBean
  private ScriptExecutor scriptExecutor;

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper mapper;

  @Test
  void postScript() throws Exception {
    Script script = new Script();
    Block block = new Block();
    block.setName("takeoff");
    ArrayList blocks = new ArrayList();
    blocks.add(block);
    script.setBlocks(blocks);
    Block land = new Block();
    land.setName("land");
    blocks.add(land);
    String content = mapper.writeValueAsString(script);
    RequestBuilder request = MockMvcRequestBuilders
        .post("/tello/execute")
        .accept(MediaType.APPLICATION_JSON)
        .content("{\"blocks\":[{\"name\":\"takeoff\"},{\"name\":\"land\"}]}")
        .contentType(MediaType.APPLICATION_JSON);
    System.out.println(content);

    MvcResult result = mockMvc.perform(request)
                .andExpect(status().isOk()).andReturn();

  }
}
