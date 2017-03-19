import java.util.*;

public class Graph {
	private HashMap<Integer,Character> VertexMap=new HashMap();  //Mapping index of the graph to vertex
	private ArrayList<Edge> EdgeList=new ArrayList();
	
	class Edge{
		int start;
		int end;
		int weight;
		
	}
	
	HashMap makeVertex(int vertex_n){
		for(int i=1;i<=vertex_n;i++){
			VertexMap.put(i,(char)(65+i-1));
		}
		return VertexMap;
	}
	
	void makeEdge(Scanner read){
		Edge newEdge=new Edge();
		Edge newEdge2=new Edge();
		newEdge.start=read.nextInt();
		newEdge.end=read.nextInt();
		newEdge.weight=read.nextInt();
		newEdge2.start=newEdge.end;
		newEdge2.end=newEdge.start;
		newEdge2.weight=newEdge.weight;
		EdgeList.add(newEdge);
		EdgeList.add(newEdge2);
	}
	
	ArrayList getEdges(){
		return EdgeList;
	}
	
	void showEdge(){
		for(int i=0;i<EdgeList.size();i++){
			System.out.println(VertexMap.get(EdgeList.get(i).start)+" "+VertexMap.get(EdgeList.get(i).end)+" "+EdgeList.get(i).weight);
		}
	}
}
