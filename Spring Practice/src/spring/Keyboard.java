package spring;

public class Keyboard {

	private int value;
	private String colour;

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public String getColour() {
		return colour;
	}

	public void setColour(String colour) {
		this.colour = colour;
	}

	public Keyboard(int value, String colour) {
		super();
		this.value = value;
		this.colour = colour;
	}

	public Keyboard() {
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public String toString() {
		return "Keyboard [value=" + value + ", colour=" + colour + "]";
	}
	

}
