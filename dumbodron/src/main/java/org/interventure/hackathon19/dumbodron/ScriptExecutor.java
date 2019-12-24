package org.interventure.hackathon19.dumbodron;

import hu.atig.dji.tello.model.TelloFlip;
import hu.atig.dji.tello.world.DumboTelloWorldImpl;
import hu.atig.dji.tello.world.TelloWorld;
import org.springframework.stereotype.Service;

import static com.sun.tools.javac.code.Flags.BLOCK;

/**
 * @author <a href="mailto:slavisa.avramovic@escriba.de">avramovics</a>
 * @since 2019-12-24
 */
@Service
public class ScriptExecutor {

  private static final int BLOCK_SCALE = 13;

  public void execute(Script script) {

    System.out.println(script);

    TelloWorld telloWorld = new DumboTelloWorldImpl();
    try {
      telloWorld.connect();
      telloWorld.enterCommandMode();
      telloWorld.takeOff();

      for (Block block : script.getBlocks()) {
        if (block.getName().equalsIgnoreCase("forward")) {
          telloWorld.forward(block.getArg().getValue() * BLOCK_SCALE);
        }
        if (block.getName().equalsIgnoreCase("hop")) {
          telloWorld.doFlip(TelloFlip.forward);
        }
        if (block.getName().equalsIgnoreCase("up")) {
          telloWorld.up(block.getArg().getValue() * BLOCK_SCALE);
        }
        if (block.getName().equalsIgnoreCase("down")) {
          telloWorld.down(block.getArg().getValue() * BLOCK_SCALE);
        }
      }

    } finally {
      telloWorld.land();
    }
  }
}
