package classDemos;
import java.util.HashMap;
import java.util.Set;
import helperClasses.*;
import java.util.ArrayList;

public class Graph {

	private class Edge
	{
		Vertex one;
		Vertex two;
		
		Edge(Vertex one, Vertex two)
		{
			this.one = one;
			this.two = two;
		}
	}
	
	private class Vertex
	{
		String name;
		HashMap<Vertex, Edge> adjacentVertices;
		
		Vertex(String name)
		{
			this.name = name;
			this.adjacentVertices = new HashMap<Vertex,Edge>();
		}
		
		public void addEdge(Edge edge)
		{
			Vertex vtx = edge.one.equals(this) ? edge.two : edge.one;
			
			if(this.isAdjacentToVertex(vtx))
			{
				return; //Edge already exists
			}
			else
			{
				this.adjacentVertices.put(vtx, edge);
			}
		}
		
		public void removeEdge(Vertex vertex)
		{
			if(!this.isAdjacentToVertex(vertex))
			{	
				return;
			}
			else
			{
				this.adjacentVertices.remove(vertex);
			}
		}
		
		public boolean isAdjacentToVertex(Vertex other)
		{
			return this.adjacentVertices.containsKey(other);
		}
		
		public ArrayList<Vertex> getAdjacentVertices()
		{
			ArrayList<Vertex> al = new ArrayList<>();
			Set<Vertex> vertices = this.adjacentVertices.keySet();
			for(Vertex adg : vertices)
			{
				al.add(adg);
			}
			return al;
		}
		
		@Override
		public boolean equals(Object other)
		{
			if(other == null)
			{
				return false;
			}
			Vertex otherVertex = (Vertex)other;
			return this.name.equals(otherVertex.name);
		}
		
		@Override
		public int hashCode()
		{
			return name.hashCode();
		}
		
		public String toString() {
			String retVal = this.name + " => ";
			Set<Vertex> vertices = this.adjacentVertices.keySet();

			for (Vertex adjV : vertices) {
				retVal += adjV.name + ", ";
			}

			retVal += "END\n";

			return retVal;
		}
	}
	
	private ArrayList<Vertex> vertices;
	
	public Graph()
	{
		this.vertices = new ArrayList<Vertex>();
	}
	
	public int numVertices()
	{
		return this.vertices.size();
	}
	
	public void addVertex(String name)
	{
		if(containsVertex(name))
		{
			return;
		}
		else
		{
			Vertex vtx = new Vertex(name);
			this.vertices.add(vtx);
		}
	}
	
	public void removeVertex(String name)
	{
		if(!containsVertex(name))
		{
			return;
		}
		Vertex vtbr = getVertex(name); 
		for(Vertex adjVtx : vtbr.getAdjacentVertices())
		{
			adjVtx.removeEdge(vtbr);
		}
		this.vertices.remove(vtbr);
	}
	
	public boolean containsVertex(String name)
	{
		if(getVertex(name) ==  null)
		{
			return false;
		}
		else
		{
			return true; 
		}
	}
	
	private Vertex getVertex(String name)
	{
		Vertex retVal = null;
		for(Vertex vtx : vertices)
		{
			if(vtx.name.equals(name))
			{
				retVal = vtx;
				break;
			}
		}
		return retVal;
	}
	
	public int numEdges()
	{
		int retVal = 0;
		for(Vertex v : vertices)
		{
			retVal += v.adjacentVertices.size();
		}
		retVal = retVal/2;
		return retVal;
	}
	
	public void addEdge(String v1,String v2)
	{
		Vertex vtx1 = getVertex(v1);
		Vertex vtx2 = getVertex(v2);
		if(vtx1 == null || vtx2 == null || vtx1.isAdjacentToVertex(vtx2))
		{
			return; //v1 doesnot exist, v2 doesnot exist or there is already an edge between v1 and v2
		}
		else
		{
			Edge edge = new Edge(vtx1, vtx2);
			vtx1.addEdge(edge);
			vtx2.addEdge(edge);
		}
	}
	
	public void removeEdge(String v1, String v2)
	{
		Vertex vtx1 = getVertex(v1);
		Vertex vtx2 = getVertex(v2);
		if(vtx1 == null || vtx2 == null || !vtx1.isAdjacentToVertex(vtx2))
		{
			return; //v1 doesnot exist, v2 doesnot exist or there is not edge between v1 and v2 to remove
		}
		else
		{
			vtx1.removeEdge(vtx2);
			vtx2.removeEdge(vtx1);
		}
	}
	
	public boolean containsEdge(String v1, String v2)
	{
		Vertex vtx1 = getVertex(v1);
		Vertex vtx2 = getVertex(v2);
		if(vtx1 == null || vtx2 == null || !vtx1.isAdjacentToVertex(vtx2))
		{
			return false;
		}
		else
		{
			return true;
		}
		
	}
	
	public String toString()
	{
		String retVal = "";

		for (Vertex v : this.vertices) {
			retVal += v.toString();
		}

		return retVal;
	}

	//----------------------------------------QUESTIONS-----------------------------------------//
	
	//BFS Traversal
	public void bfsTraversal()
	{
		System.out.print("BFS Traversal : ");
		HashMap<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
		GenericQueue<Vertex> queue = new GenericQueue<>(numVertices());
		
		for(Vertex v : this.vertices)
		{
			if(!visited.containsKey(v))
			{
				visited.put(v, true);
				queue.enqueue(v);
				
				while(!queue.isEmpty())
				{
					Vertex deQueuedVertex = queue.dequeue();
					System.out.print(deQueuedVertex.name + " ");
					
					for(Vertex vtx : deQueuedVertex.getAdjacentVertices())
					{
						if(!visited.containsKey(vtx))
						{
							visited.put(vtx, true);
							queue.enqueue(vtx);
						}
					}
				}
			}
		}
		System.out.println(" END");
	}
	
	//DFS Traversal
	public void dfsTraversal()
	{
		System.out.print("DFS Traversal : ");
		HashMap<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
		GenericStack<Vertex> stack = new GenericStack<>(numVertices());
		
		for(Vertex v : this.vertices)
		{
			if(!visited.containsKey(v))
			{
				visited.put(v, true);
				stack.push(v);
				
				while(!stack.isEmpty())
				{
					Vertex poppedVertex = stack.pop();
					System.out.print(poppedVertex.name + " ");
					
					for(Vertex vtx : poppedVertex.getAdjacentVertices())
					{
						if(!visited.containsKey(vtx))
						{
							visited.put(vtx, true);
							stack.push(vtx);
						}
					}
				}
			}
		}
		System.out.println(" END");
	}
	
	//Has path from to
	public boolean hasPathFromTo(String v1, String v2)
	{
		Vertex vtx1 = getVertex(v1);
		Vertex vtx2 = getVertex(v2);
		if(vtx1 == null || vtx2 == null)
		{
			return false;
		}
		else
		{
			/*HashMap<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
			visited.put(vtx1, true);
		 	return hasPathFromTo_DFS(vtx1, vtx2, visited);*/
			
			return hasPathFromTo_BFS(vtx1, vtx2);
		}
		
	}
	private boolean hasPathFromTo_DFS(Vertex v1, Vertex v2, HashMap<Vertex, Boolean> visited)
	{
		if(v1.isAdjacentToVertex(v2))
		{
			return true;
		}
		for(Vertex adjVtx : v1.getAdjacentVertices())
		{
			if(!visited.containsKey(adjVtx))
			{
				visited.put(adjVtx, true);
				if(hasPathFromTo_DFS(adjVtx, v2, visited))
				{
					return true;
				}
			}
		}
		return false;
	}
	private boolean hasPathFromTo_BFS(Vertex v1, Vertex v2)
	{
		HashMap<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
		GenericQueue<Vertex> queue = new GenericQueue<Vertex>(this.numVertices());
		
		visited.put(v1, true);
		queue.enqueue(v1);
		
		while(!queue.isEmpty())
		{
			Vertex dequeuedVertex = queue.dequeue();
			if(dequeuedVertex.isAdjacentToVertex(v2))
			{
				return true;
			}
			else
			{
				for(Vertex adjV : dequeuedVertex.getAdjacentVertices())
				{
					if(!visited.containsKey(adjV))
					{ 
						visited.put(adjV, true);
						queue.enqueue(adjV);
					}
				}
			}
		}
		return false;
	}
 
	//Get all connected components
	public ArrayList<ArrayList<String>> getConnectedComponents()
	{
		ArrayList<ArrayList<String>> retVal = new ArrayList<ArrayList<String>>();
		HashMap<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
		GenericQueue<Vertex> queue = new GenericQueue<Vertex>(numVertices());
		
		for(Vertex v : vertices)
		{
			
			if(!visited.containsKey(v))
			{
				visited.put(v,true);
				queue.enqueue(v);
				ArrayList<String> al = new ArrayList<String>();
				while(!queue.isEmpty())
				{
					Vertex dequeuedVertex = queue.dequeue();
					al.add(dequeuedVertex.name);
					for(Vertex vtx : dequeuedVertex.getAdjacentVertices())
					{
						if(!visited.containsKey(vtx))
						{
							visited.put(vtx, true);
							queue.enqueue(vtx);
						}
					}
					
				}
				retVal.add(al);
			}
		}
		return retVal;
	}
	
	//Check if graph is connected
	public boolean isConnected()
	{
		HashMap<Vertex, Boolean> visited = new HashMap<Vertex, Boolean>();
		GenericQueue<Vertex> queue = new GenericQueue<Vertex>(numVertices());
		visited.put(vertices.get(0), true);
		queue.enqueue(vertices.get(0));
		
		while(!queue.isEmpty())
		{
			Vertex deQueuedVertex = queue.dequeue();
			for(Vertex vtx : deQueuedVertex.getAdjacentVertices())
			{
				if(!visited.containsKey(vtx))
				{
					visited.put(vtx, true);
					queue.enqueue(vtx);
				}
			}
		}
		
		return visited.size() == numVertices();
	}
	
	//Acyclic
	public boolean isAcyclic()
	{
		HashMap<Vertex, Vertex> visited = new HashMap<Vertex, Vertex>();
		GenericStack<Vertex> stack = new GenericStack<>(numVertices());
		
		for(Vertex v : this.vertices)
		{
			if(!visited.containsKey(v))
			{
				visited.put(v, null);
				stack.push(v);
				
				while(!stack.isEmpty())
				{
					Vertex poppedVertex = stack.pop();
					
					for(Vertex vtx : poppedVertex.getAdjacentVertices())
					{
						if(!visited.containsKey(vtx))
						{
							visited.put(vtx, poppedVertex);
							stack.push(vtx);
						}
						else
						{
							Vertex reasonForVisitingVtx = visited.get(poppedVertex);
							if(reasonForVisitingVtx != vtx)
							{
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
	
	//Bipartite
	public boolean isBipartite()
	{
		HashMap<Vertex, String> visited = new HashMap<Vertex, String>();
		GenericStack<Vertex> stack = new GenericStack<>(numVertices());
		
		for(Vertex v : this.vertices)
		{
			if(!visited.containsKey(v))
			{
				visited.put(v, "Red");
				stack.push(v);
				
				while(!stack.isEmpty())
				{
					Vertex poppedVertex = stack.pop();
					
					for(Vertex vtx : poppedVertex.getAdjacentVertices())
					{
						String colorToApply = visited.get(poppedVertex).equals("Red") ? "Green" : "Red";
						if(!visited.containsKey(vtx))
						{
							visited.put(vtx, colorToApply);
							stack.push(vtx);
						}
						else
						{
							String existingColor = visited.get(vtx);
							if(!existingColor.equals(colorToApply))
							{
								return false;
							}
						}
					}
				}
			}
		}
		return true;
	}
}
