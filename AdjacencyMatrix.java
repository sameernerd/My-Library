import java.util.*;
public class AdjacencyMatrix {
	Scanner read=new Scanner(System.in);
	int vertex1,vertex2,weight;
	void makeGraph(int graphMatrix[][]){
			vertex1=read.nextInt();
			vertex2=read.nextInt();
			weight=read.nextInt();
			graphMatrix[vertex1-1][vertex2-1]=weight;
	}

}
