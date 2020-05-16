
	import java.util.*;

public class DisjointDemo {
		
	private static int set[];		//current set
	private static int weight[];	//weight of edge

	/** Union method, combines two sets */
	private static void union(int u_set, int v_set)
	{
		int u = find(u_set);
		int v = find(v_set);
		if (u == v)  {return;} 	//base case
		
		//compare the weight of the vertices
		if (weight[u] > weight[v])      {set[v] = u; }
		else if (weight[u] < weight[v]) { set[u] = v; }
		else 
		{
			set[u] = v;
			weight[v]++;
		 }
	  
	}
	
	/**find method for disjointed sets*/
	private static int find(int x) 
	{
		if (set[x] != x)
		set[x] = find(set[x]);
		return set[x];
	  
	}


	// Function to find the required spanning tree
	private static void krushkalFunct(int edge[], 
			int n, int m, ArrayList<Integer> disjointGraph[])
	{
		//declare arrays
		set = new int[n + 1];
		weight = new int[n + 1];

		for (int i = 1; i <= n; i++)
			set[i] = i;
		int maximumWeight = 1;
		// Finding the node with maximum edge weight
		for (int i = 2; i <= n; i++)
		if (edge[i] > edge[maximumWeight])
			maximumWeight = i;
		
		for (int v_set : disjointGraph[maximumWeight])
		{
			System.out.println(maximumWeight + " " + v_set);
			union(maximumWeight, v_set);
		}
	  
		for (int u_set = 1; u_set <= n; u_set++)
		{
			for (int v_set : disjointGraph[u_set])
			{
				int u = find(u_set);
				int v = find(v_set);
				if (u == v)
				continue;
				union(u, v);
				System.out.println(u_set + " " + v_set);
	  
			}
		}
	}
	// Driver code
	public static void main(String args[])
	{
		int n = 5;
		int m = 5;
		// ArrayList to store the graph
		ArrayList<Integer> disjointGraph[] = new ArrayList[n + 1];
		for (int i = 1; i <= n; i++)
		disjointGraph[i] = new ArrayList<>();
		int edge[] = new int[n + 1];
		disjointGraph[1].add(2);
		disjointGraph[2].add(1);
		edge[1]++;
		edge[2]++;
		disjointGraph[1].add(5);
		disjointGraph[5].add(1);
		edge[1]++;
		edge[5]++;
		disjointGraph[2].add(3);
		disjointGraph[3].add(2);
		edge[2]++;
		edge[3]++;
		disjointGraph[5].add(3);
		disjointGraph[3].add(5);
		edge[3]++;
		edge[5]++;
		disjointGraph[3].add(4);
		disjointGraph[4].add(3);
		edge[3]++;
		edge[4]++;
		krushkalFunct(edge, n, m, disjointGraph);
	}
}

