package graph;
import graph.*;

/**
* Implementation of interface graph
* The interface has been written by the Aligator team
* The Implementation is being written by the Octopus team
* @author: AFONSO Benjamin and TERRIEN James
*/

public class GraphImplement implements Graph {


  private Vertex[][] graphVertexes;

  public GraphImplement() {
	  this.graphVertexes = new Vertex[10][10];
  }
  /**
  *
  *
  */
  public boolean isAdjacent(Edge e1, Edge e2){
    return ((e1.getEnds()[0] == e2.getEnds()[1]) || (e1.getEnds()[1] == e2.getEnds()[0]));
  }


  /**
  *
  *
  */
  public boolean addVertex(Vertex v){
    Vertex[] temp = new Vertex[1];
    temp[0] = v;
    try {
    this.graphVertexes[0] = temp;
    } catch (Exception e) {
    	return false;
    }
    return true;
  }

  /**
  *
  *
  */
  public boolean addEdge(Edge e){
    if (isDirected(e)){
      Vertex[] temp;
      /*temp[0] = e.getOrigin();
      //temp[1] = e.getEnd();*/
      temp = e.getEnds();
      try{
    	  this.graphVertexes[this.graphVertexes.length-1] = temp;
      }catch (Exception e2) {
    	  return false;
      }

    }
    return true;
  }

  /**
  *
  *
  */
  public Edge[] getAllEdges(){
    return null;
  }

  /**
  *
  *
  */
  public Vertex[] getAllVertices(){
    return null;
  }

  /**
  *
  *
  */
  public boolean isDirected(Edge e){
    return (e instanceof DirectedEdge);
  }

  /**
  *   implementation of: vertexIsInGraph
  *
  */
  @SuppressWarnings("null")
public boolean vertexIsInGraph(Vertex v){
    int i = 0;
    Vertex[] temp = new Vertex[1];
    temp[0] = v;
    while (temp != this.graphVertexes[i] && i < this.graphVertexes.length-1){
      i++;
    }
    return (i != this.graphVertexes.length);
  }

  /**
  *   implementation of: edgeIsInGraph
  *
  */
  public boolean edgeIsInGraph(Edge e){
    int i = 0;
    Vertex[] temp;
    temp = e.getEnds();
    /*
    if (isDirected(e)){
      temp[0] = e.getOrigin();
      temp[1] = e.getEnd();
    }
    */
    while (temp != this.graphVertexes[i] && i < this.graphVertexes.length-1){
      i++;
    }
    return (i != this.graphVertexes.length);
  }

  /**
  *   implementation of: getEdge(Vertex a, Vertex b)
  *   The edge has to exist ?
  */
  public Edge getEdge(Vertex a, Vertex b){
    if (vertexIsInGraph(a) && vertexIsInGraph(b)){
      return new UndirectedEdge(a,b);
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
	try {
		int i=getEdgePosition(edge);
		for (int j = i; j < this.graphVertexes.length-2; j++){
			this.graphVertexes[j] = this.graphVertexes[j+1];
		}
	} catch (Exception e5) {
		return false;
	}

    return true;
  }

  public boolean removeVertex(Vertex vertex){
		try {
			int i=getVertexPosition(vertex);
			for (int j = i; j < this.graphVertexes.length-2; j++){
				this.graphVertexes[j] = this.graphVertexes[j+1];
			}
		} catch (Exception e5) {
			return false;
		}

	    return true;
  }

  public Edge[] adjascentEdges(Vertex vertex){
    return null;
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
      Vertex[] temp = new Vertex[1];
      temp[0] = vertex;
      while (temp != this.graphVertexes[i] && i < this.graphVertexes.length-1){
        i++;
      }
      return i;
  }

  private int getEdgePosition(Edge edge){
    int i = 0;
    Vertex[] temp = null;
    temp = edge.getEnds();
    while (temp != this.graphVertexes[i] && i < this.graphVertexes.length-1){
      i++;
    }
    return i;
  }

  private Edge getNextEdge(Vertex vertex){
    /*if (!(vertexIsInGraph(vertex))){
      throw new Exception();
    }*/
    int i = getVertexPosition(vertex);

    // Test if Undirected of Directed ......
    UndirectedEdge res = new UndirectedEdge(this.graphVertexes[i][0],this.graphVertexes[i][1]);
    return res;

  }

  private Edge getPreviousEdge(Vertex vertex){
    /*
    if (!(vertexIsInGraph(vertex))){
      throw new Exception();
    }*/
    int i = getVertexPosition(vertex)-2;

    // Test if Undirected of Directed ......
    UndirectedEdge res = new UndirectedEdge(this.graphVertexes[i][0],this.graphVertexes[i][1]);
    return res;

  }

  private Vertex getNextVertex(Edge edge){
    /*if (!(edgeIsInGraph(edge))){
      throw new Exception();
    }*/
    int i = getEdgePosition(edge);
    return this.graphVertexes[i][0];

  }

  private Vertex getPreviousVertex(Edge edge){
    /*if (!(edgeIsInGraph(edge))){
      throw new Exception();
    }*/
    int i = getEdgePosition(edge)-2;
    return this.graphVertexes[i][0];

  }


}
