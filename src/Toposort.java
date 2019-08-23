import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Toposort {
    private static ArrayList<Integer> order = new ArrayList<Integer>();
    private static ArrayList<Integer>[] adj;
    private static boolean[] used;
    private static ArrayList<Integer> toposort(ArrayList<Integer>[] adj) {
        int used[] = new int[adj.length];
        //write your code here
        return order;
    }

    private static void dfs(ArrayList<Integer>[] adj, int[] used, ArrayList<Integer> order, int s) {
    	
    }
    
    private static void search(int currentNode){
    	
    	if (adj[currentNode].size()==0){
    		order.add(currentNode);
    		used[currentNode]=true;
    		return;
    	}
    	
    	for(int i: adj[currentNode]){
    		if(!used[i])
    			search(i);
    	}
    	
    	order.add(currentNode);
    	used[currentNode]=true;
    	return;
    	
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
         adj = (ArrayList<Integer>[])new ArrayList[n];
         used = new boolean[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        //ArrayList<Integer> order = toposort(adj);
        for (int i=0; i<adj.length; i++){
        	if(!used[i]){
        		search(i);
        	}
        }
        for (int x : order) {
          //  System.out.print((x + 1) + " ");
        }
        for(int x=order.size()-1; x>=0; x--){
            System.out.print((order.get(x) + 1) + " ");
        }
    }
}

