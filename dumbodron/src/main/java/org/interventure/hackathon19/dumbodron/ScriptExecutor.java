package org.interventure.hackathon19.dumbodron;

import hu.atig.dji.tello.model.TelloFlip;
import hu.atig.dji.tello.world.DumboTelloWorldImpl;
import hu.atig.dji.tello.world.TelloWorld;
import org.springframework.stereotype.Service;

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
      telloWorld.setSpeed(50);
      telloWorld.down(60);

      for (Block block : script.getBlocks()) {
        if (block.getName().equalsIgnoreCase("forward")) {
          telloWorld.forward(block.getArg().getValue() * BLOCK_SCALE);
        }
        if (block.getName().equalsIgnoreCase("hop")) {
          telloWorld.doFlip(TelloFlip.forward);
        }
        if (block.getName().equalsIgnoreCase("back")) {
          telloWorld.backward(block.getArg().getValue() * BLOCK_SCALE);
        }
        if (block.getName().equalsIgnoreCase("right")) {
          telloWorld.rotatateRight(90);
        }
        if (block.getName().equalsIgnoreCase("left")) {
          telloWorld.rotateLeft(90);
        }
        if (block.getName().equalsIgnoreCase("up")) {
          telloWorld.up(block.getArg().getValue() * BLOCK_SCALE);
        }
        if (block.getName().equalsIgnoreCase("down")) {
          telloWorld.down(block.getArg().getValue() * BLOCK_SCALE);
        }
        if (block.getName().equalsIgnoreCase("shrink")) {
            telloWorld.left(block.getArg().getValue() * BLOCK_SCALE);
        }
        if (block.getName().equalsIgnoreCase("grow")) {
            telloWorld.right(block.getArg().getValue() * BLOCK_SCALE);
        }
      }

    } finally {
      telloWorld.land();
    }
  }
}
