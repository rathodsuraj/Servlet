package spring;

public class Monitor {

	private String name;
	private int value;
	private Keyboard keyboard;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Keyboard getKeyboard() {
		return keyboard;
	}

	public void setKeyboard(Keyboard keyboard) {
		this.keyboard = keyboard;
	}

	public Monitor(String name, int value, Keyboard keyboard) {
		super();
		this.name = name;
		this.value = value;
		this.keyboard = keyboard;
	}
	public Monitor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Monitor [name=" + name + ", value=" + value + ", keyboard=" + keyboard + "]";
	}

	
	
}
