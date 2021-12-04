/**
 * Move Klasse
 * 
 * @author Tim Wende
 *
 */
public class Move {
	public final String bezeichnung;
	public final Type type;
	public final int pwr;
	private int max_pp;
	private int pp;
	private IMover mover;
	
	/**
	 * default ctor
	 * 
	 * @param bezeichnung Bezeichnung
	 * @param type Typ
	 * @param pwr Staerke
	 * @param max_pp Maximale AP
	 */
	public Move(String bezeichnung, Type type, int pwr, int max_pp) {
		this.bezeichnung = bezeichnung;
		this.type = type;
		this.pwr = pwr;
		this.max_pp = max_pp;
		pp = max_pp;
	}
	
	/**
	 * copy ctor
	 * 
	 * @param move Move
	 */
	public Move(Move move) {
		bezeichnung = move.bezeichnung;
		type = move.type;
		pwr = move.pwr;
		max_pp = move.getMaxPP();
		pp = max_pp;
	}
	
	// getter / setter: read Movefactory
	public void addMover(IMover mover) { this.mover = mover; }
	public void increasePP(int pp){ this.pp += pp; max_pp += pp;}
	public void addPP(int pp){ this.pp += pp; }
	public int getMaxPP() { return max_pp; }
	public int getPP() { return pp; }
	public IMover getMover() { return mover; }
	public int use() { return mover.use(this); }
	public String toString() { return bezeichnung; }
}
