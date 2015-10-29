
public class NQueens {
	//could have got from board size
	//static size will not change
	private int n;
	
	public NQueens(int n){
		this.n = n;
	}
	
	public int solve(int[] board, int nextCol){
		//recursive function		
		
		//---------------------------------------------//
		int found = 0;
		
		//base case
		if(nextCol == n){
			//Found solution made it to the state and about to make a recursive call at this state
			//fill in the queen in this particular spot and this does not exist, have basically reached the end
			
			System.out.println("solution" + board);
			
			//counting that I found a solution
		} else { //recursive 
			
			//need to find for all of them in a loop
			for (int nextRow=0; nextRow <n; nextRow++){
				board[nextCol] = nextRow;
				//how many have I found if ouI solve this new board next col only
				//will produce 4 more boards;
				
				//Feasability check -- pruning state space tree because it can not lead to a solution 
				//Should probably out to check if all the queens effect each other.
				boolean isValid = true;
				
				//Can't any 2 queens on the same col, no queens on same row & diagonal
				
				if (isValid){
					found += solve(board, nextCol+1);
				}
			}
		} 		
	
		return found;
	}
	
	
	
	public static void main(String[] args) {
		int n = 4;
		NQueens nq = new NQueens(n);
		
		int[] board = new int[n];
		for (int i = 0; i <board.length; i++){
			board[i] = -1;
		}
		
		int found = nq.solve(board, 0);
	}

}
