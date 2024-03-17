import java.util.*;
public class Graph_implementation {
    static class  Edge {
        int src;
        int dest;
        int wt;
        public Edge(int s,int d,int w){
            this.src = s;
            this.dest = d;
            this.wt = w;
        }
        
    }
    /*
     
        (0)------- (1)
                    | \               
                    |  \
                    |   \
                   (2)---(3)
                    |
                    |
                   (4)                
     */

    public static void main(String[] args) {
        int vertices = 7;

        // initializing array of arrayList which contains Edges type objects
        ArrayList<Edge> graph[] = new ArrayList[vertices];
        // System.out.print("helo");
        for(int i=0;i<vertices;i++){
            graph[i] = new ArrayList<>();
        }
        // node (0)
        graph[0].add(new Edge(0,1,1));
        
        //node (1)
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 2, 1));
        graph[1].add(new Edge(1, 3, 1));

        //node (2)
        graph[2].add(new Edge(2, 1,1));
        graph[2].add(new Edge(2, 3,1));
        graph[2].add(new Edge(2, 4,1));

        //node (3)
        graph[3].add(new Edge(3, 1,1));
        graph[3].add(new Edge(3, 2,1));

        //node (4)
        graph[4].add(new Edge(4, 2,1));
        findNeighbour(graph, 2);

    }
    public static void findNeighbour(ArrayList<Edge>[] graph,int node) {
        System.out.println("neighbour vertex are : ");
     for(int i=0;i<graph[i].size();i++){
        System.out.print(graph[node].get(i).dest+" ");
        

    }   
    }
}

