package algoImpl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class BFS {

	private List<Integer> adjacent[];
	private boolean visited[];
	private List<Integer> result = new ArrayList<>();

	public BFS(int vertices) {

		adjacent = new LinkedList[vertices];
		visited = new boolean[vertices];

		for (int i = 0; i < vertices; i++) {
			adjacent[i] = new LinkedList<>();
		}
	}
	

	public void addEdge(int v, int e) {
		adjacent[v].add(e);
	}

	public void search(int s) {

		LinkedList<Integer> queue = new LinkedList<>();

		visited[s] = true;

		queue.add(s);

		result.add(s);
		
		while (!queue.isEmpty()) {

			int input = queue.poll();

			Iterator<Integer> it = adjacent[input].listIterator();

			while (it.hasNext()) {
				int i = (int) it.next();

				if (!visited[i]) {
					visited[i] = true;
					queue.add(i);
					result.add(i);
				}

			}

		}
		System.out.println("Result Size : "+result);

	}

	public static void main(String[] args) {

		BFS bfs = new BFS(4);
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 0);
		bfs.addEdge(2, 3);
		bfs.addEdge(3, 3);

		bfs.search(0);
	}

}
