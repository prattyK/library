package desingpattern.decorator;

public class BubbleLights extends TreeDecorator {


	public BubbleLights(ChrismasTree tree) {
		super(tree);
	}

	@Override
	public String decorate() {
		return super.decorate() + decorateWithBubbleLights();
	}

	private String decorateWithBubbleLights() {
		return " with Bubble Lights ";
	}

}
