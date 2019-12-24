package org.interventure.hackathon19.dumbodron;

import static java.lang.Thread.sleep;

import hu.atig.dji.tello.model.TelloFlip;
import hu.atig.dji.tello.world.TelloWorld;
import hu.atig.dji.tello.world.TelloWorldImpl;
import org.springframework.stereotype.Service;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2019-12-24
 */
@Service
public class ScriptExecutor {

  public void execute(Script script) {
    TelloWorld telloWorld = new TelloWorldImpl();

    telloWorld.connect();
    telloWorld.enterCommandMode();

    telloWorld.takeOff();
    telloWorld.doFlip(TelloFlip.back);

    try {
      sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    telloWorld.land();

    System.out.println("yeah");
  }
}
