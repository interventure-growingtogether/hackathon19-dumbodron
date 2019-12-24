package org.interventure.hackathon19.dumbodron;

import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2019-12-24
 */
@Service
public class ScriptExecutor {

  public void execute(Script script) {
    System.out.println("yeah");
    System.out.println(script);
  }
}
