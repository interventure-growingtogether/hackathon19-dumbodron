package hu.atig.dji.tello.world;

import java.util.logging.Logger;

import hu.atig.dji.tello.model.command.BasicTelloCommand;
import hu.atig.dji.tello.model.command.TelloCommand;

public class DumboTelloWorldImpl extends TelloWorldImpl {

	private static final Logger logger = Logger.getLogger(DumboTelloWorldImpl.class.getName());

	public DumboTelloWorldImpl() {
		super();
	}

	@Override
	public void forward(Integer distance) {
		TelloCommand command = new BasicTelloCommand("forward " + distance);
		boolean executionSuccessful = getTelloCommunication().executeCommand(command);
		if (executionSuccessful) {
			logger.info("Forward command was executed successfully");
		}
	}

}
