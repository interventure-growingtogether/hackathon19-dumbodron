package org.interventure.hackathon19.dumbodron;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.core.io.ClassPathResource;
import org.springframework.web.client.RestTemplate;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2019-12-24
 */
@SpringBootTest
class DronExternalTest {


  @Autowired
  private RestTemplate restTemplate;

  @Autowired
  private ObjectMapper mapper;

  @Value("tello.json")
  ClassPathResource json;

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

    Script s = mapper.readValue(json.getURL(), Script.class);

    restTemplate.postForEntity("http://localhost:8080/tello/execute", s, String.class);
  }
}
