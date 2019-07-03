package overLoading;

class A {
	
	public int test(int i) {
		System.out.println("iiiiiiiiiii");
		return i;
	}
	
}

public class OverloadedMethod extends A {
	
	public float test(float f) {
		System.out.println("fffffffffffffi");
		return f;
	}
	
	
	public static void main(String[] args) {
		OverloadedMethod obj = new OverloadedMethod();
		obj.test(1f);
	}
}