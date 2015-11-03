
public class Backtracker {

	public int solve(State s){
		 
		int found = 0;
		
		if (s.isSolved()){
			found =1;
			//
		} else {
			
			//Are there still more children I can give out.
			while(s.hasMoreChildren()) {
				
				//producing children is the horizontal aspect
				State child = s.nextChild();
				
				if (child.isFeasible()){
					//go ahead and solve recursively
					found += solve(child);
				}
				
			}
			
		}
		
		return found;
	}
}
