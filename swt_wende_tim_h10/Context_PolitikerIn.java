public class Context_PolitikerIn {
	private boolean active;
	private IState state = State.POLITISCHAKTIV;

	public Context_PolitikerIn() {
		ParteiState.setStates();
		WirtschaftsState.setStates();
		
		State.resetStates();
		WirtschaftsState.resetStates();
		
		active = true;
	}
	
	public String toString() {
		return state.toString();
	}

	public void parteilob() { state = state.parteilob(); }
	public void parteitadel() { state = state.parteitadel(); }
	public void wirtschaftslob() { state = state.wirtschaftslob(); }
	public void erwischt() { state = state.erwischt(); active = false; }
	public boolean isAktiv() { return active; }
}
