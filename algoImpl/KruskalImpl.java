package algoImpl;

import java.util.Arrays;

public class KruskalImpl {

	private int V;
	private int E;
	private Edge[] edges;

	class Edge implements Comparable<Edge> {

		int src, dest, weight = 0;

		@Override
		public int compareTo(Edge o) {
			return this.weight - o.weight;
		}
	}

	class SubSet {

		int rank, parent;
	}

	public KruskalImpl(int v, int e) {
		V = v;
		E = e;

		edges = new Edge[E];

		for (int i = 0; i < e; i++) {
			edges[i] = new Edge();
		}
	}

	private int find(SubSet subsets[], int i) {
		if (subsets[i].parent != i)
			subsets[i].parent = find(subsets, subsets[i].parent);
		return subsets[i].parent;
	}

	private void union(SubSet subset[], int x, int y) {

		int xroot = find(subset, x);
		int yroot = find(subset, y);

		if (subset[xroot].rank < subset[yroot].rank) {

			subset[xroot].parent = yroot;

		} else if (subset[xroot].rank < subset[yroot].rank) {

			subset[yroot].parent = xroot;
		} else {

			subset[yroot].parent = xroot;
			subset[xroot].rank++;
		}

	}

	private void krushKalMST() {

		Edge result[] = new Edge[V];
		int e = 0;
		
		Arrays.sort(edges);

		SubSet subsets[] = new SubSet[V];
		for (int i = 0; i < V; i++) {

			result[i] = new Edge();
			subsets[i] = new SubSet();
			subsets[i].parent = i;
			subsets[i].rank = 0;

		}

		int k = 0;

		while (e < V - 1) {

			Edge next_Edge = new Edge();
			next_Edge = edges[k++];

			int x = find(subsets, next_Edge.src);
			int y = find(subsets, next_Edge.dest);

			if (x != y) {

				result[e++] = next_Edge;
				union(subsets, x, y);

			}

		}

		for (int i = 0; i < e; ++i)
			System.out.println(result[i].src + " -- " + result[i].dest + " == " + result[i].weight);

	}

	public static void main(String[] args) {
		
		 int V = 4;  // Number of vertices in graph
	        int E = 5;  // Number of edges in graph
	        KruskalImpl graph = new KruskalImpl(V, E);
	 
	        // add edge 0-1
	        graph.edges[0].src = 0;
	        graph.edges[0].dest = 1;
	        graph.edges[0].weight = 10;
	 
	        // add edge 0-2
	        graph.edges[1].src = 0;
	        graph.edges[1].dest = 2;
	        graph.edges[1].weight = 6;
	 
	        // add edge 0-3
	        graph.edges[2].src = 0;
	        graph.edges[2].dest = 3;
	        graph.edges[2].weight = 5;
	 
	        // add edge 1-3
	        graph.edges[3].src = 1;
	        graph.edges[3].dest = 3;
	        graph.edges[3].weight = 15;
	 
	        // add edge 2-3
	        graph.edges[4].src = 2;
	        graph.edges[4].dest = 3;
	        graph.edges[4].weight = 4;
	 
	        graph.krushKalMST();

	}

}
