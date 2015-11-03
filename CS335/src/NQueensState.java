
public class NQueensState implements State {
	
	private int n;
	private int[] board;
	
	//need to know what is next to fill in
	private int nextCol;
	//need to know what next to fill in, for internal iterator
	private int nextRow;
	
	public NQueensState(int n){
		this.n = n;
		this.board = new int[n];
		
		//fill board with -1
		for(int i=0; i<board.length; i++){
			this.board[i] = -1;
		}
		this.nextCol = 0;
		this.nextRow =0;
	}
	
	//Copy instructor.. Need to worry how deep of a copy to make
	public NQueensState(NQueensState s ){
		this.n = s.n;
		this.board = new int[n];
		//need to make a deeper copy could have issued with shared memory
		for(int i=0; i<board.length; i++){
			this.board[i] = s.board[i];
		} //Potential Issue
		this.nextCol = s.nextCol;
		this.nextRow = s.nextRow;
	}
	
	public String toString(){
		String result = "state : ";
		
		for (int i=0; i<n; i++){
			result+= board[i] + " ";
		}
		
		result += "(" + nextCol + " " + nextRow + ")";
		
		
		return result;
	}
	
	@Override
	public boolean isSolved() {
		// TODO Auto-generated method stub
		
		//put things in all the cols I am done
		return (nextCol == n);
	}

	@Override
	public boolean isFeasible() {		
			
			//Feasibility Check
		
			int lastColPlaced = nextCol - 1;
			
		
			boolean isValid = true;
			
			for (int i=0; i<lastColPlaced; i++){
								
				//Row check
				if(board[i] == board[lastColPlaced]){
					isValid = false;
				}
				
				//Diag Check
				if(Math.abs(board[i] - board[lastColPlaced]) == (lastColPlaced - i)){
					isValid = false;
				}
				
			}
			
		return isValid;
	}

	@Override
	public boolean hasMoreChildren() {
		// TODO Auto-generated method stub
		return (nextRow < n);
	}
	@Override
	//Assumption you have more children to give when called. Makes life easier, assuming framework is written okay
	public State nextChild() {
		
		//Make a copy of myself
		NQueensState child = new NQueensState(this);
		
		//Modify a copy to have the new queen
		child.board[this.nextCol] = this.nextRow;

		//Prepare myself to make more children
		this.nextRow++;
		
		// Prepare child to make children
		child.nextCol++;
		child.nextRow = 0;
		
		return child;
	}
	
	

}
