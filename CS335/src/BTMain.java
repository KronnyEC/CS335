
public class BTMain {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		State nqs = new NQueensState(4);
		
		//do the children look fine
		
		//Ask if i produce this child. State child is this, see if they can produce next children.
		//Safety checks run it outside of the frame to see if it is producing the right states. 
		Backtracker bt = new Backtracker();
		
		int found = bt.solve(nqs);
		System.out.println(found);
	}

}
