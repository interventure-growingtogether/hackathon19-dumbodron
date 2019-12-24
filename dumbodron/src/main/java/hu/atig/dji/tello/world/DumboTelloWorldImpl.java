package hu.atig.dji.tello.world;

import java.util.logging.Logger;

import hu.atig.dji.tello.model.command.BasicTelloCommand;
import hu.atig.dji.tello.model.command.TelloCommand;
import hu.atig.dji.tello.model.command.TelloCommandValues;

public class DumboTelloWorldImpl extends TelloWorldImpl {

	private static final Logger logger = Logger.getLogger(DumboTelloWorldImpl.class.getName());

	public DumboTelloWorldImpl() {
		super();
	}

	@Override
	public void forward(Integer distance) {
		TelloCommand command = new BasicTelloCommand(TelloCommandValues.FORWARD + " " + distance);
		boolean executionSuccessful = getTelloCommunication().executeCommand(command);
		if (executionSuccessful) {
			logger.info("Forward command was executed successfully");
		}
	}

	@Override
	public void backward(Integer distance) {
		TelloCommand command = new BasicTelloCommand(TelloCommandValues.BACK + " " + distance);
		boolean executionSuccessful = getTelloCommunication().executeCommand(command);
		if (executionSuccessful) {
			logger.info("Back command was executed successfully");
		}
	}

	@Override
	public void right(Integer distance) {
		TelloCommand command = new BasicTelloCommand(TelloCommandValues.RIGHT + " " + distance);
		boolean executionSuccessful = getTelloCommunication().executeCommand(command);
		if (executionSuccessful) {
			logger.info("Right command was executed successfully");
		}
	}

	@Override
	public void left(Integer distance) {
		TelloCommand command = new BasicTelloCommand(TelloCommandValues.LEFT + " " + distance);
		boolean executionSuccessful = getTelloCommunication().executeCommand(command);
		if (executionSuccessful) {
			logger.info("Left command was executed successfully");
		}
	}

	@Override
	public void rotatateRight(Integer angle) {
		TelloCommand command = new BasicTelloCommand(TelloCommandValues.CW + " " + angle);
		boolean executionSuccessful = getTelloCommunication().executeCommand(command);
		if (executionSuccessful) {
			logger.info("Rotate right command was executed successfully");
		}
	}

	@Override
	public void rotateLeft(Integer angle) {
		TelloCommand command = new BasicTelloCommand(TelloCommandValues.CCW + " " + angle);
		boolean executionSuccessful = getTelloCommunication().executeCommand(command);
		if (executionSuccessful) {
			logger.info("Rotate left command was executed successfully");
		}
	}

}
