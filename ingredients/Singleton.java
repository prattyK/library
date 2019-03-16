package ingredients;

import java.io.Serializable;

public class Singleton implements Serializable, Cloneable {

	private static final long serialVersionUID = -952259152467124273L;
	private static volatile Singleton sol;

	public static Singleton getInstance() {

		if (sol == null) {

			synchronized (Singleton.class) {

				if (sol == null) {

					sol = new Singleton();

				}
			}

		}

		return sol;
	}

	protected Object readResolve() {
		return sol;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}
