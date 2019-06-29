package trees;
import java.util.HashMap;

public class Main {

  static HashMap<Integer, Integer> cache = new HashMap<Integer, Integer>();

  private int fib(int N) {
    if (cache.containsKey(N)) {
      return cache.get(N);
    }
    int result;
    if (N < 2) {
      result = N;
    } else {
      result = fib(N-1) + fib(N-2);
    }
    // keep the result in cache.
    cache.put(N, result);
    return result;
  }
  
  public static void main(String...ar) {
	  new Main().fib(4);
	  System.out.println(cache);
  }
}