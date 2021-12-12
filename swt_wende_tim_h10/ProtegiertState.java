public class ProtegiertState implements IProtegiertState {
	private String bezeichnung;
	private IProtegiertState protegiertState;

	public static final ProtegiertState HOERIG = new ProtegiertState("HÖRIG", () -> null);
	public static final ProtegiertState ERGEBEN = new ProtegiertState("ERGEBEN", () -> HOERIG);
	public static final ProtegiertState REHABILITIERT = new ProtegiertState("REHABILITIERT", () -> ERGEBEN);
	
	public ProtegiertState(String bezeichnung, IProtegiertState protegiertState) {
		this.bezeichnung = bezeichnung;
		this.protegiertState = protegiertState;
	}

	@Override
	public IProtegiertState wirtschaftslob() {
		return protegiertState.wirtschaftslob();
	}
	
	public String toString() {
		return bezeichnung;
	}
}
