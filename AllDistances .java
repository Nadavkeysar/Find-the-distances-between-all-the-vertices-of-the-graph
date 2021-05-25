public class AllDistances
{
    int num_Vertices = 4;
    public StringBuilder sb;
    public int [][] out = new int[4][4];
    public int[][] edge_weights = new int[4][4];
    public int[] path_array = new int[4];
    public int[] vertex_weights = new int[4];

	public int[][] distance_matrix()
	{
	    algo(edge_weights,0,vertex_weights);
	    return out;
	    
	}
	int minDistance(int path_array[], Boolean sptSet[])   { 
        int min = Integer.MAX_VALUE, min_index = -1; 
        for (int v = 0; v < num_Vertices; v++) 
            if (sptSet[v] == false && path_array[v] <= min) { 
                min = path_array[v]; 
                min_index = v; 
            } 
   
        return min_index; 
    } 
     void algo(int graph[][], int src_node, int vertex_weights[])  
     { 
        int path_array[] = new int[num_Vertices]; // The output array. dist[i] will hold 
        Boolean sptSet[] = new Boolean[num_Vertices]; 
        for (int i = 0; i < num_Vertices; i++) 
        { 
            path_array[i] = Integer.MAX_VALUE; 
            sptSet[i] = false; 
        } 
   
        // Path between vertex and itself is always 0 
        path_array[src_node] = 0; 
        // now find shortest path for all vertices  
        for (int count = 0; count < num_Vertices - 1; count++) 
        { 
            int u = minDistance(path_array, sptSet); 
            sptSet[u] = true; 
            for (int v = 0; v < num_Vertices; v++) 
                if (!sptSet[v] && graph[u][v] != 0 && path_array[u] !=  Integer.MAX_VALUE && path_array[u]+ graph[u][v] < path_array[v]) 
                {
                    out[src_node][count] = out[src_node][count]+ path_array[u] + vertex_weights[u]; 
                    path_array[v] = path_array[u] + graph[u][v]+ vertex_weights[u]; 
                }
        }
     }
	public int distance(int u , int v)
	{
	    return out[u][v];
	}
	
	public String path(int u, int v)   { 
        for (int i = u; i < v; i++) 
            sb.append(path_array[i]+"-");
        return sb.toString();
    }
	

	public static void main(String[] args) 
	{
        int[][] edge_weights = { {0,18,5,100}, {18,0,2,3}, {5,2,0,100}, {100,9,0,100}};
        int[] vertex_weights = {2,4,3,6};
    	
	}
}