import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Stack;


public class Searcher {

	public LinkedList<Node> queue; //acts as a queue for bfs and stack for dfs
	public LinkedList<Node> solutionStack; //holds solution values

	public Searcher(){
		queue = new LinkedList<Node>();
		solutionStack = new LinkedList<Node>();
	}

	//QUEUE FUNCTIONS
	
	public void queueRoot(Node node) {
		queue.add(node);
	}

	public void queueBFS(List<Node> nodes) {
		if(nodes.size() > 0 && unvisited(nodes)) {
			for(Node n : nodes) {
				if(!n.visited) {
					queue.addLast(n);
				}
			}
			this.queue.removeFirst();
		}
		else {
			this.queue.removeFirst();
		}
	}

	public void queueDFS(List<Node> nodes) {
		if(nodes.size() > 0  && unvisited(nodes)) {
			for(Node n : nodes) {
				if(!n.visited)
					queue.addFirst(n);
			}
		} 
		else {
			this.queue.pop();
		}
	}

	public void queueUCS(Node node) {
		//UCS queueing function
	}

	public boolean unvisited(List<Node> nodes) {
		for(Node nn : nodes) {
			if(!nn.visited) {
				return true;
			}
		}
		return false;
	}

	// UTILITIES

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
		if(!stackContains(node.name))
			solutionStack.push(node);
	}

	public Node popStack(Node node) {
		return solutionStack.pop();
	}

	public Node getTop() {
		return queue.getFirst();
	}

	public Node getBack() {
		return queue.getLast();
	}
}
