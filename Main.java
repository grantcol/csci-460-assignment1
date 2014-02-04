import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Main {
	static SearchSpace ss;
	static GraphConstructor gc = new GraphConstructor("city-edges.txt");
	
	public static void main(String [] args) throws IOException {
		build();
	}
	
	public static void build() throws IOException {
		
		ss = gc.generateGraph();
		ss.print();
		
	}
	
	public void search() {
		//here is where we will actually call all the search algs
	}
}
