package algoImpl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import algoImpl.DirectedGraph.Edge;
import algoImpl.DirectedGraph.Vertex;

public class Dijkstra {

	static class VertexCompartor implements Comparator<Vertex> {

		@Override
		public int compare(Vertex s1, Vertex s2) {
			if (s1.getWeight() < s2.getWeight())
				return -1;
			else if (s1.getWeight() > s2.getWeight())
				return 1;
			return 0;
		}

	}

	static PriorityQueue<Vertex> pq = new PriorityQueue<>(new VertexCompartor());

	public static void dijkstraExecution(Vertex source) {

		DirectedGraph.initializeSource(source, pq);
		Map<Integer, Vertex> result = new HashMap<>();

		while (!pq.isEmpty()) {
			Vertex u = pq.poll();
			result.put(u.getKey(), u);
			if (null != DirectedGraph.vertexMap.get(u.getKey()) && !DirectedGraph.vertexMap.get(u.getKey()).isEmpty()) {
				for (Edge v : DirectedGraph.vertexMap.get(u.getKey())) {
					relaxNode(v,DirectedGraph.vertexCollection[v.destination], u, v.weight);
				}
			}
		}

		for (Map.Entry<Integer, Vertex> rs : result.entrySet()) {
			System.out.println("Destination : " + rs.getValue().getKey() + " Source : "
					+ rs.getValue().getParent().getKey() + "Weight :" + rs.getValue().getWeight());
		}
	}

	public static void relaxNode(Edge v ,Vertex des, Vertex src, int weight) {
		int combWeight = src.getWeight() + weight;
		if (des.getWeight() > combWeight) {
			des.setWeight(combWeight);
			des.setParent(src);
			pq.remove(DirectedGraph.vertexCollection[v.destination]);
			pq.add(des);
		}
	}

	public static void main(String[] args) {

		new DirectedGraph(5);

		Vertex vertex1 = new Vertex(0);
		vertex1.addEdge(0, 1, 2);
		vertex1.addEdge(0, 3, 6);

		Vertex vertex2 = new Vertex(1);
		vertex2.addEdge(1, 2, 3);
		vertex2.addEdge(1, 3, 8);
		vertex2.addEdge(1, 4, 5);

		Vertex vertex3 = new Vertex(2);
		vertex3.addEdge(2, 4, 7);

		Vertex vertex4 = new Vertex(3);
		vertex4.addEdge(3, 4, 9);

		// Vertex vertex5 = new Vertex(4);
		// vertex5.addEdge(4, 3, 9);
		// vertex5.addEdge(4, 2, 7);
		// vertex5.addEdge(4, 1, 5);

		System.out.println("Vertex Map Size : " + DirectedGraph.vertexMap.size());
		System.out.println("Adjancey List Size : " + DirectedGraph.adjancecyList.length);

		dijkstraExecution(vertex1);

	}

}
