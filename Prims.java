import java.util.*;

public class Prims{
	Graph graph=new Graph();
	MinHeap heapOb=new MinHeap();
	ArrayList<Graph.Edge> PrimsEdge=new ArrayList();
	ArrayList<Graph.Edge> EdgeList=new ArrayList();
	HashMap vertexmap;
	HashMap<Character,Graph.Edge> TempMap=new HashMap();
	
	ArrayList<Graph.Edge> ApplyPrims(Scanner read){
		int vertex_n=read.nextInt(); //Vertex Number
		int edge_n=read.nextInt();  //Edge Number
		vertexmap=graph.makeVertex(vertex_n);
		char minimum_node;
		for(int i=0;i<edge_n;i++){
			graph.makeEdge(read);
		}
		Set set=vertexmap.entrySet();
		Iterator itOb=set.iterator();
		while(itOb.hasNext()){
			Map.Entry me=(Map.Entry)itOb.next();
			if((char)me.getValue()=='A')heapOb.insert(0,'A');
			else heapOb.insert(100001,(char)me.getValue());
		}
		EdgeList=graph.getEdges(); //Getting all the edges in map 
		int edge_weight; //Actual Weight of the edges
		int edge_start,edge_end;
		while(!heapOb.isEmpty()){
			minimum_node=heapOb.ExtractMin();  //Extracting the minimum value //It will return char but converting to int
			for(int i=0;i<EdgeList.size();i++){
				edge_start=EdgeList.get(i).start-1+65;
				edge_end=EdgeList.get(i).end-1+65;
				edge_weight=EdgeList.get(i).weight;
				if(heapOb.contains((char)edge_end)&&minimum_node==edge_start&&edge_weight<heapOb.getHeapNodeValue((char)edge_end)){
					heapOb.decrease(edge_weight,(char)edge_end);
					TempMap.put((char)edge_end,EdgeList.get(i));
				}
			}
		if(TempMap.containsKey((char)minimum_node))PrimsEdge.add(TempMap.get((char)minimum_node));
		}
		return PrimsEdge;
	}
}

//Usage
/*
Enter No of Vertices Then Edge
Then start entering edge with its weight
*/