package org.interventure.hackathon19.dumbodron;

import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2019-12-24
 */
@RestController
@RequestMapping("/tello")
@CrossOrigin
public class DronController {

  private ScriptExecutor executor;

  public DronController(ScriptExecutor executor) {
    this.executor = executor;
  }

  @Bean
  public RestTemplate restTemplate() {
    return new RestTemplate();
  }

  @PostMapping("/execute")
  public void postScript(@RequestBody Script script) {
    this.executor.execute(script);
  }

}
