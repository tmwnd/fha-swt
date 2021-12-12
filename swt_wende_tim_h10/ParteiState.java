public class ParteiState implements IParteiState {
	public final String bezeichnung;
	private IParteilob parteilob;
	private IParteitadel parteitadel;
	
	public static final ParteiState LOYAL = new ParteiState("LOYAL");
	public static final ParteiState KRIECHEND = new ParteiState("KRIECHEND");
	public static final ParteiState REBELLISCH = new ParteiState("REBELLISCH");
	
	public static void setStates() {
		LOYAL.withParteilob(() -> KRIECHEND);
		LOYAL.withParteitadel(() -> REBELLISCH);
		
		KRIECHEND.withParteilob(() -> KRIECHEND );
		KRIECHEND.withParteitadel(() -> REBELLISCH);
		
		REBELLISCH.withParteilob(() -> LOYAL);
		//REBELLISCH.withParteiTadel(() -> REBELLISCH);
	}
	
	public ParteiState(String bezeichnung) {
		this.bezeichnung = bezeichnung;
	}
	
	public ParteiState withParteilob(IParteilob parteilob) {
		this.parteilob = parteilob;
		return this;
	}
	
	public ParteiState withParteitadel(IParteitadel parteitadel) {
		this.parteitadel = parteitadel;
		return this;
	}

	@Override
	public IParteiState parteilob() {
		return parteilob.parteilob();
	}

	@Override
	public IParteiState parteitadel() {
		return parteitadel.parteitadel();
	}
	
	public String toString() {
		return bezeichnung;
	}
}
