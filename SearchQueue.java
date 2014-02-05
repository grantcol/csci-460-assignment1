import java.util.LinkedList;


public class SearchQueue {
	
	public LinkedList<Node> queue;
	public LinkedList<Node> solutionStack;
	
	public SearchQueue(){
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
	
	public void queueBFS(Node node) {
		queue.addLast(node);
	}
	
	public void queueDFS(Node node) {
		queue.addFirst(node);
	}
	
	public void queueUCS(Node node) {
		//UCS queueing function
	}
	
	public Node removeTop() {
		return queue.removeFirst();
	}
	
	public Node removeBack() {
		return queue.removeLast();
	}
	
	public void addToStack(Node node) {
		solutionStack.push(node);
	}
	
	public Node popStack(Node node) {
		return solutionStack.pop();
	}
}
