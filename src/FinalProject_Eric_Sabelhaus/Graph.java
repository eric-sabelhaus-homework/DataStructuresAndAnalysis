package inalProject_Eric_Sabelhaus;

public class Graph {
	private final int vertices;
	private int edges;
	private Multiset<Integer>[] graph;
	
	@SuppressWarnings("unchecked")
	public Graph(int i) 
		if (i < 1) throw new IllegalArgumentException("Cannot have negative vertices");
		this.vertices = i;
        this.edges = 0;
        graph = (Multiset<Integer>[]) new Multiset[i+1];
        for (int j = 1; j < i+1; j++) {
            graph[j] = new Multiset<Integer>();
        }
	
	
	public int getVertices() {
		return vertices;
	}
	
	ublic Iterable<Integer> adj(int v) {
        validateVertex(v);
        return graph[v];
    }
	
    // throw an IndexOutOfBoundsException unless 0 <= v < V
    public static void validateVertex(int v) {
        if (v < 0 || v > vertices)
            throw new IndexOutOfBoundsException("vertex " + v + " is not between 0 and " + (vertices-1));
    }
	
	public void addEdge(int v, int w) {
        validateVertex(v);
        validateVertex(w);
        edges++;
        graph[v].add(w);
        graph[w].add(v);
    }

	public int degree(int v) {
        validateVertex(v);
        return graph[v].size();
    }
	
	public int getEdges() {
		return edges;
	}
	
