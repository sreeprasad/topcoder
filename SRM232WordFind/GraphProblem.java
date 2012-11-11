 public class GraphProblem{

 	char [][] graph;
 	char [][] wordList;
 	int  size;
 	int  width;
 	int [][] answer ;
 


 	public GraphProblem(int size,int width){
 		this.size=size;
 		this.width=width;
 		graph=new char[size][width];
 	}


	public int[][] solveGrid(TrieNode t, GraphProblem g,int lengthOfWordList){
		//System.out.println("solving grid inside graph");
		char[][]gcopy = new char[size][width];
 		 answer = new int[lengthOfWordList][2];
 		return  solveGrid( t, g, 0,0,gcopy,answer);

 	}


 	public int[][] solveGrid(TrieNode t, GraphProblem g, int x, int y,char [][]gcopy,int [][]answer){

 
 		if((x<0) || (y<0) |(y>=width) || (x>=size)) return answer;

 		else{

 		if(gcopy[x][y]=='\u0000') {
 			if(t.isFirstLetterPresent(t,graph[x][y])){
					//System.out.println("letter "+graph[x][y]+" found ");
					gcopy[x][y]='s';
					if(t.canReachWordFromStartingLetter(t,x, y,graph, width,size)){
						System.out.println("word found at position "+x+","+y);
						System.out.println("value of word is trie "+(t.trieNodes[graph[x][y]-97].x)+","+(t.trieNodes[graph[x][y]-97].y));
						if(answer[t.trieNodes[graph[x][y]-97].x][0]<=x){			
							answer[t.trieNodes[graph[x][y]-97].x][0]=x;
							answer[t.trieNodes[graph[x][y]-97].x][1]=y;
						}
					 
					}

 			}
 			 
 				 
 			
 			}
 			
 			solveGrid(t,g,x+1,y,gcopy,answer  );	
 			solveGrid(t,g,x,y+1,gcopy,answer );
 		 


 		}	
 		return answer;


 	}

 	public void printGraph(){
 		for(int i=0;i<size;i++){
 			for(int j=0;j<width;j++){
 				System.out.print(graph[i][j]);
 			}
 			System.out.println("");
 		}
 	}

	public void read(String[]grid){
		for(int i=0;i<size;i++){
			graph[i]=grid[i].toCharArray();
		}
	}

 }