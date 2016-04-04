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
    Vertex[] temp = null;
    temp[0] = v;
    this.graphVertexes[this.graphVertexes.length] = temp;

    return true;
  }

  /**
  *
  *
  */
  public boolean addEdge(Edge e){
    if (isDirected(e)){
      Vertex[] temp;
      //temp[0] = e.getOrigin();
      //temp[1] = e.getEnd();
      temp = e.getEnds();
      this.graphVertexes[this.graphVertexes.length] = temp;
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
  public boolean vertexIsInGraph(Vertex v){
    int i = 0;
    Vertex[] temp = null;
    temp[0] = v;
    while (temp != this.graphVertexes[i] && i < this.graphVertexes.length){
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
    while (temp != this.graphVertexes[i] && i < this.graphVertexes.length){
      i++;
    }
    return (i != this.graphVertexes.length);
  }

  /**
  *   implementation of: getEdge(Vertex a, Vertex b)
  *   The edge has to exist ?
  */
  public Edge getEdge(Vertex a, Vertex b){
    int i = 0;
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
    for (Edge edge : edges){
      removeEdge(edge);
    }
    return true;
  }

  /**
  *   implementation of: removeAllVertices(Vertex[] vertexes)
  *   The edge has to exist ?
  */
  public boolean removeAllVertices(Vertex[] vertexes){
    for (Vertex vertex : vertexes){
      removeVertex(vertex);
    }
    return true;
  }

  //TODO**************

  public boolean removeEdge(Edge edge){
    return false;
  }

  public boolean removeVertex(Vertex vertex){
    return false;
  }

  public Edge[] adjascentEdges(Vertex vertex){
    return null;
  }

  //WIP ************
  // [0,(0,1),1]
  public int getVertexPosition(Vertex vertex){
      int i = 0;
      Vertex[] temp = null;
      temp[0] = vertex;
      while (temp != this.graphVertexes[i] && i < this.graphVertexes.length){
        i++;
      }
      return i;
  }

  public int getEdgePosition(Edge edge){
    int i = 0;
    Vertex[] temp = null;
    temp = edge.getEnds();
    while (temp != this.graphVertexes[i] && i < this.graphVertexes.length){
      i++;
    }
    return i;
  }

  public Edge getNextEdge(Vertex vertex){
    /*if (!(vertexIsInGraph(vertex))){
      throw new Exception();
    }*/
    int i = getVertexPosition(vertex);

    // Test if Undirected of Directed ......
    UndirectedEdge res = new UndirectedEdge(this.graphVertexes[i][0],this.graphVertexes[i][1]);
    return res;

  }

  public Edge getPreviousEdge(Vertex vertex){
    /*
    if (!(vertexIsInGraph(vertex))){
      throw new Exception();
    }*/
    int i = getVertexPosition(vertex)-2;

    // Test if Undirected of Directed ......
    UndirectedEdge res = new UndirectedEdge(this.graphVertexes[i][0],this.graphVertexes[i][1]);
    return res;

  }

  public Vertex getNextVertex(Edge edge){
    /*if (!(edgeIsInGraph(edge))){
      throw new Exception();
    }*/
    int i = getEdgePosition(edge);
    return this.graphVertexes[i][0];

  }

  public Vertex getPreviousVertex(Edge edge){
    /*if (!(edgeIsInGraph(edge))){
      throw new Exception();
    }*/
    int i = getEdgePosition(edge)-2;
    return this.graphVertexes[i][0];

  }


}
