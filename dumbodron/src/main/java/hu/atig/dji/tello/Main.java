package hu.atig.dji.tello;

import static java.lang.Thread.sleep;

import java.util.logging.Logger;

import hu.atig.dji.tello.model.TelloFlip;
import hu.atig.dji.tello.world.DumboTelloWorldImpl;

public class Main {

	private static final Logger logger = Logger.getLogger(Main.class.getName());
	
  public static void main(String[] args) {
	DumboTelloWorldImpl telloWorld = new DumboTelloWorldImpl();
	
    telloWorld.connect();
    telloWorld.enterCommandMode();
    logger.info("Default speed is: " + telloWorld.getSpeed());
    
    //telloWorld.setSpeed(10);
    
    telloWorld.takeOff();
    telloWorld.forward(55);
    telloWorld.backward(55);
    telloWorld.left(55);
    telloWorld.right(55);
    telloWorld.rotatateRight(90);
    telloWorld.rotateLeft(90);
    telloWorld.doFlip(TelloFlip.forward);

    try {
      sleep(2000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    telloWorld.land();

  }

}
