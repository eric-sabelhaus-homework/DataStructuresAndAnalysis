package FinalProject_Eric_Sabelhaus;

public class DepthFirstSearch {
    private boolean white[];    // marking the vertices for processing
    private boolean gray[];	  // The vertices is now discovered
    private boolean black[];	  // The vertices has finished being discovered
    private int time;
    private int d[] = null;
    private int f[] = null;
    private Graph myGraph;
    /**
     * Computes the vertices in graph G that are
     * connected to the source vertex s.
     */
    public DepthFirstSearch(Graph G) {
    	this.myGraph = G;
    }

    // get the discovery/finish time for each edge
    public void getDF() {
    	if (d == null && f == null ){
    		System.out.println("You must first execute dfs() method before retrieving D and F");
    		return;
    	}
    	System.out.println("\nVertices \tDiscovery \tFinish");
    	for(int i = 1; i < d.length; i++) {
    		System.out.println(i + "\t\t" + d[i] + "\t\t" + f[i]);
    	}
    }
    
	// begin depth first search
    public void dfs() {
    	white = new boolean[myGraph.getVertices()+1];
    	gray = new boolean[myGraph.getVertices()+1];
    	black = new boolean[myGraph.getVertices()+1];
    	d = new int[myGraph.getVertices()+1];
    	f = new int[myGraph.getVertices()+1];
    	
    	for(int x = 1; x < myGraph.getVertices()+1; x++) {
        	white[x] = true;
        }
        
        time = 0;
        
        for (int w = 1; w < myGraph.getVertices()+1; w++) {
            if (white[w] == true) {
                dfsVisit(w);
            }
        }
    }

    private void dfsVisit(int i) {
    	white[i] = false;
    	gray[i] = true;
    	time++;
    	System.out.println("Discovered " + i + " at " + time);
    	d[i] = time;
    	for(int j : myGraph.adj(i)) {
    		if (white[j] == true){
    			System.out.println("Parent: " + i + " Child: " + j);
    			dfsVisit(j);
    		}
    	}
    	gray[i] = false;
    	black[i] = true;
    	time++;
    	System.out.println("Finished " + i + " at " + time);
    	f[i] = time;
    }
}