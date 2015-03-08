package FinalProject_Eric_Sabelhaus;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class TestDFS {
	/**
	 * @param args
	 */
	
	@Test(expected=IndexOutOfBoundsException.class)
	public void testError()  {
		Graph testGraph = new Graph(7);
		testGraph.addEdge(8, 8);
	}
	
	@Test
	public void functionalTest() {
		//Instantiate a new graph
		Graph testGraph = new Graph(7);

		//Add the following edges
		testGraph.addEdge(1, 2);
		testGraph.addEdge(1, 6);
		testGraph.addEdge(2, 3);
		testGraph.addEdge(2, 4);
		testGraph.addEdge(2, 5);
		testGraph.addEdge(3, 5);
		testGraph.addEdge(4, 5);
		testGraph.addEdge(5, 1);
		testGraph.addEdge(6, 4);
		testGraph.addEdge(6, 7);
		
		// assert that the degree of each vertices is as expected
		assertEquals(testGraph.degree(1), 3);
		assertEquals(testGraph.degree(2), 4);
		assertEquals(testGraph.degree(3), 2);
		assertEquals(testGraph.degree(4), 3);
		assertEquals(testGraph.degree(5), 4);
		assertEquals(testGraph.degree(6), 3);
		assertEquals(testGraph.degree(7), 1);
	}

	public static void main(String[] args) {
		//Instantiate a new graph
		Graph providedGraph = new Graph(7);
		
		//Add the following edges
		//E= {{1, 2}, {1, 6}, {2, 3}, {2, 4}, {2, 5}, {3, 5}, {4, 5}, {5, 1},{6, 4}, {6, 7}}
		providedGraph.addEdge(1, 2);
		providedGraph.addEdge(1, 6);
		providedGraph.addEdge(2, 3);
		providedGraph.addEdge(2, 4);
		providedGraph.addEdge(2, 5);
		providedGraph.addEdge(3, 5);
		providedGraph.addEdge(4, 5);
		providedGraph.addEdge(5, 1);
		providedGraph.addEdge(6, 4);
		providedGraph.addEdge(6, 7);
		
		//create DFS object with graph
		DepthFirstSearch myDFS = new DepthFirstSearch(providedGraph);
		
		System.out.println("Beginning DFS of pre-selected data");
		myDFS.dfs();
		myDFS.getDF();
		System.out.println("\nCompleted DFS of pre-selected data\n");
		
		Graph randomGraph = new Graph(7);
		randomGraph.addEdge(1,4);
		randomGraph.addEdge(2,5);
		randomGraph.addEdge(3,4);
		randomGraph.addEdge(4,5);
		randomGraph.addEdge(5,1);
		randomGraph.addEdge(6,3);
		randomGraph.addEdge(7,2);

	    DepthFirstSearch randDFS = new DepthFirstSearch(randomGraph);
	    
		System.out.println("Beginning DFS of randomly generated data");
		randDFS.dfs();
		randDFS.getDF();
		System.out.println("\nCompleted DFS of randomly generated data");

	}
}
