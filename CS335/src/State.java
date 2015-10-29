
public interface State {
	public boolean isSolved();
	public boolean isFeasible();
	public boolean hasMoreChildren();
	public State nextChild();
}
