import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GraphConstructor {
	public String path;
	public SearchSpace ss = new SearchSpace();
	public List<Node> nodes = new ArrayList<Node>();
	public List<Edge> edges = new ArrayList<Edge>();
	
	public GraphConstructor (String filePath) {
		this.path = filePath;
	}
	
	public SearchSpace generateGraph() throws IOException {
		List<String> lines = new ArrayList<String>();
		BufferedReader reader = new BufferedReader(new FileReader(path));
		String line = null;
		while ((line = reader.readLine()) != null) {
		    lines.add(line);
		}
		
		for(String s : lines) {
			//create the nodes here by parsing the lines and getting the right data
			String[] p1 = s.split("-");
			String[] p2 = p1[1].split(":");
			Node start = new Node(p1[0]);
			Node end = new Node(p2[0]);
			int distance = Integer.parseInt(p2[1]);
			Edge e = new Edge(start, end, distance);
			edges.add(e);
			start.addEdge(e);
			if(!ss.contains(start.name)) {
				ss.addNode(start);
			} else {
				ss.getNode(start.name).addEdge(e);
			}
			if(!ss.contains(end.name))
				ss.addNode(end);
		}
		return ss;
	}
}
