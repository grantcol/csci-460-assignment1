import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class GraphConstructor {
	public String path;
	public SearchGraph sg = new SearchGraph();
	public List<Node> nodes = new ArrayList<Node>();

	public GraphConstructor (String filePath) {
		this.path = filePath;
	}

	public SearchGraph generateGraph() throws IOException {
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
			int cost = Integer.parseInt(p2[1]);
			addNode(start);
			addNode(end);
			getNode(start).addSuccessor(getNode(end), cost);
			getNode(end).addSuccessor(getNode(start), cost);
			printNodes();
		}
		for(Node n : nodes) {
			sg.addNode(n);
		}
		return sg;
	}

	public boolean nodeExists(Node n) {
		for(Node nn : nodes) {
			if(nn.name.equals(n.name)) {
				return true;
			}
		}
		return false;
	}

	public void addNode(Node n) {
		if(!nodeExists(n)) {
			nodes.add(n);
		}
	}

	public Node getNode(Node n) {
		for(Node nn : nodes) {
			if(nn.name.equals(n.name)) {
				return nn;
			}
		}
		return null;
	}

	public void printNodes() {
		for(Node n : nodes) {
			System.out.println(n.name + ": ");
			n.printSuccessors();
			System.out.println(" ");
		}
	}
}
