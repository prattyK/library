package algoImpl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UndirectedGraph {

	private int noOfVertex;
	public static List<Edge> adjancecyList[];
	public static Map<Integer,List<Edge>> vertexMap = new HashMap<>();
	public static Vertex vertexCollection[] ;
	

	public UndirectedGraph(int noOfVertex) {
		this.noOfVertex = noOfVertex;
		adjancecyList = new List[noOfVertex];
		vertexCollection = new Vertex[noOfVertex];
	
		for (int i = 0; i < noOfVertex; i++) {
			adjancecyList[i] = new ArrayList<>();
			vertexCollection[i] = new Vertex(i);
	
		}
	}

	static class Vertex {

		private int key;
		private int weight;
		private Vertex parent;
		
		public  Vertex(int key) {
          this.key = key;			
		}
		
		public void addEdge(int src, int des, int weight) {
			Edge edge = new Edge(src, des, weight);
			adjancecyList[src].add(edge);
			Edge edge1 = new Edge(des, src, weight);
			adjancecyList[des].add(edge1);
			vertexMap.put(src, adjancecyList[src]);
			vertexMap.put(des, adjancecyList[des]);
		}

		public int getWeight() {
			return weight;
		}

	

		public Vertex getParent() {
			return parent;
		}

		public void setParent(Vertex parent) {
			this.parent = parent;
		}

		public void setWeight(int weight) {
			this.weight = weight;
		}

		public int getKey() {
			return key;
		}

		public void setKey(int key) {
			this.key = key;
		}
		
		
		
		
	}

	static class Edge {
		int source;
		int destination;
		int weight;

		public Edge(int source, int destination, int weight) {
			this.source = source;
			this.destination = destination;
			this.weight = weight;
		}
	}
}
