import java.util.*;
// code for graph traversal BFS and DFS and find Has_A_Path or not

public class Graph_traversal {
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
    public static void BFS(ArrayList<Edge>[]graph)
    {
        Queue<Integer> q = new LinkedList<>();      //Queue 
        boolean vis[] = new boolean[graph.length];  // visited array
        q.add(0);                                 // Source
        while (! q.isEmpty()) {
            int curr = q.remove();                 // visited remove
            while (!vis[curr]) {
                System.out.print(curr + " ");               
                vis[curr] = true;            // mark as true
                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    q.add(e.dest);                // adding neighbour
                }
            }
        }
    }
    public static void DFS(ArrayList<Edge> graph[],int curr, boolean vis[]){
        System.out.print(curr+" ");
        vis[curr] = true;
        for(int i=0;i<graph[curr].size();i++){
            Edge e = graph[curr].get(i);
            if(!vis[e.dest]){
                DFS(graph, e.dest, vis);
            }
        }
    }
    public static boolean HasPath(ArrayList<Edge>graph[],int src,int dest,boolean vis[]){
        if(src == dest)
            return true;
        vis[src] = true;
        
        for(int i=0;i<graph[src].size();i++){
            Edge e = graph[src].get(i);
            if(! vis[e.dest] && HasPath(graph, e.dest, dest, vis))
            return true;
        }
        return false;

    }
    /*
     
        (1)------- (3)
      /              | \               
    (0)              |  \
       \             |   \
        (2)--------(4)---(5)-----(6)
                              
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
        graph[0].add(new Edge(0,2,1));

        
        //node (1)
        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        //node (2)
        graph[2].add(new Edge(2, 0,1));
        graph[2].add(new Edge(2, 4,1));

        //node (3)
        graph[3].add(new Edge(3, 1,1));
        graph[3].add(new Edge(3, 4,1));
        graph[3].add(new Edge(3, 5,1));


        //node (4)
        graph[4].add(new Edge(4, 2,1));
        graph[4].add(new Edge(4, 3,1));
        graph[4].add(new Edge(4, 5,1));


        // node (5)
        graph[5].add(new Edge(5, 3,1));
        graph[5].add(new Edge(5, 4,1));
        graph[5].add(new Edge(5, 6,1));


        //node (6)
        graph[6].add(new Edge(6, 5,1));


        // BFS(graph);
        // DFS(graph, 0, new boolean[vertices]);
        System.out.println(HasPath(graph, 0, 7, new boolean[vertices]));
        // findNeighbour(graph, 2);

    }
    // public static void findNeighbour(ArrayList<Edge>[] graph,int node) {
    //     System.out.println("neighbour vertex are : ");
    //  for(int i=0;i<graph[i].size();i++){
    //     System.out.print(graph[node].get(i).dest+" ");
        

    // }   
}



