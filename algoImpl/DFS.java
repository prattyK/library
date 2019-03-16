package algoImpl;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class DFS {

	private int v;
	private List<Integer> adj[];
	private boolean visited[];

	public DFS(int v) {

		adj = new LinkedList[v];
		visited = new boolean[v];
		for (int i = 0; i < v; i++) {
			adj[i] = new LinkedList<>();
//			visited[i] = false;
		}
	}

	public void addEdge(int v, int w) {
		adj[v].add(w);
	}

	public void search(int s) {

		visited[s] = true;

		System.out.println(s + " ");

		Iterator<Integer> it = adj[s].listIterator();

		while (it.hasNext()) {

			int n = it.next();
			
			if (!visited[n]) {

				search(n);
			}

		}

	}

	public static void main(String[] args) {

		DFS df = new DFS(4);

		df.addEdge(0, 1);
		df.addEdge(0, 2);
		df.addEdge(1, 2);
		df.addEdge(2, 0);
		df.addEdge(2, 3);
		df.addEdge(3, 3);

		df.search(2);
		
	}

}
