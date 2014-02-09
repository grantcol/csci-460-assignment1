import java.util.LinkedList;
import java.util.List;


public class Searcher {
	
	public LinkedList<Node> queue;
	public LinkedList<Node> solutionStack;
	
	public Searcher(){
		queue = new LinkedList<Node>();
		solutionStack = new LinkedList<Node>();
	}
	
	public Node getTop() {
		return queue.getFirst();
	}
	
	public Node getBack() {
		return queue.getLast();
	}
	
	public int size() {
		return queue.size();
	}
	
	public boolean queueContains(String nodeName) {
		for(Node n : queue) {
			if(n.name.equals(nodeName)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean stackContains(String nodeName) {
		for(Node n : solutionStack) {
			if(n.name.equals(nodeName)) {
				return true;
			}
		}
		return false;
	}
	
	public void queueBFS(Node node) {
		queue.addLast(node);
	}
	
	public void queueBFS(List<Node> nodes) {
		for(Node n : nodes) {
			queue.addLast(n);
		}
	}
	
	public void queueDFS(List<Node> nodes) {
		for(int i = nodes.size()-1; i > 0; i--){
			queue.addFirst(nodes.get(i));
		}
	}
	
	public void queueDFS(Node node) {
		queue.addFirst(node);
	}
	
	public void queueUCS(Node node) {
		//UCS queueing function
	}
	
	public Node chooseNextNode(List<Node> nodes) {
		if(!nodes.isEmpty()) {
			Node smallest = null;
			smallest = nodes.get(0);
			for(Node n : nodes) {
				if(n.distance < smallest.distance) {
					smallest = n;
				}
			}
			return smallest;
		} else {
			return null;
		}
	}
	
	public boolean empty() {
		return queue.isEmpty();
	}
	
	public Node removeTop() {
		return queue.removeFirst();
	}
	
	public Node removeBack() {
		return queue.removeLast();
	}
	
	public void pushStack(Node node) {
		solutionStack.push(node);
	}
	
	public Node popStack(Node node) {
		return solutionStack.pop();
	}
	
	public void printSolutionStack() {
		System.out.println("SOLUTION");
		for(int i = solutionStack.size()-1; i > 0; i--) {
			System.out.println(solutionStack.get(i).name);
		}
	}
}
