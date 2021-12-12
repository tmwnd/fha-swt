public class WirtschaftsState implements IWirtschaftsState {
	private String bezeichnung;
	private IWirtschaftslob wirtschaftslob;
	private IWirtschaftskritik wirtschaftskritik;
	private IProtegiertState protegiertState;
	
	public static final WirtschaftsState PROTEGIERT = new WirtschaftsState("PROTEGIERT").with(ProtegiertState.ERGEBEN);
	public static final WirtschaftsState NEUTRAL = new WirtschaftsState("NEUTRAL");
	
	public static void setStates() {
		NEUTRAL.withWirtschaftslob(() -> PROTEGIERT.with(ProtegiertState.REHABILITIERT));
		//NEUTRAL.withWirtschaftskritik(() -> NEUTRAL);
		
		PROTEGIERT.withWirtschaftslob(() -> null);
		PROTEGIERT.withWirtschaftskritik(() -> NEUTRAL);
	}
	public static void resetStates() { PROTEGIERT.with(ProtegiertState.ERGEBEN); }
	
	public WirtschaftsState(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	public WirtschaftsState with(IProtegiertState protegiertState) {
		this.protegiertState = protegiertState;
		return this;
	}
	
	public void withWirtschaftslob(IWirtschaftslob wirtschaftslob) {
		this.wirtschaftslob = wirtschaftslob;
	}
	
	public void withWirtschaftskritik(IWirtschaftskritik wirtschaftstadel) {
		this.wirtschaftskritik = wirtschaftstadel;
	}

	@Override
	public IWirtschaftsState wirtschaftslob() {
		if (protegiertState != null)
			this.protegiertState = protegiertState.wirtschaftslob();
		if (protegiertState == null)
			return wirtschaftslob.wirtschaftslob();
		return this;
	}

	@Override
	public IWirtschaftsState wirtschaftskritik() {
		return wirtschaftskritik.wirtschaftskritik();
	}
	
	public String toString() {
		return bezeichnung + ((protegiertState != null) ? " " + protegiertState : "");
	}
}
