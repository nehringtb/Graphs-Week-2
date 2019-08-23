	import java.util.ArrayList;
import java.util.Scanner;

public class Acyclicity {
	public static ArrayList<Integer>[] adj;
	public static int[] state;
	
	private static int search(int currentNode){
		 
		if(state[currentNode]==2){
    		return 1;
    	}
		else{
			state[currentNode]=2;
		}
		
    	
    	
		for (int i: adj[currentNode]){
			if(state[i]==3)
				continue;
			if(search(i)==1){
				return 1;
			}
		}
		state[currentNode]=3;
		return 0;
		
	}
	
	
    private static int acyclic(ArrayList<Integer>[] adj) {
        state= new int[adj.length];
       
    	for (int i=0;i< adj.length; i++){
    		if(state[i]!=3){
    			if(search(i)!=0)
    				return 1;
    		}
    	}
    	return 0;
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
        System.out.println(acyclic(adj));
    }
}

