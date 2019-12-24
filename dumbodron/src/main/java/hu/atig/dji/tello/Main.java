package hu.atig.dji.tello;

import static java.lang.Thread.sleep;

import hu.atig.dji.tello.model.TelloFlip;
import hu.atig.dji.tello.world.TelloWorld;
import hu.atig.dji.tello.world.TelloWorldImpl;

public class Main {

  public static void main(String[] args) {
    TelloWorld telloWorld = new TelloWorldImpl();

    telloWorld.connect();
    telloWorld.enterCommandMode();
    telloWorld.takeOff();
    telloWorld.doFlip(TelloFlip.backLeft);

    try {
      sleep(1000);
    } catch (InterruptedException e) {
      e.printStackTrace();
    }

    telloWorld.land(); 

  }

}
