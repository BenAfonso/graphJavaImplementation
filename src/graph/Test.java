package graph;

/**
	* Main Class
	* @author: Benjamin AFONSO & James TERRIEN
	* @version: 0.0.1
	*/
public class Test {

  //TODO
	public static void main(String[] args) {
    int fail = 0;
    int success = 0;
    // Instanciation of Graph Object
    Graph graph = new GraphImplement();

    // Population Graph
    double[] values = null;

    values[0] = 1.0;
    values[1] = 1.0;
    Vertex v1 = new Vertex(values);
    values[0] = 2.0;
    values[1] = 2.0;
    Vertex v2 = new Vertex(values);
    values[0] = 3.0;
    values[1] = 3.0;
    Vertex v3 = new Vertex(values);
    values[0] = 4.0;
    values[1] = 4.0;
    Vertex v4 = new Vertex(values);
    values[0] = 5.0;
    values[1] = 5.0;
    Vertex v5 = new Vertex(values);


    Edge e1 = new DirectedEdge(v1,v2);
    Edge e2 = new DirectedEdge(v2,v3);
    Edge e3 = new UndirectedEdge(v3,v4);
    Edge e4 = new UndirectedEdge(v3,v4);

    graph.addVertex(v1);
    graph.addVertex(v2);
    graph.addVertex(v3);
    graph.addVertex(v4);


    graph.addEdge(e1);
    graph.addEdge(e2);
    graph.addEdge(e3);

    // Test if 2 edges are adjacent
    if (graph.isAdjacent(e1,e2) && !(graph.isAdjacent(e1,e3))){
      System.out.println("Adjacent edges test : SUCCESS");
      success++;
    }else{
      System.out.println("Adjacent edges test : FAILED");
      fail++;
    }

    // Test if Vertex is in Graph
    if (graph.vertexIsInGraph(v1) && !(graph.vertexIsInGraph(v5))){
      System.out.println("Vertex in graph test : SUCCESS");
      success++;
    }else{
      System.out.println("Vertex in graph test : FAILED");
      fail++;
    }

    // Test if Edge is in Graph
    if (graph.edgeIsInGraph(e1) && !(graph.edgeIsInGraph(e4))){
      System.out.println("Edge in graph test : SUCCESS");
      success++;
    }else{
      System.out.println("Edge in graph test : FAILED");
      fail++;
    }

    // Get edge between 2 vertexes
    System.out.println("Edge between v1 and v2: ");
    System.out.println(graph.getEdge(v1,v2));

    // Get all edges
    System.out.println("All edges: ");
    System.out.println(graph.getAllEdges());

    // Get all vertexes
    System.out.println("All vertexes: ");
    System.out.println(graph.getAllVertices());

    // Remove test of Vertex
    if (graph.removeVertex(v1)){
      System.out.println("Remove vertex test: SUCCESS");
      success++;
    }else{
      System.out.println("Remove vertex test: FAILED");
      fail++;
    }

    // Remove test of Vertex
    if (graph.removeEdge(e1)){
      System.out.println("Remove edge test: SUCCESS");
      success++;
    }else{
      System.out.println("Remove edge test: FAILED");
      fail++;
    }

    // Remove test of All Vertex
    Vertex[] vertexes = null;
    vertexes[0] = v1;
    vertexes[1] = v2;
    if (graph.removeAllVertices(vertexes)){
      System.out.println("Remove all vertexes test: SUCCESS");
      success++;
    }else{
      System.out.println("Remove all vertexes test: FAILED");
      fail++;
    }

    Edge[] edges = null;
    edges[0] = e1;
    edges[1] = e2;
    // Remove test of All Edges
    if (graph.removeAllEdges(edges)){
      System.out.println("Remove all edges test: SUCCESS");
      success++;
    }else{
      System.out.println("Remove all edges test: FAILED");
      fail++;
    }

    // Display results
    System.out.println("========================================================");
    int nb = fail + success;
    System.out.println("Number of tests: "+nb);
    System.out.println("Succeeded tests: "+success);
    System.out.println("Failed tests: "+fail);





	}

}
