package classDemos;
import java.util.ArrayList;

public class ClientGraph {

	public static void main(String[] args) {
		Graph g = new Graph();
		
		g.addVertex("A");
		g.addVertex("B");
		g.addVertex("C");
		g.addVertex("D");
		g.addVertex("E");
		g.addVertex("F");
		g.addVertex("G");
	//	g.addVertex("H");
	//	g.addVertex("I");
		
		g.addEdge("A", "B");
		g.addEdge("B", "C");
		g.addEdge("C", "D");
		g.addEdge("D", "E");
		g.addEdge("E", "F");
	//	g.addEdge("F", "G");
		//g.addEdge("A", "D");
		g.addEdge("G", "E");
	//	g.addEdge("H", "I");
	//	g.addEdge("E", "H");
		System.out.println(g);
		System.out.println(g.hasPathFromTo("A", "F"));
		
		g.bfsTraversal();
		g.dfsTraversal();
		System.out.println(g.getConnectedComponents());
	//	System.out.println(g.isBipartite());
		System.out.println(g.isAcyclic());
		//System.out.println(g.isConnected());
	}

}
