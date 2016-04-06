package graph;

/**
* Implementation of interface graph
* The interface has been written by the Aligator team
* The Implementation is being written by the Octopus team
* @author: AFONSO Benjamin and TERRIEN James
*/

public class GraphImplement implements Graph {


  private Vertex[] vertexes;
  private Edge[][] edges;
  private int ordre = 0;
  
  public GraphImplement() {
	  this.ordre = 0;
	  this.vertexes = new Vertex[100];
	  this.edges = new Edge[100][100];
  }
  /**
  *		Implementation of isAdjacent function
  *
  */
  public boolean isAdjacent(Edge e1, Edge e2){
    return ((e1.getEnds()[0] == e2.getEnds()[1]) || (e1.getEnds()[1] == e2.getEnds()[0]));
  }


  /**
  * 	Implementation of addVertex function
  *	
  */
  public boolean addVertex(Vertex v){
	  
	  // Gerer le cas de dépassement
	  try {
		  this.vertexes[ordre] = v;
		  this.ordre++;
	  }
	  catch (Exception overflow) {
		  return false;
	  }
	  return true;
	  
  }

  /**
  *		Implementation of addEdge
  *
  */
  public boolean addEdge(Edge e){
	  
	  
	  try{
		  int i = getVertexPosition(e.getEnds()[0]);
		  int j = getVertexPosition(e.getEnds()[1]);
		  // Vertex 1 doesn't exist
		  if (i == -1){
			  this.addVertex(e.getEnds()[0]);
		  }
		  // Vertex 2 doesn't exist
		  if (j == -1){
			  this.addVertex(e.getEnds()[1]);
		  }
		  
		  // Add the edge.
		  	// If the edge is directed
		  if (isDirected(e)){
			  int p1 = getVertexPosition(((DirectedEdge) e).getOrigin());
			  int p2 = getVertexPosition(((DirectedEdge) e).getEnd());
			  System.out.println(i+" "+j);
			  System.out.println(p1+" "+p2);
			  this.edges[p1][p2] = e;

		  }
		  // The edge is not directed
		  else
		  {
			  this.edges[i][j] = e;
			  this.edges[j][i] = e;

		  }

		  
	  }catch (Exception UnknownException){
		  return false;
	  }

	  return true;
  }

  /**
  *
  * Implementation of getAllEdges
  *
  */
  public Edge[] getAllEdges(){
	int k = 0;
	Edge[] res = new Edge[this.ordre*this.ordre];
    for (int i = 0; i < this.ordre; i++){
    	for (int j = 0; j < this.ordre; j++){
    		res[k] = this.edges[i][j];
    		k++;
    	}
    }
    return res;
  }

  /**
  *
  *	Implementation of getAllVertices
  * 
  */
  public Vertex[] getAllVertices(){
    return this.vertexes;
  }

  /**
  *
  * Implementation of isDirected
  *
  */
  public boolean isDirected(Edge e){
    return (e instanceof DirectedEdge);
  }

  /**
  *   implementation of: vertexIsInGraph
  *
  */

public boolean vertexIsInGraph(Vertex v){
    int i = 0;
    while (v != this.vertexes[i] && i<this.ordre){
    	i++;
    }
    // v=this.vertexes[i] ou i=this.ordre
    return (v==this.vertexes[i]);
  }

  /**
  *   implementation of: edgeIsInGraph
  *
  */
  public boolean edgeIsInGraph(Edge e){
	int p1 = getVertexPosition(e.getEnds()[0]);
	int p2 = getVertexPosition(e.getEnds()[1]);
	System.out.println(p1+" "+p2);
    if (p1 != -1 && p2 != -1){
    	return (this.edges[p2][p1] != null || this.edges[p1][p2] != null);
    }
    return false;
  }

  /**
  *   implementation of: getEdge(Vertex a, Vertex b)
  *   The edge has to exist ?
  */
  public Edge getEdge(Vertex a, Vertex b){
	  int p1 = getVertexPosition(a);
		int p2 = getVertexPosition(b);
	    if (p1 != -1 && p2 != -1){
	    	return (this.edges[p1][p2]);
	    }
	    return null;
  }

  /**
  *   implementation of: removeAllEdges(Edge[] edges)
  *   The edge has to exist ?
  */
  public boolean removeAllEdges(Edge[] edges){
	try{
		for (Edge edge : edges){
			removeEdge(edge);
		}

	}catch (Exception e4){
		return false;
	}
	return true;
  }

  /**
  *   implementation of: removeAllVertices(Vertex[] vertexes)
  *   The edge has to exist ?
  */
  public boolean removeAllVertices(Vertex[] vertexes){
    try{
		for (Vertex vertex : vertexes){
	      removeVertex(vertex);
	    }
    }catch(Exception e3){
    	return false;
    }
    return true;
  }

  //TODO**************

  public boolean removeEdge(Edge edge){
	  int p1 = getVertexPosition(edge.getEnds()[0]);
		int p2 = getVertexPosition(edge.getEnds()[1]);
	    if (p1 != -1 && p2 != -1){
	    	this.edges[p1][p2] = null;
	    	return true;
	    }
	    return false;
  }

  /**
   * Implementation of removeVertex(vertex)
   * @param vertex
   * @return boolean
   */
  public boolean removeVertex(Vertex vertex){
	  if (vertexIsInGraph(vertex)){
		  try{
			  for (int i = 0;i<this.ordre;i++){
				  this.edges[getVertexPosition(vertex)][i] = null;
				  this.edges[i][getVertexPosition(vertex)] = null;
			  }
			  this.vertexes[getVertexPosition(vertex)] = null;
		  }
		  
		  catch (Exception e6){
			  
			  return false;
		  }
		  return true;
	  }

	  return false;
	  
  }

  public Edge[] adjascentEdges(Vertex vertex){
    int pos = getVertexPosition(vertex);
    Edge[] res = new Edge[this.ordre * this.ordre];
    int k = 0;
    for (int i = 0; i < this.ordre; i++){
    	res[k] = this.edges[pos][i];
    	res[k+1] = this.edges[i][pos];
    	k = k+2;
    }
    return res;
  }


  /*
   *
   *
   *  Privates functions
   *
   *
   */


  private int getVertexPosition(Vertex vertex){
      int i = 0;
      while (vertex != this.vertexes[i] && i < this.vertexes.length-1){
        i++;
      }
      // i = dernière case OU vertex = vertex[i]
      if (vertex == this.vertexes[i]){
    	  return i;
      }
      return -1;
  }





}
