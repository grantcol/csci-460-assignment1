import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	static SearchSpace ss;
	static GraphConstructor gc = new GraphConstructor("city-edges.txt");
	static String ROOTID = "Alexandria";

	public static void main(String [] args) throws IOException {
		ss = gc.generateGraph();
		ss.print();
		search(ss, ROOTID);
	}

	public static void search(SearchSpace ss, String rootId) {
		Searcher sq = new Searcher();
		Node root = ss.getNode(rootId);
		root.visited();
		//sq.queueBFS(root.expand());
		sq.queueDFS(root.expand());
		//sq.queueUCS(root.expand());
		sq.pushStack(root);
		while(!sq.empty()) {
			Node next = sq.removeTop();

			//sq.queueBFS(next.expand());
			sq.queueDFS(next.expand());
			//sq.queueUCS(next.expand());
			next.visited();
			if(!sq.stackContains(next.name)) 
				sq.pushStack(next);
		}
		sq.printSolutionStack();
	}
}
