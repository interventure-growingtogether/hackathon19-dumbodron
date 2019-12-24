package hu.atig.dji.tello.model;

public enum TelloFlip {

	left("l"), right("r"), forward("f"), back("b");

	private String direction;
	
	private TelloFlip(String direction) {
		this.direction = direction;
	}

	public String getDirection() {
		return this.direction;
	}
}
