package desingpattern.decorator;

public class DecoratorDPDriver {

	public static void main(String[] args) {
     
		ChrismasTree tree = new BubbleLights(new Garland(new ChrismasTreeImpl()));
		
//		ChrismasTree tree = new Garland(tree)
		System.out.println(tree.decorate());
		
	}

}
