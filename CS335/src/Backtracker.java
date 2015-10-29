
public class Backtracker {

	public int solve(State s){
		 
		int found = 0;
		
		if (s.solved()){
			found =1;
		} else {
			
			while(s.hasMoreChildren()) {
				
				//producing children is the horizontal aspect
				State child = s.nextChild();
				
				if (child.isFeasible()){ 
					found += solve(child);
				}
				
			}
			
		}
		
		return 0;
	}
}
