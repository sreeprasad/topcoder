public class GraphMain{

	public static String[] convertToSmallCase(String[] array,int length){
		for(int i=0;i<length;i++){
			array[i]=array[i].toLowerCase();
		}
		System.out.println("after converting to lower case");
		for(int i=0;i<length;i++){
			System.out.println(array[i]);
		}
		System.out.println("--------------------");
		return array;
	}

	public static void main(String abd[]){



		String []grid = {"TEST","GOAT","BOAT"};
		String []wordList = {"GOAT", "BOAT", "TEST"};
		GraphProblem g = new GraphProblem(3,4);
		
		grid=convertToSmallCase(grid,3);
		wordList=convertToSmallCase(wordList,3);

		/*String grid[]={"SXXX","XQXM","XXLA","XXXR"};
		String  []wordList={"SQL", "RAM"};
		GraphProblem g = new GraphProblem(4,4);
		grid=convertToSmallCase(grid,4);
		wordList=convertToSmallCase(wordList,2);*/


		/*String grid[]={"EASYTOFINDEAGSRVHOTCJYG", "FLVENKDHCESOXXXXFAGJKEO",
                       "YHEDYNAIRQGIZECGXQLKDBI", "DEIJFKABAQSIHSNDLOMYJIN",
 					   "CKXINIMMNGRNSNRGIWQLWOG","VOFQDROQGCWDKOUYRAFUCDO",
 					   "PFLXWTYKOITSURQJGEGSPGG"};
 		String []wordList = {"EASYTOFIND", "DIAG", "GOING", "THISISTOOLONGTOFITINTHISPUZZLE"};
		GraphProblem g = new GraphProblem(7,23);
		
		grid=convertToSmallCase(grid,7);
		wordList=convertToSmallCase(wordList,4);*/			   

		/** read grid to 2d array */
		g.read(grid);
		g.printGraph();

		/** construct TRIE with wordList */
		TrieNode t = new TrieNode();
		//t.constructTrieNodeFromStringArray(t,wordList,3);
		//t.constructTrieNodeFromStringArray(t,wordList,2);
		int gridLength=grid.length;
		t.constructTrieNodeFromStringArray(t,wordList,3);
	 
 	System.out.println("solving grid");

 	int lengthOfWordList= wordList.length;
 	 int lengthOfLongestWordInWordList=0;
 	 for(int i=0;i<lengthOfWordList;i++){
 	 	if(wordList[i].length()>lengthOfLongestWordInWordList){
 	 		lengthOfLongestWordInWordList=wordList[i].length();
 	 	}
 	 }

 	 int[][] answer=g.solveGrid(t,g,lengthOfWordList);
 	 for(int i=0;i<lengthOfWordList;i++){
 	 	for(int j=0;j<2;j++){
 	 		System.out.print(answer[i][j]);
 	 	}
 	 	System.out.println("");
 	 }
	 

	}
}