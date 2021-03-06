import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;


public class Main {
	
	static SearchGraph sg;
	static GraphConstructor gc = new GraphConstructor("city-edges.txt");
	static String ROOTID = "Alexandria";
	static String GOALID = "Luxor";

	public static void main(String [] args) throws IOException {
		sg = gc.generateGraph();
		LinkedList<Node> solution = search(sg, ROOTID);
		printSolution(solution);
	}

	public static LinkedList<Node> search(SearchGraph ss, String rootId) {
		
		Searcher sq = new Searcher();
		//Scanner user_input = new Scanner( System.in );
		Node root = ss.getNode(rootId);
		root.cost = 0;
		sq.queueRoot(root);
		root.visited = true;
		/*String searchQuery;
		System.out.print("BFS DFS UCS: ");
		searchQuery = user_input.next( );*/
		
		while(!sq.empty()) {
			
			Node next = sq.queue.getFirst();
			next.visited = true;
			sq.pushStack(next);
			
			if(next.name.equals(GOALID)) {
				sq.pushStack(next);
				break;
			}
			/*if(searchQuery.equals("DFS")) {
				sq.queueDFS(next.expand());
			}
			else if(searchQuery.equals("BFS")) {
				sq.queueBFS(next.expand());
			}
			else if(searchQuery.equals("UCS")) {
				sq.queueUCS(next, next.expand());
			}*/
			
			sq.queueDFS(next.expand());
			//sq.queueBFS(next.expand());
			//sq.queueUCS(next, next.expand());
		}
		return sq.solutionStack;
	}
	
	public static void printSolution(LinkedList<Node> solution) {
		System.out.println("SOLUTION");
		System.out.println("-----------------");
		for(int i = solution.size()-1; i >=0 ; i--) {
			System.out.println(solution.get(i).name);
		}
	}
}
