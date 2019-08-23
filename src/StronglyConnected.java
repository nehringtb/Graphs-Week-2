import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class StronglyConnected {
	private static int[][] prePost;
	private static boolean[] visited;
	private static ArrayList<Integer>[] adj;
	private static ArrayList<Integer>[] rAdj;
	private static int counter=1;
	private static boolean[] inSCC;
    private static int numberOfStronglyConnectedComponents(ArrayList<Integer>[] adj) {
        rAdj= (ArrayList<Integer>[])new ArrayList[adj.length];
        prePost= new int[adj.length][2];
        inSCC= new boolean[adj.length];
        visited= new boolean[adj.length];
        int scc=0;
        
        for(int i=0; i<adj.length; i++){
        	rAdj[i]= new ArrayList<Integer>();
        }
        
        for(int i=0; i<adj.length; i++){
        	for (int j=0; j<adj[i].size(); j++){
        		rAdj[j].add(i);
        	}
        }
        for(int i=0; i< rAdj.length; i++){
        	dfsOnR(i);
        }
        
        
        while (true){
        	int toExploreNext=findBiggestPost();
        	if(toExploreNext==-1)
        		return scc;
        	explore(toExploreNext, new boolean[adj.length], new ArrayList<Integer>(), toExploreNext);
        	scc++;
        	
        }
        
        
    }
    
    
    private static void explore(int i, boolean[] visited, ArrayList<Integer> stack, int goal){
    	if(stack.size()!=0){
    		if (i==goal){
    			inSCC[i]=true;
    			return;
    		}
    	}
    	if(visited[i] || inSCC[i])
    		return;
    	visited[i]=true;
    	
    	
    	for(int j: adj[i]){
    		if(visited[j] || inSCC[j])
        		continue;
    		
    		explore(j,visited,stack, goal);
    		
    	}
    	
    }
    private static int findBiggestPost(){
    	int biggestNode=-1;
        int biggestPost=-1;
        
    	for(int i=0; i<rAdj.length; i++){
        	if(biggestPost<prePost[i][1] && !inSCC[i]){
        		biggestPost=prePost[i][1];
        		biggestNode=i;
        	}
        }
    	return biggestNode;
    }
    
    private static void dfsOnR(int currentNode){
    	if(visited[currentNode])
    		return;
    	visited[currentNode]=true;
    	prePost[currentNode][0]=counter;
    	counter++;
    	
    	for(int i: rAdj[currentNode]){
    		if(visited[i])
    			continue;
    		dfsOnR(i);
    	}
    	
    	prePost[currentNode][1]=counter;
    	counter++;
    	
    }
    
   

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
         adj = (ArrayList<Integer>[])new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<Integer>();
        }
        for (int i = 0; i < m; i++) {
            int x, y;
            x = scanner.nextInt();
            y = scanner.nextInt();
            adj[x - 1].add(y - 1);
        }
        System.out.println(numberOfStronglyConnectedComponents(adj));
    }
}

