public class Marketing {


public static int [][] table;

public static int [] visited;

public static int RED =1;

public static int BLACK =0;

 public static void main(String[] args) {
	
	//String [] s={"1 4","2","3","0",""};
	//String [] s={"1","2","0"};
	//String [] s={"1","2","3","0","0 5","1"};
	String [] s={"","","","","","","","","","",
 "","","","","","","","","","",
 "","","","","","","","","",""};




	make_graph (s);

	System.out.println(find_components(s));


 }

public static int find_components(String []s){

	int N = s.length;

	int result=0;

	for(int i=0;i<N;i++){

		if(visited[i]==-1){

			if(!dfs(i,BLACK,N)){
				return -1;
			}
			 
			result ++;
		}

		
	}
 
 	return 1<<result;
}

public static boolean dfs (int vertex, int color,int N){

	visited[vertex]= color;

	for (int i=0;i<N;i++){
 
		if(vertex!=i){

			if(table[i][vertex]==1 && visited[i]!=-1 && visited[i]==color) return false;

		 	if (table[i][vertex]==1 && visited[i]==-1 && !dfs(i,1-color,N)) return false;
		}		 

	}

	return true;

}


public static void make_graph(String []s){

	int N =  s.length;

	table = new int [N][N];

	for(int i=0;i<N;i++){

		char [] array = s[i].toCharArray();

		for(int j=0;j<array.length;j++){

			if(array[j]!=' '){

				table[i][Integer.parseInt(""+array[j])] =1;

				table[Integer.parseInt(""+array[j])][i] =1;

			}
		}

	}

	visited = new int[N];

	for(int i=0;i<N;i++){

		visited[i]=-1;
	}


}


}