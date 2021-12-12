public class State implements IState {
	public final String bezeichnung;
	private IErwischt erwischt;
	private IParteiState parteiState;
	private IWirtschaftsState wirtschaftsState;
	
	public static final State RUHEZUSTAND = new State("RUHEZUSTAND", null);
	public static final State POLITISCHAKTIV = new State("POLITISCH_AKTIV", () -> RUHEZUSTAND).with(ParteiState.LOYAL).with(WirtschaftsState.PROTEGIERT);
	public static final State AUFSICHTSRAT = new State("AUFSICHTSRAT", () -> RUHEZUSTAND);
	
	public static void resetStates() { POLITISCHAKTIV.with(ParteiState.LOYAL).with(WirtschaftsState.PROTEGIERT); }
	
	public State(String bezeichnung, IErwischt erwischt) {
		this.bezeichnung = bezeichnung;
		this.erwischt = erwischt;
	}
	
	public State with(IParteiState parteiState) {
		this.parteiState = parteiState;
		return this;
	}
	
	public State with(IWirtschaftsState wirtschaftsState) {
		this.wirtschaftsState = wirtschaftsState;
		return this;
	}

	@Override
	public IState erwischt() {
		return erwischt.erwischt();
	}

	@Override
	public IParteiState getParteiState() {
		return parteiState;
	}

	@Override
	public IWirtschaftsState getWirtschaftsState() {
		return wirtschaftsState;
	}

	@Override
	public void setParteiState(IParteiState parteiState) {
		this.parteiState = parteiState;	
	}

	@Override
	public void setWirtschaftsState(IWirtschaftsState wirtschaftsState) {
		this.wirtschaftsState = wirtschaftsState;		
	}

	@Override
	public State parteilob() {
		if (parteiState.equals(ParteiState.KRIECHEND))
			wirtschaftsState = wirtschaftsState.wirtschaftskritik();
		parteiState = parteiState.parteilob();
		return this;
	}

	@Override
	public State parteitadel() {
		parteiState = parteiState.parteitadel();
		return this;
	}

	@Override
	public State wirtschaftslob() {
		wirtschaftsState = wirtschaftsState.wirtschaftslob();
		if (wirtschaftsState == null)
			return AUFSICHTSRAT;
		return this;
	}

	@Override
	public State wirtschaftskritik() {
		wirtschaftsState = wirtschaftsState.wirtschaftskritik();
		return this;
	}
	
	public String toString() {
		return "\n" + bezeichnung + ((parteiState != null) ? " " + parteiState : "") + ((wirtschaftsState != null) ? " " + wirtschaftsState : "");
	}
}
