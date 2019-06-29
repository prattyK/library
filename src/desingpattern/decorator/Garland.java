package desingpattern.decorator;

public class Garland extends TreeDecorator {

	private ChrismasTree tree;

	public Garland(ChrismasTree tree) {
		super(tree);
//		this.tree = tree;
	}

	@Override
	public String decorate() {
		return super.decorate() + "with Garland" ;
	}
	
}
