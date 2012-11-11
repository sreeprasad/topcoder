public class TrieNode {

	  TrieNode [] trieNodes;
	  boolean end;
	  int words;
	  int prefix;
	  int x;
	  int y;



	public TrieNode(){
		trieNodes= new TrieNode[26];
		words=0;
		prefix=0;
		end=false;
	}
 		
 	public void printWords(char[]words,int level){
 		for(int i=0;i<level;i++){
 			System.out.print(words[i]);
 		}
 		System.out.println("");
 	}

  	public boolean canReachFromVertexInTrie(TrieNode t, char c){
  		String word=""+c;
  		System.out.println("searching for letter in canReachFromVertexInTrie "+word);

  		if(countWords(t,word)==0) return false;
  		else return true;
  	}




 	public void printWords(TrieNode t,char prefix[],int level){

 		 if(t==null){
 		 	System.out.println("t is null");
 		 	return;
 		 }
 		 
 		 if(t.words>=1){
 		 	
 		 	printWords(prefix,level);
 		 	
 		 }else{
 		 for(int i=0;i<26;i++){
 		 	if(t.trieNodes[i]!=null){
  		 		prefix[level]=(char)(i+97);
 		 		printWords(t.trieNodes[i],prefix,level+1);

 		 		}
 		 	}
 		 }
 	}

 	public boolean canReachWordFromStartingLetter(TrieNode t, int x, int y, char[][]graph, int width, int size){
 			if((x>=size) ||(y>=width) || (x<0) || (y<0)){
 				return false;
 			}else{
 				//System.out.println("searching for letter "+graph[x][y]);
		 			if(t.words>0) {
		 				//System.out.println("word found in wordList");
		 				return true;
		 			}else if(t.trieNodes[(graph[x][y] -97)] !=null){
		 				 //System.out.println(" letter "+graph[x][y]+" found and searching for next word");
		 			 	 if (canReachWordFromStartingLetter(t.trieNodes[(graph[x][y] -97)],x+1,y,graph,width,size)){
							
							return true;
		 			 	}
		 			 	 else if (canReachWordFromStartingLetter(t.trieNodes[(graph[x][y] -97)],x,y+1,graph,width,size)){
		 			 	 	
		 			 	 		return true;
		 			 	 }else if (canReachWordFromStartingLetter(t.trieNodes[(graph[x][y] -97)],x+1,y+1,graph,width,size)){
		 			 	 	
		 			 	 		return true;
		 			 	 }else if (canReachWordFromStartingLetter(t.trieNodes[(graph[x][y] -97)],x-1,y-1,graph,width,size)){
		 			 	 	
		 			 	 		return true;
		 			 	 }else
		 			 	 		return false;
		 			 }else 

		 			 	return false;

		 			}
 				}
  

 	public boolean isFirstLetterPresent(TrieNode t, char c){
 
 		if(t.trieNodes[c-97]!=null)return true;
 		else return false;
 	}
 	public boolean isWordPresentInTrie(TrieNode t,String word){

 		if(word.length()==0){
 			if(t.words!=0) return true;
 			else return false;
 		}

 		int v =word.charAt(0)-97;
 		if(t.trieNodes[v]!=null){
 			word=word.substring(1);
 			return isWordPresentInTrie(t.trieNodes[v],word);
 		}else
 		return false;

 	}

	 public void constructTrieNodeFromStringArray(TrieNode t,String[] array,int length){
	 	for(int i=0;i<length;i++){
	 	 	System.out.println("adding word "+array[i]+" to trie");
	 		 t.addWord(t,array[i],i,0);
	 	}
	 }

	public void getAllWordsStartingWithPrefix(TrieNode t, String word){

		char[] prefix = new char[50];
		getAllWordsStartingWithPrefix(t,word,prefix,0);
	}

	public void getAllWordsStartingWithPrefix(TrieNode t, String word,char[]prefix,int level){
		 if(word.length()==0){
		 	 
		 	printWords(t,prefix,level);

		 }else{

		 		int v = word.charAt(0)-97;
		 		prefix[level]=word.charAt(0);
		 		 if(t.trieNodes[v]!=null){
		 		 	TrieNode w = t.trieNodes[v];
		 		 	getAllWordsStartingWithPrefix(w,word.substring(1),prefix,level+1);
		  		 }
		 	}
	}
 		
	public int countWords(TrieNode t, String word){
		System.out.println("searching for count words "+word);
		if(word.length()==0){
			return t.words;
		}
		int v = word.charAt(0)-97;
		if(t.trieNodes[v]==null){
			return 0;
		}else{
			TrieNode n = t.trieNodes[v];
			return countWords(n,word.substring(1));
		}
	}

	public int countPrefix(TrieNode t, String word){
		if(word.length()==0){
			return t.prefix;
		}
		int v = word.charAt(0)-97;
		if(t.trieNodes[v]==null){
			return 0;
		}else{
		TrieNode n = t.trieNodes[v];
		return countPrefix(n,word.substring(1));	
		}
	}

 	public void addWord(TrieNode t, String word,int x,int y){
 	 	
 		if(word.length()==0){
 		 	t.x=x;
 		 	t.y=y;
 		 	y++;
 			t.words+=1;
 		}
 		
 		if(word.length()>=1){
 			int v = word.charAt(0)-97;
 			 
 			if(t.trieNodes[v]==null){
 				
 				TrieNode n =new TrieNode();
 				n.x=x;
 				n.y=y;
 				y++;
 				t.trieNodes[v]=n;
 				t.prefix+=1;
 				addWord(n,word.substring(1),x,y);
 			}else{
 				t.prefix+=1;
 				t.x=x;
 		 		t.y=y;
 		 		y++;
 				TrieNode n =t.trieNodes[v];
 				addWord(n,word.substring(1),x,y);
 			}
 		}
 	}

 }