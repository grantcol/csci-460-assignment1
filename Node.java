import java.util.ArrayList;
import java.util.List;


public class Node {
	
	public String name;
	public List<Edge> edges = new ArrayList<Edge>();
	
	public Node(String name, List<Edge> edges) {
		this.name = name;
		this.edges = edges;
	}
	
	public Node(String name) {
		this.name = name;
	}
	
	public void setEdges(List<Edge> edges) {
		this.edges = edges;
	}
	
	public void addEdge(Edge e) {
		System.out.println("added edge from "+e.start+" to "+e.end+" of distance "+e.distance);
		this.edges.add(e);
	}
	
	public int numEdges() {
		return edges.size();
	}
	
	public String toString() {
		return this.name;
	}
	
	public void print() {
		System.out.println("NAME: "+this.name);
		System.out.print("EDGES: ");
		for(Edge e : edges) {
			System.out.print("{"+e.end.name+" DISTANCE: "+e.distance+"}, ");
		}
		System.out.println(" total: "+numEdges());
	}
}
