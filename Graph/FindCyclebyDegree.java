package Graph;
// Java implementation of the approach 
import java.util.*; 

// https://www.geeksforgeeks.org/detect-cycle-in-the-graph-using-degrees-of-nodes-of-graph/ 
class Graph { 

	int v; 

	// Adjacency List 
	LinkedList l[]; 

	Graph(int v) 
	{ 
		this.v = v; 
		this.l = new LinkedList[v]; 
		for (int i = 0; i < v; i++) { 
			l[i] = new LinkedList(); 
		} 
	} 
	void addedge(int i, int j) 
	{ 
		l[i].add(j); 
		l[j].add(i); 
	} 
} 

public class FindCyclebyDegree { 

	// Function to find a cycle in the given graph if exists 
	static void findCycle(int n, int e, Graph g) 
	{ 

		// HashMap to store the degree of each node 
		HashMap degree = new HashMap(); 

		for (int i = 0; i < g.l.length; i++) 
			degree.put(i, g.l[i].size()); 

		// Array to track visited nodes 
		int visited[] = new int[g.v]; 

		// Initially all nodes are not visited 
		for (int i = 0; i < visited.length; i++) 
			visited[i] = 0; 

		// Queue to store the nodes of degree 1 
		LinkedList q = new LinkedList(); 

		// Continuously adding those nodes whose 
		// degree is 1 to the queue 
		while (true) { 

			// Adding nodes to queue whose degree is 1 
			// and is not visited 

			for (int i = 0; i < degree.size(); i++) 
				if ((int)degree.get(i) == 1 && visited[i] == 0) 
					q.add(i); 

			// If queue becomes empty then get out 
			// of the continuous loop 
			if (q.isEmpty()) 
				break; 

			while (!q.isEmpty()) { 

				// Remove the front element from the queue 
				int temp = (int)q.remove(); 

				// Mark the removed element visited 
				visited[temp] = 1; 

				// Decrement the degree of all those nodes 
				// adjacent to removed node 
				for (int i = 0; i < g.l[temp].size(); i++) { 
					int value = (int)degree.get((int)g.l[temp].get(i)); 
					degree.replace(g.l[temp].get(i), --value); 
				} 
			} 
		} 

		int flag = 0; 

		// Checking all the nodes which are not visited 
		// i.e. they are part of the cycle 
		for (int i = 0; i < visited.length; i++) 
			if (visited[i] == 0) 
				flag = 1; 

		if (flag == 0) 
			System.out.print("-1"); 
		else { 
			for (int i = 0; i < visited.length; i++) 
				if (visited[i] == 0) 
					System.out.print(i + " "); 
		} 
	} 

	// Driver code 
	public static void main(String[] args) 
	{ 

		// No of nodes 
		int n = 5; 

		// No of edges 
		int e = 5; 
		Graph g = new Graph(n); 

		g.addedge(0, 1); 
		g.addedge(0, 2); 
		g.addedge(0, 3); 
		g.addedge(1, 2); 
		g.addedge(3, 4); 

		findCycle(n, e, g); 
	} 
} 
