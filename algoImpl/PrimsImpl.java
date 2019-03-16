package algoImpl;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

import algoImpl.UndirectedGraph.Edge;
import algoImpl.UndirectedGraph.Vertex;

public class PrimsImpl {

	private static Map<Integer,Vertex> result = new HashMap<>();
	
	static class VertexComparator implements Comparator<Vertex> {

		public int compare(Vertex s1, Vertex s2) {
			if (s1.getWeight() < s2.getWeight())
				return -1;
			else if (s1.getWeight() > s2.getWeight())
				return 1;
			return 0;
		}
	}

	

	public static void primsExecution(Vertex r) {
		 
		Queue<Vertex> pq = new PriorityQueue<>(new VertexComparator());
		
		 for (Vertex u : UndirectedGraph.vertexCollection) {
			if (u.getKey() != r.getKey()) {
				u.setWeight(Integer.MAX_VALUE);
			} else {
				u.setWeight(0);
			}
			pq.add(u);
		}

		while (!pq.isEmpty()) {

			Vertex u = pq.poll();
			
			for(Edge v : UndirectedGraph.vertexMap.get(u.getKey())) {
				
				if(pq.contains(UndirectedGraph.vertexCollection[v.destination])  && v.weight < UndirectedGraph.vertexCollection[v.destination].getWeight()) {
					
					Vertex o = UndirectedGraph.vertexCollection[v.destination];
					o.setWeight(v.weight);
					o.setParent(UndirectedGraph.vertexCollection[v.source]);
					
					pq.remove(UndirectedGraph.vertexCollection[v.destination]);
					
					pq.add(o);
					
					result.put(v.destination, o);
					
				}
				
			}
			
		}
		
		for (Map.Entry<Integer,Vertex> rs: result.entrySet()) {
			
			System.out.println("Destination : " + rs.getValue().getKey() + " Source : "+rs.getValue().getParent().getKey() + "Weight :"+rs.getValue().getWeight());
		}

	}

	public static void main(String[] args) {

		UndirectedGraph undirectedGrpah = new UndirectedGraph(5);

		Vertex vertex1 = new Vertex(0);
		vertex1.addEdge(0, 1, 2);
		vertex1.addEdge(0, 3, 6);

		Vertex vertex2 = new Vertex(1);
		vertex2.addEdge(1, 2, 3);
		vertex2.addEdge(1, 3, 8);
		vertex2.addEdge(1, 4, 5);

		Vertex vertex3 = new Vertex(2);
		vertex3.addEdge(2, 1, 3);
		vertex3.addEdge(2, 4, 7);

		Vertex vertex4 = new Vertex(3);
		vertex4.addEdge(3, 0, 6);
		vertex4.addEdge(3, 1, 8);
		vertex4.addEdge(3, 4, 9);
		
		Vertex vertex5 = new Vertex(4);
		vertex5.addEdge(4, 3, 9);
		vertex5.addEdge(4, 2, 7);
		vertex5.addEdge(4, 1, 5);

		System.out.println("Vertex Map Size : " + UndirectedGraph.vertexMap.size());
		System.out.println("Adjancey List Size : " + UndirectedGraph.adjancecyList.length);
		
		primsExecution(vertex1);
		
		System.out.println("Result Size : "+result);
	}
}