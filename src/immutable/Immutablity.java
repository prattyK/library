package immutable;

class Immutable {
	private final int value;

	public Immutable(int value) {
		this.value = value;
	}

	public int getValue() {
		return value;
	}
}

public class Immutablity extends Immutable {
	private int realValue;

	public Immutablity(int value) {
		super(value);

		realValue = value;
	}

	public int getValue() {
		return realValue;
	}

	public void setValue(int newValue) {
		realValue = newValue;
	}

	public static void main(String[] arg) {
		Immutablity obj = new Immutablity(4);
		Immutablity immObj = (Immutablity) obj;
		System.out.println(immObj.getValue());
		obj.setValue(8);
		System.out.println(immObj.getValue());
	}
}
