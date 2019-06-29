package desingpattern.decorator;

public abstract class TreeDecorator implements ChrismasTree {

	private ChrismasTree tree;
	
	
	 public TreeDecorator(ChrismasTree tree) {
		this.tree = tree;
	}


	@Override
	    public String decorate() {
	        return tree.decorate();
	    }
	
}
