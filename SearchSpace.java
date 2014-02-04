import java.util.ArrayList;
import java.util.List;

public class SearchSpace {
	public List<Node> tree;
	
	public SearchSpace(List<Node> tree) {
		this.tree = tree;
	}
	
	public SearchSpace() {
		this.tree = new ArrayList<Node>();
	}
	
	public void addNode(Node node) {
		tree.add(node);
	}
	
	public boolean contains(String nodeName) {
		for(Node n : tree) {
			if(n.name.equals(nodeName)) {
				return true;
			}
		} 
		return false;
	}
	
	public Node getNode(String name) {
		for(Node n : tree) {
			if(n.name.equals(name)) {
				return n;
			}
		}
		return null;
	}
	
	public void removeNode(Node node) {
		tree.remove(node);
	}
	
	public void removeNode(String nodeName) {
		for(Node n : tree) {
			if(n.name.equals(nodeName)) {
				removeNode(n);
			}
		}
	}
	public void print() {
		for(Node n : tree) {
			n.print();
		}
	}
}
