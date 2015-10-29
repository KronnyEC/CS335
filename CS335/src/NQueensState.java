
public class NQueensState implements State {
	
	private int n;
	private int[] board;
	private int nextCol;
	private int nextRow;
	
	public NQueensState(int n){
		this.n = n;
		this.board = new int[n];
		
		for(int i=0; i<board.length; i++){
			this.board[i] = -1;
		}
		this.nextCol = 0;
		this.nextRow =0;
	}
	@Override
	public boolean isSolved() {
		// TODO Auto-generated method stub
		
		//put things in all the cols I am done
		return (nextCol == n);
	}

	@Override
	public boolean isFeasible() {
		
		
			boolean isValid = true;
			
			for (int i=0; i<nextCol; i++){
				
				
				//Row check
				if(board[i] == board[nextCol]){
					isValid = false;
				}
				
				//Diag Check
				if(Math.abs(board[i] - board[nextCol]) == (nextCol - i)){
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
	public State nextChild() {
		
		
		
		return null;
	}
	
	

}
